package es.enriquerosales.enciclopedia.servicio;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Directorio;

/**
 * Intefaz de la capa de servicio para la clase {@link Directorio}.
 * 
 * @author Enrique Rosales
 *
 */
public interface DirectorioService {

	/**
	 * Crea una lista todas las instancias de {@link Directorio} del sistema.
	 * 
	 * @return Una {@link List} con todas las instancias de {@link Directorio} del
	 *         sistema.
	 */
	List<Directorio> listar();

	/**
	 * Crea una lista las instancias de {@link Directorio} que contengan en su
	 * nombre el filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Directorio}.
	 * @return Una {@link List} con todas las instancias de {@link Directorio} del
	 *         sistema cuyo nombre contenga el filtro.
	 */
	List<Directorio> listar(String filtroNombre);

	/**
	 * Crea un nuevo {@link Directorio} en el sistema.
	 * 
	 * @param personaje
	 *            El {@link Directorio} a crear en el sistema.
	 */
	void crear(Directorio directorio);

	/**
	 * Actualiza la información de un {@link Directorio} existente.
	 * 
	 * @param directorio
	 *            El {@link Directorio} cuyos datos se van a actualizar.
	 */
	void editar(Directorio directorio);

	/**
	 * Elimina un {@link Directorio} del sistema.
	 * 
	 * @param directorio
	 *            El {@link Directorio} a eliminar.
	 */
	void eliminar(Directorio directorio);

}
