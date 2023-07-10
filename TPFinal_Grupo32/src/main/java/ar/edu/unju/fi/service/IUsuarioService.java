package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	/**
	 * Definicion de metodos abstractos
	 */
	/*
	 *Devuelve una lista con todos los Usuarios 
	 */
	List <Usuario> getUsuarios();
	/*
	 * Devuelve un objeto Usuario
	 */
	Usuario getUsuario();
	/*
	 * Metodo para guardar un usuario nuevo
	 */
	public void guardarUsuario(Usuario usuario);
	/*
	 * Metodo que devuelve un objeto usuario por medio del id
	 */
	public Usuario getBy(Long id);
	/*
	 * Metodo para busar la existencia de un objeto Usuario
	 */
	public Boolean encontrarUsuario(Long id);

}
