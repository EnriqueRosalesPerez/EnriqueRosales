package es.enriquerosales.enciclopedia.servicio;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;

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
	 * @param afiliacion
	 *            La {@link Afiliacion} a crear.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void crear(Afiliacion afiliacion) throws ServiceException;

	/**
	 * Actualiza la información de una {@link Afiliacion} existente.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} a actualizar.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	void actualizar(Afiliacion afiliacion) throws ServiceException;

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
