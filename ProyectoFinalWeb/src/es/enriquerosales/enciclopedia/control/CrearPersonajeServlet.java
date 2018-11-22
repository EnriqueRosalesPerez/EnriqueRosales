package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementaci�n de Servlet para la p�gina formpersonaje.jsp al crear un
 * Personaje nuevo.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje/crear")
public class CrearPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = 3968766337226454170L;

	private static final String SUCCESS = "formpersonaje.jsp";
	private static final String ERROR = "/error.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("dir", request.getParameter("dir"));
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