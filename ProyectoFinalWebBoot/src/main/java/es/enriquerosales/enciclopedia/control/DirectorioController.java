package es.enriquerosales.enciclopedia.control;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private MessageSource messages;

	private static final String ATT_DIR = "directorio";
	private static final String ATT_DIRS = "directorios";
	private static final String ATT_PERSONAJES = "personajes";
	private static final String ATT_AFILIACIONES = "afiliaciones";
	private static final String ATT_BUSQUEDA = "busqueda";
	private static final String ATT_ERROR = "error";

	private static final String VIEW = "directorio/view";
	private static final String LIST = "directorio/list";
	private static final String FORM = "directorio/form";
	private static final String ERROR = "error";

	/**
	 * Muestra la p�gina con el listado de todos los directorios.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping("/directorios")
	public String mostrarListado(Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar());
			return LIST;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el listado de directorios filtrado seg�n un criterio de b�squeda.
	 * 
	 * @param s
	 *            El parámetro de búsqueda.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping("/directorios/buscar")
	public String buscarDirectorios(@RequestParam String s, Model model) {
		try {
			model.addAttribute(ATT_DIRS, dirService.listar(s));
			model.addAttribute(ATT_BUSQUEDA, s);
			return LIST;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra la p�gina de visualizaci�n de un Directorio.
	 * 
	 * @param id
	 *            El ID del Directorio a visualizar.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/directorio/{id}")
	public String mostrarDirectorio(@PathVariable int id, Model model, Locale locale) {
		try {
			Directorio dir = dirService.buscar(id);
			if (dir == null) {
				// Directorio no encontrado
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			model.addAttribute(ATT_DIR, dir);
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(dir));
			model.addAttribute(ATT_AFILIACIONES, dir.getAfiliaciones());
			return VIEW;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el listado Personajes dentro de un directorio filtrado seg�n un
	 * criterio de b�squeda.
	 * 
	 * @param dir
	 *            El ID del Directorio donde se realiza la búsqueda.
	 * @param s
	 *            El parámetro de búsqueda.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/directorio/{dir}/buscar")
	public String buscarPersonajes(@PathVariable int dir, @RequestParam String s,
			Model model, Locale locale) {
		try {
			Directorio directorio = dirService.buscar(dir);
			if (directorio == null) {
				// Directorio no encontrado
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			model.addAttribute(ATT_DIR, directorio);
			model.addAttribute(ATT_AFILIACIONES, directorio.getAfiliaciones());
			model.addAttribute(ATT_PERSONAJES, personajeService.listar(directorio, s));
			model.addAttribute(ATT_BUSQUEDA, s);
			return VIEW;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para editar un Directorio.
	 * 
	 * @param directorio
	 *            El Directorio que se esté editando.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/directorio/{id}/editar")
	public String mostrarFormularioEdicion(@ModelAttribute Directorio directorio,
			Model model, Locale locale) {
		try {
			directorio = dirService.buscar(directorio.getId());
			if (directorio == null) {
				// Directorio no encontrado
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			model.addAttribute("directorio", directorio);
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario para crear un Directorio.
	 * 
	 * @param directorio
	 *            El Directorio que se esté creando.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/directorio/crear")
	public String mostrarFormularioCreacion(@ModelAttribute Directorio directorio,
			Model model) {
		try {
			return FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Guarda un Directorio en el sistema, teniendo en cuenta que puede ser nuevo o
	 * editado.
	 * 
	 * @param directorio
	 *            El Directorio que se esté guardando, puede ser nuevo o existente.
	 * @param result
	 *            Interfaz que representa el resultado del formulario.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @param Locale
	 *            locale La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/directorio/guardar")
	public String guardarDirectorio(@Valid Directorio directorio, BindingResult result,
			Model model, HttpSession session, Locale locale) {
		try {
			if (result.hasErrors()) {
				return FORM;
			}
			Usuario usuario = (Usuario) session.getAttribute("user");
			if (directorio.getId() == null) {
				// Creando nuevo directorio
				dirService.crear(usuario, directorio);
			} else {
				// Editando directorio existente, asignando creador y fecha de creaci�n
				// original.
				Directorio antiguo = dirService.buscar(directorio.getId());
				directorio.setCreador(antiguo.getCreador());
				directorio.setFechaCreacion(antiguo.getFechaCreacion());
				dirService.editar(usuario, directorio);
			}
			return mostrarDirectorio(directorio.getId(), model, locale);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Elimina un Directorio del sistema.
	 * 
	 * @param directorio
	 *            El Directorio que se esté eliminando.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param Locale
	 *            locale La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/directorio/{id}/eliminar")
	public String eliminarDirectorio(@ModelAttribute Directorio directorio, Model model,
			Locale locale) {
		try {
			directorio = dirService.buscar(directorio.getId());
			if (directorio == null) {
				// Directorio no existe
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.directorio.noencontrado", null, locale));
				return ERROR;
			}
			dirService.eliminar(directorio);
			return mostrarListado(model);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DataIntegrityViolationException) {
				// Se está intentando eliminar un Directorio que tiene personajes dentro.
				model.addAttribute(ATT_ERROR, messages
						.getMessage("error.directorio.eliminar.novacio", null, locale));
				return mostrarDirectorio(directorio.getId(), model, locale);
			}
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
