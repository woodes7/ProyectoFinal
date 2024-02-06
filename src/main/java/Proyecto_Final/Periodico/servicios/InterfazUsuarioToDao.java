package Proyecto_Final.Periodico.servicios;

import java.util.List;

import Proyecto_Final.Periodico.daos.Usuario;
import Proyecto_Final.Periodico.dtos.UsuarioDto;



public interface InterfazUsuarioToDao {

	/**
	 * Metodo que convierte campo a campo un objeto UsuarioDTO a DAO
	 * @param ausuarioDTO el objeto usuarioDTO
	 * @return Usuario convertido a DAO
	 */
	public Usuario usuarioToDao(UsuarioDto usuarioDto);
	
	/**
	 * Metodo que convierte toda una lista de objetos UsuarioDTO a lista de DAOs
	 * @param listaUsuarioDTO lista cargadas de objetos usuarioDTO
	 * @return Lista de usuarios DAO
	 */
	public List<Usuario> listUsuarioToDao(List<UsuarioDto>listaUsuarioDto);
}
