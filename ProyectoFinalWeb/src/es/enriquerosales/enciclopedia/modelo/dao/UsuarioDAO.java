package es.enriquerosales.enciclopedia.modelo.dao;

import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Usuario}.
 * 
 * @author Enrique Rosales
 *
 */
public interface UsuarioDAO {

	/**
	 * Busca un {@link Usuario} en el sistema a partir del nombre de usuario y la
	 * contraseña proporcionados.
	 * 
	 * @param nombreUsuario
	 *            El nombre de usuario a buscar.
	 * @param contrasenna
	 *            La contraseña del usuario.
	 * @return Una instancia de {@link Usuario}, o {@code null} si no existe.
	 * @throws DAOException
	 *             Si se produce un error al interactuar con la base de datos.
	 */
	Usuario findByNombreAndPass(String nombreUsuario, String contrasenna) throws DAOException;

}
