package es.enriquerosales.enciclopedia.modelo.dao.hib;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.enriquerosales.enciclopedia.modelo.Afiliacion;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;

/**
 * Implementaci�n con Hibernate de {@link PersonajeDAO}.
 * 
 * @author Enrique Rosales
 *
 */
@Repository
public class PersonajeDAOHib implements PersonajeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Personaje> findAll() throws DAOException {
		try {
			String hql = "FROM Personaje";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personaje> findByNombre(String filtroNombre) throws DAOException {
		try {
			String hql = "FROM Personaje WHERE nombre LIKE :nombre";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("nombre", "%" + filtroNombre + "%").list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personaje> findByDirectorio(Directorio directorio) throws DAOException {
		try {
			String hql = "FROM Personaje WHERE directorio.id = :dir";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("dir", directorio.getId()).list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personaje> findByDirectorioAndNombre(Directorio directorio,
			String filtroNombre) throws DAOException {
		try {
			String hql = "FROM Personaje WHERE directorio.id = :dir AND nombre LIKE :nombre";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("dir", directorio.getId())
					.setParameter("nombre", "%" + filtroNombre + "%").list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personaje> findByAfiliacionAndNombre(Afiliacion afiliacion,
			String filtroNombre) throws DAOException {
		try {
			String hql = "SELECT p FROM Afiliacion a JOIN a.personajes p WHERE a.id = :id AND p.nombre LIKE :nombre";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("id", afiliacion.getId())
					.setParameter("nombre", "%" + filtroNombre + "%").list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Personaje findById(int id) throws DAOException {
		try {
			return (Personaje) sessionFactory.getCurrentSession().get(Personaje.class,
					id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void insert(Personaje personaje) throws DAOException {
		try {
			sessionFactory.getCurrentSession().save(personaje);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Personaje personaje) throws DAOException {
		try {
			sessionFactory.getCurrentSession().update(personaje);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Personaje personaje) throws DAOException {
		try {
			sessionFactory.getCurrentSession().delete(personaje);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
