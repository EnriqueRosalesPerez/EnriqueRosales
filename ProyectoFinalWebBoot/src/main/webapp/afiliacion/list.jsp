<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function nuevaAfiliacion(id) {
		window.location
				.replace("${raiz }/afiliacion/crear?dir=" + id);
	}
</script>
<c:choose>
	<c:when test="${empty afiliaciones }">
		<h4>
			<spring:message code="directorio.afiliaciones.vacio" />
		</h4>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1}">
				<c:if test="${not empty directorio.id }">
					<button type="button" class="btn btn-primary-red btn-crear"
						"
						onclick="nuevaAfiliacion(${directorio.id})">
						<spring:message code="directorio.afiliaciones.nuevo" />
					</button>
				</c:if>
			</c:if>
		</c:if>
	</c:when>
	<c:otherwise>
		<c:if test="${not empty user}">
			<c:if test="${user.tipo.id == 1}">
				<c:if test="${not empty directorio.id }">
					<button type="button" class="btn btn-primary-red btn-crear"
						onclick="nuevaAfiliacion(${directorio.id})">
						<spring:message code="directorio.afiliaciones.nuevo" />
					</button>
				</c:if>
			</c:if>
		</c:if>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#afiliaciones">
							<button class="btn btn-primary-red dropdown-toggle">
								<spring:message code="afiliacion.titulo" />
							</button>
						</a>
					</h4>
				</div>
				<div id="afiliaciones" class="panel-collapse collapse">
					<ul class="list-group">
						<c:forEach items="${afiliaciones }" var="afiliacion">
							<li><a href="${raiz }/afiliacion/${afiliacion.id}">${afiliacion.nombre }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>