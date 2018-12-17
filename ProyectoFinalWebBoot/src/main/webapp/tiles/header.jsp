<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="${raiz }/directorios"><spring:message
						code="directorios.lista.titulo" /></a></li>


			<c:choose>
				<c:when test="${empty user }">
					<li class="nav-item active"><a class="nav-link"
						href="${raiz }/login"><spring:message code="login.titulo" /></a></li>
					<li class="nav-item active navbar-right"><a class="nav-link"
						href="${raiz }/registro"><spring:message
								code="registro.titulo" /></a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item active text-light"><spring:message
							code="login.conectado" arguments="${user.nombreUsuario }" /></li>
					<li class="nav-item active"><a class="nav-link"
						href="${raiz }/logout"><spring:message
								code="login.desconectar" /></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>