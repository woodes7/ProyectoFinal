package Proyecto_Final.Periodico.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "articulo", schema = "pb_operacional")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "titulo", nullable = false, unique = true, length = 150)
	private String titulo;

	@Column(name = "contenido", nullable = false, length = 5000)
	private String contenido;

	@Column(name = "fch_publicacion", nullable = true, updatable = false)
	    private Calendar fchPublicacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autor", referencedColumnName = "id_usuaurio", nullable = false)
	private Usuario autor;
	
    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno (muchos artículos pertenecen a una sección)
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion", nullable = false)
    private Seccion seccion;
    
    private List<Articulo> articulos = new ArrayList<>();

  //CONSTRUCTORES
    
	public Articulo(long id, String titulo, String nombreUsuario, Calendar fchPublicacion, Usuario autor,
			Seccion seccion, List<Articulo> articulos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fchPublicacion = fchPublicacion;
		this.autor = autor;
		this.seccion = seccion;
		this.articulos = articulos;
	}

	public Articulo() {
		super();
		
	}      
	// GETTERS Y SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreUsuario() {
		return contenido;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.contenido = nombreUsuario;
	}

	public Calendar getFchPublicacion() {
		return fchPublicacion;
	}

	public void setFchPublicacion(Calendar fchPublicacion) {
		this.fchPublicacion = fchPublicacion;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	//METODOS
	
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", fchPublicacion="
				+ fchPublicacion + ", autor=" + autor + ", seccion=" + seccion + ", articulos=" + articulos + "]";
	}
	
}
