package es.enriquerosales.enciclopedia.modelo.dao.hib;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;

/**
 * Implementación con Hibernate de {@link DirectorioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class DirectorioDAOHib implements DirectorioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Directorio> findAll() throws DAOException {
		try {
			String hql = "FROM Directorio";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Directorio> findByNombre(String filtroNombre) throws DAOException {
		try {
			String hql = "FROM Directorio WHERE nombre LIKE :nombre";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setString("nombre", "%" + filtroNombre + "%").list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Directorio findById(int id) throws DAOException {
		try {
			return (Directorio) sessionFactory.getCurrentSession().get(Directorio.class,
					id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void insert(Directorio directorio) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(directorio);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Directorio directorio) throws DAOException {
		try {
			sessionFactory.getCurrentSession().update(directorio);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Directorio directorio) throws DAOException {
		try {
			sessionFactory.getCurrentSession().delete(directorio);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
