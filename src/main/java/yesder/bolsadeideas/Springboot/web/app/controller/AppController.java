package yesder.bolsadeideas.Springboot.web.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yesder.bolsadeideas.Springboot.web.app.repository.DocenteRepository;

import yesder.bolsadeideas.Springboot.web.app.service.AsignaturaService;

@Controller
public class AppController {
	
	@Autowired
	AsignaturaService asignaService;
	@Autowired
    private DocenteRepository uc;

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}


//	@GetMapping("/asignatura-form")
//	public String getAsiganturaForm(Model model) {
//		model.addAttribute("asignaturaList", asignaService.getAllUsers());
//		return "asignatura/asignatura-form";
//	}
	@GetMapping("/docente-form")
	//@RequestMapping(value="/docente-form", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp){
        mp.put("docentes", uc.findAll());
        return "docente/docente-form";
    }

//	@GetMapping("/docente-form")
//	public String getDocenteForm() {
//		return "docente/docente-form";
//	}	
//	
	@GetMapping("/fechas318_302")
	public String getFechas318_302() {
		return "Fechas/fechas318_302";
	}
	@GetMapping("/fechas650")
	public String getFechas650() {
		return "Fechas/fechas650";
	}
}
