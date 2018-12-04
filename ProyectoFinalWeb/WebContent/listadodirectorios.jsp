<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.titulo.directorios" /></title>
</head>
<body>
	<a href="directorios?lang=es">ES</a>
	<a href="directorios?lang=en">EN</a>
	<br>
	<c:choose>
		<c:when test="${empty user}">
			<a href="login"><spring:message code="login.acceder" /></a>
		</c:when>
		<c:otherwise>
			<spring:message code="login.conectado"
				arguments="${user.nombreUsuario }" />
			<br>
			<a href="logout"><spring:message code="login.desconectar" /></a>
		</c:otherwise>
	</c:choose>
	<br>
	<h3>
		<spring:message code="directorios.lista.titulo" />
	</h3>
	<br>
	<form action="buscarDir" method="GET">
		<input type="text" name="s" value="${busqueda}" /> <input
			type="submit" value=<spring:message code="directorios.lista.buscar"/> />
		<a href="directorios"><spring:message
				code="directorios.lista.limpiar" /></a>
	</form>
	<br>
	<table>
		<c:if test="${not empty user}">
			<tr>
				<td><a href="editarDir"><spring:message
							code="directorios.lista.crear" /></a></td>
			</tr>
		</c:if>
		<c:choose>
			<c:when test="${empty directorios}">
				<h3>
					<spring:message code="directorios.lista.vacio" />
				</h3>
			</c:when>
			<c:otherwise>
				<c:forEach items="${directorios}" var="directorio">
					<tr>
						<td><a href="verDir?id=${directorio.id}"> <c:out
									value="${directorio.nombre}" />
						</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>