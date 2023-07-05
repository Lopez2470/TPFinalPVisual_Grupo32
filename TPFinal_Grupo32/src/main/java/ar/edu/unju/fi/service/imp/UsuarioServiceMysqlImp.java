package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class UsuarioServiceMysqlImp implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	Usuario usuario;

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findByAdmin(false);
	}

	@Override
	public Usuario getUsuario() {
		return getUsuario();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public Usuario getBy(Long id) {
		return usuarioRepository.findById(id).get();
	}

}
