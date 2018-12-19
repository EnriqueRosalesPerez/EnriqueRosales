<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:choose>
	<c:when test="${empty personajes }">
		<div id="tablaPersonajes">
			<h3>
				<spring:message code="directorio.personajes.vacio" />
			</h3>
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-hover" id="tablaPersonajes">
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