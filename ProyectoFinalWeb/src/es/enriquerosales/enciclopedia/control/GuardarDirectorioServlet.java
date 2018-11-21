package es.enriquerosales.enciclopedia.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Directorio;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.DirectorioService;

/**
 * Servlet implementation class GuardarDirectorioServlet
 */
@WebServlet("/guardar")
public class GuardarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 8345267569308625868L;
	private static DirectorioService dirService;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
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
			Directorio dir = new Directorio();
			dir.setNombre(request.getParameter("nombre"));
			dir.setAnnoInicio(request.getParameter("inicio"));
			dir.setAnnoFin(request.getParameter("fin"));
			dir.setDescripcion(request.getParameter("desc"));
			dir.setFechaCreacion(new Date());

			// FIXME Creador de prueba
			Usuario u = new Usuario();
			u.setId(1);

			dir.setCreador(u);
			dirService.crear(dir);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
