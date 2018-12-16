package es.enriquerosales.enciclopedia.control;

import java.util.Locale;

import org.hibernate.AssertionFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.enriquerosales.enciclopedia.interceptor.LoginInterceptor;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Clase controlador para realizar tareas relacionadas con Usuarios (login y
 * registro).
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@SessionAttributes(LoginInterceptor.ATT_USER)
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MessageSource messages;

	private static final String ATT_ERROR = "error";

	private static final String LOGIN_FORM = "login/form";
	private static final String ERROR = "error";
	private static final String SUCCESS = "redirect:/directorios";
	private static final String REGISTRO_FORM = "registro/form";

	/**
	 * Muestra el formulario de login.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/login")
	public String mostrarLoginForm(@ModelAttribute Usuario usuario, Model model) {
		try {
			return LOGIN_FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Intenta realizar el login del usuario.
	 * 
	 * @param username
	 *            El nombre de usuario.
	 * @param pass
	 *            La contraseña.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/login")
	public String realizarLogin(@ModelAttribute Usuario usuario, Model model, Locale locale) {
		try {
			usuario = usuarioService.acceder(usuario.getNombreUsuario(), usuario.getContrasenna());
			if (usuario == null) {
				model.addAttribute(ATT_ERROR, messages.getMessage("login.error", null, locale));
				return LOGIN_FORM;
			}
			model.addAttribute(LoginInterceptor.ATT_USER, usuario);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Muestra el formulario de registro de usuario.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/registro")
	public String mostrarRegistroForm(@ModelAttribute Usuario usuario, Model model) {
		try {
			return REGISTRO_FORM;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Intenta realizar el registro de un nuevo usuario.
	 * 
	 * @param username
	 *            El nombre de usuario.
	 * @param pass
	 *            La contraseña.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/registro")
	public String registrarUsuario(@ModelAttribute Usuario usuario, Model model, Locale locale) {
		try {
			usuarioService.registrar(usuario);
			// Una vez realizado el registro, se hace login con el usuario.
			return realizarLogin(usuario, model, locale);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof AssertionFailure) {
				// Nombre de usuario introducido ya existente
				// TODO Usar result.reject();
				model.addAttribute(ATT_ERROR, messages.getMessage("registro.error.usuarioexistente", null, locale));
				return REGISTRO_FORM;
			} else {
				model.addAttribute(ATT_ERROR, messages.getMessage("registro.error", null, locale));
				return REGISTRO_FORM;
			}
		}
	}

	/**
	 * Desconecta al usuario que est� conectado.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param sessionStatus
	 *            La sesión HTTP en ejecución.
	 * @return Una cadena que representa la página de destino.
	 */
	@RequestMapping(value = "/logout")
	public String desconectar(Model model, SessionStatus sessionStatus) {
		try {
			sessionStatus.setComplete();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
