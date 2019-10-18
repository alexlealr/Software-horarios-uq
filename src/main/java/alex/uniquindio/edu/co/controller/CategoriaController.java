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
import alex.uniquindio.edu.co.service.CategoriaService;

/**
 * Clase controlador que permite redireccionar a los formulario del crud
 * categoria y de igual forma realizar su crud en la base de datos
 * 
 * @author alexander leal
 *
 */
@Controller
public class CategoriaController {

	/**
	 * Servicio categoria en el cual se encuentran los metodos pertinentes al crud
	 * de categoria
	 */
	@Autowired
	CategoriaService categoriaService;

	/**
	 * Permite cargar el formulario de registro de categoria
	 * @param model
	 * @return categoria/categoria-view formulario
	 */
	@GetMapping("/categoriaForm")
	public String categoriaForm(Model model) {
		model.addAttribute("categoriaForm", new Categoria());
		model.addAttribute("categoriaList", categoriaService.getAllUsers());
		model.addAttribute("listTab", "active");
		return "categoria/categoria-view";
	}
    /**
     * Permite crear la categoria de acuerdo a los datos ingresado por 
     * el usuario
     * @param asig Entidad categoria
     * @param result 
     * @param model
     * @return formulario categoria
     */
	@PostMapping("/categoriaForm")
	public String createCategoria(@Valid @ModelAttribute("categoriaForm") Categoria asig, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("categoriaForm", asig);
			model.addAttribute("formTab", "active");
		} else {
			try {
				categoriaService.createCategoria(asig);
				model.addAttribute("categoriaForm", new Categoria());
				model.addAttribute("listTab", "active");

			} catch (Exception e) {

				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("categoriaForm", asig);
				model.addAttribute("formTab", "active");
				model.addAttribute("userList", categoriaService.getAllUsers());

			}
		}
		model.addAttribute("categoriaList", categoriaService.getAllUsers());
		return "categoria/categoria-view";
	}

	/**
	 * Setea los datos de la categoria que el usuario selecciona para editar
	 * @param model
	 * @param id variable para identificar la categoria seleccionada
	 * @return formuario categoria
	 * @throws Exception
	 */
	@GetMapping("/editCategoria/{id}")
	public String getEditCategoriaForm(Model model, @PathVariable(name = "id") Long id) throws Exception {
		Categoria asigToEdit = categoriaService.getCategoriaById(id);

		model.addAttribute("categoriaForm", asigToEdit);
		model.addAttribute("categoriaList", categoriaService.getAllUsers());
		model.addAttribute("formTab", "active");
		model.addAttribute("editMode", "true");

		return "categoria/categoria-view";
	}
    /**
     * Permite editar la categoria que el usuario seleccione
     * @param asig Entidad categoria
     * @param result
     * @param model
     * @return formulario categoria
     */
	@PostMapping("/editCategoria")
	public String postEditCategoriaForm(@Valid @ModelAttribute("categoriaForm") Categoria asig, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("categoriaForm", asig);
			model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				categoriaService.updateCategoria(asig);
				model.addAttribute("categoriaForm", new Categoria());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("categoriaForm", asig);
				model.addAttribute("formTab", "active");
				model.addAttribute("categoriaList", categoriaService.getAllUsers());
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("categoriaList", categoriaService.getAllUsers());
		return "categoria/categoria-view";

	}
    /**
     * Permite cancelar la categoria que el usuario ha elegido para
     * editar
     * @param model
     * @return formulario categoria
     */
	@GetMapping("/editCategoria/cancel")
	public String cancelEditCategoria(ModelMap model) {
		return "redirect:/categoriaForm";
	}
	
    /**
     * permite eliminar la categoria seleccionada
     * @param model
     * @param id de la categoria a eliminar
     * @return formulario categoria
     */
	@GetMapping("/deleteCategoria/{id}")
	public String deleteCategoria(Model model, @PathVariable(name = "id") Long id) {
		try {
			categoriaService.deleteCategoria(id);
		} catch (Exception e) {
			model.addAttribute("Error de eliminacion", "La asignatura no puede ser eliminada");
		}
		return categoriaForm(model);
	}
}
