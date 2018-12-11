package es.enriquerosales.enciclopedia.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.EdicionAfiliacion;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.AfiliacionDAO;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionAfiliacionDAO;
import es.enriquerosales.enciclopedia.servicio.AfiliacionService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de {@link AfiliacionService}.
 * 
 * @author Enrique Rosales
 *
 */
@Service
@Transactional
public class AfiliacionServiceImpl implements AfiliacionService {

	@Autowired
	private AfiliacionDAO afiliacionDAO;

	@Autowired
	private EdicionAfiliacionDAO edicionAfiliacionDAO;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void crear(Usuario creador, Afiliacion afiliacion) throws ServiceException {
		try {
			afiliacion.setCreador(creador);
			afiliacion.setFechaCreacion(new Date());
			afiliacionDAO.insert(afiliacion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void actualizar(Usuario editor, Afiliacion afiliacion) throws ServiceException {
		try {
			afiliacionDAO.update(afiliacion);
			guardarEdicion(editor, afiliacion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Afiliacion afiliacion) throws ServiceException {
		try {
			afiliacion = afiliacionDAO.findById(afiliacion.getId());
			afiliacionDAO.delete(afiliacion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Crea y guarda una instancia de {@link EdicionAfiliacion} a partir de los
	 * parámetros obtenidos con la fecha actual.
	 * 
	 * @param editor
	 *            El {@link Usuario} que está realizando la edición.
	 * @param afiliacion
	 *            La {@link Afiliacion} que ha sido editada.
	 * @throws DAOException
	 *             Si se produce un error al insertar los datos.
	 */
	private void guardarEdicion(Usuario editor, Afiliacion afiliacion) throws DAOException {
		EdicionAfiliacion edicion = new EdicionAfiliacion();
		edicion.setAfiliacion(afiliacion);
		edicion.setEditor(editor);
		edicion.setFechaEdicion(new Date());
		edicionAfiliacionDAO.insert(edicion);
	}

}
