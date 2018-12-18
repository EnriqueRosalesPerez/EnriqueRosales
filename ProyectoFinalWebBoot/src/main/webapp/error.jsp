<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="app.name"></spring:message></title>
<c:set var="raiz" value="${pageContext.request.contextPath }"></c:set>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="${raiz }/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${raiz }/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="${raiz }/css/signin.css" rel="stylesheet">
<link href="${raiz }/css/starter-template.css" rel="stylesheet">

<!-- jQuery and vendor libraries -->
<script src="${raiz }/js/jquery-3.2.1.js"></script>
<script src="${raiz }/js/vendor/popper.min.js"></script>
<script src="${raiz }/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/tiles/header.jsp" />
	<main role="main" class="container">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="${raiz }/directorios"><spring:message
						code="directorios.titulo"></spring:message></a></li>
			<li class="breadcrumb-item active" aria-current="page"><spring:message
					code="app.error"></spring:message></li>
		</ol>
	</nav>
	<div class="text-center">${error}</div>
	</main>
	<jsp:include page="/tiles/footer.jsp" />
</body>
</html>


