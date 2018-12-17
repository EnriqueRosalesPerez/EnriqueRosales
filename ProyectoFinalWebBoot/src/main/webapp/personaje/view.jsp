<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	$(document).ready(function() {
		document.title = '${personaje.nombre}';
	})

	function editar() {
		window.location.replace("${raiz }/personaje/${personaje.id }/editar");
	}

	function eliminar() {
		if (window
				.confirm('<spring:message code="personaje.eliminar.confirmar"/>')) {
			window.location
					.replace("${raiz }/personaje/${personaje.id}/eliminar");
		}
	}

	function borrarComentario(id) {
		window.location.replace("${raiz }/comentario/" + id
				+ "/eliminar?personajeid=${personaje.id}")
	}
</script>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item"><a
			href="${raiz }/directorio/${personaje.directorio.id }">${personaje.directorio.nombre }</a></li>
		<li class="breadcrumb-item active" aria-current="page">${personaje.nombre }</li>
	</ol>
</nav>
<div class="container-fluid">
	<section class="row">
		<div class="text-left font-italic col-sm-8">
			<spring:message code="afiliacion.creado">
				<spring:argument>${personaje.creador.nombreUsuario}</spring:argument>
				<spring:argument>
					<fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${personaje.fechaCreacion}" />
				</spring:argument>
			</spring:message>
		</div>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1 }">
				<div class="container btn-group float-right col-sm-4" role="group">
					<button type="button" class="btn btn-primary" onclick="editar()">
						<spring:message code="personaje.editar" />
					</button>
					<button type="button" class="btn btn-primary" onclick="eliminar()">
						<spring:message code="personaje.eliminar" />
					</button>
				</div>
			</c:if>
		</c:if>
	</section>
</div>
<div class="text-left">
	<h1>${personaje.nombre}</h1>
</div>
<div class="text-left font-italic">
	<c:out value="${personaje.annoNacimiento } - ${personaje.annoMuerte }"></c:out>
</div>
<hr>
<jsp:include page="/afiliacion/list.jsp" />
<hr>
<div class="text-justify" style="white-space: pre-wrap;">${personaje.biografia}</div>
<hr>
<h3>
	<spring:message code="personaje.comentarios.titulo" />
</h3>
<c:if test="${not empty user }">
	<form:form modelAttribute="comentario"
		action="${raiz }/comentario/publicar?personajeid=${personaje.id}"
		method="POST">
		<spring:message code="personaje.comentarios.publicar" />
		<br>
		<form:hidden path="personaje.id" value="${personaje.id }" />
		<form:textarea required="required" path="comentario" rows="4"
			cols="50" />
		<br>
		<input type="submit"
			value=<spring:message code="personaje.comentarios.guardar" /> />
	</form:form>
	<br>
</c:if>
<c:choose>
	<c:when test="${empty personaje.comentarios }">
		<i><spring:message code="personaje.comentarios.vacio" /></i>
	</c:when>
	<c:otherwise>
		<div class="container float-left">
			<c:forEach items="${personaje.comentarios }" var="comentario">

				<div class="card">
					<div class="card-body">
						<c:if test="${not empty user }">
							<c:if test="${user.tipo.id == 1 }">
								<button type="button" class="btn btn-primary float-right"
									onclick="borrarComentario(${comentario.id})">
									<spring:message code="personaje.comentarios.eliminar" />
								</button>
							</c:if>
						</c:if>
						<p class="card-subtitle mb-2 text-muted font-italic text-left">
							<fmt:formatDate type="BOTH" pattern="dd/MM/yyyy HH:mm"
								value="${comentario.fechaPublicacion}" />
						</p>
						<p class="card-title font-weight-bold text-left">
							<spring:message code="personaje.comentarios.usuario"
								arguments="${comentario.usuario.nombreUsuario }" />
						</p>
						<p class="card-text text-left">${comentario.comentario}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:otherwise>
</c:choose>