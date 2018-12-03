package es.enriquerosales.enciclopedia.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Clase controlador para realizar tareas relacionadas con directorios.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
public class DirectorioController {

	@Autowired
	private DirectorioService dirService;

	@Autowired
	private PersonajeService personajeService;

	private static final String ATT_DIR = "directorio";
	private static final String ATT_DIRS = "directorios";
	private static final String ATT_PERSONAJES = "personajes";
	private static final String ATT_BUSQUEDA = "busqueda";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS_DIR = "directorio";
	private static final String SUCCESS_INDEX = "redirect:directorios";
	private static final String SUCCESS_LIST = "listadodirectorios";
	private static final String SUCCESS_FORM = "formdirectorio";
	private static final String SUCCESS_EDIT = "redirect:/verDir?id=";
	private static final String ERROR = "error";

	/**
	 * Muestra la página con el listado de todos los directorios.
	 */
	@GetMapping("/directorios")
	public String mostrarListado(Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar());
			return SUCCESS_LIST;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el listado de directorios filtrado según un criterio de búsqueda.
	 */
	@GetMapping("/buscarDir")
	public String buscarDirectorios(@RequestParam String s, Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar(s));
			model.addAttribute(ATT_BUSQUEDA, s);
			return SUCCESS_LIST;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la página de visualización de un Directorio.
	 */
	@GetMapping(value = "/verDir")
	public String mostrarDirectorio(@RequestParam int id, Model model) {
		try {
			Directorio dir = dirService.buscar(id);
			model.addAttribute(ATT_DIR, dir);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(dir));
			return SUCCESS_DIR;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el listado Personajes dentro de un directorio filtrado según un
	 * criterio de búsqueda.
	 */
	@GetMapping(value = "/buscarPersonajes")
	public String buscarPersonajes(@RequestParam int dir, @RequestParam String s,
			Model model) {
		try {
			Directorio directorio = dirService.buscar(dir);
			model.addAttribute(ATT_DIR, directorio);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(directorio, s));
			model.addAttribute(ATT_BUSQUEDA, s);
			return SUCCESS_DIR;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear o editar un Directorio.
	 */
	@GetMapping(value = "/editarDir")
	public String mostrarFormulario(@ModelAttribute Directorio directorio, Model model) {
		try {
			if (directorio.getId() != null) {
				directorio = dirService.buscar(directorio.getId());
				model.addAttribute(ATT_DIR, directorio);
			}
			return SUCCESS_FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Guarda un Directorio en el sistema, teniendo en cuenta que puede ser nuevo o
	 * editado.
	 */
	@PostMapping(value = "/guardarDir")
	public String guardarDirectorio(@ModelAttribute Directorio directorio, Model model,
			HttpSession session) {
		try {
			Usuario usuario = (Usuario) session.getAttribute("user");
			if (directorio.getId() == null) {
				// Creando nuevo directorio
				dirService.crear(usuario, directorio);
				return SUCCESS_INDEX;
			} else {
				// Editando directorio existente, asignando creador y fecha de creación
				// original.
				Directorio antiguo = dirService.buscar(directorio.getId());
				directorio.setCreador(antiguo.getCreador());
				directorio.setFechaCreacion(antiguo.getFechaCreacion());
				dirService.editar(usuario, directorio);
				return SUCCESS_EDIT + directorio.getId();
			}

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Elimina un Directorio del sistema.
	 */
	@GetMapping(value = "/eliminarDir")
	public String eliminarDirectorio(@ModelAttribute Directorio directorio, Model model) {
		try {
			dirService.eliminar(directorio);
			return SUCCESS_INDEX;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
