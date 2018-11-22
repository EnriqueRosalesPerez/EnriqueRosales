package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Implementación de Servlet para la página directorio.jsp.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir")
public class VisualizarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 5510286495403127210L;
	private static DirectorioService dirService;
	private static PersonajeService personajeService;

	private static final String SUCCESS = "directorio.jsp";
	private static final String ERROR = "/error.jsp";

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dirService = Factory.getDirectorioService();
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
			int dirId = Integer.parseInt(request.getParameter("id"));
			Directorio dir = dirService.buscar(dirId);
			request.setAttribute("dir", dir);
			request.setAttribute("personajes", personajeService.listar(dir));
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
