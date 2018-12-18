package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Afiliacion}.
 * 
 * @author Enrique Rosales
 *
 */
public interface AfiliacionDAO {

	/**
	 * Devuelve una {@link Afiliacion} dado su ID.
	 * 
	 * @param id
	 *            El ID de la {@link Afiliacion} a buscar.
	 * @return La {@link Afiliacion} con el ID proporcionado, o {@code null} si no
	 *         se encuentra.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Afiliacion findById(int id) throws DAOException;

	/**
	 * Inserta en la base de datos la {@link Afiliacion} obtenida como parámetro.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} a insertar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void insert(Afiliacion afiliacion) throws DAOException;

	/**
	 * Actualiza en la base de datos el objeto {@link Afiliacion} obtenido como
	 * parámetro.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} a actualizar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void update(Afiliacion afiliacion) throws DAOException;

	/**
	 * Elimina de la base de datos el objeto {@link Afiliacion} obtenido como
	 * parámetro.
	 * 
	 * @param afiliacion
	 *            La {@link Afiliacion} a eliminar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void delete(Afiliacion afiliacion) throws DAOException;

}
