<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<c:choose>
		<c:when test="${empty personajes }">
		<h3>No hay personajes en este directorio</h3>
	</c:when>
		<c:otherwise>
			<h3>Personajes</h3>
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
	<c:if test="${not empty user}">
		Crear nuevo personaje
	</c:if>
</body>
</html>