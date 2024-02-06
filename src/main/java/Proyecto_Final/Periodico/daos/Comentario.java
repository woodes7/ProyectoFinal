package Proyecto_Final.Periodico.daos;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario", schema = "pb_operacional")
public class Comentario {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private long id;

	    @Column(name = "contenido", nullable = false, length = 500)
	    private String contenido;

	    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno (muchos comentarios pertenecen a un usuario)
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
	    private Usuario idUsuario;
	    
	    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno (muchos comentarios pertenecen a un artículo)
	    @JoinColumn(name = "id_articulo", referencedColumnName = "id", nullable = false)
	    private Articulo idArticulo;

	    @Column(name = "fch_publicacion", nullable = true, updatable = false)
	    private Calendar fchPublicacion;
	    
}
