<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:choose>
	<c:when test="${empty dir}">
		<title>Creando directorio</title>
		<title>Editando ${dir.nombre}</title>
	</c:when>
	<c:otherwise>
		<title>Editando ${dir.nombre}</title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<form:form modelAttribute="directorio" method="POST" action="guardarDir">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" required="required" /></td>
			</tr>
			<tr>
				<td>Año de inicio</td>
				<td><form:input path="annoInicio" /></td>
			</tr>
			<tr>
				<td>Año de fin</td>
				<td><form:input path="annoFin" /></td>
			</tr>
		</table>
		Descripción <br>
		<form:textarea path="descripcion" rows="4" cols="50"
			value="${dir.descripcion}" />
		<br>
		<input type="submit" value="Guardar" />
		<br>
		<br>
		<a href="directorios">Atrás</a>
	</form:form>
</body>
</html>