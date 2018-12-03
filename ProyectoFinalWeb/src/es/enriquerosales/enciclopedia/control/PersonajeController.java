package es.enriquerosales.enciclopedia.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Personaje;
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
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private DirectorioService dirService;

	private static final String ATT_ERROR = "error";

	private static final String ERROR = "error";

	/**
	 * Muestra la p�gina de visualizaci�n de un Personaje.
	 */
	@GetMapping(value = "/verPersonaje")
	public String mostrarPersonaje(@RequestParam int id, Model model) {
		try {
			Personaje personaje = personajeService.buscar(id);
			model.addAttribute("personaje", personaje);
			return "personaje";
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear o editar un Personaje.
	 */
	@GetMapping(value = "/editarPersonaje")
	public String mostrarFormulario(@ModelAttribute Personaje personaje,
			@RequestParam int dir, Model model) {
		try {
			if (personaje.getId() != null) {
				personaje = personajeService.buscar(personaje.getId());
				model.addAttribute("personaje", personaje);
			}
			model.addAttribute("dir", dir);
			return "formpersonaje";
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Guarda un Directorio en el sistema, teniendo en cuenta que puede ser nuevo o
	 * editado.
	 */
	@PostMapping(value = "/guardarPersonaje")
	public String guardarPersonaje(@ModelAttribute Personaje personaje,
			@RequestParam int dir, Model model, HttpSession session) {
		try {
			Usuario usuario = (Usuario) session.getAttribute("user");
			personaje.setDirectorio(dirService.buscar(dir));
			if (personaje.getId() == null) {
				// Creando nuevo personaje
				personajeService.crear(usuario, personaje);
				return "index";
			} else {
				// Editando personaje existente, asignando creador y fecha de creaci�n
				// original.
				Personaje antiguo = personajeService.buscar(personaje.getId());
				personaje.setCreador(antiguo.getCreador());
				personaje.setFechaCreacion(antiguo.getFechaCreacion());
				personajeService.editar(usuario, personaje);
				return "redirect:/verPersonaje?id=" + personaje.getId() + "&dir=" + dir;
			}

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Elimina un Personaje del sistema.
	 */
	@GetMapping(value = "/eliminarPersonaje")
	public String eliminarPersonaje(@ModelAttribute Personaje personaje, Model model) {
		try {
			personajeService.eliminar(personaje);
			return "index";
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
