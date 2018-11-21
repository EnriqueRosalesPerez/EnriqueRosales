package es.enriquerosales.enciclopedia.modelo;

/**
 * Representa un usuario del sistema.
 * 
 * @author Enrique Rosales
 *
 */
public class Usuario {

	private int id;
	private String nombreUsuario;
	private String contrasenna;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

}
