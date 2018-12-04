package es.enriquerosales.enciclopedia.control;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Directorio;
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

	@Autowired
	private MessageSource messages;

	private static final String ATT_PERSONAJE = "personaje";
	private static final String ATT_DIR = "dir";
	private static final String ATT_USER = "user";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS_VER = "personaje";
	private static final String SUCCESS_FORM = "formpersonaje";
	private static final String SUCCESS_INDEX = "index";
	private static final String ERROR = "error";

	/**
	 * Muestra la p�gina de visualizaci�n de un Personaje.
	 * 
	 * @param id
	 *            El ID del Personaje a visualizar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/verPersonaje")
	public String mostrarPersonaje(@RequestParam int id, Model model, Locale locale) {
		try {
			Personaje personaje = personajeService.buscar(id);
			if (personaje == null) {
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.personaje.noencontrado", null, locale));
				// Personaje no encontrado
				return ERROR;
			}
			model.addAttribute(ATT_PERSONAJE, personaje);
			return SUCCESS_VER;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear o editar un Personaje.
	 * 
	 * @param personaje
	 *            El Personaje que se va a editar, puede ser nuevo o existente.
	 * @param dir
	 *            El ID del Directorio al que pertenece el Personaje.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/editarPersonaje")
	public String mostrarFormulario(@ModelAttribute Personaje personaje,
			@RequestParam Integer dir, Model model, Locale locale) {
		try {
			if (personaje.getId() != null) {
				// Editando personaje existente
				personaje = personajeService.buscar(personaje.getId());
				if (personaje == null) {
					// Personaje no encontrado
					model.addAttribute(ATT_ERROR, messages
							.getMessage("error.personaje.noencontrado", null, locale));
					return ERROR;
				}
			} else {
				// Creando nuevo personaje, se asigna el directorio al que va a
				// pertenecer.
				Directorio directorio = new Directorio();
				directorio.setId(dir);
				personaje.setDirectorio(directorio);
			}
			model.addAttribute(ATT_PERSONAJE, personaje);
			model.addAttribute(ATT_DIR, dir);
			return SUCCESS_FORM;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Guarda un Personaje en el sistema, teniendo en cuenta que puede ser nuevo o
	 * editado.
	 * 
	 * @param personaje
	 *            El Personaje que se va a guardar, puede ser nuevo o existente.
	 * @param result
	 *            Interfaz que representa el resultado del formulario.
	 * @param dir
	 *            El ID del Directorio al que pertenece el Personaje.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/guardarPersonaje")
	public String guardarPersonaje(@Valid Personaje personaje, BindingResult result,
			@RequestParam Integer dir, Model model, HttpSession session) {
		try {
			if (result.hasErrors()) {
				return SUCCESS_FORM;
			}
			Usuario usuario = (Usuario) session.getAttribute(ATT_USER);
			personaje.setDirectorio(dirService.buscar(dir));
			if (personaje.getId() == null) {
				// Creando nuevo personaje
				personajeService.crear(usuario, personaje);
				return SUCCESS_INDEX;
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
	 * 
	 * @param personaje
	 *            El Personaje a eliminar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/eliminarPersonaje")
	public String eliminarPersonaje(@ModelAttribute Personaje personaje, Model model) {
		try {
			personajeService.eliminar(personaje);
			return SUCCESS_INDEX;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
