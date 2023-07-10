package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class UsuarioServiceMysqlImp implements IUsuarioService{
	/*
	 * Inyeccion de service
	 */
	@Autowired
	private IUsuarioRepository usuarioRepository;
	/*
	 * Inyeccion de la entidad Usuario
	 */
	@Autowired
	private Usuario usuario;
	/*
	 * Metodo que devuelve todos los usuarios que sean unicamente
	 * Usuarios comunes
	 */
	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findByAdmin(false);
	}
	/*
	 * Metodo que nos devuelve un objeto Usuario
	 */
	@Override
	public Usuario getUsuario() {
		return usuario;
	}
	/*
	 * Metodo que guarda el usuario pasado como parametro
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	/*
	 * Metodo que devuelve un objeto Usuario a partir
	 * de su nro de id pasado como parametro
	 */
	@Override
	public Usuario getBy(Long id) {
		return usuarioRepository.findById(id).get();
	}
	/*
	 * Metodo que busca si existe un usuarui a partir de su id
	 */
	@Override
	public Boolean encontrarUsuario(Long id) {
		return usuarioRepository.existsById(id);
	}

}
