package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long>{
	/*
	 * Metodo para filtrar los objetos de acuerdo con su estado
	 */
	public List<IndiceMasaCorporal> findByEstado(Boolean estado);
	
	/*
	 * Metodo para filtrar la lista de acuerdo a un Usuario y ordenando en forma descendende por el 
	 * atributo fechaIMC
	 */
	public List<IndiceMasaCorporal> findByUsuario(Usuario usuario, Sort sortByFechaDesc);
	/*
	 * Metodo para filtrar 
	 */
	//public Optional<IndiceMasaCorporal> findFirstByUsuarioOrderByFechaDesc(Usuario usuario);
	//public IndiceMasaCorporal findFirstByUsuarioOrderByFechaDesc(Usuario usuario, Sort sortByFechaDesc);	
	/*
	 * Metodo para filtrar de acuerdo a un Usuario especificado
	 */
	public IndiceMasaCorporal findByUsuario(Usuario usuario);
}
