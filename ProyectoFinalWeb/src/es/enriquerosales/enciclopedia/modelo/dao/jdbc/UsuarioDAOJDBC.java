package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.enriquerosales.enciclopedia.modelo.Usuario;
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
	public Usuario buscar(String nombreUsuario, String contrasenna) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			Usuario usuario = null;
			String sql = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND contrasenna = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, nombreUsuario);
			st.setString(2, contrasenna);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreUsuario(rs.getString("nombreUsuario"));
				usuario.setContrasenna(rs.getString("contrasenna"));
			}
			rs.close();

			return usuario;
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
