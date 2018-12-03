package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;

/**
 * Implementación de Servlet para guardar un nuevo directorio.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/guardar")
public class GuardarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 8345267569308625868L;
	private static DirectorioService dirService;

	private static final String SUCCESS = "/index.jsp";
	private static final String ERROR = "/error.jsp";

	public void setDirService(DirectorioService dirService) {
		GuardarDirectorioServlet.dirService = dirService;
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
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Directorio dir = null;
			String idStr = request.getParameter("id");
			if (idStr == null || idStr.equals("")) {
				// Se está creando un nuevo directorio
				dir = new Directorio();
				Usuario creador = (Usuario) request.getSession().getAttribute("user");
				dir.setCreador(creador);
				dir.setFechaCreacion(new Date());
			} else {
				// Se está editando un directorio existente
				dir = dirService.buscar(Integer.parseInt(idStr));
			}

			dir.setNombre(request.getParameter("nombre"));
			dir.setAnnoInicio(request.getParameter("inicio"));
			dir.setAnnoFin(request.getParameter("fin"));
			dir.setDescripcion(request.getParameter("desc"));

			if (idStr == null || idStr.equals("")) {
				dirService.crear(dir);
			} else {
				Usuario editor = (Usuario) request.getSession().getAttribute("user");
				dirService.editar(editor, dir);
			}

			request.getRequestDispatcher(SUCCESS).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher(ERROR).forward(request, response);
		}
	}

}
