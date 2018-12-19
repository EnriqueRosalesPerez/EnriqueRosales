<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	function nuevoPersonaje(id) {
		window.location.replace("${raiz}/personaje/crear?dir=" + id);
	}
	
	function buscar() {
		var form = $('form[name="form-busqueda"]');
		var formdata = false;
		if (window.FormData){ //Objeto HTML5, si no existe serializa el form
		     formdata = new FormData(form[0]);
		}
		
		$.ajax({
			url: "${raiz}/ajax/${rutaBusqueda}",
			method: "POST",
			contentType: false,
			processData: false,
			timeout: 20000,
			data: formdata ? formdata : form.serialize(),
			success: function(result){
					$('#tablaPersonajes').replaceWith(result);
			},
			error: function(result){
					alert(JSON.stringify(result));
			}
		});
	}
	
	function limpiar() {
		$.ajax({
			url: "${raiz}/ajax/${rutaLimpiar}",
			method: "POST",
			contentType: false,
			processData: false,
			timeout: 20000,
			success: function(result){
					$('#tablaPersonajes').replaceWith(result);
					$('#s').val('');
			},
			error: function(result){
					alert(JSON.stringify(result));
			}
		});
	}
</script>
<form name="form-busqueda" action="javascript:buscar()">
	<div class="form-group row">
		<div class="col-8">
			<input class="form-control" type="text" name="s" id="s"
				value="${busqueda}" />
		</div>
		<div class="col">
			<input class="btn btn-primary-red col" type="button"
				onclick="buscar()"
				value=<spring:message code="directorio.personajes.buscar" /> />
		</div>
		<div class="col">
			<button type="button" class="btn btn-primary-red" class="col"
				onclick="limpiar()">
				<spring:message code="directorio.personajes.limpiar" />
			</button>
		</div>
	</div>
</form>
<h3>
	<spring:message code="directorio.personajes.titulo" />
</h3>
<c:if test="${not empty user}">
	<c:if test="${user.tipo.id == 1}">
		<c:if test="${not empty directorio.id }">
			<button type="button" class="btn btn-primary-red btn-crear"
				onclick="nuevoPersonaje(${directorio.id})">
				<spring:message code="directorio.personajes.nuevo" />
			</button>
		</c:if>
	</c:if>
</c:if>
<jsp:include page="/personaje/table.jsp" />