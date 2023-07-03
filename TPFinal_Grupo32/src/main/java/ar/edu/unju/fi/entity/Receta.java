package ar.edu.unju.fi.entity;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class Receta {
	private Long id;
	private String nombre;
	private String categoria;
	private Ingrediente ingrediente;
	private String preparacion;
	private Image imagen;
	/**
	 * 
	 */
	public Receta() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param ingrediente
	 * @param preparacion
	 * @param imagen
	 */
	public Receta(Long id, String nombre, String categoria, Ingrediente ingrediente, String preparacion, Image imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingrediente = ingrediente;
		this.preparacion = preparacion;
		this.imagen = imagen;
	}
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
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
}
