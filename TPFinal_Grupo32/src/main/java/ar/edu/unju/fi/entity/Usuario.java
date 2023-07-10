package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	//@NotNull
	private Long Id;
	
	@Column(name = "usu_nombre", length = 20, nullable = false)
	@NotBlank(message = "Ingrese un nombre")
	@Size(min = 5, message = "Minimo de caracteres permitidos es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos es 20")
	private String nombre;

	@Column(name = "usu_apellido", length = 20, nullable = false)
	@NotBlank(message = "Ingrese un apellido")
	@Size(min = 5, message = "Minimo de caracteres permitidos es 5")
	@Size(max = 20, message = "Máximo de caracteres permitidos es 20")
	private String apellido;

	@Column(name = "usu_email", length = 40, nullable = false)
	@Email(message = "Correo Electronico mal ingresado")
	@NotBlank(message = "Ingrese un correo electrónico")
	private String email;

	@Column(name = "usu_fecha", nullable = false)
	@NotNull(message = "Ingrese una fecha")
	@Past(message = "Ingrese una fecha correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@Column(name = "usu_telefono", length = 10, nullable = false)
	@NotNull(message = "Ingrese un nro. de telefono")
	@NotBlank(message = "Ingrese un nro telefonico")
	//@Pattern(regexp = "[11|2[2,3,4,6,8,9]{1}|3[3-8]{1}][1-9]{8}")
	@Pattern(regexp = "[0-9]{10}")
	private String telefono;

	@Column(name = "usu_sexo", length = 9, nullable = false)
	@NotNull(message = "Seleccione una opción")
	@NotBlank(message = "Debe elegir una opcion")
	private String sexo;

	@Column(name = "usu_estatura", nullable = false)
	@NotNull(message = "Ingrese su estatura")
	@Min(value = 1, message = "Ingrese un valor")
	private Double estatura;

	@Column(name = "usu_admin", nullable = false)
	@NotNull(message = "Eliga una opción")
	
	private Boolean admin;

	/* constructor por defecto */
	public Usuario() {
	}

	/* constructor parametrizado */
	/**
	 * @param nombre:          nombre del usuario a registrar
	 * @param apellido:        apellido del usuario a registrar
	 * @param email:           correo electronico del usuario a registrar
	 * @param fechaNacimiento: fecha de nacimiento del usuario a registrar
	 * @param telefono:        nro de telefono del usuario a registrar
	 * @param sexo:            sexo del usuario a registrar
	 *                         (Masculino/Femenino/Otro)
	 * @param estatura:        Altura en metros del usuario a registrar
	 * @param admin:           variable booleana para determinar si el usuario a
	 *                         registrar es un Administrador o un usuario comun
	 */
	public Usuario(String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono,
			String sexo, Double estatura, Boolean admin) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
		this.admin = admin;
	}

	/* Getter - Setters */
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
