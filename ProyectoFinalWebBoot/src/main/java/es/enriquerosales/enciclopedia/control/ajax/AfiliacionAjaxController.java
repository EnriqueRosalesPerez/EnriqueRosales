package es.enriquerosales.enciclopedia.control.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Controlador AJAX para solicitudes en páginas de {@link Afiliacion}.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@RequestMapping("/ajax/afiliacion")
public class AfiliacionAjaxController {

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private AfiliacionService afiliacionService;

	private static final String ATT_PERSONAJES = "personajes";

	private static final String TABLA_PERSONAJES = "forward:/personaje/table.jsp";

	/**
	 * Busca personajes que pertenezcan a una afiliación específica y que cuyo
	 * nombre contenga el criterio de búsqueda introducido.
	 * 
	 * @param id
	 *            El ID de la {@link Afiliacion} donde se realiza la búsqueda.
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
			Afiliacion afiliacion = new Afiliacion();
			afiliacion.setId(id);
			model.addAttribute(ATT_PERSONAJES,
					personajeService.listar(afiliacion, criterio));
			return TABLA_PERSONAJES;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Limpia la búsqueda recuperando todos los personajes de una afiliación
	 * específica.
	 * 
	 * @param id
	 *            El ID de la {@link Afiliacion} donde se realiza la búsqueda.
	 * @param model
	 *            El criterio a utilizar para la búsqueda.
	 * @return Una página JSP con el resultado.
	 */
	@PostMapping("/{id}/limpiar")
	public String limpiarBusqueda(@PathVariable int id, Model model) {
		try {
			Afiliacion afiliacion = afiliacionService.buscar(id);
			afiliacion.setId(id);
			model.addAttribute(ATT_PERSONAJES, afiliacion.getPersonajes());
			return TABLA_PERSONAJES;
		} catch (Exception e) {
			return null;
		}
	}

}
