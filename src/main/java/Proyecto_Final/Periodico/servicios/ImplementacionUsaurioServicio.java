package Proyecto_Final.Periodico.servicios;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Proyecto_Final.Periodico.daos.Usuario;
import Proyecto_Final.Periodico.dtos.UsuarioDto;
import Proyecto_Final.Periodico.repositorios.UsuarioRepositorio;




@Service
public class ImplementacionUsaurioServicio implements InterfazUsuarioServicio  {


	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private InterfazUsuarioToDao toDao;

	@Autowired
	private InterfazUsuarioToDto toDto;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private InterfazEmailServicio emailServicio;

	
	@Override
	public UsuarioDto registrar(UsuarioDto userDto) {


		try {
			// Comprueba si ya existe un usuario con el email que quiere registrar
			Usuario usuarioDaoByEmail = repositorio.findFirstByEmailUsuario(userDto.getEmailUsuario());

			if (usuarioDaoByEmail != null) 
				return null; // Si no es null es que ya está registrado
			
			// Ahora se comprueba si hay un usuario por el DNI que quiere registrar
			boolean yaExisteElDNI = repositorio.existsByDniUsuario(userDto.getDniUsuario());

			if (yaExisteElDNI) {
				// Si es que ya hay un usuario con ese dni se setea a null para controlar el
				// error en controlador
				userDto.setDniUsuario(null);
				return userDto;
			}

			// Si llega a esta línea es que no existe el usuario con el email y el dni a
			// registrar
			userDto.setClaveUsuario(passwordEncoder.encode(userDto.getClaveUsuario()));
			Usuario usuarioDao = toDao.usuarioToDao(userDto);
			usuarioDao.setRol(Roles rol);
			usuarioDao.setFchAltaUsuario(Calendar.getInstance());
			repositorio.save(usuarioDao);

			return userDto;
		} catch (IllegalArgumentException iae) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + iae.getMessage());
		} catch (Exception e) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + e.getMessage());
		}
		return null;
	}

	
	/**
	 * Metodo que ejecuta la creacion de un usuario administrador con su rol de administrador
	 */
	private void inicializarUsuarioAdmin() {
		// Comprueba si ya existe un usuario admin
		if (!repositorio.existsByNombreUsuario("admin")) {
			// Si no existe, crea un nuevo usuario con rol de administrador
			Usuario admin = new Usuario();
			admin.setNombreUsuario("admin");
			admin.setClaveUsuario(passwordEncoder.encode("admin"));
			admin.setDniUsuario("-");
			admin.setEmailUsuario("admin@admin.com");
			admin.setRol("ROLE_ADMIN");

			repositorio.save(admin);
		}
	}
	
	/**
	 * Metodo que automatiza la creacion de un usuario administrador que se ejecuta la primera vez que se despliega la aplicacion
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		inicializarUsuarioAdmin();
	}
	
	@Override
	public Usuario buscarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmailUsuario(email);
	}

	@Override
	public boolean buscarPorApodo(String apodo) {
		return repositorio.existsByDniUsuario(apodo);
	}

	@Override
	public List<UsuarioDto> buscarTodos() {
		return toDto.listaUsuarioToDto(repositorio.findAll());
	}

	@Override
	public UsuarioDto obtenerUsuarioPorToken(String token) {
		Usuario usuarioExistente = repositorio.findByToken(token);

		if (usuarioExistente != null) {
			UsuarioDto usuario = toDto.usuarioToDto(usuarioExistente);
			return usuario;
		} else {
			System.out.println("No existe el usuario con el token " + token);
			return null;
		}

	}

	@Override
	public boolean iniciarResetPassConEmail(String emailUsuario) {
		try {
			Usuario usuarioExistente = repositorio.findFirstByEmailUsuario(emailUsuario);

			if (usuarioExistente != null) {
				// Generar el token y establece la fecha de expiración
				String token = passwordEncoder.encode(RandomStringUtils.random(30));
				Calendar fechaExpiracion = Calendar.getInstance();
				fechaExpiracion.add(Calendar.MINUTE, 10);
				// Actualizar el usuario con el nuevo token y la fecha de expiración
				usuarioExistente.setToken(token);
				usuarioExistente.setExpiracionToken(fechaExpiracion);

				// Actualizar el usuario en la base de datos
				repositorio.save(usuarioExistente);

				// Enviar el correo de recuperación
				String nombreUsuario = usuarioExistente.getNombreUsuario() + " "
						+ usuarioExistente.getApellidosUsuario();
				emailServicio.enviarEmailRecuperacion(emailUsuario, nombreUsuario, token);

				return true;

			} else {
				System.out.println("[Error UsuarioServicioImpl - iniciarRecuperacionConEmail()] El usuario con email "
						+ emailUsuario + " no existe");
				return false;
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("[Error UsuarioServicioImpl - registrar() ]" + iae.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("[Error UsuarioServicioImpl - iniciarRecuperacionConEmail()]" + e.getMessage());
			return false;
		}
	}
	

	@Override
	public boolean modificarContraseñaConToken(UsuarioDto usuario) {
		Usuario usuarioExistente = repositorio.findByToken(usuario.getToken());

		if (usuarioExistente != null) {
			String nuevaContraseña = passwordEncoder.encode(usuario.getPassword());
			usuarioExistente.setClaveUsuario(nuevaContraseña);
			usuarioExistente.setToken(null); // Se setea a null para invalidar el token ya consumido al cambiar de
												// password
			repositorio.save(usuarioExistente);

			return true;
		}

		return false;
	}

	@Override
	public Usuario eliminar(long id) {
		Usuario usuario = repositorio.findById(id).orElse(null);
		if (usuario != null) {
			repositorio.delete(usuario);
		} 
		return usuario;
		
	}

}
