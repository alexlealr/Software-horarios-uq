package alex.uniquindio.edu.co.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.swing.JOptionPane;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import alex.uniquindio.edu.co.entity.Libro;
import alex.uniquindio.edu.co.repository.CategoriaRepository;
import alex.uniquindio.edu.co.repository.UsuarioRepository;
import alex.uniquindio.edu.co.service.LibroService;

@Controller
public class LibroController {

	@Autowired
	LibroService libroService;

	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/libroForm")
	public String libroForm(Model model) {
		model.addAttribute("libroForm", new Libro());
		model.addAttribute("categorias",categoriaRepository.findAll());
		model.addAttribute("libroList", libroService.getAllUsers());
		model.addAttribute("listTab","active");
		return "libro/libro-view";
	}

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
	
	@GetMapping("/ver{id}")
	public String ver(@PathVariable(value="id")Long id, Map<String, Object> model, RedirectAttributes flash) throws Exception {
		JOptionPane.showMessageDialog(null,"entro");
		Libro lib= libroService.getLibroById(id);
		if (lib==null) {
			flash.addFlashAttribute("Error", "El libro no existe en la base de datos");
			return "redirect:/libro-list";
		}
		model.put("libro",lib);
		model.put("titulo", lib.getNombre());
		
		return "redirect:/libro/ver";
	}
	@GetMapping("/editLibro/{id}")
	public String getEditLibroForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		Libro asigToEdit = libroService.getLibroById(id);

		model.addAttribute("libroForm", asigToEdit);
		model.addAttribute("libroList", libroService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");

		return "libro/libro-view";
	}
	

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

	@GetMapping("/editLibro/cancel")
	public String cancelEditLibro(ModelMap model) {
		return "redirect:/libroForm";
	}
	
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
