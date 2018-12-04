package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;

/**
 * Implementaci�n con Hibernate de {@link EdicionPersonajeDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
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
