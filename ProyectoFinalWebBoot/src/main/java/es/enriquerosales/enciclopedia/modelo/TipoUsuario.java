package es.enriquerosales.enciclopedia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa el tipo de un {@link Usuario} del sistema.
 * 
 * @author Enrique Rosales
 *
 */
@Entity
@Table(name = "tiposusuario")
public class TipoUsuario {

	private Integer id;
	private String nombre;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
