package es.enriquerosales.enciclopedia.control;

import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Clase controlador para realizar tareas relacionadas con directorios.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@RequestMapping("/personaje")
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private DirectorioService dirService;

	@Autowired
	private AfiliacionService afiliacionService;

	@Autowired
	private MessageSource messages;

	private static final String ATT_PERSONAJE = "personaje";
	private static final String ATT_AFILIACIONES = "afiliaciones";
	private static final String ATT_USER = "user";
	private static final String ATT_ERROR = "error";

	private static final String VIEW = "personaje/view";
	private static final String FORM = "personaje/form";
	private static final String DIR = "forward:/directorio/";
	private static final String ERROR = "error";

	/**
	 * Método {@link InitBinder} que trata los datos del formulario de Personaje y
	 * los convierte a los tipos adecuados.
	 * 
	 * @param binder
	 *            Permite acceder a los componentes dentro de la solicitud.
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Set.class, "afiliaciones", new CustomCollectionEditor(Set.class) {
			// Convierte los ID que llegan en la solicitud como un array de String
			// a objetos Afiliacion
			protected Object convertElement(Object idStr) {
				if (idStr instanceof String) {
					try {
						int id = Integer.parseInt((String) idStr);
						return afiliacionService.buscar(id);

					} catch (ServiceException e) {
						e.printStackTrace();
					}
				}
				return null;
			}
		});
	}

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
	@GetMapping(value = "/{id}")
	public String mostrarPersonaje(@PathVariable int id, @ModelAttribute Comentario comentario, Model model,
			Locale locale) {
		try {
			Personaje personaje = personajeService.buscar(id);
			if (personaje == null) {
				model.addAttribute(ATT_ERROR, messages.getMessage("error.personaje.noencontrado", null, locale));
				// Personaje no encontrado
				return ERROR;
			}
			model.addAttribute(ATT_PERSONAJE, personaje);
			model.addAttribute(ATT_AFILIACIONES, personaje.getDirectorio().getAfiliaciones());
			return VIEW;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para editar un Personaje.
	 * 
	 * @param personaje
	 *            El Personaje que se va a editar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/{id}/editar")
	public String mostrarFormularioEdicion(@ModelAttribute Personaje personaje, Model model, Locale locale) {
		try {
			personaje = personajeService.buscar(personaje.getId());
			if (personaje == null) {
				// Personaje no encontrado
				model.addAttribute(ATT_ERROR, messages.getMessage("error.personaje.noencontrado", null, locale));
				return ERROR;
			}
			// model.addAttribute(ATT_AFILIACIONES,
			// personaje.getDirectorio().getAfiliaciones());
			model.addAttribute(ATT_PERSONAJE, personaje);
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear un Personaje.
	 * 
	 * @param personaje
	 *            El Personaje que se va a crear.
	 * @param dir
	 *            El Directorio donde se crea el Personaje.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/crear")
	public String mostrarFormularioCreacion(@ModelAttribute Personaje personaje, @RequestParam Integer dir, Model model,
			Locale locale) {
		try {
			// Asignar directorio donde se crea el personaje.
			Directorio directorio = dirService.buscar(dir);
			if (directorio == null) {
				// Directorio no encontrado
				// model.addAttribute(ATT_ERROR, messages
				// .getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			personaje.setDirectorio(directorio);
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
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
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/guardar")
	public String guardarPersonaje(@Valid Personaje personaje, BindingResult result, Model model, HttpSession session,
			Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			}
			Usuario usuario = (Usuario) session.getAttribute(ATT_USER);
			if (personaje.getId() == null) {
				// Creando nuevo personaje
				personajeService.crear(usuario, personaje);
			} else {
				// Editando personaje existente, asignando creador y fecha de creaci�n
				// original.
				Personaje antiguo = personajeService.buscar(personaje.getId());
				personaje.setCreador(antiguo.getCreador());
				personaje.setFechaCreacion(antiguo.getFechaCreacion());
				personajeService.editar(usuario, personaje);

			}
			return mostrarPersonaje(personaje.getId(), new Comentario(), model, locale);

		} catch (Exception e) {
			e.printStackTrace();
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
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/{id}/eliminar")
	public String eliminarPersonaje(@ModelAttribute Personaje personaje, Model model, Locale locale) {
		try {
			personaje = personajeService.buscar(personaje.getId());
			if (personaje == null) {
				// Personaje no encontrado
				model.addAttribute(ATT_ERROR, messages.getMessage("error.personaje.noencontrado", null, locale));
				return ERROR;
			}
			int dir = personaje.getDirectorio().getId();
			personajeService.eliminar(personaje);
			return DIR + dir;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
