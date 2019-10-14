package alex.uniquindio.edu.co.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import alex.uniquindio.edu.co.repository.CategoriaRepository;
import alex.uniquindio.edu.co.service.LibroService;

@Controller
public class AppController {
	
	@Autowired
	LibroService asignaService;
	@Autowired
    private CategoriaRepository uc;

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
