package es.enriquerosales.enciclopedia.servicio;

/**
 * Excepci�n que encapsula todos los errores que se puedan producir al trabajar
 * con la capa de servicio.
 * 
 * @author Enrique Rosales
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 3160769560075194610L;

	/**
	 * Constructor con mensaje.
	 * 
	 * @param msg
	 *            El mensaje de la excepci�n.
	 */
	public ServiceException(String msg) {
		super(msg);
	}

	/**
	 * Constructor con excepci�n.
	 * 
	 * @param ex
	 *            La excepci�n a encapsular.
	 */
	public ServiceException(Exception ex) {
		super(ex);
	}

}
