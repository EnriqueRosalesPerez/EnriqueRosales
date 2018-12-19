package es.enriquerosales.enciclopedia.control;

import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import es.enriquerosales.enciclopedia.interceptor.LoginInterceptor;
import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.ArchivoService;
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
@SessionAttributes(LoginInterceptor.ATT_USER)
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;

	@Autowired
	private DirectorioService dirService;

	@Autowired
	private AfiliacionService afiliacionService;

	@Autowired
	private ArchivoService archivoService;

	@Autowired
	private MessageSource messages;

	@Autowired
	private ServletContext context;

	private static final String ATT_PERSONAJE = "personaje";
	private static final String ATT_AFILIACIONES = "afiliaciones";
	private static final String ATT_ERROR = "error";
	private static final String IMAGES_PATH = "images/";
	private static final String IMAGES_NAME = "attachment_";

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
	 * @param comentario
	 *            Atributo para el formulario de Comentarios.
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
			model.addAttribute(ATT_AFILIACIONES, personaje.getAfiliaciones());
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
	 * @param comentario
	 *            Atributo del modelo para vincularse a la página del personaje
	 *            después de guardarlo.
	 * @param usuario
	 *            El {@link Usuario} de la sesión actual.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/guardar")
	public String guardarPersonaje(@Valid Personaje personaje, BindingResult result,
			@RequestParam MultipartFile retrato, @RequestParam(required = false) boolean borrarImagen,
			@ModelAttribute Comentario comentario, @ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario,
			Model model, Locale locale) {
		try {
			if (result.hasErrors()) {
				// Recuperar datos del directorio
				personaje.setDirectorio(dirService.buscar(personaje.getDirectorio().getId()));
				if (personaje.getId() != null) {
					// Recuperar datos originales
					Personaje antiguo = personajeService.buscar(personaje.getId());
					personaje.setNombre(antiguo.getNombre());
					personaje.setImagen(antiguo.getImagen());
				}
				return FORM;
			}
			if (personaje.getId() == null) {
				// Creando nuevo personaje
				if (!retrato.isEmpty()) {
					personaje.setImagen(guardar(retrato));
				}
				personajeService.crear(usuario, personaje);
			} else {
				// Editando personaje existente, asignando creador, fecha de creaci�n e
				// imagen original.
				Personaje antiguo = personajeService.buscar(personaje.getId());
				personaje.setCreador(antiguo.getCreador());
				personaje.setFechaCreacion(antiguo.getFechaCreacion());
				personaje.setImagen(antiguo.getImagen());
				if (borrarImagen) {
					borrar(personaje.getImagen());
					personaje.setImagen(null);
				} else if (!retrato.isEmpty()) {
					// Eliminar imagen antigua
					if (personaje.getImagen() != null) {
						borrar(personaje.getImagen());
					}
				}
				if (!retrato.isEmpty()) {
					personaje.setImagen(guardar(retrato));
				}
				personajeService.editar(usuario, personaje);
			}

			return "redirect:/personaje/" + personaje.getId();

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

	/**
	 * Guarda la imagen en el sistema.
	 * 
	 * @param file
	 *            El archivo a guardar.
	 * @return La ruta donde se ha guardado el archivo.
	 * @throws ServiceException
	 *             Si se produce un error al guardar el fichero.
	 */
	private String guardar(MultipartFile file) throws ServiceException {
		String ruta = null;
		if (file != null && file.getOriginalFilename() != null && !file.getOriginalFilename().isEmpty()) {
			ruta = IMAGES_PATH + IMAGES_NAME + System.currentTimeMillis() + "_" + file.getOriginalFilename();
			String path = context.getRealPath(ruta);

			// Almacenar en disco
			archivoService.guardar(file, path);
		}

		return ruta;
	}

	/**
	 * Elimina el archivo situado en la ruta obtenida.
	 * 
	 * @param filePath
	 *            La ruta del archivo a eliminar.
	 * @throws ServiceException
	 *             Si se produce un error al eliminar.
	 */
	private void borrar(String filePath) throws ServiceException {
		archivoService.eliminar(context.getRealPath(filePath));
	}
}
