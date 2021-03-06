package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.Comentario;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Comentario}.
 * 
 * @author Enrique Rosales
 *
 */
public interface ComentarioDAO {

	/**
	 * Guarda un {@link Comentario} en el sistema.
	 * 
	 * @param comentario
	 *            El {@link Comentario} a guardar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void save(Comentario comentario) throws DAOException;

	/**
	 * Elimina un {@link Comentario} en el sistema.
	 * 
	 * @param comentario
	 *            El {@link Comentario} a eliminar.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	void delete(Comentario comentario) throws DAOException;

	/**
	 * Devuelve un {@link Comentario} dado su ID.
	 * 
	 * @param id
	 *            El ID del {@link Comentario} a buscar.
	 * @return El {@link Comentario} con el ID proporcionado, o {@code null} si no
	 *         se encuentra.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Comentario findById(int id) throws DAOException;

}
