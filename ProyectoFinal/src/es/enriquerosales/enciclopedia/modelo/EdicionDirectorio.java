package es.enriquerosales.enciclopedia.modelo;

/**
 * Guarda la iformación relativa a una edición que se haya hecho sobre una
 * entrada de {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
public class EdicionDirectorio {

	private int id;
	private Directorio directorio;
	private Usuario editor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Directorio getDirectorio() {
		return directorio;
	}

	public void setDirectorio(Directorio directorio) {
		this.directorio = directorio;
	}

	public Usuario getEditor() {
		return editor;
	}

	public void setEditor(Usuario editor) {
		this.editor = editor;
	}

}
