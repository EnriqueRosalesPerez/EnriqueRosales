package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.List;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link DirectorioService}.
 * 
 * @author Enrique Rosales
 *
 */
public class DirectorioServiceImpl implements DirectorioService {

	@Override
	public List<Directorio> listar() throws ServiceException {
		return listar("");
	}

	@Override
	public List<Directorio> listar(String filtroNombre) throws ServiceException {
		try {
			return Factory.getDirectorioDAO().buscar(filtroNombre);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void crear(Directorio directorio) throws ServiceException {
		try {
			Factory.getDirectorioDAO().insertar(directorio);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void editar(Directorio directorio) throws ServiceException {
		try {
			Factory.getDirectorioDAO().actualizar(directorio);
			// TODO Crear y guardar EdicionDirectorio
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminar(Directorio directorio) throws ServiceException {
		try {
			Factory.getDirectorioDAO().eliminar(directorio);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}
