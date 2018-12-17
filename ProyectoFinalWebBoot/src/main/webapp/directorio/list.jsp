<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="directorios.lista.titulo" />
</h3>
<br>
<form action="${raiz }/directorios/buscar" method="GET">
	<input type="text" name="s" value="${busqueda}" /> <input
		type="submit" value=<spring:message code="directorios.lista.buscar"/> />
	<a href="${raiz }/directorios"><spring:message
			code="directorios.lista.limpiar" /></a>
</form>
<br>
<table>
	<c:if test="${not empty user}">
		<c:if test="${user.tipo.id == 1 }">
			<tr>
				<td><a href="${raiz }/directorio/crear"><spring:message
							code="directorios.lista.crear" /></a></td>
			</tr>
		</c:if>
	</c:if>
	<c:choose>
		<c:when test="${empty directorios}">
			<h3>
				<spring:message code="directorios.lista.vacio" />
			</h3>
		</c:when>
		<c:otherwise>
			<c:forEach items="${directorios}" var="directorio">
				<tr>
					<td><a href="${raiz }/directorio/${directorio.id}"> <c:out
								value="${directorio.nombre}" />
					</a></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>