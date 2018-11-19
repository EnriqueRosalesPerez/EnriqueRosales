package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.enriquerosales.enciclopedia.modelo.EdicionPersonaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.EdicionPersonajeDAO;

/**
 * Implementación con JDBC de {@link EdicionPersonajeDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionPersonajeDAOJDBC implements EdicionPersonajeDAO {

	private JDBCDataSource dataSource;
	private Connection conn;
	private PreparedStatement st;

	public void setDataSource(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertar(EdicionPersonaje edicion) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO edicionespersonajes (idPersonaje, idEditor, fechaEdicion) "
					+ "VALUES (?, ?, ?);";

			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, edicion.getPersonaje().getId());
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
