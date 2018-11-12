package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.dao.DAOException;
import es.enriquerosales.enciclopedia.modelo.dao.PersonajeDAO;

/**
 * Implementación con JDBC de {@link PersonajeDAO}.
 * 
 * @author Enrique Rosales
 *
 */
public class PersonajeDAOJDBC implements PersonajeDAO {

	private JDBCDataSource dataSource;
	private Connection conn;
	private PreparedStatement st;

	public void setDataSource(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Personaje> buscar() throws DAOException {
		return buscar("");
	}

	@Override
	public List<Personaje> buscar(String filtroNombre) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Personaje> resultado = new LinkedList<Personaje>();
			String sql = "SELECT * FROM personajes WHERE nombre LIKE ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, "%" + filtroNombre + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Personaje p = mapear(rs);
				resultado.add(p);
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
	public void insertar(Personaje personaje) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO personajes "
					+ "(nombre, annoNacimiento, annoMuerte, "
					+ "biografia, idDirectorio, fechaCreacion, idCreador) "
					+ "VALUES ?, ?, ?, ?, ?, ?, ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, personaje.getNombre());
			st.setString(2, personaje.getAnnoNacimiento());
			st.setString(3, personaje.getAnnoMuerte());
			st.setString(4, personaje.getBiografia());
			st.setInt(5, personaje.getDirectorio().getId());
			st.setDate(6, new java.sql.Date(personaje.getFechaCreacion().getTime()));
			st.setInt(7, personaje.getCreador().getId());

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
	public void actualizar(Personaje personaje) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "UPDATE personajes " + "SET nombre = ?, "
					+ "annoNacimiento = ?, " + "annoMuerte = ?, " + "biografia = ?, "
					+ "idDirectorio = ?, " + "fechaCreacion = ?, " + "idCreador = ? "
					+ "WHERE id = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, personaje.getNombre());
			st.setString(2, personaje.getAnnoNacimiento());
			st.setString(3, personaje.getAnnoMuerte());
			st.setString(4, personaje.getBiografia());
			st.setInt(5, personaje.getDirectorio().getId());
			st.setDate(6, new java.sql.Date(personaje.getFechaCreacion().getTime()));
			st.setInt(7, personaje.getCreador().getId());
			st.setInt(8, personaje.getId());

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
	public void eliminar(Personaje personaje) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "DELETE FROM personajes WHERE id = ?;";
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, personaje.getId());

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
	 * Mapea la columna actual del ResultSet a un Personaje.
	 * 
	 * @param rs
	 *            El ResultSet a mapear.
	 * @return El Personaje en el que se encuentra el ResultSet.
	 * @throws SQLException
	 *             Si se produce un error al leer los datos.
	 */
	private Personaje mapear(ResultSet rs) throws SQLException {
		Personaje p = new Personaje();

		p.setId(rs.getInt("id"));
		p.setNombre(rs.getString("nombre"));
		p.setAnnoNacimiento(rs.getString("annoNacimiento"));
		p.setAnnoMuerte(rs.getString("annoMuerte"));
		p.setBiografia(rs.getString("biografia"));
		p.setFechaCreacion(rs.getDate("fechaCreacion"));
		// TODO Añadir Directorio y Creador.

		return p;
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
