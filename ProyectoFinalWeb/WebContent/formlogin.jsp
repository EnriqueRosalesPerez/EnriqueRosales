<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.titulo.login" /></title>
</head>
<body>
	<form action="login" method="POST">
		<p>
			<spring:message code="login.nombre" />
		</p>
		<p>
			<input type="text" name="username" />
		</p>
		<p>
			<spring:message code="login.pass" />
		</p>
		<p>
			<input type="password" name="pass" />
		</p>
		<p>
			<input type="submit" value="Acceder" />
		</p>
	</form>
	${error }
	<br>
	<a href="."><spring:message code="login.salir" /></a>
</body>
</html>