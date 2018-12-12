<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:choose>
	<c:when test="${empty afiliacion.nombre}">
		<title><spring:message code="afiliacion.form.titulo.nuevo" /></title>
	</c:when>
	<c:otherwise>
		<title><spring:message code="afiliacion.form.titulo.editar"
				arguments="${afiliacion.nombre }" /></title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<form:form modelAttribute="afiliacion" method="POST"
		action="${pageContext.request.contextPath }/afiliacion/guardar">
		<form:hidden path="directorio.id" />
		<form:hidden path="id" />
		<table>
			<tr>
				<td><spring:message code="afiliacion.form.nombre" /></td>
				<td><form:input path="nombre" /> <form:errors path="nombre"
						cssClass="error" /></td>
			</tr>
		</table>
		<spring:message code="afiliacion.form.descripcion" />
		<br>
		<form:textarea path="descripcion" rows="4" cols="50"
			value="${afiliacion.descripcion}" />
		<br>
		<input type="submit"
			value=<spring:message code="afiliacion.form.guardar" /> />
		<br>
		<br>
		<c:choose>
			<c:when test="${empty afiliacion.id }">
				<a
					href="${pageContext.request.contextPath }/directorio/${directorio.id}"><spring:message
						code="afiliacion.form.salir" /></a>
			</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/afiliacion/${afiliacion.id}"><spring:message
						code="afiliacion.form.salir" /></a>
			</c:otherwise>
		</c:choose>

	</form:form>
</body>
</html>