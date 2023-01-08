<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compras</title>
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
<body  opacity=0.8>
<body>
<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios</a></li>

				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/productos">Productos</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

                <li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Ventas</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/venta">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label for="cedulaCliente"> cedulaCliente:</label>
						<input type="text"
							name="cedulaCliente" id="cedulaCliente"
							value="${producto.cedulaCliente}" class="form-control" />
					</div>
					
					
					
				
					<div class="form-group">
						<label for="codigoProducto1"> codigo producto 1:</label>
						<input type="text"
							name="codigoProducto1" id="codigoProducto1"
							value="${producto.codigoProducto1}" class="form-control" />
						<label for="cantidadProducto1"> cantidad producto 1:</label>
						<input type="text"
							name="cantidadProducto1" id="cantidadProducto1"
							value="" class="form-control" />
					</div>
					<div class="form-group">
						<label for="codigoProducto2"> codigo producto 2:</label>
						<input type="text"
							name="codigoProducto2" id="codigoProducto2"
							value="${producto.codigoProducto2}" class="form-control" />
						<label for="cantidadProducto2"> cantidad producto 2:</label>
						<input type="text"
							name="cantidadProducto2" id="cantidadProducto2"
							value="" class="form-control" />
					</div>
					<div class="form-group">
						<label for="codigoProducto3"> codigo producto 3:</label>
						<input type="text"
							name="codigoProducto3" id="codigoProducto3"
							value="${producto.codigoProducto3}" class="form-control" />
						<label for="cantidadProducto3"> cantidad producto 3:</label>
						<input type="text"
							name="cantidadProducto3" id="cantidadProducto3"
							value="" class="form-control" />
					</div>
					
					<button type="submit" class="btn btn-secondary" href="/venta">Consultar</button>
					
				</div>
				
				
				
			</form>
					
		</div>
		<br> 
		<br>	
		<div style="color: red">${mensaje}</div>			
		
    <table class="table">
			<thead>
				<tr>
					
					<th>Fecha Venta</th>
					<th>Nombre Cliente</th>
					<th>Direccion</th>
					<th>Telefono</th>
					<th>vendedor</th>
					<th>Fecha Pago</th>
					<th>Forma de Pago</th>
					<th>Total Venta</th>


					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${compras}" var="compra">
				
					<tr style=" color: black"> 
						
						<td>${compra.fechaCompra}</td>
						<td>${venta.clientes.nombreCliente}</td>
						<td>${venta.clientes.direccionCliente}</td>
						<td>${venta.clientes.telefonoCliente}</td>
						<td>${venta.vendedor.nombreVendedor}</td>
						<td>${venta.fechaPago}</td>
						<td>${venta.formaPago}</td>
						<td>${venta.totalVenta}</td>
						<td><a class="btn btn-success" href="/detalleventa/${venta.fechaVenta}">Ver</a></td>
						
						
					</tr>
				
			</c:forEach>
				
			
			</tbody>
		</table>
		
		<div>Total Venta Sin Iva: ${totalVenta.precioTotalSinIva}</div>
		<div>Iva Total: ${totalVenta.ivaTotal}</div>
		<div>Total con Iva: ${totalVenta.precioTotal}</div>
	</div>
	
</body>
</html>