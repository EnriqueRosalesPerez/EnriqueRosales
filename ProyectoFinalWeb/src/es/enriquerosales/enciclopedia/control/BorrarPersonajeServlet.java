package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Implementaci�n de Servlet para eliminaci�n de Personajes.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje/eliminar")
public class BorrarPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = 1590533612700087885L;
	private static PersonajeService personajeService;

	private static final String SUCCESS = "/index.jsp";
	private static final String ERROR = "/error.jsp";

	public void setPersonajeService(PersonajeService personajeService) {
		BorrarPersonajeServlet.personajeService = personajeService;
	}

	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		// Spring no permite la IoD en Servlets, se obtiene desde el contexto
		this.setPersonajeService(context.getBean(PersonajeService.class));
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
