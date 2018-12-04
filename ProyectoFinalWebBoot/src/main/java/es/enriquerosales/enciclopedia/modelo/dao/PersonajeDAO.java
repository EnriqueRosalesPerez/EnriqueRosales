package es.enriquerosales.enciclopedia.modelo.dao;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
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
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Personaje> findAll() throws DAOException;

	/**
	 * Busca todos los objetos {@link Personaje} del sistema cuyo nombre contenga el
	 * filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que contengan el filtro en su nombre.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Personaje> findByNombre(String filtroNombre) throws DAOException;

	/**
	 * Busca todos los objetos {@link Personaje} del sistema que pertenezcan al
	 * {@link Directorio} indicado como parámetro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} del que obtener los Personajes.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que pertenecen al Directorio dado.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Personaje> findByDirectorio(Directorio directorio) throws DAOException;

	/**
	 * Busca todos los objetos {@link Personaje} del sistema que pertenezcan al
	 * {@link Directorio} indicado como parámetro y cuyo nombre contenga el filtro
	 * obtenido como parámetro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} del que obtener los Personajes.
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} que contiene todos los objetos {@link Personaje} del
	 *         sistema que pertenecen al Directorio dado y que contengan el filtro
	 *         en su nombre.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	List<Personaje> findByDirectorioAndNombre(Directorio directorio, String filtroNombre)
			throws DAOException;

	/**
	 * Busca el objeto {@link Personaje} del sistema que tenga el ID obtenida como
	 * parámetro.
	 * 
	 * @param id
	 *            El ID del {@link Personaje} a buscar.
	 * @return La instancia de {@link Personaje} con el ID buscado, o {@code null}
	 *         si no existe.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Personaje findById(int id) throws DAOException;

	/**
	 * Inserta en la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a insertar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void insert(Personaje personaje) throws DAOException;

	/**
	 * Actualiza en la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a actualizar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void update(Personaje personaje) throws DAOException;

	/**
	 * Elimina de la base de datos el objeto {@link Personaje} obtenido como
	 * parámetro.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a eliminar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void delete(Personaje personaje) throws DAOException;

}
