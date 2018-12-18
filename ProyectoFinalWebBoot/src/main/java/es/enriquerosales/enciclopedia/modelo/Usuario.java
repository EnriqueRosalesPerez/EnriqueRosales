package es.enriquerosales.enciclopedia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Representa un usuario del sistema.
 * 
 * @author Enrique Rosales
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

	private Integer idUsuario;
	private String nombreUsuario;
	private String contrasenna;
	private TipoUsuario tipo;
	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer id) {
		this.idUsuario = id;
	}

	@NotEmpty
	@Size(max = 45)
	@Column(name = "nombreUsuario", nullable = false, unique = true, length = 45)
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@NotEmpty
	@Size(max = 45)
	@Column(name = "contrasenna", nullable = false, length = 45)
	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	@ManyToOne
	@JoinColumn(name = "tipoUsuarioId", nullable = false)
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@NotEmpty
	@Size(max = 45)
	@Column(name = "email", nullable = false, unique = true, length = 45)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
