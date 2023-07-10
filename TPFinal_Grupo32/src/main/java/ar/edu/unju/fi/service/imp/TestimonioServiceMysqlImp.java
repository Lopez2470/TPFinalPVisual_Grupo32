package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import ar.edu.unju.fi.service.IUsuarioService;
@Service
public class TestimonioServiceMysqlImp implements ITestimonioService {
	
	@Autowired
	private ITestimonioRepository testimonioRepository;
	
	@Autowired
	private Testimonio testimonio;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private Usuario usuario;

	@Override
	public List<Testimonio> getTestimonios() {
		return testimonioRepository.findByEstado(true);
	}

	@Override
	public Testimonio getTestimonio() {
		return testimonio;
	}

	@Override
	public void guardarTestimonio(Testimonio testimonio, Long id) {
		testimonio.setFechaPublicacion(LocalDate.now());
		testimonio.setEstado(true);	
		usuario = usuarioService.getBy(id);
		testimonio.setUsuario(usuario);
		testimonioRepository.save(testimonio);
	}

	@Override
	public void editarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
	}

	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
	}

	@Override
	public Testimonio getBy(Long id) {
		return testimonioRepository.findById(id).get();
	}

}
