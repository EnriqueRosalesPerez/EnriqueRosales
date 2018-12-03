<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${dir.nombre}" /></title>
</head>
<body>
	<a href="../directorios">Volver al índice</a>
	<c:if test="${not empty user}">
		<br>
		<a href="editar?id=${dir.id}">Editar esta página</a>
		<br>
		<a href="eliminar?id=${dir.id}">Eliminar esta página</a>
	</c:if>
	<br>
	<br>
	<i>Página creada por ${dir.creador.nombreUsuario} el <fmt:formatDate
			type="date" pattern="dd/MM/yyyy" value="${dir.fechaCreacion}" /></i>
	<h1>
		<c:out value="${dir.nombre}" />
	</h1>
	<i><c:out value="${dir.annoInicio}" /> - <c:out
			value="${dir.annoFin}" /></i>
	<br>
	<br>
	<div style="white-space: pre-wrap;"><c:out value="${dir.descripcion}" /></div>
	<br>
	<form action="buscar" method="GET">
		<input type="hidden" name="dir" value="${dir.id }" /> <input
			type="text" name="s" value="${busqueda}" /> <input type="submit"
			value="Buscar" /> <a href="dir?id=${dir.id }">Limpiar busqueda</a>
	</form>
	<c:choose>
		<c:when test="${empty personajes }">
			<h3>No se han encontrado personajes</h3>
			<c:if test="${not empty user}">
				<a href="dir/personaje/crear?dir=${dir.id}">Crear nuevo
					personaje</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<h3>Personajes</h3>
			<c:if test="${not empty user}">
				<a href="dir/personaje/crear?dir=${dir.id}">Crear nuevo
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
						<td><a href="dir/personaje?id=${personaje.id}">${personaje.nombre}</a></td>
						<td>${personaje.annoNacimiento}</td>
						<td>${personaje.annoMuerte}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>