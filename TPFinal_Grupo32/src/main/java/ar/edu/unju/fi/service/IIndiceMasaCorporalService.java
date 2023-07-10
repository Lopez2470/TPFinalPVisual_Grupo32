 package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

public interface IIndiceMasaCorporalService {
	/*
	 *Metodos abstractos
	 */
	/*
	 * Devuelve una lista de todos los objetos IndiceMasaCorporal
	 */
	List<IndiceMasaCorporal> getIndiceMasaCorporales();
	/*
	 * Devuelve un objeto IndiceMasaCorporal
	 */
	IndiceMasaCorporal getIndiceMC();
	/*
	 * Guarda un objeto IndiceMasaCorporal teniendo como parametros el
	 * usuario y el peso ingresados
	 */
	//void guardarIndiceMC(IndiceMasaCorporal indiceMC);
	void guardarIndiceMC(Usuario usuario, Double peso);
	/*
	 * Devuelve el resultado del calculo del IMC
	 */
	//public void calcularIMC(IndiceMasaCorporal indiceMC);
	//public String calcularIMC(IndiceMasaCorporal indiceMC, Usuario usuario);
	public String calcularIMC(Usuario usuario, Double peso);

	/*
	 * Calcula el peso ideal del usuario pasando como parametros un objeto IndiceMasaCorporal
	 * y Usuario (solo de prueba)
	 */
	//public Double calcularPesoIdeal(IndiceMasaCorporal indiceMC);
	public Double calcularPesoIdeal(IndiceMasaCorporal indiceMC, Usuario usuario);
	/*
	 * Calcula el peso ideal del usuario pasado como parametro
	 */
	public Double calcularPesoIdeal(Usuario usuario);
	/*
	 * Calcula la edad del usuario pasado como parametro
	 */
	public Integer calcularEdad(Usuario usuario);
	/*
	 * Devuelve el objeto IndiceMasaCorporal que coincide con el id pasado por parametro
	 */
	public IndiceMasaCorporal getBy(Long id);
	/*
	 * Devuelve la lista de IndiceMasaCorporal de un usuario ordenado por fecha en forma 
	 * descendente
	 */
	public List<IndiceMasaCorporal> finByUsuarios(Usuario usuario);
	
	//public IndiceMasaCorporal obtenerUltimoByUsuario(Usuario usuario);
	

}
