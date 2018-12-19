<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function crear() {
		window.location.replace("${raiz}/directorio/crear");
	}

	function buscar() {
		if ($('#busqueda').val() == '') {
			return;
		}

		var form = $('form[name="form-busqueda"]');
		var formdata = false;
		if (window.FormData) { //Objeto HTML5, si no existe serializa el form
			formdata = new FormData(form[0]);
		}

		$.ajax({
			url : "${raiz}/ajax/directorio/buscar",
			method : "POST",
			contentType : false,
			processData : false,
			timeout : 20000,
			data : formdata ? formdata : form.serialize(),
			success : function(result) {
				$('#tablaDirectorios').replaceWith(result);
			},
			error : function(result) {
				alert(JSON.stringify(result));
			}
		});
	}

	function limpiar() {
		$.ajax({
			url : "${raiz}/ajax/directorio/limpiar",
			method : "POST",
			contentType : false,
			processData : false,
			timeout : 20000,
			success : function(result) {
				$('#tablaDirectorios').replaceWith(result);
				$('#busqueda').val('');
			},
			error : function(result) {
				alert(JSON.stringify(result));
			}
		});
	}
</script>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page"><spring:message
				code="directorios.titulo" /></li>
	</ol>
</nav>
<h3>
	<spring:message code="directorios.lista.titulo" />
</h3>
<br>
<form name="form-busqueda" action="javascript:buscar()">
	<div class="form-group row">
		<div class="col-8">
			<input id="busqueda" class="form-control" type="text" name="busqueda"
				value="${busqueda}" />
		</div>
		<div class="col">
			<input class="btn btn-primary-red col" type="submit"
				value=<spring:message code="directorios.lista.buscar" /> />
		</div>
		<div class="col">
			<button type="button" class="btn btn-primary-red" class="col"
				onclick="limpiar()">
				<spring:message code="directorios.lista.limpiar" />
			</button>
		</div>
	</div>
</form>
<c:if test="${not empty user}">
	<c:if test="${user.tipo.id == 1 }">
		<button type="button" class="btn btn-primary-red btn-crear"
			class="col" onclick="crear()">
			<spring:message code="directorios.lista.crear" />
		</button>
	</c:if>
</c:if>
<jsp:include page="/directorio/table.jsp" />