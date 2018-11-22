package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Implementación de Servlet para la página formpersonaje.jsp al editar un
 * Personaje existente.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje/editar")
public class EditarPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = 989145360711252513L;
	private static PersonajeService personajeService;

	private static final String SUCCESS = "formpersonaje.jsp";
	private static final String ERROR = "/error.jsp";

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			personajeService = Factory.getPersonajeService();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("dir", request.getParameter("dir"));
			int personajeId = Integer.parseInt(request.getParameter("id"));
			Personaje personaje = personajeService.buscar(personajeId);
			request.setAttribute("personaje", personaje);
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
