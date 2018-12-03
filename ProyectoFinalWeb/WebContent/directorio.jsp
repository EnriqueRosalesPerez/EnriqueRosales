<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${directorio.nombre}" /></title>
</head>
<body>
	<a href="directorios">Volver al índice</a>
	<c:if test="${not empty user}">
		<br>
		<a href="editarDir?id=${directorio.id}">Editar esta página</a>
		<br>
		<a href="eliminarDir?id=${directorio.id}">Eliminar esta página</a>
	</c:if>
	<br>
	<br>
	<i>Página creada por ${directorio.creador.nombreUsuario} el <fmt:formatDate
			type="date" pattern="dd/MM/yyyy" value="${directorio.fechaCreacion}" /></i>
	<h1>
		<c:out value="${directorio.nombre}" />
	</h1>
	<i><c:out value="${directorio.annoInicio}" /> - <c:out
			value="${directorio.annoFin}" /></i>
	<br>
	<br>
	<div style="white-space: pre-wrap;"><c:out value="${directorio.descripcion}" /></div>
	<br>
	<form action="buscarPersonajes" method="GET">
		<input type="hidden" name="dir" value="${directorio.id }" /> <input
			type="text" name="s" value="${busqueda}" /> <input type="submit"
			value="Buscar" /> <a href="verDir?id=${directorio.id }">Limpiar
			busqueda</a>
	</form>
	<c:choose>
		<c:when test="${empty personajes }">
			<h3>No se han encontrado personajes</h3>
			<c:if test="${not empty user}">
				<a href="editarPersonaje?dir=${directorio.id}">Crear nuevo
					personaje</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<h3>Personajes</h3>
			<c:if test="${not empty user}">
				<a href="editarPersonaje?dir=${directorio.id}">Crear nuevo
					personaje</a>
				<br>
				<br>
			</c:if>
			<table>
				<tr>
					<th>Nombre</th>
					<th>Nacimiento</th>
					<th>Muerte</th>
				</tr>
				<c:forEach items="${personajes}" var="personaje">
					<tr>
						<td><a
							href="verPersonaje?id=${personaje.id}">${personaje.nombre}</a></td>
						<td>${personaje.annoNacimiento}</td>
						<td>${personaje.annoMuerte}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>