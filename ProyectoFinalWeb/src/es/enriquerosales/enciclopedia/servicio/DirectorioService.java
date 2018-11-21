package es.enriquerosales.enciclopedia.servicio;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Intefaz de la capa de servicio para la clase {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
public interface DirectorioService {

	/**
	 * Crea una lista todas las instancias de {@link Directorio} del sistema.
	 * 
	 * @return Una {@link List} con todas las instancias de {@link Directorio} del
	 *         sistema.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Directorio> listar() throws ServiceException;

	/**
	 * Crea una lista las instancias de {@link Directorio} que contengan en su
	 * nombre el filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Directorio}.
	 * @return Una {@link List} con todas las instancias de {@link Directorio} del
	 *         sistema cuyo nombre contenga el filtro.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	List<Directorio> listar(String filtroNombre) throws ServiceException;

	/**
	 * Crea un nuevo {@link Directorio} en el sistema.
	 * 
	 * @param personaje
	 *            El {@link Directorio} a crear en el sistema.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void crear(Directorio directorio) throws ServiceException;

	/**
	 * Actualiza la información de un {@link Directorio} existente.
	 * 
	 * @param editor
	 *            El {@link Usuario} que está realizando la edición.
	 * @param directorio
	 *            El {@link Directorio} cuyos datos se van a actualizar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void editar(Usuario editor, Directorio directorio) throws ServiceException;

	/**
	 * Elimina un {@link Directorio} del sistema.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a eliminar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void eliminar(Directorio directorio) throws ServiceException;

}
