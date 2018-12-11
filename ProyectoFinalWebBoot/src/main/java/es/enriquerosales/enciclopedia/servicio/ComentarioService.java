package es.enriquerosales.enciclopedia.servicio;

import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para la clase {@link Comentario}.
 * 
 * @author Enrique Rosales
 *
 */
public interface ComentarioService {

	/**
	 * Publica un nuevo {@link Comentario} en la página de un {@link Personaje}
	 * específico.
	 * 
	 * @param usuario
	 *            El {@link Usuario} que publica el comentario.
	 * @param personaje
	 *            El {@link Personaje} donde se publica el comentario.
	 * @param comentario
	 *            El comentario.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void publicar(Usuario usuario, Personaje personaje, String comentario)
			throws ServiceException;

	/**
	 * Elimina un {@link Comentario} del sistema.
	 * 
	 * @param comentario
	 *            El {@link Comentario} a eliminar.
	 * @throws ServiceException
	 */
	void eliminar(Comentario comentario) throws ServiceException;

}
