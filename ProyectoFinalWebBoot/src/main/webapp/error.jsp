<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="error.titulo" /></title>
</head>
<body>
	${error}
	<br>
	<a href="${pageContext.request.contextPath }/directorios">Inicio</a>
</body>
</html>