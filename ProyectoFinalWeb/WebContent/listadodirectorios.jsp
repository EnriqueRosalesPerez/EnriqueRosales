<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directorios</title>
</head>
<body>
	<h3>Directorios</h3>
	<br>
	<table>
		<c:forEach items="${directorios}" var="directorio">
			<tr>
				<td>
					<a href="directorios/dir?id=${directorio.id}"> 
						<c:out value="${directorio.nombre}" />
					</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="directorios/crear">Crear nuevo directorio</a></td>
		</tr>
	</table>
</body>
</html>