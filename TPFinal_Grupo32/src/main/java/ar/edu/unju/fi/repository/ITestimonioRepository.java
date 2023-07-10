package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Testimonio;

@Repository
public interface ITestimonioRepository extends CrudRepository<Testimonio, Long>{
	/*
	 * Metodo para realizar el listado de los objetos testimonios que tengan 
	 * como valor en la variable booleana estado 'true'.
	 */
	public List<Testimonio> findByEstado(Boolean estado);

}
