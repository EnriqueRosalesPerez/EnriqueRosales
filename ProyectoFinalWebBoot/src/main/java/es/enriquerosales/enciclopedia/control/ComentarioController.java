package es.enriquerosales.enciclopedia.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	private static final String SUCCESS = "redirect:/personaje/";
	private static final String ERROR = "error";

	/**
	 * Publica un nuevo {@link Comentario}.
	 * 
	 * @param personajeid
	 *            El ID del {@link Personaje} donde se realiza la publicación.
	 * @param comentario
	 *            El comentario a publicar.
	 * @param session
	 *            La sesión HTTP en ejecución.
	 * @return Una cadena que representa la página de destino.
	 */
	@PostMapping("/publicar")
	public String publicar(@ModelAttribute Comentario comentario,
			@ModelAttribute(LoginInterceptor.ATT_USER) Usuario usuario) {
		try {
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
	 * @param personaje
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
