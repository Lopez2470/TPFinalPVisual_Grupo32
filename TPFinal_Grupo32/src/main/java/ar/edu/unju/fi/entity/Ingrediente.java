package ar.edu.unju.fi.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Ingrediente {
	//Atributos
	@NotNull
	private Long id;
	
	@NotBlank(message = "Ingresar nombre")
	@Size(min = 3, message = "Minimo de caracteres permitidos es 3")
	@Size(max = 40, message = "Máximo de caracteres permitidos es 40")
	private String Nombre;
	
	//constructor
	public Ingrediente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor con parametros
	public Ingrediente(Long id, String nombre) {
		super();
		this.id = id;
		Nombre = nombre;
	}
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
}
