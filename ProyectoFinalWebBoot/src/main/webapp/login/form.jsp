<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="usuario" action="${raiz }/login"
	method="POST">
	<p>
		<spring:message code="login.nombre" />
	</p>
	<p>
		<form:input path="nombreUsuario" />
	</p>
	<p>
		<spring:message code="login.pass" />
	</p>
	<p>
		<form:input type="password" path="contrasenna" />
	</p>
	<p>
		<input type="submit" value="<spring:message code="login.acceder" />" />
	</p>
</form:form>
${error }
<br>
<a href="${raiz }/directorios"><spring:message code="login.salir" /></a>