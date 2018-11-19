package es.enriquerosales.enciclopedia.modelo;

import java.util.Date;

/**
 * Guarda la iformación relativa a una edición que se haya hecho sobre una
 * entrada de {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionPersonaje {

	private int id;
	private Personaje personaje;
	private Usuario editor;
	private Date fechaEdicion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Usuario getEditor() {
		return editor;
	}

	public void setEditor(Usuario editor) {
		this.editor = editor;
	}

	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

}
