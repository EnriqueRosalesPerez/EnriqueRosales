<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<c:choose>
			<c:when test="${not empty directorio.id }">
				<c:set var="nombre" value="${directorio.nombre }"></c:set>
				<c:if test="${fn:length(nombre) > 20 }">
					<c:set var="nombre" value="${fn:substring(nombre, 0, 20)}..."></c:set>
				</c:if>
				<li class="breadcrumb-item"><a
					href="${raiz }/directorio/${directorio.id}">${nombre }</a></li>
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="directorio.form.titulo.editar" arguments="${nombre}" /></li>
			</c:when>
			<c:otherwise>
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="directorio.form.titulo.nuevo" /></li>
			</c:otherwise>
		</c:choose>
	</ol>
</nav>
<form:form modelAttribute="directorio" method="POST"
	action="${raiz }/directorio/guardar">
	<form:hidden path="id" />
	<form:errors path="*" cssClass="form-group alert alert-danger"
		element="div"></form:errors>
	<div class="form-group">
		<spring:message code="directorio.form.nombre" />
		<form:input path="nombre" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="directorio.form.inicio" />
		<form:input path="annoInicio" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="directorio.form.fin" />
		<form:input path="annoFin" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="directorio.form.descripcion" />
		<form:textarea path="descripcion" value="${directorio.descripcion}"
			cssClass="form-control" rows="20" />
	</div>
	<div class="form-group">
		<input type="submit" class="btn btn-primary-red"
			value=<spring:message code="directorio.form.guardar" /> />
	</div>
</form:form>