package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link EdicionPersonaje}.
 * 
 * @author Enrique Rosales
 *
 */
public interface EdicionPersonajeDAO {

	/**
	 * Inserta en la base de datos el objeto {@link EdicionPersonaje} obtenido como
	 * parámetro.
	 * 
	 * @param edicion
	 *            El objeto {@link EdicionPersonaje} a insertar.
	 */
	void insertar(EdicionPersonaje edicion) throws DAOException;

}
