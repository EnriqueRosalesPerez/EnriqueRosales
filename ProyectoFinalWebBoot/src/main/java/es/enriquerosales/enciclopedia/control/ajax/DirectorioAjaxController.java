package es.enriquerosales.enciclopedia.control.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Controlador AJAX para solicitudes en páginas de {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@RequestMapping("/ajax/directorio")
public class DirectorioAjaxController {

	@Autowired
	private DirectorioService dirService;

	@Autowired
	private PersonajeService personajeService;

	private static final String ATT_DIRS = "directorios";
	private static final String ATT_PERSONAJES = "personajes";

	private static final String TABLA_DIRS = "forward:/directorio/table.jsp";
	private static final String TABLA_PERSONAJES = "forward:/personaje/table.jsp";

	/**
	 * Realiza una búsqueda de directorios según el criterio introducido.
	 * 
	 * @param criterio
	 *            El criterio a utilizar para la búsqueda.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una página JSP con el resultado de la búsqueda.
	 */
	@PostMapping("/buscar")
	public String buscar(@RequestParam("busqueda") String criterio, Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar(criterio));
			return TABLA_DIRS;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Limpia la búsqueda de directorios recuperando todos los directorios.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una página JSP con el resultado.
	 */
	@PostMapping("/limpiar")
	public String limpiar(Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar());
			return TABLA_DIRS;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Busca personajes que pertenezcan a un directorio específico y que cuyo nombre
	 * contenga el criterio de búsqueda introducido.
	 * 
	 * @param id
	 *            El ID del {@link Directorio} donde se realiza la búsqueda.
	 * @param criterio
	 *            El criterio a utilizar para la búsqueda.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una página JSP con el resultado de la búsqueda.
	 */
	@PostMapping("/{id}/buscar")
	public String buscarPersonajes(@PathVariable int id,
			@RequestParam("busqueda") String criterio, Model model) {
		try {
			Directorio directorio = new Directorio();
			directorio.setId(id);
			model.addAttribute(ATT_PERSONAJES,
					personajeService.listar(directorio, criterio));
			return TABLA_PERSONAJES;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Limpia la búsqueda recuperando todos los personajes de un directorio
	 * específico.
	 * 
	 * @param id
	 *            El ID del {@link Directorio} donde se realiza la búsqueda.
	 * @param model
	 *            El criterio a utilizar para la búsqueda.
	 * @return Una página JSP con el resultado.
	 */
	@PostMapping("/{id}/limpiar")
	public String limpiarBusqueda(@PathVariable int id, Model model) {
		try {
			Directorio directorio = new Directorio();
			directorio.setId(id);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(directorio));
			return TABLA_PERSONAJES;
		} catch (Exception e) {
			return null;
		}
	}

}
