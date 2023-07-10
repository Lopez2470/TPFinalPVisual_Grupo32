package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	/**
	 * Definicion de metodos abstractos
	 */
	
	List <Usuario> getUsuarios();
	
	Usuario getUsuario();
	
	public void guardarUsuario(Usuario usuario);
	
	public Usuario getBy(Long id);
	
	public Boolean encontrarUsuario(Long id);

}
