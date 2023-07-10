package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ITestimonioService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/testimonio/")
public class TestimonioController {
	/*
	 * Inyeccion del service ITestimonioService
	 */
	@Autowired
	ITestimonioService testimonioService;
	/*
	 * Inyeccion del service IUsuarioService
	 */
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	Usuario usuarioTest;
	/*/
	 * Controlador que devuelve la pagina web de los
	 * testimonios como devolucion al pedido.
	 * Se envia a traves del model un objeto para almacenar los 
	 * datos ingresados
	 */
	@GetMapping("inicio")
	public String inicioTestimonioPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "testimonios-ingreso";
	}	
	/*
	 * Realiza la verificacion de los datos ingresados.
	 * Si existe el usuario con ese codigo, se devuelve a la pagina
	 * donde realiza el testimonio.
	 * Caso contrario se devuelve a la pagina de inicio, para el ingreso
	 * de un nuevo codigo de usuario.
	 */
	@PostMapping("verificarIngreso")
	public String ingresoCodigoVerificar(Model model, @RequestParam("id") Long id) {
		boolean mensaje;
		if (usuarioService.encontrarUsuario(id)) {
			usuarioTest = usuarioService.getUsuario();
			usuarioTest = usuarioService.getBy(id);
			model.addAttribute("usuario", usuarioTest);
			model.addAttribute("testimonio", testimonioService.getTestimonio());
			return "testimonios-registrar";
		} else {
			model.addAttribute("mensaje", true);
			return "testimonios-ingreso";
		}
	}
	/*
	 * Metodo para guardar los datos ingresados, devolviendo a la pagina
	 * en donde se visualizan todos los testimonios.
	 */
	@PostMapping("guardarTestimonio")
	public ModelAndView getGuardarTestimonio(@ModelAttribute("testimonio") Testimonio testimonio,
			@RequestParam("id") Long id) {
		ModelAndView modelView = new ModelAndView("testimonios");
		testimonioService.guardarTestimonio(testimonio, id);
		modelView.addObject("testimonios", testimonioService.getTestimonios());
		return modelView;
	}
}


