package es.enriquerosales.enciclopedia.control;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Clase controlador para realizar tareas relacionadas con el login.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MessageSource messages;

	private static final String ATT_ERROR = "error";
	private static final String ATT_USER = "user";

	private static final String SUCCESS_GET = "formlogin";
	private static final String ERROR = "error";
	private static final String SUCCESS_POST = "redirect:/directorios";
	private static final String ERROR_LOGIN = "formlogin";

	/**
	 * Muestra el formulario de login.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping(value = "/login")
	public String mostrarForm(Model model) {
		try {
			return SUCCESS_GET;
		} catch (Exception e) {
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
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @param locale
	 *            La configuración de idioma activa.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping(value = "/login")
	public String realizarLogin(@RequestParam String username, @RequestParam String pass,
			Model model, HttpSession session, Locale locale) {
		try {
			Usuario usuario = usuarioService.acceder(username, pass);
			if (usuario == null) {
				model.addAttribute(ATT_ERROR,
						messages.getMessage("login.error", null, locale));
				return ERROR_LOGIN;
			}
			session.setAttribute(ATT_USER, usuario);
			return SUCCESS_POST;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	/**
	 * Desconecta al usuario que est� conectado.
	 * 
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @return Una cadena que representa la página de destino.
	 */
	@RequestMapping(value = "/logout")
	public String desconectar(Model model, HttpSession session) {
		try {
			session.removeAttribute(ATT_USER);
			return SUCCESS_POST;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

}
