package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class IndiceMasaCorporal {
	
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIMC;
	private Usuario usuario;
	private String estado;
	private Double peso;
	
	/*Constructor por Defecto*/
	public IndiceMasaCorporal() {
		// TODO Auto-generated constructor stub
	}
	/*Constructor parametrizado*/

	/**
	 * @param fechaIMC: Fecha en la que se realiza el servicio
	 * @param usuario: Identificacion del usuario que utiliza el servicio
	 * @param estado: Resultado del IMC
	 * @param peso: peso de la persona al momento de realizar el IMC
	 */
	public IndiceMasaCorporal(LocalDate fechaIMC, Usuario usuario, String estado, Double peso) {
		this.fechaIMC = fechaIMC;
		this.usuario = usuario;
		this.estado = estado;
		this.peso = peso;
	}
	
	/*Getters-Setters del IndiceMasaCorporal*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaIMC() {
		return fechaIMC;
	}

	public void setFechaIMC(LocalDate fechaIMC) {
		this.fechaIMC = fechaIMC;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
}