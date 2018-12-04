package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;

/**
 * Implementación con Hibernate de {@link EdicionDirectorioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionDirectorioDAOHib implements EdicionDirectorioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(EdicionDirectorio edicion) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(edicion);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
