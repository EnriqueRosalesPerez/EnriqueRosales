package es.enriquerosales.enciclopedia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.enriquerosales.enciclopedia.factory.Factory;
import es.enriquerosales.enciclopedia.modelo.Usuario;
import es.enriquerosales.enciclopedia.servicio.UsuarioService;

/**
 * Implementación de Servlet para realizar un login
 * 
 * @author Enrique Rosales
 */
@WebServlet("/acceso")
public class AccesoServlet extends HttpServlet {

	private static final long serialVersionUID = 4623656588654005327L;
	private static UsuarioService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			userService = Factory.getUsuarioService();
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
			Usuario usuario = userService.acceder(request.getParameter("username"),
					request.getParameter("pass"));

			HttpSession session = request.getSession();
			session.setAttribute("user", usuario);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
