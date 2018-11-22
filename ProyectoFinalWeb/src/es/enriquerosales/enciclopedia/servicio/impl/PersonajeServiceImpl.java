package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link PersonajeService}.
 * 
 * @author Enrique Rosales
 *
 */
public class PersonajeServiceImpl implements PersonajeService {

	private PersonajeDAO personajeDAO;
	private EdicionPersonajeDAO edicionPersonajeDAO;

	public void setPersonajeDAO(PersonajeDAO personajeDAO) {
		this.personajeDAO = personajeDAO;
	}

	public void setEdicionPersonajeDAO(EdicionPersonajeDAO edicionPersonajeDAO) {
		this.edicionPersonajeDAO = edicionPersonajeDAO;
	}

	@Override
	public List<Personaje> listar() throws ServiceException {
		return listar("");
	}

	@Override
	public List<Personaje> listar(String filtroNombre) throws ServiceException {
		try {
			return personajeDAO.findByNombre(filtroNombre);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Personaje> listar(Directorio directorio) throws ServiceException {
		try {
			return personajeDAO.findByDirectorio(directorio);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Personaje> listar(Directorio directorio, String filtroNombre)
			throws ServiceException {
		try {
			return personajeDAO.findByDirectorioAndNombre(directorio, filtroNombre);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Personaje buscar(int id) throws ServiceException {
		try {
			return personajeDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void crear(Personaje personaje) throws ServiceException {
		try {
			personajeDAO.insert(personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void editar(Usuario editor, Personaje personaje) throws ServiceException {
		try {
			personajeDAO.update(personaje);
			guardarEdicion(editor, personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void eliminar(Personaje personaje) throws ServiceException {
		try {
			personajeDAO.delete(personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Crea y guarda una instancia de {@link EdicionPersonaje} a partir de los
	 * parámetros obtenidos con la fecha actual.
	 * 
	 * @param editor
	 *            El {@link Usuario} que está realizando la edición.
	 * @param directorio
	 *            El {@link Personaje} que ha sido editado.
	 * @throws DAOException
	 *             Si se produce un error al insertar los datos.
	 */
	private void guardarEdicion(Usuario editor, Personaje personaje) throws DAOException {
		EdicionPersonaje edicion = new EdicionPersonaje();
		edicion.setPersonaje(personaje);
		edicion.setEditor(editor);
		edicion.setFechaEdicion(new Date());
		edicionPersonajeDAO.insert(edicion);
	}

}
