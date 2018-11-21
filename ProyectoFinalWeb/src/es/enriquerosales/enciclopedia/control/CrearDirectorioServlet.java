package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementación de Servlet para la página formdirectorio.jsp al crear un
 * Directorio nuevo.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/crear")
public class CrearDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 3142188989826771228L;

	private static final String SUCCESS = "formdirectorio.jsp";
	private static final String ERROR = "/error.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
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
