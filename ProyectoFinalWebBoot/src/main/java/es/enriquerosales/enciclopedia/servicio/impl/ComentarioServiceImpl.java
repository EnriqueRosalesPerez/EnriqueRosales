package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.ComentarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.servicio.ComentarioService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementaci�n de {@link ComentarioService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	private ComentarioDAO comentarioDAO;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void publicar(Usuario usuario, Personaje personaje, String comentario)
			throws ServiceException {
		try {
			Comentario com = new Comentario();
			com.setPersonaje(personaje);
			com.setUsuario(usuario);
			com.setComentario(comentario);
			com.setFechaPublicacion(new Date());
			comentarioDAO.save(com);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Comentario comentario) throws ServiceException {
		try {
			comentario = comentarioDAO.findById(comentario.getId());
			comentarioDAO.delete(comentario);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
