package es.enriquerosales.enciclopedia.servicio;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para la clase {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
public interface PersonajeService {

	/**
	 * Crea una lista todas las instancias de {@link Personaje} del sistema.
	 * 
	 * @return Una {@link List} con todas las instancias de {@link Personaje} del
	 *         sistema.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Personaje> listar() throws ServiceException;

	/**
	 * Crea una lista las instancias de {@link Personaje} que contengan en su nombre
	 * el filtro obtenido como par�metro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} con todas las instancias de {@link Personaje} del
	 *         sistema cuyo nombre contenga el filtro.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Personaje> listar(String filtroNombre) throws ServiceException;

	/**
	 * Crea una lista las instancias de {@link Personaje} que pertenezcan al
	 * {@link Directorio} indicado como par�metro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} del que obtener los Personajes.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que pertenecen al Directorio dado.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Personaje> listar(Directorio directorio) throws ServiceException;

	/**
	 * Crea una lista las instancias de {@link Personaje} que pertenezcan al
	 * {@link Directorio} indicado como par�metro y contengan en su nombre el filtro
	 * obtenido como par�metro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} del que obtener los Personajes.
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que pertenecen al Directorio dado y cuyo nombre contenga el
	 *         filtro.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Personaje> listar(Directorio directorio, String filtroNombre)
			throws ServiceException;

	/**
	 * Crea una lista las instancias de {@link Personaje} que pertenezcan a la
	 * {@link Afiliacion} indicada como parámetro y contengan en su nombre el filtro
	 * obtenido como parámetro.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} del que obtener los Personajes.
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que pertenecen al Directorio dado y cuyo nombre contenga el
	 *         filtro.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Personaje> listar(Afiliacion afiliacion, String filtroNombre)
			throws ServiceException;

	/**
	 * Devuelve el {@link Personaje} que tenga el ID obtenido como par�metro.
	 * 
	 * @param id
	 *            El ID del {@link Personaje} a buscar.
	 * @return La instancia de {@link Personaje} con el ID buscado, o {@code null}
	 *         si no existe.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	Personaje buscar(int id) throws ServiceException;

	/**
	 * Crea una nueva entrada de {@link Personaje} en el sistema.
	 * 
	 * @param creador
	 *            El {@link Usuario} que est� creando el {@link Personaje}.
	 * @param personaje
	 *            El {@link Personaje} a crear en el sistema.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void crear(Usuario creador, Personaje personaje) throws ServiceException;

	/**
	 * Actualiza la informaci�n de una entrada de {@link Personaje} existente.
	 * 
	 * @param editor
	 *            El {@link Usuario} que est� realizando la edici�n.
	 * 
	 * @param personaje
	 *            El {@link Personaje} cuyos datos se van a actualizar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void editar(Usuario editor, Personaje personaje) throws ServiceException;

	/**
	 * Elimina una entrada de {@link Personaje} del sistema.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a eliminar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void eliminar(Personaje personaje) throws ServiceException;

}
