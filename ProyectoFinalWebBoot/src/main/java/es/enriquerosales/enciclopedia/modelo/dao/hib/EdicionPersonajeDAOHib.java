package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;

/**
 * Implementación con Hibernate de {@link EdicionPersonajeDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionPersonajeDAOHib implements EdicionPersonajeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(EdicionPersonaje edicion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(edicion);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
