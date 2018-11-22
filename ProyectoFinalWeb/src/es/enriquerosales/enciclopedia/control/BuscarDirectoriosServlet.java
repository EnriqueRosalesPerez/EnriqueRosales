package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;

/**
 * Implementación de Servlet para buscar Directorios.
 */
@WebServlet("/buscar")
public class BuscarDirectoriosServlet extends HttpServlet {

	private static final long serialVersionUID = 5841513784804931898L;
	private static DirectorioService dirService;

	private static final String SUCCESS = "listadodirectorios.jsp";
	private static final String ERROR = "error.jsp";

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
			String filtroBusqueda = request.getParameter("s");
			request.setAttribute("directorios", dirService.listar(filtroBusqueda));
			request.setAttribute("busqueda", filtroBusqueda);
			request.getRequestDispatcher(SUCCESS).forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
