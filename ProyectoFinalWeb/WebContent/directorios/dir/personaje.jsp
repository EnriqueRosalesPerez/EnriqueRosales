<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${personaje.nombre}</title>
</head>
<body>
	<a href="../dir?id=${dir}">Atr�s</a>
	<c:if test="${not empty user}">
		<br>
		<a href="personaje/editar?id=${personaje.id}&dir=${dir}">Editar esta p�gina</a>
		<br>
		<a href="personaje/eliminar?id=${personaje.id}">Eliminar esta p�gina</a>
	</c:if>
	<br>
	<br>
	<i>P�gina creada por ${personaje.creador.nombreUsuario} el <fmt:formatDate
			type="date" pattern="dd/MM/yyyy" value="${personaje.fechaCreacion}" /></i>
	<h1>${personaje.nombre}</h1>
	<i>${personaje.annoNacimiento } - ${personaje.annoMuerte }</i>
	<br>
	<br>
	<div style="white-space: pre-wrap;"><c:out value="${personaje.biografia}" /></div>
</body>
</html>