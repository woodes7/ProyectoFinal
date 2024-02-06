package Proyecto_Final.Periodico.servicios;

import Proyecto_Final.Periodico.dtos.UsuarioDto;

public class AutorizacionServicio {

	public boolean poderCrearArticulo(UsuarioDto usuarioDto) {
        return "admin".equals(usuarioDto.getRol()) || "editor".equals(usuarioDto.getRol());
    }
	public boolean poderBorrarArticulo(UsuarioDto usuarioDto) {
        return "admin".equals(usuarioDto.getRol());
    }
	public boolean poderDarAutor(UsuarioDto usuarioDto) {
	        return "admin".equals(usuarioDto.getRol());
	}
    public boolean poderEliminarComentario(UsuarioDto usuarioDto) {
        return "admin".equals(usuarioDto.getRol());
    }
    
   
}
