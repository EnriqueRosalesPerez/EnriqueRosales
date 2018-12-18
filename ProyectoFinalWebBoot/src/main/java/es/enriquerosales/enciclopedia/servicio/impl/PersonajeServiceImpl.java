package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;
import es.enriquerosales.enciclopedia.servicio.ArchivoService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementaci�n de {@link PersonajeService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
@Transactional
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeDAO personajeDAO;

	@Autowired
	private EdicionPersonajeDAO edicionPersonajeDAO;

	@Autowired
	private ArchivoService archivoService;

	@Autowired
	private ServletContext context;

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
	public List<Personaje> listar(Afiliacion afiliacion, String filtroNombre)
			throws ServiceException {
		try {
			return personajeDAO.findByAfiliacionAndNombre(afiliacion, filtroNombre);
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void crear(Usuario creador, Personaje personaje) throws ServiceException {
		try {
			personaje.setCreador(creador);
			personaje.setFechaCreacion(new Date());
			personajeDAO.insert(personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void editar(Usuario editor, Personaje personaje) throws ServiceException {
		try {
			personajeDAO.update(personaje);
			guardarEdicion(editor, personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void eliminar(Personaje personaje) throws ServiceException {
		try {
			personaje = personajeDAO.findById(personaje.getId());
			eliminarAfiliaciones(personaje);
			if (personaje.getImagen() != null) {
				archivoService.eliminar(context.getRealPath(personaje.getImagen()));
			}
			personajeDAO.delete(personaje);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Crea y guarda una instancia de {@link EdicionPersonaje} a partir de los
	 * par�metros obtenidos con la fecha actual.
	 * 
	 * @param editor
	 *            El {@link Usuario} que est� realizando la edici�n.
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

	/**
	 * Elimina las referencias entre este {@link Personaje} y las instancias de
	 * {@link Afiliacion} que lo contienen.
	 * 
	 * @param personaje
	 *            El {@link Personaje} del que eliminar las referencias.
	 */
	private void eliminarAfiliaciones(Personaje personaje) {
		for (Afiliacion afiliacion : personaje.getAfiliaciones()) {
			afiliacion.getPersonajes().remove(personaje);
		}
		personaje.getAfiliaciones().clear();
	}

}
