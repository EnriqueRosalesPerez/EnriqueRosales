package es.enriquerosales.enciclopedia.modelo.dao.hib;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;

/**
 * Implementación con Hibernate de {@link UsuarioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class UsuarioDAOHib implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Usuario findByNombreAndPass(String nombreUsuario, String contrasenna)
			throws DAOException {
		try {
			String hql = "FROM Usuario WHERE nombreUsuario = :nombre AND contrasenna = :pass";
			return (Usuario) sessionFactory.getCurrentSession().createQuery(hql)
					.setString("nombre", nombreUsuario).setString("pass", contrasenna)
					.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
