<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:choose>
	<c:when test="${empty personaje.nombre}">
		<title><spring:message code="personaje.form.titulo.nuevo" /></title>
	</c:when>
	<c:otherwise>
		<title><spring:message code="personaje.form.titulo.editar"
				arguments="${personaje.nombre }" /></title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<form:form modelAttribute="personaje" method="POST"
		action="guardarPersonaje">
		<form:hidden path="directorio.id"/>
		<form:hidden path="id" />
		<table>
			<tr>
				<td><spring:message code="personaje.form.nombre" /></td>
				<td><form:input path="nombre" /> <form:errors path="nombre"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="personaje.form.nacimiento" /></td>
				<td><form:input path="annoNacimiento" /></td>
			</tr>
			<tr>
				<td><spring:message code="personaje.form.muerte" /></td>
				<td><form:input path="annoMuerte" /></td>
			</tr>
		</table>
		<spring:message code="personaje.form.biografia" />
		<br>
		<form:textarea path="biografia" rows="4" cols="50"
			value="${personaje.biografia}" />
		<br>
		<input type="submit" value="Guardar" />
		<br>
		<br>
		<a href="verDir?id=${personaje.directorio.id }"><spring:message
				code="personaje.form.salir" /></a>
	</form:form>
</body>
</html>