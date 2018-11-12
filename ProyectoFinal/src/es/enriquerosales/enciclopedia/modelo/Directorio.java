package es.enriquerosales.enciclopedia.modelo;

import java.util.Date;

/**
 * Clase POJO que representa un directorio del sistema. Un directorio refiere a
 * un período histórico bajo el que se sitúan los objetos {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
public class Directorio {

	private int id;
	private String nombre;
	private String annoInicio;
	private String annoFin;
	private String descripcion;
	private Date fechaCreacion;
	private Usuario creador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnnoInicio() {
		return annoInicio;
	}

	public void setAnnoInicio(String annoInicio) {
		this.annoInicio = annoInicio;
	}

	public String getAnnoFin() {
		return annoFin;
	}

	public void setAnnoFin(String annoFin) {
		this.annoFin = annoFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

}
