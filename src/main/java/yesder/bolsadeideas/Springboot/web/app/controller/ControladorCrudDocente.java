/**
 * 
 */
package yesder.bolsadeideas.Springboot.web.app.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yesder.bolsadeideas.Springboot.web.app.entity.Docente;
import yesder.bolsadeideas.Springboot.web.app.repository.DocenteRepository;
/**
 * @author PERSONAL
 *
 */
@Controller 
public class ControladorCrudDocente {
	@Autowired
    private DocenteRepository uc;
	
	@GetMapping("/docente-form")
	//@RequestMapping(value="/docente-form", method = RequestMethod.GET)
    public String listaUsuarios(ModelMap mp){
        mp.addAttribute("docentes", uc.findAll());
        return "docente/docente-form";
    }
	
	//@GetMapping("/docente-form")
//	@RequestMapping(value="/docente-form", method = RequestMethod.GET)
//	@ResponseBody
//    public String listaUsuarios(ModelMap mp){
//        mp.put("docentes", uc.findAll());
//        return "docente/docente-form";
//    }
// 
	@RequestMapping(value="/nuevo", method=RequestMethod.GET)
    public String nuevo(ModelMap mp, BindingResult bindingResult){
		 
        mp.addAttribute("docente", new Docente());
        
        return "docente/docente-form";
    }
   
//   // @RequestMapping(value="", method = RequestMethod.GET)
//	public String getDocenteForm(ModelMap mp) {
//		return listaUsuarios(mp);
//	}
    @RequestMapping(value="/docente-form", method=RequestMethod.POST)
    public String crear(@Valid Docente docente, BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "docente/docente-form";
        }else{
            uc.save(docente);
            mp.addAttribute("docente", docente);
            return listaUsuarios(mp);
        }
    }
// 
//    @RequestMapping(value="/docente-form", method = RequestMethod.POST)
//    public String creado(@RequestParam("docente") Docente docente){
//        return "docente/docente-form";
//    }

}
