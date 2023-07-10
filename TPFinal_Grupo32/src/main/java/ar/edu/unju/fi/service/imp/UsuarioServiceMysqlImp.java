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
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findByAdmin(false);
	}

	@Override
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
		
	}

	@Override
	public Usuario getBy(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Boolean encontrarUsuario(Long id) {
		return usuarioRepository.existsById(id);
	}

}
