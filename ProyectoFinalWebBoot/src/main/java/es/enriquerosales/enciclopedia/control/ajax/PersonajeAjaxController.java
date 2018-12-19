package es.enriquerosales.enciclopedia.control.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

@Controller
@RequestMapping("/ajax")
public class PersonajeAjaxController {

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private AfiliacionService afiliacionService;

	private static final String ATT_PERSONAJES = "personajes";

	private static final String SUCCESS = "forward:/personaje/table.jsp";

	@PostMapping("/directorio/{dir}/buscar")
	public String buscarEnDir(@PathVariable int dir, @RequestParam("s") String criterio,
			Model model) {
		try {
			Directorio directorio = new Directorio();
			directorio.setId(dir);
			model.addAttribute(ATT_PERSONAJES,
					personajeService.listar(directorio, criterio));
			return SUCCESS;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/directorio/{dir}/limpiar")
	public String limpiarEnDir(@PathVariable int dir, Model model) {
		try {
			Directorio directorio = new Directorio();
			directorio.setId(dir);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(directorio));
			return SUCCESS;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/afiliacion/{id}/buscar")
	public String buscarEnAfiliacion(@PathVariable int id,
			@RequestParam("s") String criterio, Model model) {
		try {
			Afiliacion afiliacion = new Afiliacion();
			afiliacion.setId(id);
			model.addAttribute(ATT_PERSONAJES,
					personajeService.listar(afiliacion, criterio));
			return SUCCESS;
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/afiliacion/{id}/limpiar")
	public String limpiarEnAfiliacion(@PathVariable int id, Model model) {
		try {
			Afiliacion afiliacion = afiliacionService.buscar(id);
			afiliacion.setId(id);
			model.addAttribute(ATT_PERSONAJES, afiliacion.getPersonajes());
			return SUCCESS;
		} catch (Exception e) {
			return null;
		}
	}

}
