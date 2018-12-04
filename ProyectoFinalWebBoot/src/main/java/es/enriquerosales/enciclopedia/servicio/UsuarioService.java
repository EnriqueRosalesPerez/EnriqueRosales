package es.enriquerosales.enciclopedia.servicio;

import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Intefaz de la capa de servicio para la clase {@link Usuario}.
 * 
 * @author Enrique Rosales
 *
 */
public interface UsuarioService {

	/**
	 * Intenta realizar un acceso en el sistema con el nombre de usuario y la
	 * contrase�a proporcionados.
	 * 
	 * @param nombreUsuario
	 *            El nombre de usuario del usuario que intenta acceder.
	 * @param contrasenna
	 *            La contrase�a del usuario que intenta acceder.
	 * @return Una instancia de {@link Usuario} si los datos son correctos,
	 *         {@code null} en cualquier otro caso.
	 * @throws ServiceException
	 *             Si se produce un error al procesar el servicio.
	 */
	Usuario acceder(String nombreUsuario, String contrasenna) throws ServiceException;

}
