package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Personaje;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;
import es.enriquerosales.enciclopedia.servicio.PersonajeService;

/**
 * Implementación de Servlet para guardar un nuevo personaje.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir/personaje/guardar")
public class GuardarPersonajeServlet extends HttpServlet {

	private static final long serialVersionUID = -4298608906381231995L;
	private static PersonajeService personajeService;
	private static DirectorioService dirService;

	private static final String SUCCESS = "/index.jsp";
	private static final String ERROR = "/error.jsp";

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			personajeService = Factory.getPersonajeService();
			dirService = Factory.getDirectorioService();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Personaje personaje = null;
			String idStr = request.getParameter("id");
			if (idStr == null || idStr.equals("")) {
				// Se está creando un nuevo personaje
				personaje = new Personaje();
				Usuario creador = (Usuario) request.getSession().getAttribute("user");
				personaje.setCreador(creador);
				personaje.setFechaCreacion(new Date());
				int idDir = Integer.parseInt(request.getParameter("dir"));
				personaje.setDirectorio(dirService.buscar(idDir));
			} else {
				// Se está editando un personaje existente
				personaje = personajeService.buscar(Integer.parseInt(idStr));
			}
			personaje.setNombre(request.getParameter("nombre"));
			personaje.setAnnoNacimiento(request.getParameter("nacimiento"));
			personaje.setAnnoMuerte(request.getParameter("muerte"));
			personaje.setBiografia(request.getParameter("bio"));

			if (idStr == null || idStr.equals("")) {
				personajeService.crear(personaje);
			} else {
				Usuario editor = (Usuario) request.getSession().getAttribute("user");
				personajeService.editar(editor, personaje);
			}

			request.getRequestDispatcher(SUCCESS).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

}
