package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.EdicionAfiliacion;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionAfiliacionDAO;

/**
 * Implementación con Hibernate de {@link EdicionAfiliacionDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
public class EdicionAfiliacionDAOHib implements EdicionAfiliacionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(EdicionAfiliacion edicion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(edicion);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
