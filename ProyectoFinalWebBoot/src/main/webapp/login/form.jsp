<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.titulo" /></title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login" method="POST">
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
			<input type="submit" value="Acceder" />
		</p>
	</form>
	${error }
	<br>
	<a href="${pageContext.request.contextPath }/directorios"><spring:message
			code="login.salir" /></a>
</body>
</html>