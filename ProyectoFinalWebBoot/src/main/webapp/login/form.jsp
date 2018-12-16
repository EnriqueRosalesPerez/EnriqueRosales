<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.titulo" /></title>
</head>
<body>
	<form:form modelAttribute="usuario"
		action="${pageContext.request.contextPath }/login" method="POST">
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
	<a href="${pageContext.request.contextPath }/directorios"><spring:message
			code="login.salir" /></a>
</body>
</html>