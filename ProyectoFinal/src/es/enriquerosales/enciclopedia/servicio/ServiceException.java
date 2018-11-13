package es.enriquerosales.enciclopedia.servicio;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3160769560075194610L;
	
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Exception ex) {
		super(ex);
	}

}
