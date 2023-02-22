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

				<li class="nav-item"><a class="nav-link" href="/producto">vendedor</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/faltantes">Faltantes</a></li>

                <li class="nav-item active"><a class="nav-link" href="/devoluciones">Devoluciones</a></li>

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
			<form method="post" action="/detalledevoluciones/${CodigoVenta}">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label>Seleccionar una Accion</label>
						 <select name="IDDevoluciones" id ="IDDevoluciones"
								class="form-select">
								<option name="IDDevoluciones" value="1">Editar Detalle</option>
								<option name="IDDevoluciones" value="0">Crear un Detalle</option>
		
								
							</select>
					</div>
					
					
					<div class="form-group">
						<label>Codigo de la Venta:</label><input type="text" name="CodigoVenta" id ="CodigoVenta"
							class="form-control" value="${CodigoVenta}" disabled="disabled" />
					</div>
					<div class="form-group">
						<label>Seleccionar un Producto</label>
						 <select name="nombreProducto" id ="nombreProducto" class="form-select">
							
							<c:forEach items="${productos}" var="productos">
								<option name="nombreProducto" value="${productos.nombreProducto}">${productos.nombreProducto}</option>
							</c:forEach>		
								
							</select>
					</div>
					<div class="form-group">
						
						<label for="codigoProducto"> Codigo del Producto</label>
						<input type="text"
							name="codigoProducto" id="codigoProducto"
							value="${detalledevolucionesEditar.productos.codigoProducto}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cantidad"> Cantidad del Producto:</label>
						<input type="text"
							name="cantidad" id="cantidad"
							value="${detalledevolucionesEditar.cantidad}" class="form-control" />
					
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
					
					<th>Nombre Producto</th>
					<th>Codigo Producto</th>
					<th>Cantidad Producto</th>
					<th>Valor Unitario</th>
					<th>Valor Total</th>
										
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${detalledevoluciones}" var="detalledevoluciones">
				
					<tr style=" color: black"> 
						
						<td>${detalledevoluciones.productos.nombreProducto}</td>
						<td>${detalledevoluciones.productos.codigoProducto}</td>
						<td>${detalledevoluciones.cantidadProducto}</td>
						<td>${detalledevoluciones.precioProducto}</td>
						<td>${detalledevoluciones.totalDetalle}</td>
						
						<td><a class="btn btn-success" href="/BuscarDetalleDev/${CodigoVenta}/${detalledevoluciones.nombreProducto}">Editar</a></td>
						<td><a class="btn btn-danger" href="/eliminardetalledevoluciones/${CodigoVenta}/${detalledevoluciones.nombreProducto}">Eliminar</a></td>
						
						
					</tr>
				
			</c:forEach>
				
			
			</tbody>
		</table>
		
		<div>Total Venta Sin Iva: ${TotalsinIVa}</div>
		<div>Iva Total: ${TotalIVa}  </div>
		<div>Total con Iva: ${TotalVenta}</div>
	</div>
	
</body>
</html>