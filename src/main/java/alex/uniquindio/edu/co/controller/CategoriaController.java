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

import alex.uniquindio.edu.co.entity.Categoria;
import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.service.CategoriaService;
import alex.uniquindio.edu.co.service.LibroService;

@Controller
public class CategoriaController {

	@Autowired
	CategoriaService libroService;

	@GetMapping("/categoriaForm")
	public String categoriaForm(Model model) {
		model.addAttribute("categoriaForm", new Categoria());
		model.addAttribute("categoriaList", libroService.getAllUsers());
		model.addAttribute("listTab","active");
		return "categoria/categoria-view";
	}

	@PostMapping("/categoriaForm")
	public String createCategoria(@Valid @ModelAttribute("categoriaForm")Categoria asig, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("categoriaForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			libroService.createCategoria(asig);
			model.addAttribute("categoriaForm", new Categoria());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("categoriaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("userList", libroService.getAllUsers());
		
		}
		}
	    	model.addAttribute("categoriaList", libroService.getAllUsers());
	    	return "categoria/categoria-view";
	}
	
	
	@GetMapping("/editCategoria/{id}")
	public String getEditCategoriaForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Categoria asigToEdit = libroService.getCategoriaById(id);

		model.addAttribute("categoriaForm", asigToEdit);
		model.addAttribute("categoriaList", libroService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "categoria/categoria-view";
	}
	

	@PostMapping("/editCategoria")
	public String postEditCategoriaForm(@Valid @ModelAttribute("categoriaForm")Categoria asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("categoriaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				libroService.updateCategoria(asig);
				model.addAttribute("categoriaForm", new Categoria());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("categoriaForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("categoriaList", libroService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("categoriaList", libroService.getAllUsers());
		return "categoria/categoria-view";

	}

	@GetMapping("/editCategoria/cancel")
	public String cancelEditCategoria(ModelMap model) {
		return "redirect:/categoriaForm";
	}
	
	@GetMapping("/deleteCategoria/{id}")
	public String deleteCategoria(Model model, @PathVariable(name="id") Long id) {
		try {
			libroService.deleteCategoria(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","La asignatura no puede ser eliminada");
		}
		return categoriaForm(model);
	}
}
