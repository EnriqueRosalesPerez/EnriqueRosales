package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link DirectorioService}.
 * 
 * @author Enrique Rosales
 *
 */
public class DirectorioServiceImpl implements DirectorioService {

	private DirectorioDAO directorioDAO;
	private EdicionDirectorioDAO edicionDirectorioDAO;

	public void setDirectorioDAO(DirectorioDAO directorioDAO) {
		this.directorioDAO = directorioDAO;
	}

	public void setEdicionDirectorioDAO(EdicionDirectorioDAO edicionDirectorioDAO) {
		this.edicionDirectorioDAO = edicionDirectorioDAO;
	}

	@Override
	public List<Directorio> listar() throws ServiceException {
		return listar("");
	}

	@Override
	public List<Directorio> listar(String filtroNombre) throws ServiceException {
		try {
			return directorioDAO.buscar(filtroNombre);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void crear(Directorio directorio) throws ServiceException {
		try {
			directorioDAO.insertar(directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void editar(Usuario editor, Directorio directorio) throws ServiceException {
		try {
			directorioDAO.actualizar(directorio);
			guardarEdicion(editor, directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminar(Directorio directorio) throws ServiceException {
		try {
			directorioDAO.eliminar(directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Crea y guarda una instancia de {@link EdicionDirectorio} a partir de los
	 * parámetros obtenidos con la fecha actual.
	 * 
	 * @param editor
	 *            El {@link Usuario} que está realizando la edición.
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
		edicionDirectorioDAO.insertar(edicion);
	}

}
