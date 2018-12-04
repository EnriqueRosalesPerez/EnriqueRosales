package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;

/**
 * Implementaci�n con Hibernate de {@link EdicionDirectorioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
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
