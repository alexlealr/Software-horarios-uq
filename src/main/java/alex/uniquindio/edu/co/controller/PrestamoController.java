package alex.uniquindio.edu.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import alex.uniquindio.edu.co.entity.Prestamo;
import alex.uniquindio.edu.co.repository.LibroRepository;
import alex.uniquindio.edu.co.repository.PrestamoRepository;
import alex.uniquindio.edu.co.repository.UsuarioRepository;
import alex.uniquindio.edu.co.service.PrestamoService;


@Controller
public class PrestamoController {

	

	@Autowired
	PrestamoService UsuarioService;
	
	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	

	@GetMapping("/prestamoForm")
	public String PrestamoForm(Model model) {
		model.addAttribute("prestamoForm", new Prestamo());
		model.addAttribute("libros",libroRepository.findAll()); 
		model.addAttribute("usuarios",usuarioRepository.findAll()); 
		model.addAttribute("prestamoList", UsuarioService.getAllUsers());
		model.addAttribute("listTab","active");
		return "prestamo/prestamo-view";
	}

	@PostMapping("/prestamoForm")
	public String createPrestamo(@Valid @ModelAttribute("prestamoForm")Prestamo asig, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("prestamoForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			UsuarioService.createPrestamo(asig);
			model.addAttribute("prestamoForm", new Prestamo());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("prestamoForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("prestamoList", UsuarioService.getAllUsers());
		
		}
		}
	    	model.addAttribute("prestamoList", UsuarioService.getAllUsers());
	    	return "prestamo/prestamo-view";
	}
	
	
	@GetMapping("/editPrestamo/{id}")
	public String getEditPrestamoForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Prestamo asigToEdit = UsuarioService.getPrestamoById(id);

		model.addAttribute("prestamoForm", asigToEdit);
		model.addAttribute("prestamoList", UsuarioService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "prestamo/prestamo-view";
	}
	

	@PostMapping("/editPrestamo")
	public String postEditPrestamoForm(@Valid @ModelAttribute("prestamoForm")Prestamo asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("prestamoForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				UsuarioService.updatePrestamo(asig);
				model.addAttribute("prestamoForm", new Prestamo());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("prestamoForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("prestamoList", UsuarioService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("PrestamoList", UsuarioService.getAllUsers());
		return "prestamo/prestamo-view";

	}

	@GetMapping("/editPrestamo/cancel")
	public String cancelEditPrestamo(ModelMap model) {
		return "redirect:/prestamoForm";
	}
	
	@GetMapping("/deletePrestamo/{id}")
	public String deletePrestamo(Model model, @PathVariable(name="id") Long id) {
		try {
			UsuarioService.deletePrestamo(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","El prestamo no puede ser eliminada");
		}
		return PrestamoForm(model);
	}

}
