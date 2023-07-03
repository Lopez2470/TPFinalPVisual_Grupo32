package ar.edu.unju.fi.entity;

public class Ingrediente {
	//Atributos
	private Long id;
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
