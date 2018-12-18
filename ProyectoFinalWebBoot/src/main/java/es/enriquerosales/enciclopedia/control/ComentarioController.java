package es.enriquerosales.enciclopedia.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.enriquerosales.enciclopedia.interceptor.LoginInterceptor;
import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.ComentarioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Clase controlador para realizar tareas relacionadas con comentarios.
 * 
 * @author Enrique Rosales
 *
 */
@Controller
@RequestMapping("/comentario")
@SessionAttributes(LoginInterceptor.ATT_USER)
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	@Autowired
	private PersonajeService personajeService;

	private static final String SUCCESS = "redirect:/personaje/";
	private static final String VIEW = "personaje/view";
	private static final String ERROR = "error";

	/**
	 * Publica un nuevo {@link Comentario}.
	 * 
	 * @param comentario
	 *            El comentario a publicar.
	 * @param result
	 *            Interfaz que representa el resultado del formulario.
	 * @param usuario
	 *            El {@link Usuario} de la sesión actual.
	 * @param model
	 *            Interfaz donde se almacenan atributos.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping("/publicar")
	public String publicar(@Valid Comentario comentario, BindingResult result,
			@ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario, Model model) {
		try {
			if (result.hasErrors()) {
				// Volviendo a página de personaje mostrando error
				Personaje personaje = personajeService.buscar(comentario.getPersonaje().getId());
				model.addAttribute("personaje", personaje);
				return VIEW;
			}
			comentarioService.publicar(usuario, comentario.getPersonaje(), comentario.getComentario());
			// Volver a la página donde se estaba
			return SUCCESS + comentario.getPersonaje().getId();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * Elimina un {@link Comentario}.
	 * 
	 * @param comentario
	 *            El {@link Comentario} a eliminar.
	 * @param personajeid
	 *            El ID del {@link Personaje} en el que se está.
	 * @return Una cadena que representa la página de destino.
	 */
	@GetMapping("/{id}/eliminar")
	public String eliminar(@ModelAttribute Comentario comentario, @RequestParam Integer personajeid) {
		try {
			comentarioService.eliminar(comentario);
			// Volver a la página donde se estaba
			return SUCCESS + personajeid;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
