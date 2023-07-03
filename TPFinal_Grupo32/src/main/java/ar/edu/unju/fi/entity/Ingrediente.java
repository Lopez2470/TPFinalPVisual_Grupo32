package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	//Atributos
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingre_id")
	private Long id;
	
	@NotBlank(message = "Ingresar nombre")
	@Size(min = 3, message = "Minimo de caracteres permitidos es 3")
	@Size(max = 40, message = "Máximo de caracteres permitidos es 40")
	@Column(name="ingre_nombre",length = 40,nullable = false)
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
