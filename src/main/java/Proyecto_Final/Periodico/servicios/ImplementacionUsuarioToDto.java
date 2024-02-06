package Proyecto_Final.Periodico.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Proyecto_Final.Periodico.daos.Usuario;
import Proyecto_Final.Periodico.dtos.UsuarioDto;


@Service
public class ImplementacionUsuarioToDto implements InterfazUsuarioToDto {

	@Override
	public UsuarioDto usuarioToDto(Usuario usuaurioDao) {
		try {
			UsuarioDto dto = new UsuarioDto();
			dto.setNombreUsuario(usuaurioDao.getNombreUsuario());
			dto.setApellidosUsuario(usuaurioDao.getApellidosUsuario());
			dto.setDniUsuario(usuaurioDao.getDniUsuario());
			dto.setTlfUsuario(usuaurioDao.getTlfUsuario());
			dto.setEmailUsuario(usuaurioDao.getEmailUsuario());
			dto.setClaveUsuario(usuaurioDao.getClaveUsuario());
			dto.setToken(usuaurioDao.getToken());
			dto.setExpiracionToken(usuaurioDao.getExpiracionToken());
			dto.setId(usuaurioDao.getIdUsuario());
			
			return dto;
		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDtoImpl - usuarioToDto()] - Error al convertir usuario DAO a usuarioDTO (return null): "
							+ e);
			return null;
		}
	}

	@Override
	public List<UsuarioDto> listaUsuarioToDto(List<Usuario> listaUsuarioDao) {
		try {
			
			List<UsuarioDto> listaDto = new ArrayList<>();
			for (Usuario u : listaUsuarioDao) {
				listaDto.add(this.usuarioToDto(u));
			}
			return listaDto;

		} catch (Exception e) {
			System.out.println(
					"\n[ERROR UsuarioToDtoImpl - listauUsuarioToDto()] - Error al convertir lista de usuario DAO a lista de usuarioDTO (return null): "
							+ e);
		}
		return null;
	}
}


