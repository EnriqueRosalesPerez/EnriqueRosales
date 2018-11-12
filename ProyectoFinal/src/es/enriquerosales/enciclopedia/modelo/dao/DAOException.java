package es.enriquerosales.enciclopedia.modelo.dao;

/**
 * Excepci�n que encapsula todos los errores que se puedan producir al trabajar
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
	 *            El mensaje de la excepci�n.
	 */
	public DAOException(String msg) {
		super(msg);
	}

	/**
	 * Constructor con excepci�n.
	 * 
	 * @param ex
	 *            La excepci�n a encapsular.
	 */
	public DAOException(Exception ex) {
		super(ex);
	}

}
