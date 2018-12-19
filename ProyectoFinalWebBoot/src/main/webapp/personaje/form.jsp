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
		<li class="breadcrumb-item"><c:set var="dirNombre"
				value="${personaje.directorio.nombre }"></c:set> <c:if
				test="${fn:length(dirNombre) > 20 }">
				<c:set var="dirNombre" value="${fn:substring(dirNombre, 0, 20)}..."></c:set>
			</c:if> <a href="${raiz }/directorio/${personaje.directorio.id}">${dirNombre }</a></li>
		<c:choose>
			<c:when test="${not empty personaje.id }">
				<c:set var="nombre" value="${personaje.nombre }"></c:set>
				<c:if test="${fn:length(nombre) > 20 }">
					<c:set var="nombre" value="${fn:substring(nombre, 0, 20)}..."></c:set>
				</c:if>
				<li class="breadcrumb-item"><a
					href="${raiz }/personaje/${personaje.id}">${nombre }</a></li>
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="personaje.form.titulo.editar" arguments="${nombre}" /></li>
			</c:when>
			<c:otherwise>
				<li class="breadcrumb-item active" aria-current="page"><spring:message
						code="personaje.form.titulo.nuevo" /></li>
			</c:otherwise>
		</c:choose>
	</ol>
</nav>
<form:form modelAttribute="personaje" method="POST"
	enctype="multipart/form-data" action="${raiz }/personaje/guardar">
	<form:hidden path="directorio.id" />
	<form:hidden path="id" />
	<form:errors path="*" cssClass="form-group alert alert-danger"
		element="div"></form:errors>
	<div class="form-group">
		<spring:message code="personaje.form.nombre" />
		<form:input path="nombre" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="personaje.form.imagen" />
		<c:choose>
			<c:when test="${empty personaje.imagen }">
				<input type="file" name="retrato" accept="image/jpg, image/png"
					class="form-control-file">
			</c:when>
			<c:otherwise>
				<input type="text" class="form-control" value=${personaje.imagen }
					readonly />
				<spring:message code="personaje.form.imagen.modificar" />
				<input type="file" name="retrato" accept="image/jpg, image/png"
					class="form-control-file">
				<input type="checkbox" name="borrarImagen">
				<spring:message code="personaje.form.imagen.eliminar" />
			</c:otherwise>
		</c:choose>
	</div>
	<div class="form-group"></div>
	<div class="form-group">
		<spring:message code="personaje.form.nacimiento" />
		<form:input path="annoNacimiento" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="personaje.form.muerte" />
		<form:input path="annoMuerte" cssClass="form-control" />
	</div>
	<div class="form-group">
		<spring:message code="personaje.form.biografia" />
		<form:textarea path="biografia" cssClass="form-control" rows="20"
			value="${personaje.biografia}" />
	</div>
	<div class="form-group">
		<h4>
			<spring:message code="personaje.form.afiliaciones" />
		</h4>
		<form:checkboxes items="${personaje.directorio.afiliaciones }"
			path="afiliaciones" itemLabel="nombre" itemValue="id"
			cssClass="form-check-input" delimiter="<br>" />
	</div>
	<div class="form-group">
		<input class="btn btn-primary-red" type="submit" value="Guardar" />
	</div>
</form:form>