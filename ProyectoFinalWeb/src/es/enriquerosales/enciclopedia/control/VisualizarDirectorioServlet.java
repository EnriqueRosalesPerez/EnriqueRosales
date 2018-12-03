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

	public void setPersonajeService(PersonajeService personajeService) {
		VisualizarDirectorioServlet.personajeService = personajeService;
	}

	public void setDirService(DirectorioService dirService) {
		VisualizarDirectorioServlet.dirService = dirService;
	}

	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		// Spring no permite la IoD en Servlets, se obtiene desde el contexto
		this.setDirService(context.getBean(DirectorioService.class));
		this.setPersonajeService(context.getBean(PersonajeService.class));
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
