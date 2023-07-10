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
	/*
	 * Inyeccion de los services utilizados
	 */
	@Autowired
	private ITestimonioRepository testimonioRepository;
	
	@Autowired
	private Testimonio testimonio;
	/*
	 * Inyeccion de los services utilizados
	 */
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private Usuario usuario;
	/*
	 * devuelve todos los objetos Testimonio con el atributo estado en true.
	 */
	@Override
	public List<Testimonio> getTestimonios() {
		return testimonioRepository.findByEstado(true);
	}
	/*
	 * devuelve un objeto Testimonio
	 */
	@Override
	public Testimonio getTestimonio() {
		return testimonio;
	}
	/*
	 * guarda el objeto Testimonio
	 * se le asigna true a su estado
	 * la fecha es la actual,
	 * el usuario se asigna de acuerdo al id que viene como parametro
	 * el comentario viene dentro del objeto testimonio pasado como 
	 * parametro
	 */
	@Override
	public void guardarTestimonio(Testimonio testimonio, Long id) {
		testimonio.setFechaPublicacion(LocalDate.now());
		testimonio.setEstado(true);	
		usuario = usuarioService.getBy(id);
		testimonio.setUsuario(usuario);
		testimonioRepository.save(testimonio);
	}
	/*
	 * metodo no utilizado
	 */
	@Override
	public void editarTestimonio(Testimonio testimonio) {
		testimonioRepository.save(testimonio);
	}
	/*
	 * metodo no utilizado, la eliminacion se hace de manera logica
	 */
	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
	}
	/*
	 * se obtiene un objeto Testimonio buscando por el nro de id
	 */
	@Override
	public Testimonio getBy(Long id) {
		return testimonioRepository.findById(id).get();
	}

}
