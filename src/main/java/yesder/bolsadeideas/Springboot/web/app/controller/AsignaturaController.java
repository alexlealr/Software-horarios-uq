package yesder.bolsadeideas.Springboot.web.app.controller;

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

import yesder.bolsadeideas.Springboot.web.app.entity.Asignatura;
import yesder.bolsadeideas.Springboot.web.app.service.AsignaturaService;

@Controller
public class AsignaturaController {

	@Autowired
	AsignaturaService asignaService;

	@GetMapping("/asignaturaForm")
	public String asignaturaForm(Model model) {
		model.addAttribute("asignaturaForm", new Asignatura());
		model.addAttribute("asignaturaList", asignaService.getAllUsers());
		model.addAttribute("listTab","active");
		return "asignatura/asignatura-view";
	}

	@PostMapping("/asignaturaForm")
	public String createAsignatura(@Valid @ModelAttribute("asignaturaForm")Asignatura asig, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("asignaturaForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			   
		   
			asignaService.createAsignatura(asig);
			model.addAttribute("asignaturaForm", new Asignatura());
			model.addAttribute("listTab","active");
			
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("userForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("userList", asignaService.getAllUsers());
		
		}
		}
	    	model.addAttribute("asignaturaList", asignaService.getAllUsers());
	    	return "asignatura/asignatura-view";
	}
	
	/**
	@GetMapping("/editAsignatura/{id}")
	public String getEditAsignaturaForm(Model model, @PathVariable(name ="id")String id)throws Exception{
		Asignatura asigToEdit = asignaService.getAsignaturaByCod(id);

		model.addAttribute("userForm", asigToEdit);
		model.addAttribute("userList", asignaService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "asignatura/asignatura-view";
	}

	@PostMapping("/editAsignatura")
	public String postEditAsignaturaForm(@Valid @ModelAttribute("asignaturaForm")Asignatura asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("asignaturaForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				asignaService.updateAsignatura(asig);
				model.addAttribute("asignaturaForm", new Asignatura());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("asignaturaForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("asignaturaList", asignaService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("asignaturaList", asignaService.getAllUsers());
		return "asignatura/asignatura-view";

	}

	@GetMapping("/asignaturaForm/cancel")
	public String cancelEditAsignatura(ModelMap model) {
		return "redirect:/asignatura-form";
	}*/
}
