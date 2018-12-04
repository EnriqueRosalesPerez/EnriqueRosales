package es.enriquerosales.enciclopedia.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;
import es.enriquerosales.enciclopedia.servicio.ServiceException;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Implementaci�n de {@link UsuarioService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario acceder(String nombreUsuario, String contrasenna)
			throws ServiceException {
		try {
			return usuarioDAO.findByNombreAndPass(nombreUsuario, contrasenna);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
