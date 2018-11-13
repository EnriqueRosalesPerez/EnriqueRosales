package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.UsuarioDAO;

/**
 * Implementación con JDBC de {@link UsuarioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class UsuarioDAOJDBC implements UsuarioDAO {

	private JDBCDataSource dataSource;
	private Connection conn;
	private PreparedStatement st;

	public void setDataSource(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean buscarUsuario(String nombreUsuario, String contrasenna)
			throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			boolean encontrado = false;
			String sql = "SELECT * FROM personajes WHERE nombre = ? AND contrasenna = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, nombreUsuario);
			st.setString(2, contrasenna);
			ResultSet rs = st.executeQuery();

			encontrado = rs.next();
			rs.close();

			return encontrado;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				cerrarConexiones();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}

	/**
	 * Cierra las conexiones con la base de datos.
	 * 
	 * @throws SQLException
	 *             Si se produce un error en la base de datos.
	 */
	private void cerrarConexiones() throws SQLException {
		if (st != null) {
			st.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

}
