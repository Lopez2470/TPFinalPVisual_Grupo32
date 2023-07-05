package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	/**
	 * Definicion de metodos abstractos
	 */
	
	List <Usuario> getUsuarios();
	
	Usuario getUsuario();
	/*Guardar el objeto usuario*/
	public void guardarUsuario(Usuario usuario);
	/*Buscar usuario por su id*/
	public Usuario getBy(Long id);

}
