package es.enriquerosales.enciclopedia.servicio.impl;

import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;
import es.enriquerosales.enciclopedia.servicio.ServiceException;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Implementación de {@link UsuarioService}.
 * 
 * @author Enrique Rosales
 *
 */
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public Usuario acceder(String nombreUsuario, String contrasenna)
			throws ServiceException {
		try {
			return usuarioDAO.buscar(nombreUsuario, contrasenna);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
