package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

public interface ITestimonioService {
	
	List<Testimonio> getTestimonios();
	
	Testimonio getTestimonio();
	
	public void guardarTestimonio(Testimonio testimonio);
	
	public void editarTestimonio(Testimonio testimonio);
	
	public void eliminarTestimonio(Testimonio testimonio);
	
	public Testimonio getBy(Long id);
	

}
