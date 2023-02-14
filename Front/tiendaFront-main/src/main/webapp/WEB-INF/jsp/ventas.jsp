<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
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
				<li class="nav-item"><a class="nav-link" href="/usuario">Usuarios</a></li>

				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/producto">Productos</a></li>

				<li class="nav-item active"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/faltantes">Faltantes</a></li>

                <li class="nav-item"><a class="nav-link" href="/devoluciones">Devoluciones</a></li>

				<li class="nav-item"><a class="nav-link" href="/Pagos">Pagos</a></li>

            	<li class="nav-item"><a class="nav-link" href="/Cartera">Cartera</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

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
						<label>Seleccionar una Accion</label>
						 <select name="ID" id ="ID"
								class="form-select">
								<option name="ID" value="1">Editar Venta</option>
								<option name="ID" value="0">Crear Venta</option>
		
								
							</select>
						<label>Seleccionar un Vendedor</label>
						<select name="nombreVendedor" id ="nombreVendedor"class="form-select">
							<c:forEach items="${vendedor}" var="vendedor">
								<option name="nombreVendedor" value="${vendedor.nombreVendedor}">${vendedor.nombreVendedor}</option>
							</c:forEach>
								
							</select>
					</div>
					
					<div class="form-group">
						<label for="documentoCliente"> Documento Cliente</label>
						<input type="text"
							name="documentoCliente" id="documentoCliente"
							value="${VentasEditar.documentoCliente}" class="form-control" />
						<label for="CodigoVenta"> Codigo de la Venta:</label>
						<input type="text"
							name="CodigoVenta" id="CodigoVenta"
							value="${VentasEditar.CodigoVenta}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Seleccionar Descuento</label>
						 <select name="descuento" id ="descuento"
								class="form-select">
								<option name="descuento" value="5">5%</option>
								<option name="descuento" value="3">3%</option>
		
								
							</select>
					</div>
					<div class="form-group">
						<label for="FechaVenta"> Fecha de la Venta:</label>
						<input type="date"
							name="FechaVenta" id="FechaVenta"
							value="${VentasEditar.FechaVenta}" class="form-control" />
						<label for="FechaEntrega"> Fecha de Entrega:</label>
						<input type="date"
							name="FechaEntrega" id="FechaEntrega"
							value="${VentasEditar.FechaEntrega}" class="form-control" />
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example">
					<button type="submit" class="btn btn-primary" formmethod="post" >Guardar</button>
					<button type="button" class="btn btn-secondary" onclick= relocate_buscar() >Consultar</button>
					</div>
					
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
					<th>Codigo Venta</th>
					<th>Nombre Cliente</th>
					<th>Apellido Cliente</th>
					<th>Documento</th>
					<th>Direccion</th>
					<th>Telefono</th>
					<th>Vendedor</th>
					<th>Total Venta</th>


					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ventas}" var="venta">
				
					<tr style=" color: black"> 
						
						<td>${venta.fechaVenta}</td>
						<td>${venta.codigoVenta}</td>
						<td>${venta.clientes.nombreCliente}</td>
						<td>${venta.clientes.apellidoCliente}</td>
						<td>${venta.clientes.documentoCliente}</td>
						<td>${venta.clientes.direccionCliente}</td>
						<td>${venta.clientes.telefonoCliente}</td>
						<td>${venta.vendedor.nombreVendedor}</td>
						<td>${venta.totalVenta}</td>
						<td><a class="btn btn-success" href="/detalleventa/${venta.codigoVenta}">Ver</a></td>
						
						
					</tr>
				
			</c:forEach>
				
			
			</tbody>
		</table>
		
	</div>
	
</body>
</html>