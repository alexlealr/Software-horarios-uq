package alex.uniquindio.edu.co.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.repository.CategoriaRepository;
import alex.uniquindio.edu.co.service.LibroService;


/**
 * Clase controlador que permite redireccionar a los formulario del crud
 * libro y de igual forma realizar su crud en la base de datos
 * 
 * @author alexander leal
 *
 */
@Controller
public class LibroController {

	/**
	 * Servicio ibro en el cual se encuentran los metodos pertinentes al crud
	 * de libro
	 */
	@Autowired
	LibroService libroService;
    
	/**
	 * Repositorio categoria en el cual se puede acceder a ciertas consultas
	 * sin pasar por otras capas de categoria
	 */
	@Autowired
	CategoriaRepository categoriaRepository;
	
	/**
	 * Permite cargar el formulario de registro de libro
	 * @param model
	 * @return libro/libro-view"
	 */
	@GetMapping("/libroForm")
	public String libroForm(Model model) {
		model.addAttribute("libroForm", new Libro());
		model.addAttribute("categorias",categoriaRepository.findAll());
		model.addAttribute("libroList", libroService.getAllUsers());
		model.addAttribute("listTab","active");
		return "libro/libro-view";
	}
	/**
     * Permite crear el libro de acuerdo a los datos ingresado por 
     * el usuario
     * @param asig Entidad libro
     * @param result 
     * @param model
     * @return formulario libro
     */
	@PostMapping("/libroForm")
	public String createLibro(@Valid @ModelAttribute("libroForm")Libro asig, BindingResult result, ModelMap model, @RequestParam("file") MultipartFile foto) {
		if (!foto.isEmpty()) {
			  Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			  String rootPath = directorioRecursos.toFile().getAbsolutePath();
			  try {
				  byte[] bytes = foto.getBytes();
				  Path rutaCompleta = Paths.get(rootPath+ "//"+ foto.getOriginalFilename());
				  Files.write(rutaCompleta, bytes);
				  asig.setImagen(foto.getOriginalFilename());
				  } catch (IOException e) {
					  e.printStackTrace();
			  }
		  }
			
		if (result.hasErrors()) {
			model.addAttribute("libroForm", asig);
			model.addAttribute("formTab","active");
		}else {
		   try {
			libroService.createLibro(asig);
			model.addAttribute("libroForm", new Libro());
			model.addAttribute("listTab","active");
		
		} catch (Exception e) {
			
			model.addAttribute("formErrorMessage",e.getMessage());
			model.addAttribute("userForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("userList", libroService.getAllUsers());
		
		}
		}
		  
	    	model.addAttribute("libroList", libroService.getAllUsers());
	    	return "libro/libro-view";
	}
	
	
	/**
	 * Setea los datos del libro que el usuario selecciona para editar
	 * @param model
	 * @param id variable para identificar el libro seleccionado
	 * @return formuario libro
	 * @throws Exception
	 */
	@GetMapping("/editLibro/{id}")
	public String getEditLibroForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Libro asigToEdit = libroService.getLibroById(id);

		model.addAttribute("libroForm", asigToEdit);
		model.addAttribute("libroList", libroService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "libro/libro-view";
	}
	
	/**
     * Permite editar el libro que el usuario seleccione
     * @param asig Entidad libro
     * @param result
     * @param model
     * @return formulario libro
     */
	@PostMapping("/editLibro")
	public String postEditLibroForm(@Valid @ModelAttribute("libroForm")Libro asig, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("libroForm", asig);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				libroService.updateLibro(asig);
				model.addAttribute("libroForm", new Libro());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("libroForm", asig);
				model.addAttribute("formTab","active");
				model.addAttribute("libroList", libroService.getAllUsers());
				model.addAttribute("editMode","true");
			}
		}

		model.addAttribute("libroList", libroService.getAllUsers());
		return "libro/libro-view";

	}

	 /**
     * Permite cancelar el que el usuario ha elegido para
     * editar
     * @param model
     * @return formulario libro
     */
	@GetMapping("/editLibro/cancel")
	public String cancelEditLibro(ModelMap model) {
		return "redirect:/libroForm";
	}
	
	  /**
     * permite eliminar el seleccionada
     * @param model
     * @param id del libro a eliminar
     * @return formulario libro
     */
	@GetMapping("/deleteLibro/{id}")
	public String deleteLibro(Model model, @PathVariable(name="id") Long id) {
		try {
			libroService.deleteLibro(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion","La asignatura no puede ser eliminada");
		}
		return libroForm(model);
	}
}
