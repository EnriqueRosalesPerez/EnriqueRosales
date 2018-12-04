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
<title><c:out value="${directorio.nombre}" /></title>
</head>
<body>
	<a href="directorios"><spring:message code="directorio.salir" /></a>
	<c:if test="${not empty user}">
		<c:if test="${user.tipo.id == 1 }">
			<br>
			<a href="editarDir?id=${directorio.id}"><spring:message
					code="directorio.editar" /></a>
			<br>
			<a href="eliminarDir?id=${directorio.id}"><spring:message
					code="directorio.eliminar" /></a>
		</c:if>
	</c:if>
	<br>
	<br>
	<i><spring:message code="directorio.creado">
			<spring:argument>${directorio.creador.nombreUsuario}</spring:argument>
			<spring:argument>
				<fmt:formatDate type="date" pattern="dd/MM/yyyy"
					value="${directorio.fechaCreacion}" />
			</spring:argument>
		</spring:message></i>
	<h1>
		<c:out value="${directorio.nombre}" />
	</h1>
	<i><c:out value="${directorio.annoInicio}" /> - <c:out
			value="${directorio.annoFin}" /></i>
	<br>
	<br>
	<div style="white-space: pre-wrap;">
		<c:out value="${directorio.descripcion}" />
	</div>
	<br>
	<form action="buscarPersonajes" method="GET">
		<input type="hidden" name="dir" value="${directorio.id }" /> <input
			type="text" name="s" value="${busqueda}" /> <input type="submit"
			value=<spring:message code="directorio.personajes.buscar" /> /> <a
			href="verDir?id=${directorio.id }"><spring:message
				code="directorio.personajes.limpiar" /></a>
	</form>
	<c:choose>
		<c:when test="${empty personajes }">
			<h3>
				<spring:message code="directorio.personajes.vacio" />
			</h3>
			<c:if test="${not empty user}">
				<c:if test="${user.tipo.id == 1}">
					<a href="editarPersonaje?dir=${directorio.id}"><spring:message
							code="directorio.personajes.nuevo" /></a>
				</c:if>
			</c:if>
		</c:when>
		<c:otherwise>
			<h3>
				<spring:message code="directorio.personajes.titulo" />
			</h3>
			<c:if test="${not empty user}">
				<c:if test="${user.tipo.id == 1}">
					<a href="editarPersonaje?dir=${directorio.id}"><spring:message
							code="directorio.personajes.nuevo" /></a>
					<br>
					<br>
				</c:if>
			</c:if>
			<table>
				<tr>
					<th><spring:message code="directorio.personajes.nombre" /></th>
					<th><spring:message code="directorio.personajes.nacimiento" /></th>
					<th><spring:message code="directorio.personajes.muerte" /></th>
				</tr>
				<c:forEach items="${personajes}" var="personaje">
					<tr>
						<td><a href="verPersonaje?id=${personaje.id}">${personaje.nombre}</a></td>
						<td>${personaje.annoNacimiento}</td>
						<td>${personaje.annoMuerte}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>