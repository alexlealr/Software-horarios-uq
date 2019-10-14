package alex.uniquindio.edu.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.service.UsuarioService;

@Controller
public class UsuarioController {

	
	@Autowired
	UsuarioService UsuarioService;
	
	private PasswordEncoder passwordEncoder;
	

	@GetMapping("/usuarioForm")
	public String UsuarioForm(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("usuarioList", UsuarioService.getAllUsers());
		model.addAttribute("listTab","active");
		return "usuario/usuario-view";
	}

	@PostMapping("/usuarioForm")
	public String createUsuario(@Valid @ModelAttribute("usuarioForm")Usuario asig, BindingResult result, ModelMap model) {
		passwordEncoder = new BCryptPasswordEncoder();
		asig.setPassword(passwordEncoder.encode(asig.getPassword()));
		asig.setRole("ADMIN");
		if (result.hasErrors()) {
			model.addAttribute("usuarioForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			UsuarioService.createUsuario(asig);
			model.addAttribute("libroForm", new Usuario());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("userForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("usuarioList", UsuarioService.getAllUsers());
		
		}
		}
	    	model.addAttribute("usuarioList", UsuarioService.getAllUsers());
	    	return "usuario/usuario-view";
	}
	
	
	@GetMapping("/editUsuario/{id}")
	public String getEditUsuarioForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Usuario asigToEdit = UsuarioService.getUsuarioById(id);

		model.addAttribute("usuarioForm", asigToEdit);
		model.addAttribute("usuarioList", UsuarioService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "usuario/usuario-view";
	}
	

	@PostMapping("/editUsuario")
	public String postEditUsuarioForm(@Valid @ModelAttribute("usuarioForm")Usuario asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				UsuarioService.updateUsuario(asig);
				model.addAttribute("usuarioForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("usuarioForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("usuarioList", UsuarioService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("UsuarioList", UsuarioService.getAllUsers());
		return "usuario/usuario-view";

	}

	@GetMapping("/editUsuario/cancel")
	public String cancelEditUsuario(ModelMap model) {
		return "redirect:/usuarioForm";
	}
	
	@GetMapping("/deleteUsuario/{id}")
	public String deleteUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			UsuarioService.deleteUsuario(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","El usuario no puede ser eliminado");
		}
		return UsuarioForm(model);
	}
}
