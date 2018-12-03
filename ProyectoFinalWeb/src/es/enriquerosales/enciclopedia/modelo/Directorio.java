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
 * Clase POJO que representa un directorio del sistema. Un directorio refiere a
 * un período histórico bajo el que se sitúan los objetos {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
@Entity
@Table(name = "directorios")
public class Directorio {

	private Integer id;
	private String nombre;
	private String annoInicio;
	private String annoFin;
	private String descripcion;
	private Date fechaCreacion;
	private Usuario creador;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "annoInicio")
	public String getAnnoInicio() {
		return annoInicio;
	}

	public void setAnnoInicio(String annoInicio) {
		this.annoInicio = annoInicio;
	}

	@Column(name = "annoFin")
	public String getAnnoFin() {
		return annoFin;
	}

	public void setAnnoFin(String annoFin) {
		this.annoFin = annoFin;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@ManyToOne
	@JoinColumn(name = "idCreador")
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

}
