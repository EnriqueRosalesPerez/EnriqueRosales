package es.enriquerosales.enciclopedia.factory;

import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.DirectorioDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.JDBCDataSource;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.PersonajeDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.UsuarioDAOJDBC;

/**
 * Clase que implementa el patrón Factory para generar instancias de varias
 * clases.
 * 
 * @author Enrique Rosales
 *
 */
public class Factory {

	private static UsuarioDAO usuarioDAO;
	private static DirectorioDAO directorioDAO;
	private static PersonajeDAO personajeDAO;
	private static JDBCDataSource dataSource;

	/**
	 * Devuelve una instancia de {@link UsuarioDAO}.
	 * 
	 * @return Una instancia de {@link UsuarioDAO}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static UsuarioDAO getUsuarioDAO() throws ClassNotFoundException {
		if (usuarioDAO == null) {
			UsuarioDAOJDBC bean = new UsuarioDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			usuarioDAO = bean;
		}
		return usuarioDAO;
	}

	/**
	 * Devuelve una instancia de {@link DirectorioDAO}.
	 * 
	 * @return Una instancia de {@link DirectorioDAO}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static DirectorioDAO getDirectorioDAO() throws ClassNotFoundException {
		if (directorioDAO == null) {
			DirectorioDAOJDBC bean = new DirectorioDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			directorioDAO = bean;
		}
		return directorioDAO;
	}

	/**
	 * Devuelve una instancia de {@link PersonajeDAO}.
	 * 
	 * @return Una instancia de {@link PersonajeDAO}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static PersonajeDAO getPersonajeDAO() throws ClassNotFoundException {
		if (personajeDAO == null) {
			PersonajeDAOJDBC bean = new PersonajeDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			personajeDAO = bean;
		}
		return personajeDAO;
	}

	/**
	 * Devuelve una instancia de {@link JDBCDataSource}.
	 * 
	 * @return Una instancia de {@link JDBCDataSource}.
	 * @throws ClassNotFoundException
	 *             Si no se encuentra el Driver JDBC.
	 */
	private static JDBCDataSource getJDBCDataSource() throws ClassNotFoundException {
		if (dataSource == null) {
			JDBCDataSource bean = new JDBCDataSource();
			dataSource = bean;
		}
		return dataSource;
	}

}
