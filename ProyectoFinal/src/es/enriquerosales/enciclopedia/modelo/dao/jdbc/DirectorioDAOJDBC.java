package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.DirectorioDAO;

/**
 * Implementación con JDBC de {@link DirectorioDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class DirectorioDAOJDBC implements DirectorioDAO {

	private JDBCDataSource dataSource;
	private Connection conn;
	private PreparedStatement st;

	public void setDataSource(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Directorio> buscar() throws DAOException {
		return buscar("");
	}
	
	@Override
	public List<Directorio> buscar(int id) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Directorio> resultado = new LinkedList<Directorio>();
			String sql = "SELECT * FROM directorios WHERE id = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Directorio d = mapear(rs);
				resultado.add(d);
			}
			rs.close();

			return resultado;
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

	@Override
	public List<Directorio> buscar(String filtroNombre) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Directorio> resultado = new LinkedList<Directorio>();
			String sql = "SELECT * FROM directorios WHERE nombre LIKE ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, "%" + filtroNombre + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Directorio d = mapear(rs);
				resultado.add(d);
			}
			rs.close();

			return resultado;
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

	@Override
	public void insertar(Directorio directorio) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO directorios " + "(nombre, annoInicio, annoFin, "
					+ "descripcion, fechaCreacion, idCreador) "
					+ "VALUES ?, ?, ?, ?, ?, ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, directorio.getNombre());
			st.setString(2, directorio.getAnnoInicio());
			st.setString(3, directorio.getAnnoFin());
			st.setString(4, directorio.getDescripcion());
			st.setDate(5, new java.sql.Date(directorio.getFechaCreacion().getTime()));
			st.setInt(6, directorio.getCreador().getId());

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

	@Override
	public void actualizar(Directorio directorio) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "UPDATE directorios " + "SET nombre = ?, " + "annoInicio = ?, "
					+ "annoFin = ?, " + "descripcion = ?, " + "fechaCreacion = ?, "
					+ "idCreador = ? " + "WHERE id = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, directorio.getNombre());
			st.setString(2, directorio.getAnnoInicio());
			st.setString(3, directorio.getAnnoFin());
			st.setString(4, directorio.getDescripcion());
			st.setDate(5, new java.sql.Date(directorio.getFechaCreacion().getTime()));
			st.setInt(6, directorio.getCreador().getId());

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

	@Override
	public void eliminar(Directorio directorio) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "DELETE FROM directorios WHERE id = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, directorio.getId());

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
	 * Mapea la columna actual del ResultSet a un Directorio.
	 * 
	 * @param rs
	 *            El ResultSet a mapear.
	 * @return El Directorio en el que se encuentra el ResultSet.
	 * @throws SQLException
	 *             Si se produce un error al leer los datos.
	 */
	private Directorio mapear(ResultSet rs) throws SQLException {
		Directorio d = new Directorio();

		d.setId(rs.getInt("id"));
		d.setNombre(rs.getString("nombre"));
		d.setAnnoInicio(rs.getString("annoInicio"));
		d.setAnnoFin(rs.getString("annoFin"));
		d.setDescripcion(rs.getString("descripcion"));
		d.setFechaCreacion(rs.getDate("fechaCreacion"));
		// TODO Añadir Creador.

		return d;
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
