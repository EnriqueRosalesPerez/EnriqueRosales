<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Directorios</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty user}">
			<a href="login">Acceder</a>
		</c:when>
		<c:otherwise>
			Conectado como ${user.nombreUsuario}
			<br>
			<a href="logout">Desconectarse</a>
		</c:otherwise>
	</c:choose>
	<br>
	<h3>Directorios</h3>
	<br>
	<form action="buscar" method="GET">
		<input type="text" name="s" value="${busqueda}" /> <input
			type="submit" value="Buscar" /> <a href="directorios">Limpiar
			busqueda</a>
	</form>
	<br>
	<table>
		<c:if test="${not empty user}">
			<tr>
				<td><a href="directorios/crear">Crear nuevo directorio</a></td>
			</tr>
		</c:if>
		<c:choose>
			<c:when test="${empty directorios}">
				<h3>No se han encontrado directorios</h3>
			</c:when>
			<c:otherwise>
				<c:forEach items="${directorios}" var="directorio">
					<tr>
						<td><a href="directorios/dir?id=${directorio.id}"> <c:out
									value="${directorio.nombre}" />
						</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>