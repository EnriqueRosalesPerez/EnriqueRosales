package es.enriquerosales.enciclopedia.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

/**
 * Clase POJO que representa un personaje hist�rico del sistema.
 * 
 * @author Enrique Rosales
 *
 */
@Entity
@Table(name = "personajes")
public class Personaje {

	private Integer id;
	private String nombre;
	private String annoNacimiento;
	private String annoMuerte;
	private String biografia;
	private Directorio directorio;
	private Date fechaCreacion;
	private Usuario creador;
	private Set<Comentario> comentarios;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "annoNacimiento")
	public String getAnnoNacimiento() {
		return annoNacimiento;
	}

	public void setAnnoNacimiento(String annoNacimiento) {
		this.annoNacimiento = annoNacimiento;
	}

	@Column(name = "annoMuerte")
	public String getAnnoMuerte() {
		return annoMuerte;
	}

	public void setAnnoMuerte(String annoMuerte) {
		this.annoMuerte = annoMuerte;
	}

	@Column(name = "biografia")
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	@ManyToOne
	@JoinColumn(name = "idDirectorio", nullable = false)
	public Directorio getDirectorio() {
		return directorio;
	}

	public void setDirectorio(Directorio directorio) {
		this.directorio = directorio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCreacion", nullable = false)
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@ManyToOne
	@JoinColumn(name = "idCreador", nullable = false)
	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "personaje")
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
