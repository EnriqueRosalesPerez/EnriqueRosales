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
	<c:when test="${empty directorio.nombre}">
		<title><spring:message code="directorio.form.titulo.nuevo" /></title>
	</c:when>
	<c:otherwise>
		<title><spring:message code="directorio.form.titulo.editar"
				arguments="${directorio.nombre }" /></title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<form:form modelAttribute="directorio" method="POST"
		action="${pageContext.request.contextPath }/directorio/guardar">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><spring:message code="directorio.form.nombre" /></td>
				<td><form:input path="nombre" /> <form:errors path="nombre"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="directorio.form.inicio" /></td>
				<td><form:input path="annoInicio" /></td>
			</tr>
			<tr>
				<td><spring:message code="directorio.form.fin" /></td>
				<td><form:input path="annoFin" /></td>
			</tr>
		</table>
		<spring:message code="directorio.form.descripcion" />
		<br>
		<form:textarea path="descripcion" rows="4" cols="50"
			value="${directorio.descripcion}" />
		<br>
		<input type="submit"
			value=<spring:message code="directorio.form.guardar" /> />
		<br>
		<br>
		<c:choose>
			<c:when test="${empty directorio.id }">
				<a href="${pageContext.request.contextPath }/directorios"><spring:message
						code="directorio.form.salir" /></a>
			</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/directorio/${directorio.id}"><spring:message
						code="directorio.form.salir" /></a>
			</c:otherwise>
		</c:choose>

	</form:form>
</body>
</html>