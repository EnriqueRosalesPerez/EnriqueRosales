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
 * Implementación de Servlet para eliminación de Personajes.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje/eliminar")
public class BorrarPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = 1590533612700087885L;
	private static PersonajeService personajeService;

	private static final String SUCCESS = "/index.jsp";
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
			Personaje personaje = personajeService
					.buscar(Integer.parseInt(request.getParameter("id")));
			personajeService.eliminar(personaje);
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
