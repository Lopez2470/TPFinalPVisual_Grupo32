package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class IndiceMasaCorporalServiceMysqlImp implements IIndiceMasaCorporalService {

	@Autowired
	IIndiceMasaCorporalRepository indiceMCRepository;

	@Autowired
	IndiceMasaCorporal indiceMC;

	@Autowired
	IUsuarioService usuarioService;

	@Override
	public List<IndiceMasaCorporal> getIndiceMasaCorporales() {
		return indiceMCRepository.findByEstado(true);
	}

	@Override
	public IndiceMasaCorporal getIndiceMC() {
		return indiceMC;
	}

	@Override
	public void guardarIndiceMC(Usuario usuario, Double peso) {
		indiceMC.setResultado(calcularIMC(usuario, peso));
		indiceMC.setPeso(peso);
		indiceMC.setUsuario(usuario);
		indiceMC.setEstado(true);
		System.out.println(LocalDate.now());
		indiceMC.setFechaIMC(LocalDate.now());
		indiceMCRepository.save(indiceMC);
	}

	@Override
	public String calcularIMC(Usuario usuario, Double peso) {
		Double imcResultado;
		String resultado;
		imcResultado = (peso / Math.pow(usuario.getEstatura(), 2));
		if (imcResultado < 18.5) {
			resultado = "Está por debajo de su peso ideal";
		} else {
			if (imcResultado >= 18.5 && imcResultado <= 25) {
				resultado = "Está en su peso ideal";
			} else {
				resultado = "Está con sobre peso";
			}
		}
		return resultado;
	}

	/*
	 * / Metodo no utilizado para el calculo del peso ideal
	 */
	@Override
	public Double calcularPesoIdeal(IndiceMasaCorporal indiceMC, Usuario usuario) {
		/*
		 * //IndiceMasaCorporal imcUsu = indiceMCRepository.findByUsuario(usuario);
		 * System.out.println("peso: " + imcUsu.getPeso());
		 * System.out.println("resultado: " + imcUsu.getResultado()); //Usuario usuAux =
		 * usuarioService.getBy(indiceMC.getUsuario().getId());
		 * System.out.println("id: " + indiceMC.getUsuario().getId() ); int edad; Period
		 * periodo =
		 * Period.between(imcUsu.getUsuario().getFechaNacimiento(),LocalDate.now());
		 * edad=periodo.getYears(); Double pesoIdeal; pesoIdeal=
		 * ((usuario.getEstatura()*10) - 100*((edad/10)*0.9)); return pesoIdeal;
		 */
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularEdad(Usuario usuario) {
		Period periodo = Period.between(usuario.getFechaNacimiento(), LocalDate.now());
		return periodo.getYears();
	}

	@Override
	public IndiceMasaCorporal getBy(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IndiceMasaCorporal> finByUsuarios(Usuario usuario) {
		Sort sortByFechaDesc = Sort.by(Sort.Direction.DESC, "fechaIMC");
		return indiceMCRepository.findByUsuario(usuario, sortByFechaDesc);
	}

	@Override
	public Double calcularPesoIdeal(Usuario usuario) {
		int edad;
		Period periodo = Period.between(usuario.getFechaNacimiento(), LocalDate.now());
		edad = periodo.getYears();
		Double pesoIdeal;
		pesoIdeal = ((usuario.getEstatura() * 100) - 100 * ((edad / 10) * 0.9));
		return pesoIdeal;
	}
}
