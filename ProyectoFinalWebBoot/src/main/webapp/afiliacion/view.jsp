<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
	function editar() {
		window.location.replace("${raiz }/afiliacion/${afiliacion.id}/editar");
	}

	function eliminar() {
		window.location
				.replace("${raiz }/afiliacion/${afiliacion.id}/eliminar");

	}
</script>
<div class="modal fade" id="dialogoEliminar" tabindex="-1" role="dialog"
	aria-labelledby="dialogoEliminar" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
					<spring:message code="afiliacion.eliminar.titulo"></spring:message>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<spring:message code="afiliacion.eliminar.confirmar"></spring:message>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">
					<spring:message code="afiliacion.eliminar.confirmar.no"></spring:message>
				</button>
				<button type="button" class="btn btn-primary-red"
					onclick="eliminar()">
					<spring:message code="afiliacion.eliminar.confirmar.si"></spring:message>
				</button>
			</div>
		</div>
	</div>
</div>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item"><a
			href="${raiz }/directorio/${afiliacion.directorio.id}"> <c:set
					var="dirNombre" value="${afiliacion.directorio.nombre }"></c:set> <c:if
					test="${fn:length(dirNombre) > 20 }">
					<c:set var="dirNombre" value="${fn:substring(dirNombre, 0, 20)}..."></c:set>
				</c:if> ${dirNombre }
		</a></li>
		<c:set var="nombre" value="${afiliacion.nombre}" />
		<c:if test="${fn:length(nombre) > 20 }">
			<c:set var="nombre" value="${fn:substring(nombre, 0, 20)}..." />
		</c:if>
		<li class="breadcrumb-item active" aria-current="page">${nombre }</li>
	</ol>
</nav>

<c:if test="${not empty error }">
	<div class="alert alert-danger">${error }</div>
</c:if>
<div class="container-fluid">
	<section class="row">
		<div class="text-left font-italic col-sm-8">
			<spring:message code="afiliacion.creado">
				<spring:argument>${afiliacion.creador.nombreUsuario}</spring:argument>
				<spring:argument>
					<fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${afiliacion.fechaCreacion}" />
				</spring:argument>
			</spring:message>
		</div>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1 }">
				<div class="container btn-group float-right col-sm-4" role="group">
					<button type="button" class="btn btn-primary-red"
						onclick="editar()">
						<spring:message code="afiliacion.editar" />
					</button>
					<button type="button" class="btn btn-primary-red"
						data-toggle="modal" data-target="#dialogoEliminar">
						<spring:message code="afiliacion.eliminar" />
					</button>
				</div>
			</c:if>
		</c:if>
	</section>
</div>
<div class="text-left">
	<h1>${afiliacion.nombre}</h1>
</div>
<div class="text-justify" style="white-space: pre-wrap;">${afiliacion.descripcion}</div>
<div>
	<hr>
	<c:set var="rutaBusqueda"
		value="${raiz }/afiliacion/${afiliacion.id }/buscar" scope="request"></c:set>
	<c:set var="rutaLimpiar" value="${raiz }/afiliacion/${afiliacion.id }"
		scope="request"></c:set>
	<jsp:include page="/personaje/list.jsp" />
</div>
