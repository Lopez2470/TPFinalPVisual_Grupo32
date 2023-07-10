package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/imc/")
public class IndiceMasaCorporalController {
	/**
	 * Inyeccion de  servicios cargados en el repositorio 
	 */
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/**
	 * Controller que devuelve el html pedido
	 * @param model: utilizado para cargar el objeto a enviar, junto con la variable 'existe'
	 * @return
	 */
	@GetMapping("imcRegistro/")
	public String getIndiceMCRegistro(Model model) {
		boolean existe=true;		
		model.addAttribute("usuario", usuarioService.getUsuario());
		model.addAttribute("existe", existe);
		return "imc-registro";
	}
	/**
	 * Realiza la validacion del dato ingresado,procede a llamar al metodo
	 * para guardar los datos en un objeto de IndiceMasaCorporal
	 * @param usuario: es el objeto en donde es almcenado los datos ingresados
	 * @param peso: valor obtenido desde la vista
	 * @param model es el modelo en donde se adjuntaran los datos a mostrar en la salida
	 * @return devuelve un html cargado con el model, los datos a visualizar
	 * En caso de no existir un usuario con el valor ingresado, se devuelve en el 
	 * modelo para volver a ingresar con un valor de 'existe' false que indica el resultado 
	 * de la consulta. 
	 */
	@PostMapping("imcRegistrar/")
	public String registrarImcPage(@ModelAttribute("usuario") Usuario usuario, @RequestParam("peso")Double peso, Model model){
		//ModelAndView modelAndView = new ModelAndView("imc-registros");
		boolean existe = (usuarioService.encontrarUsuario(usuario.getId()));
		System.out.println("valor de existe: " + existe);
		System.out.println("valor de peso: " + peso);
		
		if (existe) {
			Usuario usuExiste = usuarioService.getBy(usuario.getId());
			System.out.println("nombre: " + usuExiste.getNombre());
			System.out.println("apellido: " + usuExiste.getApellido());
			System.out.println("sexo: " + usuExiste.getSexo());
			
			indiceMasaCorporalService.guardarIndiceMC(usuExiste, peso);
			model.addAttribute("imcLista",indiceMasaCorporalService.finByUsuarios(usuExiste));
			model.addAttribute("usuario", usuExiste);
			return "imc-registros";
		} else {
			ModelAndView modelAndView = new ModelAndView("imc-registro");
			modelAndView.setViewName("imc-registro");
			modelAndView.addObject("existe", false);
			return "imc-registro";
		}

	}
	/**
	 * Controlador que devuelve a la pagina de inicio de la consulta de 
	 * peso ideal como respuesta a ese requerimiento
	 * @param model es el modelo utilizado para cargar los datos ingresados
	 * en este caso el valor del codigo de un usuario
	 * @return devuelve la pagina pedida.
	 */
	@GetMapping("pesoIdealInicio/")
	public String getPesoIdealPage(Model model) {
		boolean existe=true;		
		//model.addAttribute("indiceMC", indiceMasaCorporalService.getIndiceMC());
		model.addAttribute("usuario", usuarioService.getUsuario());
		model.addAttribute("existe", existe);
		return "pesoIdeal-inicio";
		
	}
	/*
	 * Calcula el peso ideal del usuario ingresado y se devuelve en un modelo los datos
	 * a mostrar en la pagina de devolucion
	 */
	@PostMapping("pesoIdealCalcular/")
	public String calcularPesoIdealPage(@ModelAttribute("usuario") Usuario usuario,Model model){
		boolean existe = (usuarioService.encontrarUsuario(usuario.getId()));	
		
		if (existe) {
			Usuario usuExiste = usuarioService.getBy(usuario.getId());
			System.out.println("nombre: " + usuExiste.getNombre());
			System.out.println("apellido: " + usuExiste.getApellido());
			System.out.println("sexo: " + usuExiste.getSexo());
			
			Double pesoCalculado = indiceMasaCorporalService.calcularPesoIdeal(usuExiste );
			System.out.println("pesocacl: " + pesoCalculado);
			
			Integer edadCalculada = indiceMasaCorporalService.calcularEdad(usuExiste);
			System.out.println("edadcalc: " + edadCalculada);
			
			model.addAttribute("usuario", usuExiste);
			model.addAttribute("pesoIdeal", pesoCalculado);
			model.addAttribute("edad", edadCalculada);
			return "pesoIdeal-resultado";	
		} else {
			ModelAndView modelAndView = new ModelAndView("pesoIdeal-inicio");
			modelAndView.setViewName("pesoIdeal-inicio");
			modelAndView.addObject("existe", false);
			return "pesoIdeal-inicio";
		}
	
	}
				
}
		
		
		
		
