package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.List;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link PersonajeService}.
 * 
 * @author Enrique Rosales
 *
 */
public class PersonajeServiceImpl implements PersonajeService {

	@Override
	public List<Personaje> listar() throws ServiceException {
		return listar("");
	}

	@Override
	public List<Personaje> listar(String filtroNombre) throws ServiceException {
		try {
			return Factory.getPersonajeDAO().buscar(filtroNombre);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void crear(Personaje personaje) throws ServiceException {
		try {
			Factory.getPersonajeDAO().insertar(personaje);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void editar(Personaje personaje) throws ServiceException {
		try {
			Factory.getPersonajeDAO().actualizar(personaje);
			// TODO Crear y guardar EdicionPersonaje
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminar(Personaje personaje) throws ServiceException {
		try {
			Factory.getPersonajeDAO().eliminar(personaje);
		} catch (ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}
