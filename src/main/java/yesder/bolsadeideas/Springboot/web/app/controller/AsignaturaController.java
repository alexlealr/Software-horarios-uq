package yesder.bolsadeideas.Springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsignaturaController {

	
	@GetMapping("/asignaturaForm")
	public String asignaturaForm() {
		return "asignatura/asignatura-view";
	}
}
