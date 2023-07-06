package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

public interface IIndiceMasaCorporalService {
	/*
	 *Metodos 
	 */
	List<IndiceMasaCorporal> getIndiceMasaCorporales();
	
	IndiceMasaCorporal getIndiceMC();
	
	void guardarIndiceMC(IndiceMasaCorporal indceMC);
	
	public void calcularIMC(IndiceMasaCorporal indiceMC);
	
	public Double calcularPesoIdeal(IndiceMasaCorporal indiceMC);
	
	public Integer calcularEdad();
	
	public IndiceMasaCorporal getBy(Long id);
	

}
