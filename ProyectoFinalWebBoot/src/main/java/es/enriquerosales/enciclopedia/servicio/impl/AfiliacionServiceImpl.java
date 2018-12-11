package es.enriquerosales.enciclopedia.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.dao.AfiliacionDAO;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
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

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void crear(Afiliacion afiliacion) throws ServiceException {
		try {
			afiliacionDAO.insert(afiliacion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void actualizar(Afiliacion afiliacion) throws ServiceException {
		try {
			afiliacionDAO.update(afiliacion);
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

}
