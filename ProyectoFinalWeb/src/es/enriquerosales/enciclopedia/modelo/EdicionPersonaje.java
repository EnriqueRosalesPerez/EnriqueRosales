package es.enriquerosales.enciclopedia.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Guarda la iformaci�n relativa a una edici�n que se haya hecho sobre una
 * entrada de {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
@Entity
@Table(name = "edicionespersonajes")
public class EdicionPersonaje {

	private Integer id;
	private Personaje personaje;
	private Usuario editor;
	private Date fechaEdicion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "idPersonaje", nullable = false)
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@ManyToOne
	@JoinColumn(name = "idEditor", nullable = false)
	public Usuario getEditor() {
		return editor;
	}

	public void setEditor(Usuario editor) {
		this.editor = editor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaEdicion", nullable = false)
	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

}
