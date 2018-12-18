package es.enriquerosales.enciclopedia.servicio;

import org.springframework.web.multipart.MultipartFile;

/**
 * Interfaz de la capa de servicios para trabajar con ficheros.
 * 
 * @author Enrique Rosales
 *
 */
public interface ArchivoService {

	/**
	 * Guarda el archivo obtenido en la ruta de destino.
	 * 
	 * @param file
	 *            El archivo a guardar.
	 * @param destino
	 *            La ruta donde guardarlo.
	 * @throws ServiceException
	 *             Si se produce un error al guardar el fichero.
	 */
	void guardar(MultipartFile file, String destino) throws ServiceException;

	/**
	 * Elimina el fichero situado en la ruta de destino.
	 * 
	 * @param destino
	 *            La ruta donde se sitúa el archivo a eliminar.
	 * @throws ServiceException
	 *             Si se produce un error al eliminar el fichero.
	 */
	void eliminar(String destino) throws ServiceException;
}
