package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.enriquerosales.enciclopedia.modelo.EdicionDirectorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionDirectorioDAO;

/**
 * Implementación con JDBC de {@link EdicionDirectorioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionDirectorioDAOJDBC implements EdicionDirectorioDAO {

	private JDBCDataSource dataSource;
	private Connection conn;
	private PreparedStatement st;

	public void setDataSource(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertar(EdicionDirectorio edicion) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO edicionesdirectorios (idDirectorio, idEditor, fechaEdicion) "
					+ "VALUES (?, ?, ?);";

			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, edicion.getDirectorio().getId());
			st.setInt(2, edicion.getEditor().getId());
			st.setDate(3, new java.sql.Date(edicion.getFechaEdicion().getTime()));

			st.executeUpdate();
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
