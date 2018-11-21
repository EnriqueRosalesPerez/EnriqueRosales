package es.enriquerosales.enciclopedia.modelo;

import java.util.Date;

/**
 * Clase POJO que representa un personaje histórico del sistema.
 * 
 * @author Enrique Rosales
 *
 */
public class Personaje {

	private int id;
	private String nombre;
	private String annoNacimiento;
	private String annoMuerte;
	private String biografia;
	private Directorio directorio;
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

	public String getAnnoNacimiento() {
		return annoNacimiento;
	}

	public void setAnnoNacimiento(String annoNacimiento) {
		this.annoNacimiento = annoNacimiento;
	}

	public String getAnnoMuerte() {
		return annoMuerte;
	}

	public void setAnnoMuerte(String annoMuerte) {
		this.annoMuerte = annoMuerte;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Directorio getDirectorio() {
		return directorio;
	}

	public void setDirectorio(Directorio directorio) {
		this.directorio = directorio;
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
