<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function limpiar() {
		window.location.replace("${raiz}/directorios");
	}

	function crear() {
		window.location.replace("${raiz}/directorio/crear");
	}
</script>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page"><spring:message
				code="directorios.titulo" /></li>
	</ol>
</nav>
<h3>
	<spring:message code="directorios.lista.titulo" />
</h3>
<br>
<form action="${raiz }/directorios/buscar" method="GET">
	<div class="form-group row">
		<div class="col-8">
			<input class="form-control" type="text" name="s" value="${busqueda}" />
		</div>
		<div class="col">
			<input class="btn btn-primary-red col" type="submit"
				value=<spring:message code="directorios.lista.buscar" /> />
		</div>
		<div class="col">
			<button type="button" class="btn btn-primary-red" class="col"
				onclick="limpiar()">
				<spring:message code="directorios.lista.limpiar" />
			</button>
		</div>
	</div>
</form>
<c:if test="${not empty user}">
	<c:if test="${user.tipo.id == 1 }">
		<button type="button" class="btn btn-primary-red btn-crear" class="col"
			onclick="crear()">
			<spring:message code="directorios.lista.crear" />
		</button>
	</c:if>
</c:if>
<c:choose>
	<c:when test="${empty directorios}">
		<h3>
			<spring:message code="directorios.lista.vacio" />
		</h3>
	</c:when>
	<c:otherwise>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Año de inicio</th>
					<th>Año de fin</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${directorios}" var="directorio">
					<tr>
						<td><a href="${raiz }/directorio/${directorio.id}"> <c:out
									value="${directorio.nombre}" />
						</a></td>
						<td>${directorio.annoInicio }</td>
						<td>${directorio.annoFin }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>