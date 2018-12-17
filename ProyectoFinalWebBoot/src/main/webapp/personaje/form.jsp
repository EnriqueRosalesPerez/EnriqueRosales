<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form:form modelAttribute="personaje" method="POST"
	action="${raiz }/personaje/guardar">
	<form:hidden path="directorio.id" />
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
	<h4>
		<spring:message code="personaje.form.afiliaciones" />
	</h4>
	<form:checkboxes items="${personaje.directorio.afiliaciones }"
		path="afiliaciones" itemLabel="nombre" itemValue="id" delimiter="<br>" />
	<br>
	<br>
	<input type="submit" value="Guardar" />
	<br>
	<br>
	<c:choose>
		<c:when test="${empty personaje.id }">
			<a href="${raiz }/directorio/${personaje.directorio.id}"><spring:message
					code="personaje.form.salir" /></a>
		</c:when>
		<c:otherwise>
			<a href="${raiz }/personaje/${personaje.id}"><spring:message
					code="personaje.form.salir" /></a>
		</c:otherwise>
	</c:choose>

</form:form>