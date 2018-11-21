package es.enriquerosales.enciclopedia.factory;

import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.DirectorioDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.EdicionDirectorioDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.EdicionPersonajeDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.JDBCDataSource;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.PersonajeDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.UsuarioDAOJDBC;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;
import es.enriquerosales.enciclopedia.servicio.impl.DirectorioServiceImpl;
import es.enriquerosales.enciclopedia.servicio.impl.PersonajeServiceImpl;
import es.enriquerosales.enciclopedia.servicio.impl.UsuarioServiceImpl;

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
	private static EdicionDirectorioDAO edicionDirectorioDAO;
	private static EdicionPersonajeDAO edicionPersoanajeDAO;
	private static DirectorioService directorioService;
	private static PersonajeService personajeService;
	private static UsuarioService usuarioService;
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
	 * Devuelve una instancia de {@link EdicionDirectorioDAO}.
	 * 
	 * @return Una instancia de {@link EdicionDirectorioDAO}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static EdicionDirectorioDAO getEdicionDirectorioDAO()
			throws ClassNotFoundException {
		if (edicionDirectorioDAO == null) {
			EdicionDirectorioDAOJDBC bean = new EdicionDirectorioDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			edicionDirectorioDAO = bean;
		}
		return edicionDirectorioDAO;
	}

	/**
	 * Devuelve una instancia de {@link EdicionPersonajeDAO}.
	 * 
	 * @return Una instancia de {@link EdicionPersonajeDAO}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static EdicionPersonajeDAO getEdicionPersonajeDAO()
			throws ClassNotFoundException {
		if (edicionPersoanajeDAO == null) {
			EdicionPersonajeDAOJDBC bean = new EdicionPersonajeDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			edicionPersoanajeDAO = bean;
		}
		return edicionPersoanajeDAO;
	}

	/**
	 * Devuelve una instancia de {@link DirectorioService}.
	 * 
	 * @return Una instancia de {@link DirectorioService}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static DirectorioService getDirectorioService() throws ClassNotFoundException {
		if (directorioService == null) {
			DirectorioServiceImpl bean = new DirectorioServiceImpl();
			bean.setDirectorioDAO(getDirectorioDAO());
			bean.setEdicionDirectorioDAO(getEdicionDirectorioDAO());
			directorioService = bean;
		}
		return directorioService;
	}

	/**
	 * Devuelve una instancia de {@link PersonajeService}.
	 * 
	 * @return Una instancia de {@link PersonajeService}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static PersonajeService getPersonajeService() throws ClassNotFoundException {
		if (personajeService == null) {
			PersonajeServiceImpl bean = new PersonajeServiceImpl();
			bean.setPersonajeDAO(getPersonajeDAO());
			bean.setEdicionPersonajeDAO(getEdicionPersonajeDAO());
			personajeService = bean;
		}
		return personajeService;
	}

	/**
	 * Devuelve una instancia de {@link UsuarioService}.
	 * 
	 * @return Una instancia de {@link UsuarioService}.
	 * @throws ClassNotFoundException
	 *             Si se produce un error al inyectar dependencias.
	 */
	public static UsuarioService getUsuarioService() throws ClassNotFoundException {
		if (usuarioService == null) {
			UsuarioServiceImpl bean = new UsuarioServiceImpl();
			bean.setUsuarioDAO(getUsuarioDAO());
			usuarioService = bean;
		}
		return usuarioService;
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
