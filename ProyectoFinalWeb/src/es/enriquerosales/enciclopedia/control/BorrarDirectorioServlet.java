package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;

/**
 * Implementación de Servlet para eliminación de Directorios.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/eliminar")
public class BorrarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = -700593884312867995L;
	private static DirectorioService dirService;

	private static final String SUCCESS = "/index.jsp";
	private static final String ERROR = "/error.jsp";

	public void setDirService(DirectorioService dirService) {
		BorrarDirectorioServlet.dirService = dirService;
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
			Directorio dir = dirService
					.buscar(Integer.parseInt(request.getParameter("id")));
			dirService.eliminar(dir);
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
