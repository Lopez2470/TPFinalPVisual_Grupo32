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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Component
@Entity
@Table(name = "indiceMC")
public class IndiceMasaCorporal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imc_id")
	@NotNull
	private Long id;
	
	@Column(name = "imc_fecha", nullable = false)
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIMC;
	
	@ManyToOne
	@JoinColumn(name = "usu_id")
	@NotNull
	private Usuario usuario;
	
	@Column(name = "imc_estado", length = 20, nullable = false)
	@NotNull
	private String estado;
	
	@Column(name = "imc_peso", nullable = false)
	@Min(value = 30,message = "Ingrese su peso correctamente")
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
