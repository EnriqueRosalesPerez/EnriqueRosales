package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.dao.AfiliacionDAO;
import es.enriquerosales.enciclopedia.modelo.dao.ComentarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;

/**
 * Implementación con Hibernate de {@link ComentarioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
public class AfiliacionDAOHib implements AfiliacionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Afiliacion findById(int id) throws DAOException {
		try {
			return sessionFactory.getCurrentSession().get(Afiliacion.class, id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void insert(Afiliacion afiliacion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(afiliacion);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void update(Afiliacion afiliacion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().update(afiliacion);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void delete(Afiliacion afiliacion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().delete(afiliacion);
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

}
