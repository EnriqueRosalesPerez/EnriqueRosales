<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${dir.nombre}" /></title>
</head>
<body>
	<h1>
		<c:out value="${dir.nombre}" />
	</h1>
	<i><c:out value="${dir.annoInicio}" /> - <c:out
			value="${dir.annoFin}" /></i>
	<br>
	<br>
	<br>
	<br>
	<c:out value="${dir.descripcion}" />
	<br>
	<br>
	<a href="../directorios">Volver al �ndice</a>
</body>
</html>