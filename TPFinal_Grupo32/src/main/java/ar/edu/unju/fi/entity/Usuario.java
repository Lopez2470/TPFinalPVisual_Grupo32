package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	
	private Long Id;
	private String nombre;
	private String apellido;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private Integer telefono;
	private String sexo;
	private Double estatura;
	private Boolean admin;
/*constructor por defecto*/
public Usuario() {
}
/*constructor parametrizado*/
/**
 * @param nombre: nombre del usuario a registrar
 * @param apellido: apellido del usuario a registrar
 * @param email: correo electronico del usuario a registrar
 * @param fechaNacimiento: fecha de nacimiento del usuario a registrar
 * @param telefono: nro de telefono del usuario a registrar
 * @param sexo: sexo del usuario a registrar (Masculino/Femenino/Otro)
 * @param estatura: Altura en metros del usuario a registrar
 * @param admin: variable booleana para determinar si el usuario a registrar
 *        es un Administrador o un usuario comun
 */
public Usuario(String nombre, String apellido, String email, LocalDate fechaNacimiento, Integer telefono, String sexo,
		Double estatura, Boolean admin) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.fechaNacimiento = fechaNacimiento;
	this.telefono = telefono;
	this.sexo = sexo;
	this.estatura = estatura;
	this.admin = admin;
}

/*Getter - Setters*/
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
public Integer getTelefono() {
	return telefono;
}
public void setTelefono(Integer telefono) {
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
