package es.enriquerosales.enciclopedia.servicio.impl;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.servicio.ServiceException;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Implementación de {@link UsuarioService}.
 * 
 * @author Enrique Rosales
 *
 */
public class UsuarioServiceImpl implements UsuarioService {

	@Override
	public Usuario acceder(String nombreUsuario, String contrasenna)
			throws ServiceException {
		try {
			return Factory.getUsuarioDAO().buscar(nombreUsuario, contrasenna);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}
