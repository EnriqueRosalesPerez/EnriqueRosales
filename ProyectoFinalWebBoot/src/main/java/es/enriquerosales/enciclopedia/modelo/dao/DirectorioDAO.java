package es.enriquerosales.enciclopedia.modelo.dao;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
public interface DirectorioDAO {

	/**
	 * Busca todos los objetos {@link Directorio} del sistema.
	 * 
	 * @return Una {@link List} que contiene todos los objetos {@link Directorio}
	 *         del sistema.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Directorio> findAll() throws DAOException;

	/**
	 * Busca todos los objetos {@link Directorio} del sistema cuyo nombre contenga
	 * el filtro obtenido como par�metro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Directorio}.
	 * @return Una {@link List} que contiene todos los objetos {@link Directorio}
	 *         del sistema que contengan el filtro en su nombre.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Directorio> findByNombre(String filtroNombre) throws DAOException;

	/**
	 * Busca el objeto {@link Directorio} del sistema que tenga el ID obtenido como
	 * par�metro.
	 * 
	 * @param id
	 *            El ID del {@link Directorio} a buscar.
	 * @return La instancia de {@link Directorio} con el ID buscado, o {@code null}
	 *         si no existe.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Directorio findById(int id) throws DAOException;

	/**
	 * Inserta en la base de datos el objeto {@link Directorio} obtenido como
	 * par�metro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a insertar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void insert(Directorio directorio) throws DAOException;

	/**
	 * Actualiza en la base de datos el objeto {@link Directorio} obtenido como
	 * par�metro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a actualizar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void update(Directorio directorio) throws DAOException;

	/**
	 * Elimina de la base de datos el objeto {@link Directorio} obtenido como
	 * par�metro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a eliminar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void delete(Directorio directorio) throws DAOException;

}
