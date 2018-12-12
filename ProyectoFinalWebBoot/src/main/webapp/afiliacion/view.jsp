<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${afiliacion.nombre }</title>
</head>
<body>
	<a
		href="${pageContext.request.contextPath }/directorio/${afiliacion.directorio.id}"><spring:message
			code="afiliacion.salir" /></a>
	<c:if test="${not empty user}">
		<c:if test="${user.tipo.id == 1 }">
			<br>
			<a
				href="${pageContext.request.contextPath }/afiliacion/${afiliacion.id}/editar"><spring:message
					code="afiliacion.editar" /></a>
			<br>
			<a
				href="${pageContext.request.contextPath }/afiliacion/${afiliacion.id}/eliminar"
				onclick="return window.confirm(
				'<spring:message code="afiliacion.eliminar.confirmar"/>'
				)">
				<spring:message code="afiliacion.eliminar" />
			</a>
		</c:if>
	</c:if>
	${error }
	<br>
	<br>
	<i><spring:message code="afiliacion.creado">
			<spring:argument>${afiliacion.creador.nombreUsuario}</spring:argument>
			<spring:argument>
				<fmt:formatDate type="date" pattern="dd/MM/yyyy"
					value="${afiliacion.fechaCreacion}" />
			</spring:argument>
		</spring:message></i>
	<h1>
		<c:out value="${afiliacion.nombre}" />
	</h1>
	<br>
	<br>
	<div style="white-space: pre-wrap;"><c:out value="${afiliacion.descripcion}" /></div>
	<br>
	<c:choose>
		<c:when test="${empty afiliacion.personajes }">
			<h3>
				<spring:message code="afiliacion.personajes.vacio" />
			</h3>
		</c:when>
		<c:otherwise>
			<h3>
				<spring:message code="afiliacion.personajes.titulo" />
			</h3>
			<table>
				<tr>
					<th><spring:message code="afiliacion.personajes.nombre" /></th>
					<th><spring:message code="afiliacion.personajes.nacimiento" /></th>
					<th><spring:message code="afiliacion.personajes.muerte" /></th>
				</tr>
				<c:forEach items="${afiliacion.personajes}" var="personaje">
					<tr>
						<td><a
							href="${pageContext.request.contextPath }/personaje/${personaje.id}">${personaje.nombre}</a></td>
						<td>${personaje.annoNacimiento}</td>
						<td>${personaje.annoMuerte}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>