package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

public interface ITestimonioService {
	/*
	 * Lista de metodos sin desarrollar
	 */
	/*
	 *devuelve todos los testimonios 
	 */
	List<Testimonio> getTestimonios();
	/*
	 * devuelve un objeto Testimonio
	 */
	Testimonio getTestimonio();
	/*
	 * guarda un objeto Testimonio, enviando como parametros un objeto
	 * Testimonio y el valor de un id
	 */
	public void guardarTestimonio(Testimonio testimonio, Long id);
	/*
	 * permite editar un objeto Testimonio
	 */
	public void editarTestimonio(Testimonio testimonio);
	/*
	 * permite eliminar un objeto Testimonio
	 */
	public void eliminarTestimonio(Testimonio testimonio);
	/*
	 * devuelve un objeto Testimonio a partir de un id
	 */
	public Testimonio getBy(Long id);

	//void guardarTestimonio(Testimonio testimonio);	

}
