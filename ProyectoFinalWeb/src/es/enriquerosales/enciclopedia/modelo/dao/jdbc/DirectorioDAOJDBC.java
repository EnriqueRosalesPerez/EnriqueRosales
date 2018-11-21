package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
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
	public List<Directorio> findAll() throws DAOException {
		return findByNombre("");
	}

	@Override
	public List<Directorio> findByNombre(String filtroNombre) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Directorio> resultado = new LinkedList<Directorio>();
			String sql = "SELECT * FROM directorios d "
					+ "INNER JOIN usuarios u ON d.idCreador = u.id WHERE d.nombre LIKE ?;";

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
	public Directorio findById(int id) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			Directorio resultado = null;
			String sql = "SELECT * FROM directorios d "
					+ "INNER JOIN usuarios u ON d.idCreador = u.id WHERE d.id = ?;";

			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				resultado = mapear(rs);
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
	public void insert(Directorio directorio) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO directorios (nombre, annoInicio, annoFin, "
					+ "descripcion, fechaCreacion, idCreador) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";
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
	public void update(Directorio directorio) throws DAOException {
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
			st.setInt(7, directorio.getId());

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
	public void delete(Directorio directorio) throws DAOException {
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
	 *            El ResultSet a mapear. @return El Directorio en el que se
	 *            encuentra el ResultSet. @throws SQLException Si se produce un
	 *            error al leer los datos. @throws DAOException @throws
	 * @throws SQLException
	 *             Si se produce un error al procesar el resultado.
	 */
	private Directorio mapear(ResultSet rs) throws SQLException {
		Directorio directorio = new Directorio();
		Usuario usuario = new Usuario();

		directorio.setId(rs.getInt("id"));
		directorio.setNombre(rs.getString("nombre"));
		directorio.setAnnoInicio(rs.getString("annoInicio"));
		directorio.setAnnoFin(rs.getString("annoFin"));
		directorio.setDescripcion(rs.getString("descripcion"));
		directorio.setFechaCreacion(rs.getDate("fechaCreacion"));

		usuario.setId(rs.getInt("idCreador"));
		usuario.setNombreUsuario(rs.getString("nombreUsuario"));
		usuario.setContrasenna("contrasenna");

		return directorio;
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
