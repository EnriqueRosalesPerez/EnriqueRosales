<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<form action="guardar" method="POST">
		<input type="hidden" name="dir" value="${dir}" />
		<c:if test="${not empty personaje}">
			<input name="id" type="hidden" value="${personaje.id}" />
		</c:if>
		<table>
			<tr>
				<td>Nombre</td>
				<td><input name="nombre" required type="text"
					value="${personaje.nombre}" /></td>
			</tr>
			<tr>
				<td>Año de nacimiento</td>
				<td><input name="nacimiento" type="text"
					value="${personaje.annoNacimiento}" /></td>
			</tr>
			<tr>
				<td>Año de muerte</td>
				<td><input name="muerte" type="text"
					value="${personaje.annoMuerte}" /></td>
			</tr>
		</table>
		Biografía <br>
		<textarea name="bio" rows="4" cols="50"><c:out
				value="${personaje.biografia}" /></textarea>
		<br> <input type="submit" value="Guardar" /> <br> <br>
		<a href="..?id=${dir}">Atrás</a>
	</form>
</body>
</html>