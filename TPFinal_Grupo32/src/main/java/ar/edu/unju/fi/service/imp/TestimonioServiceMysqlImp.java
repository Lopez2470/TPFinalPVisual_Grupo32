package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
@Service
public class TestimonioServiceMysqlImp implements ITestimonioService {
	
	@Autowired
	ITestimonioRepository testimonioRespository;
	
	@Autowired
	Testimonio testimonio;

	@Override
	public List<Testimonio> getTestimonios() {
		return testimonioRespository.findByEstado(true);
	}

	@Override
	public Testimonio getTestimonio() {
		return getTestimonio();
	}

	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRespository.save(testimonio);
	}

	@Override
	public void editarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRespository.save(testimonio);
	}

	@Override
	public void eliminarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(false);
		testimonioRespository.save(testimonio);
	}

	@Override
	public Testimonio getBy(Long id) {
		return testimonioRespository.findById(id).get();
	}

}
