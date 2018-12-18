<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
	function editar() {
		window.location.replace("${raiz }/directorio/${directorio.id}/editar");
	}

	function eliminar() {
		window.location
				.replace("${raiz }/directorio/${directorio.id}/eliminar");
	}
</script>
<div class="modal fade" id="dialogoEliminar" tabindex="-1" role="dialog"
	aria-labelledby="dialogoEliminar" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
					<spring:message code="directorio.eliminar.titulo"></spring:message>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<spring:message code="directorio.eliminar.confirmar"></spring:message>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">
					<spring:message code="directorio.eliminar.confirmar.no"></spring:message>
				</button>
				<button type="button" class="btn btn-primary-red"
					onclick="eliminar()">
					<spring:message code="directorio.eliminar.confirmar.si"></spring:message>
				</button>
			</div>
		</div>
	</div>
</div>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<c:set var="nombre" value="${directorio.nombre }"></c:set>
		<c:if test="${fn:length(nombre) > 20 }">
			<c:set var="nombre" value="${fn:substring(nombre, 0, 20)}..."></c:set>
		</c:if>
		<li class="breadcrumb-item active" aria-current="page">${nombre }</li>
	</ol>
</nav>
<c:if test="${not empty error }">
	<div class="alert alert-danger">${error}</div>
</c:if>
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
					<button type="button" class="btn btn-primary-red"
						onclick="editar()">
						<spring:message code="directorio.editar" />
					</button>
					<button type="button" class="btn btn-primary-red"
						data-toggle="modal" data-target="#dialogoEliminar">
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