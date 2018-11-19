package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link EdicionDirectorio}.
 * 
 * @author Enrique Rosales
 *
 */
public interface EdicionDirectorioDAO {

	/**
	 * Inserta en la base de datos el objeto {@link EdicionDirectorio} obtenido como
	 * parámetro.
	 * 
	 * @param edicion
	 *            El objeto {@link EdicionDirectorio} a insertar.
	 * 
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void insertar(EdicionDirectorio edicion) throws DAOException;

}
