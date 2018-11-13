package es.enriquerosales.enciclopedia.factory;

import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.DirectorioDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.JDBCDataSource;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.PersonajeDAOJDBC;
import es.enriquerosales.enciclopedia.modelo.dao.jdbc.UsuarioDAOJDBC;

public class Factory {

	private static UsuarioDAO usuarioDAO;
	private static DirectorioDAO directorioDAO;
	private static PersonajeDAO personajeDAO;
	private static JDBCDataSource dataSource;

	public static UsuarioDAO getUsuarioDAO() throws ClassNotFoundException {
		if (usuarioDAO == null) {
			UsuarioDAOJDBC bean = new UsuarioDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			usuarioDAO = bean;
		}
		return usuarioDAO;
	}
	
	public static DirectorioDAO getDirectorioDAO() throws ClassNotFoundException {
		if (directorioDAO == null) {
			DirectorioDAOJDBC bean = new DirectorioDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			directorioDAO = bean;
		}
		return directorioDAO;
	}
	
	public static PersonajeDAO getPersonajeDAO() throws ClassNotFoundException {
		if (personajeDAO == null) {
			PersonajeDAOJDBC bean = new PersonajeDAOJDBC();
			bean.setDataSource(getJDBCDataSource());
			personajeDAO = bean;
		}
		return personajeDAO;
	}

	private static JDBCDataSource getJDBCDataSource() throws ClassNotFoundException {
		if (dataSource == null) {
			JDBCDataSource bean = new JDBCDataSource();
			dataSource = bean;
		}
		return dataSource;
	}

}
