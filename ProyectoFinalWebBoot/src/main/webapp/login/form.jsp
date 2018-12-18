<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item active" aria-current="page"><spring:message
				code="login.titulo" /></li>
	</ol>
</nav>
<form:form modelAttribute="usuario" action="${raiz }/login"
	method="POST">
	<form:errors path="nombreUsuario"
		cssClass="form-group alert alert-danger" element="div"></form:errors>
	<form:errors path="contrasenna"
		cssClass="form-group alert alert-danger" element="div"></form:errors>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="login.nombre" />
		<form:input path="nombreUsuario" cssClass="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="login.pass" />
		<form:input type="password" path="contrasenna" cssClass="form-control" />
	</div>
	<div class="form-group">
		<input type="submit" value="<spring:message code="login.acceder" />"
			class="btn btn-primary-red" />
	</div>
</form:form>
