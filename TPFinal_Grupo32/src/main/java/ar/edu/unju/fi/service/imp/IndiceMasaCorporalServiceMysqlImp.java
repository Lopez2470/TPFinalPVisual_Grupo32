package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;

public class IndiceMasaCorporalServiceMysqlImp implements IIndiceMasaCorporalService {

	@Autowired
	IIndiceMasaCorporalRepository indiceMCRepository;
	
	@Autowired
	IndiceMasaCorporal indiceMC;
	
	
	@Override
	public List<IndiceMasaCorporal> getIndiceMasaCorporales() {
		return indiceMCRepository.findByEstado(true);
	}

	@Override
	public IndiceMasaCorporal getIndiceMC() {
		return indiceMC;
	}

	@Override
	public void guardarIndiceMC(IndiceMasaCorporal indiceMC) {
		indiceMCRepository.save(indiceMC);
	}

	@Override
	public void calcularIMC(IndiceMasaCorporal indiceMC) {
		Double imcResultado ;
		String resultado;
		imcResultado = (indiceMC.getPeso()/Math.pow(indiceMC.getUsuario().getEstatura(), 2));
		if (imcResultado  < 18.5) {
			resultado ="Está por debajo de su peso ideal";
		} else {
			if (imcResultado>= 18.5 && imcResultado<= 25) {
				resultado = "Está en su peso ideal";
			} else {
				resultado = "Está con sobre peso";
			}
		}
		
		indiceMC.setResultado(resultado);
		indiceMC.setEstado(true);
		indiceMC.setFechaIMC(LocalDate.now());
		indiceMCRepository.save(indiceMC);
	}

	@Override
	public Double calcularPesoIdeal(IndiceMasaCorporal indiceMC) {
		int edad;
		Period periodo = Period.between(indiceMC.getUsuario().getFechaNacimiento(),LocalDate.now());
		edad=periodo.getYears();
		Double pesoIdeal;
		pesoIdeal= ((indiceMC.getUsuario().getEstatura()*10) - 100*((edad/10)*0.9));
		return pesoIdeal;
	}

	@Override
	public Integer calcularEdad() {
		return null;
	}

	@Override
	public IndiceMasaCorporal getBy(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
