package es.enriquerosales.enciclopedia.modelo.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = -11903154423535696L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Exception ex) {
		super(ex);
	}

}
