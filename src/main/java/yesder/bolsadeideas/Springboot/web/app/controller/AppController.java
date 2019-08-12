package yesder.bolsadeideas.Springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

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
	
	@GetMapping("/registrarDocente")
	public String registrarDocente() {
		return "registrarDocente";
	}

	@GetMapping("/docente-form")
	public String getDocenteForm() {
		return "docente/docente-form";
	}	
	@GetMapping("/asignatura-form")
	public String getAsiganturaForm() {
		return "asignatura/asignatura-form";
	}
	@GetMapping("/fechas318_302")
	public String getFechas318_302() {
		return "Fechas/fechas318_302";
	}
	@GetMapping("/fechas650")
	public String getFechas650() {
		return "Fechas/fechas650";
	}
}
