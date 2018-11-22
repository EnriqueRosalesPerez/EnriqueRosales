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
 * Implementación de Servlet para la página formdirectorio.jsp al editar un
 * Directorio existente.
 * 
 * @author Enrique Rosales
 */
@WebServlet("/directorios/editar")
public class EditarDirectorioServlet extends HttpServlet {

	private static final long serialVersionUID = 5233543272872467666L;
	private static DirectorioService dirService;

	private static final String SUCCESS = "formdirectorio.jsp";
	private static final String ERROR = "/error.jsp";

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
			// TODO Juntar con CrearDirectorioServlet?
			int dirId = Integer.parseInt(request.getParameter("id"));
			Directorio dir = dirService.buscar(dirId);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher(SUCCESS).forward(request, response);
		} catch (Exception e) {
			//TODO tratar excepciones concretas
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
