package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

	public void setDirService(DirectorioService dirService) {
		BuscarDirectoriosServlet.dirService = dirService;
	}

	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		// Spring no permite la IoD en Servlets, se obtiene desde el contexto
		this.setDirService(context.getBean(DirectorioService.class));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String filtroBusqueda = request.getParameter("s");
			request.setAttribute("directorios", dirService.listar(filtroBusqueda));
			request.setAttribute("busqueda", filtroBusqueda);
			request.getRequestDispatcher(SUCCESS).forward(request, response);
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
