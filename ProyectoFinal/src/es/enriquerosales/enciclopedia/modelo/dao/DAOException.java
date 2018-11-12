package es.enriquerosales.enciclopedia.modelo.dao;

/**
 * Excepción que encapsula todos los errores que se puedan producir al trabajar
 * con una interfaz DAO.
 * 
 * @author Enrique Rosales
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = -11903154423535696L;

	/**
	 * Constructor con mensaje.
	 * 
	 * @param msg
	 *            El mensaje de la excepción.
	 */
	public DAOException(String msg) {
		super(msg);
	}

	/**
	 * Constructor con excepción.
	 * 
	 * @param ex
	 *            La excepción a encapsular.
	 */
	public DAOException(Exception ex) {
		super(ex);
	}

}
