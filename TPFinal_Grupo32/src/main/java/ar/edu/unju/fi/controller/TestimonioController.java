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
	@Autowired
	ITestimonioService testimonioService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	Usuario usuarioTest;
	
	@GetMapping("inicio")
	public String inicioTestimonioPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "testimonios-ingreso";
	}	
	
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
	
	@PostMapping("guardarTestimonio")
	public ModelAndView getGuardarTestimonio(@ModelAttribute("testimonio") Testimonio testimonio,
			@RequestParam("id") Long id) {
		ModelAndView modelView = new ModelAndView("testimonios");
		testimonioService.guardarTestimonio(testimonio, id);
		modelView.addObject("testimonios", testimonioService.getTestimonios());
		return modelView;
	}
}


