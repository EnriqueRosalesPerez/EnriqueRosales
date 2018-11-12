package es.enriquerosales.enciclopedia.modelo.dao;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Personaje;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
public interface PersonajeDAO {

	/**
	 * Busca todos los objetos {@link Personaje} del sistema.
	 * 
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema.
	 */
	List<Personaje> buscar() throws DAOException;

	/**
	 * Busca todos los objetos {@link Personaje} del sistema cuyo nombre contenga el
	 * filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que contengan el filtro en su nombre.
	 */
	List<Personaje> buscar(String filtroNombre) throws DAOException;

	/**
	 * Inserta en la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a insertar.
	 */
	void insertar(Personaje personaje) throws DAOException;

	/**
	 * Actualiza en la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a actualizar.
	 */
	void actualizar(Personaje personaje) throws DAOException;

	/**
	 * Elimina de la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a eliminar.
	 */
	void eliminar(Personaje personaje) throws DAOException;

}
