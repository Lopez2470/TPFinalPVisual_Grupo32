package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Testimonio {

	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPublicacion;
	private Usuario usuario;
	private String comentario;
	
	/*Constructor por Defecto*/
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	/*Constructor Parametrizado*/
	/**
	 * @param fechaPublicacion: Fecha en la cual se realice el comentario
	 * @param usuario: Nombre del usuario que realiza el comentario
	 * @param comentario: Detalle del comentario del usuario
	 */
	public Testimonio(LocalDate fechaPublicacion, Usuario usuario, String comentario) {
		this.fechaPublicacion = fechaPublicacion;
		this.usuario = usuario;
		this.comentario = comentario;
	}
	
	/*Getters and Setters de los atributos de la clase*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
