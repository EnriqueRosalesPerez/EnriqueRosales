<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="registro.titulo" /></title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registro"
		method="POST">
		<p>
			<spring:message code="registro.nombre" />
		</p>
		<p>
			<input type="text" name="username" />
		</p>
		<p>
			<spring:message code="registro.pass" />
		</p>
		<p>
			<input type="password" name="pass" />
		</p>
		<p>
			<input type="submit" value=<spring:message code="registro.guardar" /> />
		</p>
	</form>
	${error }
	<br>
	<a href="${pageContext.request.contextPath }/directorios"><spring:message
			code="login.salir" /></a>
</body>
</html>