package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	/*
	 * Se inyectan los services utilizados en el controlador
	 */
	@Autowired
	private IUsuarioService usuarioService;
	/*
	 * Devuelve la pagina de ingreso de un nuevo
	 * usuario. 
	 * Se envia el model para almacenar los datos ingresados
	 */
	@GetMapping("/nuevo")
	public String getNuevoUsuario(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "registro-usuario";
	}

	//Metodo que guarda el objeto validado enviado por la vista.
		@PostMapping("/guardar")
		public String getGuardarUsuarioPage(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result){
			if(result.hasErrors()) {
				ModelAndView modelView = new ModelAndView("usuarios");
				modelView.setViewName("registro-usuario");
				modelView.addObject("usuarios", usuario);
				return "registro-usuario";
			}			
			usuarioService.guardarUsuario(usuario);	
			return"registro-usuario-nuevo";
		}
}
