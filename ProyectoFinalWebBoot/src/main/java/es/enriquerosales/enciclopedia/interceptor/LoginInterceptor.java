package es.enriquerosales.enciclopedia.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.enriquerosales.enciclopedia.modelo.Usuario;

/**
 * Interceptor para validar que el usuario está autorizado para acceder a una
 * ruta o recurso determinado.
 * 
 * @author Enrique Rosales
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public static final String ATT_USER = "user";
	private static final String LOGIN = "/login";
	private static final String INICIO = "/directorios";

	private String[] adminOnly = { "/editar", "/crear", "/guardar", "/eliminar" };
	private String[] userOnly = { "/publicar" };

	private static final int ID_ADMIN = 1;
	private static final int ID_ESTANDAR = 2;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
		boolean permitido = false;
		if (usuario == null) {
			// Usuario sin autenticar, comprobar si intenta acceder a una ruta solo para
			// usuarios autenticados.
			permitido = !Arrays.stream(adminOnly).anyMatch(uri::endsWith);
			if (permitido) {
				permitido = !Arrays.stream(userOnly).anyMatch(uri::endsWith);
			}
			if (!permitido) {
				response.sendRedirect(request.getContextPath() + LOGIN);
			}
		} else {
			int tipoId = usuario.getTipo().getId();
			if (tipoId == ID_ESTANDAR) {
				// Comprobar si el usuario normal intenta acceder a una ruta solo para
				// administradores.
				permitido = !Arrays.stream(adminOnly).anyMatch(uri::endsWith);
				if (!permitido) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.sendRedirect(request.getContextPath() + INICIO);
				}
			} else if (tipoId == ID_ADMIN) {
				// Administradores tienen acceso total.
				permitido = true;
			}
		}
		return permitido;
	}

}
