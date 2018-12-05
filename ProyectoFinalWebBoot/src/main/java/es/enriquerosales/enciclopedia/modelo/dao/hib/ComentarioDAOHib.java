package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.Comentario;
import es.enriquerosales.enciclopedia.modelo.dao.ComentarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;

/**
 * Implementaci�n con Hibernate de {@link ComentarioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
public class ComentarioDAOHib implements ComentarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Comentario comentario) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(comentario);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Comentario comentario) throws DAOException {
		try {
			sessionFactory.getCurrentSession().delete(comentario);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Comentario findById(int id) throws DAOException {
		try {
			return sessionFactory.getCurrentSession().get(Comentario.class, id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
