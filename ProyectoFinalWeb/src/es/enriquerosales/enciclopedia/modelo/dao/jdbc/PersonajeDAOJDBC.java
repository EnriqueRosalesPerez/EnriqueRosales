package es.enriquerosales.enciclopedia.modelo.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
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
	public List<Personaje> findAll() throws DAOException {
		return findByNombre("");
	}

	@Override
	public List<Personaje> findByNombre(String filtroNombre) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Personaje> resultado = new LinkedList<Personaje>();
			String sql = "SELECT * FROM personajes p "
					+ "INNER JOIN directorios d ON p.idDirectorio = d.id "
					+ "INNER JOIN usuarios u ON p.idCreador = u.id "
					+ "WHERE p.nombre LIKE ?;";

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
	public Personaje findById(int id) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			Personaje resultado = null;
			String sql = "SELECT * FROM personajes p "
					+ "INNER JOIN directorios d ON p.idDirectorio = d.id "
					+ "INNER JOIN usuarios u ON p.idCreador = u.id " + "WHERE p.id = ?;";

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
	public List<Personaje> findByDirectorio(Directorio directorio) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Personaje> resultado = new LinkedList<Personaje>();
			String sql = "SELECT * FROM personajes p "
					+ "INNER JOIN directorios d ON p.idDirectorio = d.id "
					+ "INNER JOIN usuarios u ON p.idCreador = u.id "
					+ "WHERE p.idDirectorio = ?;";

			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, directorio.getId());
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
	public List<Personaje> findByDirectorioAndNombre(Directorio directorio,
			String filtroNombre) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			List<Personaje> resultado = new LinkedList<Personaje>();
			String sql = "SELECT * FROM personajes p "
					+ "INNER JOIN directorios d ON p.idDirectorio = d.id "
					+ "INNER JOIN usuarios u ON p.idCreador = u.id "
					+ "WHERE p.idDirectorio = ? AND p.nombre LIKE ?;";

			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, directorio.getId());
			st.setString(2, "%" + filtroNombre + "%");
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
	public void insert(Personaje personaje) throws DAOException {
		if (dataSource == null) {
			throw new DAOException("No se ha establecido un JDBCDataSource.");
		}
		try {
			String sql = "INSERT INTO personajes "
					+ "(nombre, annoNacimiento, annoMuerte, "
					+ "biografia, idDirectorio, fechaCreacion, idCreador) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
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
	public void update(Personaje personaje) throws DAOException {
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
	public void delete(Personaje personaje) throws DAOException {
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
	 *             Si se produce un error al procesar el resultado.
	 */
	private Personaje mapear(ResultSet rs) throws SQLException {
		Personaje personaje = new Personaje();
		Directorio directorio = new Directorio();
		Usuario usuario = new Usuario();

		personaje.setId(rs.getInt("id"));
		personaje.setNombre(rs.getString("nombre"));
		personaje.setAnnoNacimiento(rs.getString("annoNacimiento"));
		personaje.setAnnoMuerte(rs.getString("annoMuerte"));
		personaje.setBiografia(rs.getString("biografia"));
		personaje.setFechaCreacion(rs.getDate("fechaCreacion"));

		directorio.setId(rs.getInt("idDirectorio"));
		directorio.setAnnoInicio(rs.getString("annoInicio"));
		directorio.setAnnoFin(rs.getString("annoFin"));
		personaje.setDirectorio(directorio);

		usuario.setId(rs.getInt("idCreador"));
		usuario.setNombreUsuario(rs.getString("nombreUsuario"));
		usuario.setContrasenna(rs.getString("contrasenna"));
		personaje.setCreador(usuario);

		return personaje;
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
