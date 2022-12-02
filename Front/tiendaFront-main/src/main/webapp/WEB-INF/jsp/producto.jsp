<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>usuario</title>
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

<body>
	<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios

				</a></li>
				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/proveedores">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/productos">Productos</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Producto</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/producto"
				enctype="multipart/form-data">
		<div class="form-group mt-3">
			<label for="file">Select a CSV file</label> <input type="file"
				name="file" class="form-control-file" id="file" accept=".csv">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Importar
			producto</button>
				
				
			</form>
					
		</div>
		<br> 		
		
    <table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>codigoProducto</th>
					<th>iva compra</th>
					<th>id proveedor</th>
					<th>nombre producto</th>
					<th>precio compra</th>
					<th>precio venta</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${producto}" var="producto">
					<tr>
						<td>${producto.id}</td>
						<td>${producto.codigoProducto}</td>
						<td>${producto.ivaCompra}</td>
						<td>${producto.idProveedor}</td>
						<td>${producto.nombreProducto}</td>
						<td>${producto.precioCompra}</td>
						<td>${producto.precioVenta}</td>
						
						
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>