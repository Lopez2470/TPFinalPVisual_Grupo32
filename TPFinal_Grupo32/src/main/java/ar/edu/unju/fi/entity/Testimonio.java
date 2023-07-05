package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tes_id")
	@NotNull
	private Long id;
	
	@Column(name = "tes_fecha", nullable = false)
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPublicacion;
	
	@ManyToOne
	@JoinColumn(name = "usu_id")
	@NotNull
	private Usuario usuario;
	
	@Column(name = "tes_comentario", nullable = false)
	@NotNull(message = "Ingrese su comentario")
	@Size(min = 10,message = "Minimo de caracteres permitidos es 10")
	@Size(max = 60, message = "Máximo de caracteres permitidos es 60")
	private String comentario;
	
	@Column(name = "tes_estado", nullable = false)
	@NotNull
	private Boolean estado;
	
	/*Constructor por Defecto*/
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	/*Constructor Parametrizado*/
	/**
	 * @param fechaPublicacion: Fecha en la cual se realice el comentario
	 * @param usuario: Nombre del usuario que realiza el comentario
	 * @param comentario: Detalle del comentario del usuario
	 * @param estado: Atributo para realizar la baja del testimonio
	 */
	public Testimonio(LocalDate fechaPublicacion, Usuario usuario, String comentario, Boolean estado) {
		this.fechaPublicacion = fechaPublicacion;
		this.usuario = usuario;
		this.comentario = comentario;
		this.estado = estado;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
