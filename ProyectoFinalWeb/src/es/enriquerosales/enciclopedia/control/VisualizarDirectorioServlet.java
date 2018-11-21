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

/**
 * Implementación de Servlet para la página directorio.jsp.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/dir")
public class VisualizarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 5510286495403127210L;

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
		try {
			int dirId = Integer.parseInt(request.getParameter("id"));
			Directorio dir = dirService.encontrar(dirId);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("directorio.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
