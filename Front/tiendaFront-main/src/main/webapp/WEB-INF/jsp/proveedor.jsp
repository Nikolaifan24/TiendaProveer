<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/css.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<link href="style.css" rel="stylesheet" type="text/css" />	
</head>
<body opacity=0.5>
<body>
<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios

				</a></li>
				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Proveedores</h1>
	
	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/proveedor">
				
				<div class="container overflow-hidden">
				<div class="form-group">
					<input type="hidden" name="id" value="${proveedorEditar.id}">

					<label for="nit"> Nit:</label><input type="text"
						name="nit" id="nit"
						value="${proveedorEditar.nit}" class="form-control" />
				</div>
				<div class="form-group">
					<label>nombre:</label><input type="text" name="nombre"
						class="form-control" value="${proveedorEditar.nombre}" />
				</div>
				<div class="form-group">
					<label>Ciudad:</label><input type="text" name="ciudad"
						class="form-control" value="${proveedorEditar.ciudad}" />
				</div>
				<div class="form-group">
					<label> Direccion:</label> <input type="text"
						name="address" class="form-control"
						value="${proveedorEditar.address}" />
				</div>
				<div class="form-group">
					<label>Telefono:</label> <input type="text" name="telefono"
						class="form-control" value="${proveedorEditar.telefono}" />
				</div>
				</div>
				<br>
				<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-primary" formmethod="post" >Grabar</button>
				<!-- <a type="button" class="btn btn-secondary" href= "/proveedorPorNit/${proveedorEditar.nit}" >Consultar proveedor</a>-->
				<a type="button" class="btn btn-secondary" onclick="getInputValue();" >Consultar Proveedor</a>
		 		</div>
			</form>
		</div>
		<br> 
		<br>	
		<div style="color: red">${mensaje}</div>	
		
    <table class="table">
			<thead>
				<tr>
					<th>Nit</th>
					<th>Nombre</th>
					<th>Ciudad</th>
					<th>Direccion</th>
					<th>Telefono</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${proveedores}" var="proveedor">
					<tr style=" color: #FFF35F"> 
						<td>${proveedor.nit}</td>
						<td>${proveedor.nombre}</td>
						<td>${proveedor.ciudad}</td>
						<td>${proveedor.direccion}</td>
						<td>${proveedor.telefono}</td>
						<td><a class="btn btn-danger" href="/eliminarproveedor/${proveedor.nit}">Eliminar proveedor</a></td>
						<td><a class="btn btn-success" href="/proveedor/${proveedor.nit}">Actualizar proveedor</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>


<script>

function getInputValue(){
    
    var inputVal = document.getElementById("nit").value;
    var url = "/proveedorPorNit/" + inputVal;
    let res = fetch(url);
        
}


</script>
</html>