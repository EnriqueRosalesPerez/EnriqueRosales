<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:choose>
	<c:when test="${empty directorios}">
		<div id="tablaDirectorios">
			<h3>
				<spring:message code="directorios.lista.vacio" />
			</h3>
		</div>
	</c:when>
	<c:otherwise>
		<table class="table table-hover" id="tablaDirectorios">
			<thead>
				<tr>
					<th><spring:message code="directorios.lista.nombre" /></th>
					<th><spring:message code="directorios.lista.inicio" /></th>
					<th><spring:message code="directorios.lista.fin" /></th>
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