package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

@Repository
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long>{
	
	public List<IndiceMasaCorporal> findByEstado(Boolean estado);

}