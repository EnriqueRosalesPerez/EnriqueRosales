package es.enriquerosales.enciclopedia.servicio;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Interfaz de la capa de servicio para la clase {@link Afiliacion}.
 * 
 * @author Enrique Rosales
 *
 */
public interface AfiliacionService {

	/**
	 * Crea una nueva {@link Afiliacion} en el sistema.
	 * 
	 * @param creador
	 *            El {@link Usuario} que está creando la {@link Afiliacion}.
	 * @param afiliacion
	 *            La {@link Afiliacion} a crear.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void crear(Usuario creador, Afiliacion afiliacion) throws ServiceException;

	/**
	 * Actualiza la información de una {@link Afiliacion} existente.
	 * 
	 * @param editor
	 *            El {@link Usuario} que está realizando la edición.
	 * @param afiliacion
	 *            La {@link Afiliacion} a actualizar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void actualizar(Usuario editor, Afiliacion afiliacion) throws ServiceException;

	/**
	 * Elimina una {@link Afiliacion} del sistema.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} a eliminar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void eliminar(Afiliacion afiliacion) throws ServiceException;

}
