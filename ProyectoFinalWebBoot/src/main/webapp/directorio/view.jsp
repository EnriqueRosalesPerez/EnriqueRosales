<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	$(document).ready(function() {
		document.title = '${directorio.nombre}';
	})

	function editar() {
		window.location.replace("${raiz }/directorio/${directorio.id}/editar");
	}

	function eliminar() {
		if (window
				.confirm('<spring:message code="directorio.eliminar.confirmar"/>')) {
			window.location
					.replace("${raiz }/directorio/${directorio.id}/eliminar");
		}
	}
</script>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item active" aria-current="page">${directorio.nombre }</li>
	</ol>
</nav>
<div class="container-fluid">
	<section class="row">
		<div class="text-left font-italic col-sm-8">
			<spring:message code="afiliacion.creado">
				<spring:argument>${directorio.creador.nombreUsuario}</spring:argument>
				<spring:argument>
					<fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${directorio.fechaCreacion}" />
				</spring:argument>
			</spring:message>
		</div>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1 }">
				<div class="container btn-group float-right col-sm-4" role="group">
					<button type="button" class="btn btn-primary" onclick="editar()">
						<spring:message code="directorio.editar" />
					</button>
					<button type="button" class="btn btn-primary" onclick="eliminar()">
						<spring:message code="directorio.eliminar" />
					</button>
				</div>
			</c:if>
		</c:if>
	</section>
</div>
<div class="text-left">
	<h1>${directorio.nombre}</h1>
</div>
<div class="text-left font-italic">
	<c:out value="${directorio.annoInicio } - ${directorio.annoFin }"></c:out>
</div>
<hr>
<div class="text-justify" style="white-space: pre-wrap;">${directorio.descripcion}</div>
<div>
	<hr>
	<jsp:include page="/afiliacion/list.jsp" />
	<hr>
	<c:set var="rutaBusqueda"
		value="${raiz }/directorio/${directorio.id}/buscar" scope="request"></c:set>
	<c:set var="rutaLimpiar" value="${raiz }/directorio/${directorio.id}"
		scope="request"></c:set>
	<jsp:include page="/personaje/list.jsp" />
</div>