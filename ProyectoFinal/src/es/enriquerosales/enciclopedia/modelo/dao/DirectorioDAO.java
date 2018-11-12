package es.enriquerosales.enciclopedia.modelo.dao;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;

/**
 * Interfaz DAO para actuar como capa intermedia entre el modelo Java y la base
 * de datos para la clase {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
public interface DirectorioDAO {

	/**
	 * Busca todos los objetos {@link Directorio} del sistema.
	 * 
	 * @return Una {@link List} que contiene todos los objetos {@link Directorio}
	 *         del sistema.
	 */
	List<Directorio> buscar();

	/**
	 * Busca todos los objetos {@link Directorio} del sistema cuyo nombre contenga
	 * el filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Directorio}.
	 * @return Una {@link List} que contiene todos los objetos {@link Directorio}
	 *         del sistema que contengan el filtro en su nombre.
	 */
	List<Directorio> buscar(String filtroNombre);

	/**
	 * Inserta en la base de datos el objeto {@link Directorio} obtenido como
	 * parámetro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a insertar.
	 */
	void insertar(Directorio directorio);

	/**
	 * Actualiza en la base de datos el objeto {@link Directorio} obtenido como
	 * parámetro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a actualizar.
	 */
	void actualizar(Directorio directorio);

	/**
	 * Elimina de la base de datos el objeto {@link Directorio} obtenido como
	 * parámetro.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a eliminar.
	 */
	void eliminar(Directorio directorio);

}
