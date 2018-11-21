package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para obtener una conexión con una base de datos a partir del Driver
 * JDBC.
 * 
 * @author Enrique Rosales
 *
 */
public class JDBCDataSource {

	private String url;
	private String usuario;
	private String contrasenna;

	/**
	 * Constructor por defecto. Comprueba que exista el Driver JDBC de MySQL.
	 * 
	 * @throws ClassNotFoundException
	 *             Si no se encuentra el Driver JDBC.
	 */
	public JDBCDataSource() throws ClassNotFoundException {
		Class.forName(ParametrosJDBC.DRIVER_JDBC_MYSQL);
	}

	/**
	 * Establece una conexión con la base de datos.
	 * 
	 * @return Un objeto {@link Connection} que representa la conexión realizada.
	 * @throws SQLException
	 *             Si se produce un error al conectar con la base de datos.
	 */
	public Connection getConnection() throws SQLException {
		url = ParametrosJDBC.URL_BD_MYSQL;
		usuario = ParametrosJDBC.USUARIO_BD;
		contrasenna = ParametrosJDBC.PASS_BD;
		return DriverManager.getConnection(url, usuario, contrasenna);
	}

}
