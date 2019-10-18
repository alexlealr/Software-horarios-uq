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
import alex.uniquindio.edu.co.repository.UsuarioRepository;
import alex.uniquindio.edu.co.service.PrestamoService;

/**
 * Clase controlador que permite redireccionar a los formulario del crud
 * prestamo y de igual forma realizar su crud en la base de datos
 * 
 * @author alexander leal
 *
 */
@Controller
public class PrestamoController {

	
	/**
	 * Servicio prestamo en el cual se encuentran los metodos pertinentes al crud
	 * de prestamo
	 */
	@Autowired
	PrestamoService UsuarioService;
	
	/**
	 * Repositorio libro en el cual se puede acceder a los datos del libro 
	 * sin pasar por las otras capas
	 */
	@Autowired
	LibroRepository libroRepository;
	
	/**
	 * Repositorio usuario en el cual se puede acceder a los datos del usuario 
	 * sin pasar por las otras capas
	 */
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/**
	 * Permite cargar el formulario de registro del prestamo
	 * @param model
	 * @return formulario prestamo
	 */
	@GetMapping("/prestamoForm")
	public String PrestamoForm(Model model) {
		model.addAttribute("prestamoForm", new Prestamo());
		model.addAttribute("libros",libroRepository.findAll()); 
		model.addAttribute("usuarios",usuarioRepository.findAll()); 
		model.addAttribute("prestamoList", UsuarioService.getAllUsers());
		model.addAttribute("listTab","active");
		return "prestamo/prestamo-view";
	}
	 /**
     * Permite crear el prestamo de acuerdo a los datos ingresado por 
     * el usuario
     * @param asig Entidad prestamo
     * @param result 
     * @param model
     * @return formulario prestamo
     */
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
	
	/**
	 * Setea los datos del prestamo que el usuario selecciona para editar
	 * @param model
	 * @param id variable para identificar el prestamo seleccionada
	 * @return formuario prestamo
	 * @throws Exception
	 */
	@GetMapping("/editPrestamo/{id}")
	public String getEditPrestamoForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Prestamo asigToEdit = UsuarioService.getPrestamoById(id);

		model.addAttribute("prestamoForm", asigToEdit);
		model.addAttribute("prestamoList", UsuarioService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "prestamo/prestamo-view";
	}
	
	 /**
     * Permite editar el prestamo que el usuario seleccione
     * @param asig Entidad prestamo
     * @param result
     * @param model
     * @return formulario prestamo
     */
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
	/**
     * Permite cancelar el prestamo que el usuario ha elegido para
     * editar
     * @param model
     * @return formulario prestamo
     */
	@GetMapping("/editPrestamo/cancel")
	public String cancelEditPrestamo(ModelMap model) {
		return "redirect:/prestamoForm";
	}
    /**
     * permite eliminar el prestamo seleccionada
     * @param model
     * @param id del prestamo a eliminar
     * @return formulario prestamo
     */
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
