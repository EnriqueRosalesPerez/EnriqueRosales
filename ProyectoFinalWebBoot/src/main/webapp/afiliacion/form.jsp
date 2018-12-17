<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	$(document)
			.ready(
					function() {
						var afiliacion = '${afiliacion.nombre}';
						if (afiliacion == '') {
							document.title = '<spring:message code="afiliacion.form.titulo.nuevo" />'
						} else {
							document.title = '<spring:message code="afiliacion.form.titulo.editar" arguments="${afiliacion.nombre}"/>'
						}
					})
</script>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item"><a
			href="${raiz }/directorio/${afiliacion.directorio.id}">${afiliacion.directorio.nombre }</a></li>
		<c:choose>
			<c:when test="${not empty afiliacion.nombre }">
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="afiliacion.form.titulo.editar"
						arguments="${afiliacion.nombre}" /></li>
			</c:when>
			<c:otherwise>
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="afiliacion.form.titulo.nuevo" /></li>
			</c:otherwise>
		</c:choose>
	</ol>
</nav>
<form:form modelAttribute="afiliacion" method="POST"
	action="${raiz }/afiliacion/guardar">
	<div class="form-group">
		<form:errors path="nombre" cssClass="alert alert-danger" />
	</div>
	<form:hidden path="directorio.id" />
	<form:hidden path="id" />
	<div class="form-group">
		<spring:message code="afiliacion.form.nombre" />
		<form:input path="nombre" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="afiliacion.form.descripcion" />
		<form:textarea path="descripcion" value="${afiliacion.descripcion}"
			cssClass="form-control" rows="20" />
	</div>
	<div class="form-group">
		<input type="submit" class="btn btn-primary"
			value=<spring:message code="afiliacion.form.guardar" /> />
	</div>
	<c:choose>
		<c:when test="${empty afiliacion.id }">
			<a href="${raiz }/directorio/${afiliacion.directorio.id}"><spring:message
					code="afiliacion.form.salir" /></a>
		</c:when>
		<c:otherwise>
			<a href="${raiz }/afiliacion/${afiliacion.id}"><spring:message
					code="afiliacion.form.salir" /></a>
		</c:otherwise>
	</c:choose>
</form:form>