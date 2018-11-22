<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="guardar" method="POST">
		<c:if test="${not empty dir}">
			<input name="id" type="hidden" value="${dir.id}" />
		</c:if>
		<table>
			<tr>
				<td>Nombre</td>
				<td><input name="nombre" required type="text"
					value="${dir.nombre}" /></td>
			</tr>
			<tr>
				<td>Año de inicio</td>
				<td><input name="inicio" type="text" value="${dir.annoInicio}" /></td>
			</tr>
			<tr>
				<td>Año de fin</td>
				<td><input name="fin" type="text" value="${dir.annoFin}" /></td>
			</tr>
		</table>
		Descripción <br>
		<textarea name="desc" rows="4" cols="50"><c:out
				value="${dir.descripcion}" /></textarea>
		<br> <input type="submit" value="Guardar" /> <br> <br>
		<a href="../directorios">Atrás</a>
	</form>
</body>
</html>