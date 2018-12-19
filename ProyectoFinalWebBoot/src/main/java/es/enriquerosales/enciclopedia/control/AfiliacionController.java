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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Clase controlador para realizar tareas relacionadas con directorios.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@RequestMapping("/afiliacion")
public class AfiliacionController {

	@Autowired
	private AfiliacionService afiliacionService;

	@Autowired
	private DirectorioService dirService;

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private MessageSource messages;

	private static final String ATT_AFILIACION = "afiliacion";
	private static final String ATT_PERSONAJES = "personajes";
	private static final String ATT_BUSQUEDA = "busqueda";
	private static final String ATT_USER = "user";
	private static final String ATT_ERROR = "error";

	private static final String VIEW = "afiliacion/view";
	private static final String FORM = "afiliacion/form";
	private static final String DIR = "forward:/directorio/";
	private static final String ERROR = "error";

	/**
	 * Muestra la página de visualización de una Afiliacion.
	 * 
	 * @param id
	 *            El ID de la Afiliacion a visualizar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/{id}")
	public String mostrarAfiliacion(@PathVariable int id, Model model, Locale locale) {
		try {
			Afiliacion afiliacion = afiliacionService.buscar(id);
			if (afiliacion == null) {
				model.addAttribute(ATT_ERROR, messages.getMessage("error.afiliacion.noencontrado", null, locale));
				// Afiliación no encontrada
				return ERROR;
			}
			model.addAttribute(ATT_AFILIACION, afiliacion);
			model.addAttribute(ATT_PERSONAJES, afiliacion.getPersonajes());
			return VIEW;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el listado Personajes dentro de una afiliación filtrado según un
	 * criterio de búsqueda.
	 * 
	 * @param id
	 *            El ID de la Afiliacion donde se realiza la búsqueda.
	 * @param s
	 *            El parámetro de búsqueda.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "{id}/buscar")
	public String buscarPersonajes(@PathVariable int id, @RequestParam String s, Model model, Locale locale) {
		try {
			Afiliacion afiliacion = afiliacionService.buscar(id);
			if (afiliacion == null) {
				// Afiliación no encontrada
				model.addAttribute(ATT_ERROR, messages.getMessage("error.afiliacion.noencontrado", null, locale));
				return ERROR;
			}
			model.addAttribute(ATT_AFILIACION, afiliacion);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(afiliacion, s));
			model.addAttribute(ATT_BUSQUEDA, s);
			return VIEW;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para editar una Afiliacion.
	 * 
	 * @param afiliacion
	 *            La Afiliacion que se va a editar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/{id}/editar")
	public String mostrarFormularioEdicion(@ModelAttribute Afiliacion afiliacion, Model model, Locale locale) {
		try {
			afiliacion = afiliacionService.buscar(afiliacion.getId());
			if (afiliacion == null) {
				// Afiliacion no encontrada
				model.addAttribute(ATT_ERROR, messages.getMessage("error.afiliacion.noencontrado", null, locale));
				return ERROR;
			}

			model.addAttribute(ATT_AFILIACION, afiliacion);
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear una Afiliacion.
	 * 
	 * @param afiliacion
	 *            La Afiliacion que se va a crear.
	 * @param dir
	 *            El Directorio donde se crea la Afiliacion.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/crear")
	public String mostrarFormularioCreacion(@ModelAttribute Afiliacion afiliacion, @RequestParam Integer dir,
			Model model, Locale locale) {
		try {
			// Asignar directorio donde se crea la afiliación.
			Directorio directorio = dirService.buscar(dir);
			if (directorio == null) {
				// Directorio no encontrado
				model.addAttribute(ATT_ERROR, messages.getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			afiliacion.setDirectorio(directorio);
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Guarda una Afiliacion en el sistema, teniendo en cuenta que puede ser nueva o
	 * editada.
	 * 
	 * @param afiliacion
	 *            La Afiliacion que se va a guardar, puede ser nuevo o existente.
	 * @param result
	 *            Interfaz que representa el resultado del formulario.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/guardar")
	public String guardarAfiliacion(@Valid Afiliacion afiliacion, BindingResult result, Model model,
			HttpSession session, Locale locale) {
		try {
			if (result.hasErrors()) {
				// Recuperar datos del directorio
				afiliacion.setDirectorio(dirService.buscar(afiliacion.getDirectorio().getId()));
				if (afiliacion.getId() != null) {
					// Recuperar nombre original para no romper el breadcrumb
					afiliacion.setNombre(afiliacionService.buscar(afiliacion.getId()).getNombre());
				}
				return FORM;
			}
			Usuario usuario = (Usuario) session.getAttribute(ATT_USER);
			if (afiliacion.getId() == null) {
				// Creando nueva afiliacion
				afiliacionService.crear(usuario, afiliacion);
			} else {
				// Editando afiliacion existente, asignando creador y fecha de creación
				// original.
				Afiliacion antiguo = afiliacionService.buscar(afiliacion.getId());
				afiliacion.setCreador(antiguo.getCreador());
				afiliacion.setFechaCreacion(antiguo.getFechaCreacion());
				afiliacionService.editar(usuario, afiliacion);

			}
			return mostrarAfiliacion(afiliacion.getId(), model, locale);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Elimina una Afiliacion del sistema.
	 * 
	 * @param afiliacion
	 *            La Afiliacion a eliminar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/{id}/eliminar")
	public String eliminarAfiliacion(@ModelAttribute Afiliacion afiliacion, Model model, Locale locale) {
		try {
			afiliacion = afiliacionService.buscar(afiliacion.getId());
			if (afiliacion == null) {
				// Afiliacion no encontrada
				model.addAttribute(ATT_ERROR, messages.getMessage("error.afiliacion.noencontrado", null, locale));
				return ERROR;
			}
			int dir = afiliacion.getDirectorio().getId();
			afiliacionService.eliminar(afiliacion);
			return DIR + dir;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
