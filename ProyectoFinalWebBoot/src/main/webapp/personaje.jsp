<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${personaje.nombre}</title>
</head>
<body>
	<a href="verDir?id=${personaje.directorio.id }"><spring:message
			code="personaje.salir" /></a>
	<c:if test="${not empty user}">
		<c:if test="${user.tipo.id == 1 }">
			<br>
			<a
				href="editarPersonaje?id=${personaje.id}&dir=${personaje.directorio.id}"><spring:message
					code="personaje.editar" /></a>
			<br>
			<a href="eliminarPersonaje?id=${personaje.id}"><spring:message
					code="personaje.eliminar" /></a>
		</c:if>
	</c:if>
	<br>
	<br>
	<i><spring:message code="personaje.creado">
			<spring:argument>${personaje.creador.nombreUsuario}</spring:argument>
			<spring:argument>
				<fmt:formatDate type="date" pattern="dd/MM/yyyy"
					value="${personaje.fechaCreacion}" />
			</spring:argument>
		</spring:message></i>
	<h1>${personaje.nombre}</h1>
	<i>${personaje.annoNacimiento } - ${personaje.annoMuerte }</i>
	<br>
	<br>
	<div style="white-space: pre-wrap;">
		<c:out value="${personaje.biografia}" />
	</div>
</body>
</html>