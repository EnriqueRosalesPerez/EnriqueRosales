<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function nuevoPersonaje(id) {
		window.location.replace("${raiz}/personaje/crear?dir=" + id);
	}

	function limpiar() {
		window.location.replace("${rutaLimpiar}");
	}
</script>
<form action="${rutaBusqueda}" method="GET">
	<div class="form-group row">
		<div class="col-8">
			<input class="form-control" type="text" name="s" value="${busqueda}" />
		</div>
		<div class="col">
			<input class="btn btn-primary-red col" type="submit"
				value=<spring:message code="directorio.personajes.buscar" /> />
		</div>
		<div class="col">
			<button type="button" class="btn btn-primary-red" class="col"
				onclick="limpiar()">
				<spring:message code="directorio.personajes.limpiar" />
			</button>
		</div>
	</div>
</form>
<c:choose>
	<c:when test="${empty personajes }">
		<h3>
			<spring:message code="directorio.personajes.vacio" />
		</h3>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1}">
				<c:if test="${not empty directorio.id }">
					<button type="button" class="btn btn-primary-red btn-crear"
						onclick="nuevoPersonaje(${directorio.id})">
						<spring:message code="directorio.personajes.nuevo" />
					</button>
				</c:if>
			</c:if>
		</c:if>
	</c:when>
	<c:otherwise>
		<h3>
			<spring:message code="directorio.personajes.titulo" />
		</h3>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1}">
				<c:if test="${not empty directorio.id }">
					<button type="button" class="btn btn-primary-red btn-crear"
						onclick="nuevoPersonaje(${directorio.id})">
						<spring:message code="directorio.personajes.nuevo" />
					</button>
				</c:if>
			</c:if>
		</c:if>
		<table class="table table-hover">
			<thead>
				<tr>
					<th><spring:message code="directorio.personajes.nombre" /></th>
					<th><spring:message code="directorio.personajes.nacimiento" /></th>
					<th><spring:message code="directorio.personajes.muerte" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${personajes}" var="personaje">
					<tr>
						<td><a href="${raiz }/personaje/${personaje.id}">${personaje.nombre}</a></td>
						<td>${personaje.annoNacimiento}</td>
						<td>${personaje.annoMuerte}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>