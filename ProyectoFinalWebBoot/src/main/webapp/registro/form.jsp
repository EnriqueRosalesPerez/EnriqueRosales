<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="registro.titulo" /></title>
</head>
<body>
	<form:form modelAttribute="usuario"
		action="${pageContext.request.contextPath }/registro" method="POST">
		<p>
			<spring:message code="registro.nombre" />
		</p>
		<p>
			<form:input path="nombreUsuario" />
		</p>
		<p>
			<spring:message code="registro.pass" />
		</p>
		<p>
			<form:input type="password" path="contrasenna" />
		</p>
		<p>
			<input type="submit" value=<spring:message code="registro.guardar" /> />
		</p>
	</form:form>
	${error }
	<br>
	<a href="${pageContext.request.contextPath }/directorios"><spring:message
			code="login.salir" /></a>
</body>
</html>