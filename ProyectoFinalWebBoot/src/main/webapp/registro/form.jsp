<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
					code="directorios.titulo"></spring:message></a></li>
		<li class="breadcrumb-item active" aria-current="page"><spring:message
				code="registro.titulo" /></li>
	</ol>
</nav>
<form:form modelAttribute="usuario" action="${raiz }/registro"
	method="POST">
	<form:errors path="*" cssClass="form-group alert alert-danger"
		element="div"></form:errors>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="registro.nombre" />
		<form:input path="nombreUsuario" cssClass="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="registro.email" />
		<form:input type="email" path="email" cssClass="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="registro.email.repetir" />
		<input type="email" name="emailrep" id="emailrep" class="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="registro.pass" />
		<form:input type="password" path="contrasenna" cssClass="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<spring:message code="registro.pass.repetir" />
		<input type="password" name="passrep" id="passrep"
			class="form-control" />
	</div>
	<div class="form-group col-sm-5 mx-auto">
		<input type="submit" value=<spring:message code="registro.guardar" />
			class="btn btn-primary-red" />
	</div>
</form:form>