package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementaci�n de {@link DirectorioService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
@Transactional
public class DirectorioServiceImpl implements DirectorioService {

	@Autowired
	private DirectorioDAO directorioDAO;

	@Autowired
	private EdicionDirectorioDAO edicionDirectorioDAO;

	@Override
	public List<Directorio> listar() throws ServiceException {
		return listar("");
	}

	@Override
	public List<Directorio> listar(String filtroNombre) throws ServiceException {
		try {
			return directorioDAO.findByNombre(filtroNombre);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Directorio buscar(int id) throws ServiceException {
		try {
			return directorioDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void crear(Usuario creador, Directorio directorio) throws ServiceException {
		try {
			directorio.setCreador(creador);
			directorio.setFechaCreacion(new Date());
			directorioDAO.insert(directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void editar(Usuario editor, Directorio directorio) throws ServiceException {
		try {
			directorioDAO.update(directorio);
			guardarEdicion(editor, directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Directorio directorio) throws ServiceException {
		try {
			directorio = directorioDAO.findById(directorio.getId());
			directorioDAO.delete(directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Crea y guarda una instancia de {@link EdicionDirectorio} a partir de los
	 * par�metros obtenidos con la fecha actual.
	 * 
	 * @param editor
	 *            El {@link Usuario} que est� realizando la edici�n.
	 * @param directorio
	 *            El {@link Directorio} que ha sido editado.
	 * @throws DAOException
	 *             Si se produce un error al insertar los datos.
	 */
	private void guardarEdicion(Usuario editor, Directorio directorio)
			throws DAOException {
		EdicionDirectorio edicion = new EdicionDirectorio();
		edicion.setDirectorio(directorio);
		edicion.setEditor(editor);
		edicion.setFechaEdicion(new Date());
		edicionDirectorioDAO.insert(edicion);
	}

}
