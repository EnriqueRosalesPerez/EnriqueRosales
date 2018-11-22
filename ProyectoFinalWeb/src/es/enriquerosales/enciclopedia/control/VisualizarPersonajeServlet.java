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
 * Implementación de Servlet para la página personaje.jsp.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje")
public class VisualizarPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = 9021204434011234078L;
	private static PersonajeService personajeService;

	private static final String SUCCESS = "personaje.jsp";
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
			// TODO si el ID no existe o es incorrecto mandar a página de no encontrado.
			int id = Integer.parseInt(request.getParameter("id"));
			Personaje personaje = personajeService.buscar(id);
			request.setAttribute("personaje", personaje);
			request.setAttribute("dir", personaje.getDirectorio().getId());
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
