package Proyecto_Final.Periodico.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Proyecto_Final.Periodico.daos.Usuario;
import Proyecto_Final.Periodico.dtos.UsuarioDto;



@Service
public class ImplementacionUsuarioToDao  implements InterfazUsuarioToDao {

	@Override
	public Usuario usuarioToDao(UsuarioDto usuarioDto) {

		Usuario usuario = new Usuario();

		try {
			usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
			usuario.setApellidosUsuario(usuarioDto.getApellidosUsuario());
			usuario.setEmailUsuario(usuarioDto.getEmailUsuario());
			usuario.setClaveUsuario(usuarioDto.getClaveUsuario());
			usuario.setTlfUsuario(usuarioDto.getTlfUsuario());
			usuario.setDniUsuario(usuarioDto.getDniUsuario());
			
			return usuario;

		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDaoImpl - toUsuarioDao()] - Al convertir usuarioDTO a usuarioDAO (return null): "
							+ e);
			return null;
		}

	}

	@Override
	public List<Usuario> listUsuarioToDao(List<UsuarioDto> listaUsuarioDto) {

		List<Usuario> listaUsuarioDao = new ArrayList<>();

		try {
			for (UsuarioDto usuarioDTO : listaUsuarioDto) {
				listaUsuarioDao.add(usuarioToDao(usuarioDTO));
			}

			return listaUsuarioDao;

		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDaoImpl - toListUsuarioDao()] - Al convertir lista de usuarioDTO a lista de usuarioDAO (return null): "
							+ e);
		}
		return null;
	}
		

}
