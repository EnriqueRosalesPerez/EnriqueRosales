<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo }</title>
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

	<tiles:insertAttribute name="header" />
	<main role="main" class="container">
	<div class="text-center">
		<tiles:insertAttribute name="body" />
	</div>
	</main>
	<!-- /.container -->
	<tiles:insertAttribute name="footer" />

</body>
</html>