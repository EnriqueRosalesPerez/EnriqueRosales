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
		<c:set var="dirNombre" value="${afiliacion.directorio.nombre }"></c:set>
		<c:if test="${fn:length(dirNombre) > 20 }">
			<c:set var="dirNombre" value="${fn:substring(dirNombre, 0, 20)}..."></c:set>
		</c:if>
		<li class="breadcrumb-item"><a
			href="${raiz }/directorio/${afiliacion.directorio.id}">${dirNombre }</a></li>
		<c:choose>
			<c:when test="${not empty afiliacion.id }">
				<c:choose>
					<c:when test="${not empty afiliacion.nombre }">
						<c:set var="nombre" value="${afiliacion.nombre }"></c:set>
						<c:if test="${fn:length(nombre) > 20 }">
							<c:set var="nombre" value="${fn:substring(nombre, 0, 20)}..."></c:set>
						</c:if>
						<li class="breadcrumb-item"><a
							href="${raiz }/afiliacion/${afiliacion.id}">${nombre }</a></li>
						<li class="breadcrumb-item active" aria-current="page"><spring:message
								code="afiliacion.form.titulo.editar" arguments="${nombre}" /></li>
					</c:when>
					<c:otherwise>
						<li class="breadcrumb-item"><a
							href="${raiz }/afiliacion/${afiliacion.id}">${afiliacion.id }</a></li>
						<li class="breadcrumb-item active" aria-current="page"><spring:message
								code="afiliacion.form.titulo.editar"
								arguments="${afiliacion.id}" /></li>
					</c:otherwise>
				</c:choose>
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
	<form:errors path="*" cssClass="form-group alert alert-danger"
		element="div"></form:errors>
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
		<input type="submit" class="btn btn-primary-red"
			value=<spring:message code="afiliacion.form.guardar" /> />
	</div>
</form:form>