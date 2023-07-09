package ar.edu.unju.fi.entity;

import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name="recetas")
public class Receta {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rece_id")
	private Long id;
	
	@Size(min = 1,message = "Minimo de caracteres permitidos es 1")
	@Size(max = 40, message = "Máximo de caracteres permitidos es 40")
	@Column(name="rece_nombre",length = 40,nullable = false)
	private String nombre;
	
	@Column(name="rece_categoria")
	private String categoria;
	
	@ManyToOne
	@JoinColumn(name = "ingre_id")
	private Ingrediente ingredientes;
	
	
	@Column(name="rece_preparacion")
	private String preparacion;
	
	@Column(name="rece_imagen")
	private byte[] imagen;
	
	
	//constructor
	public Receta() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Constructor parametrizado
	public Receta(
			@Size(min = 1, message = "Minimo de caracteres permitidos es 1") @Size(max = 40, message = "Máximo de caracteres permitidos es 40") String nombre,
			String categoria, Ingrediente ingredientes, String preparacion, byte[] imagen) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.imagen = imagen;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Ingrediente getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingrediente ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}


	
	

	
	
	
}
