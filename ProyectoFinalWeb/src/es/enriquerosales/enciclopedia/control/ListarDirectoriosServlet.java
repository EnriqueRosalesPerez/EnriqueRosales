package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.ServiceException;

/**
 * Implementación de Servlet para guardar Directorios.
 */
@WebServlet("/directorios")
public class ListarDirectoriosServlet extends HttpServlet {

	private static final long serialVersionUID = -6059431042383505267L;
	
	private static DirectorioService dirService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dirService = Factory.getDirectorioService();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("directorios", dirService.listar());
			request.getRequestDispatcher("listadodirectorios.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
