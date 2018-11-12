package es.enriquerosales.enciclopedia.modelo.dao;

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
	 * contrase�a proporcionados.
	 * 
	 * @param nombreUsuario
	 *            El nombre de usuario a buscar.
	 * @param contrasenna
	 *            La contrase�a del usuario.
	 * @return {@code true} si el usuario y la contrase�a existen y son correctos,
	 *         {@code false} en otro caso.
	 */
	boolean buscarUsuario(String nombreUsuario, String contrasenna) throws DAOException;

}
