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
	 * Devuelve una {@link Afiliacion} dado su ID.
	 * 
	 * @param id
	 *            El ID de la {@link Afiliacion} a buscar.
	 * @return La {@link Afiliacion} con el ID proporcionado, o {@code null} si no
	 *         se encuentra.
	 * @throws ServiceException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Afiliacion buscar(int id) throws ServiceException;

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
	void editar(Usuario editor, Afiliacion afiliacion) throws ServiceException;

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
