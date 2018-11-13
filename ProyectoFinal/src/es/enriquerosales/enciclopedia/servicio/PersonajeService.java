package es.enriquerosales.enciclopedia.servicio;

import java.util.List;

import es.enriquerosales.enciclopedia.modelo.Personaje;

/**
 * Interfaz de la capa de servicio para la clase {@link Personaje}.
 * 
 * @author Enrique Rosales
 *
 */
public interface PersonajeService {

	/**
	 * Crea una lista todas las instancias de {@link Personaje} del sistema.
	 * 
	 * @return Una {@link List} con todas las instancias de {@link Personaje} del
	 *         sistema.
	 */
	List<Personaje> listar();

	/**
	 * Crea una lista las instancias de {@link Personaje} que contengan en su nombre
	 * el filtro obtenido como parámetro.
	 * 
	 * @param filtroNombre
	 *            El texto a utilizar como filtro para buscar el {@link Personaje}.
	 * @return Una {@link List} con todas las instancias de {@link Personaje} del
	 *         sistema cuyo nombre contenga el filtro.
	 */
	List<Personaje> listar(String filtroNombre);

	/**
	 * Crea una nueva entrada de {@link Personaje} en el sistema.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a crear en el sistema.
	 */
	void crear(Personaje personaje);

	/**
	 * Actualiza la información de una entrada de {@link Personaje} existente.
	 * 
	 * @param personaje
	 *            El {@link Personaje} cuyos datos se van a actualizar.
	 */
	void editar(Personaje personaje);

	/**
	 * Elimina una entrada de {@link Personaje} del sistema.
	 * 
	 * @param personaje
	 *            El {@link Personaje} a eliminar.
	 */
	void eliminar(Personaje personaje);

}
