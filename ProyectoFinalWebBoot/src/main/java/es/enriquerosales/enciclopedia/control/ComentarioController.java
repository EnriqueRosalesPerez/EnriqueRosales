package es.enriquerosales.enciclopedia.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

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
	public String publicar(@RequestParam Integer personajeid,
			@RequestParam String comentario, HttpSession session) {
		try {
			Personaje personaje = new Personaje();
			personaje.setId(personajeid);
			Usuario usuario = (Usuario) session.getAttribute("user");
			comentarioService.publicar(usuario, personaje, comentario);
			return "redirect:/verPersonaje?id=" + personajeid;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@GetMapping("/eliminarComentario")
	public String eliminar(@RequestParam Integer id, @RequestParam Integer personaje) {
		try {
			Comentario comentario = new Comentario();
			comentario.setId(id);
			comentarioService.eliminar(comentario);
			return "redirect:/verPersonaje?id=" + personaje;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
