package Proyecto_Final.Periodico.servicios;

import java.util.List;

import Proyecto_Final.Periodico.daos.Usuario;
import Proyecto_Final.Periodico.dtos.UsuarioDto;





public interface InterfazUsuarioToDto {

	/**
	 * Metodo que convierte campo a campo un objeto UsuarioDTO a DAO
	 * @param ausuarioDTO el objeto usuarioDTO
	 * @return Usuario convertido a DAO
	 */
	public UsuarioDto usuarioToDto(Usuario usuaurioDao);
	
	/**
	 * Metodo que convierte toda una lista de objetos UsuarioDTO a lista de DAOs
	 * @param listaUsuarioDTO lista cargadas de objetos usuarioDTO
	 * @return Lista de usuarios DAO
	 */
	public List<UsuarioDto> listaUsuarioToDto(List<Usuario> listaUsuario);
}
