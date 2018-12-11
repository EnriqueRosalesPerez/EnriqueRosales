package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.EdicionAfiliacion;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link EdicionAfiliacion}.
 * 
 * @author Enrique Rosales
 *
 */
public interface EdicionAfiliacionDAO {

	/**
	 * Inserta en la base de datos el objeto {@link EdicionAfiliacion} obtenido como
	 * parámetro.
	 * 
	 * @param edicion
	 *            El objeto {@link EdicionAfiliacion} a insertar.
	 * 
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void insert(EdicionAfiliacion edicion) throws DAOException;

}
