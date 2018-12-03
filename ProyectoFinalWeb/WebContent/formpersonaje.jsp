<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:choose>
	<c:when test="${empty personaje}">
		<title>Creando personaje</title>
	</c:when>
	<c:otherwise>
		<title>Editando ${personaje.nombre}</title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<form:form modelAttribute="personaje" method="POST"
		action="guardarPersonaje">
		<input type="hidden" name="dir" id="dir" value="${dir}" />
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" required="required" /></td>
			</tr>
			<tr>
				<td>Año de nacimiento</td>
				<td><form:input path="annoNacimiento" /></td>
			</tr>
			<tr>
				<td>Año de muerte</td>
				<td><form:input path="annoMuerte" /></td>
			</tr>
		</table>
		Biografía <br>
		<form:textarea path="biografia" rows="4" cols="50"
			value="${personaje.biografia}" />
		<br>
		<input type="submit" value="Guardar" />
		<br>
		<br>
		<a href="verDir?id=${dir }">Atrás</a>
	</form:form>
</body>
</html>