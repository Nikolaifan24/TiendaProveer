<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Compra</title>
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

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Compras</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/detallecompra/${CodigoCompra}">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label>Seleccionar una Accion</label>
						 <select name="ID" id ="ID"
								class="form-select">
								<option name="ID" value=" ">Seleccionar</option>
								<option name="ID" value="1">Editar Detalle</option>
								<option name="ID" value="0">Crear un Detalle</option>
		
								
							</select>
					</div>
					
					
					<div class="form-group">
						<label>Codigo de la compra:</label><input type="text" name="codigoCompra" id ="codigoCompra"
							class="form-control" value="${CodigoCompra}" disabled="disabled" />
					</div>
				
					<div class="form-group">
						<label for="nombreProducto"> Nombre del Producto:</label>
						<input type="text"
							name="nombreProducto" id="nombreProducto"
							value="${detallecompraEditar.nombreProducto}" class="form-control" />
						<label for="codigoProducto"> Codigo del Producto</label>
						<input type="text"
							name="codigoProducto" id="codigoProducto"
							value="${detallecompraEditar.productos.codigoProducto}" class="form-control" />
					</div>
					<div class="form-group">
						<label for="cantidadProducto"> Cantidad del Producto:</label>
						<input type="text"
							name="cantidadProducto" id="cantidadProducto"
							value="${detallecompraEditar.cantidadProducto}" class="form-control" />
						<label for="valorUnitario"> Valor Unitario:</label>
						<input type="text"
							name="valorUnitario" id="valorUnitario"
							value="${detallecompraEditar.valorUnitario}" class="form-control" />
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example">
						<button type="submit" class="btn btn-primary" formmethod="post" >Crear</button>
						<button type="button" class="btn btn-secondary" onclick= relocate_buscar() >Consultar</button>
						<!-- <button type="submit" class="btn btn-danger" formmethod="post" >Carga Datos</button> -->
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
				<c:forEach items="${detallecompra}" var="detallecompra">
				
					<tr style=" color: black"> 
						
						<td>${detallecompra.nombreProducto}</td>
						<td>${detallecompra.productos.codigoProducto}</td>
						<td>${detallecompra.cantidadProducto}</td>
						<td>${detallecompra.valorUnitario}</td>
						<td>${detallecompra.valorTotal}</td>
						
						<td><a class="btn btn-success" href="/BuscarDetalle/${CodigoCompra}/${detallecompra.nombreProducto}">Editar</a></td>
						
						
					</tr>
				
			</c:forEach>
				
			
			</tbody>
		</table>
		
		<div>Total Venta Sin Iva:   </div>
		<div>Iva Total: ${valorTotal}   </div>
		<div>Total con Iva: </div>
	</div>
	
</body>
</html>

<script>
	console.log(document.getElementById("codigoCompra").value);
	function relocate_buscar()
		{
			var inputVal = document.getElementById("codigoCompra").value;
			var inputVal1 = document.getElementById("nombreProducto").value;
			location.href = "/detallecompra/" + inputVal + "/" + inputVal1; 
			console.log("El valor es");
		} 
</script>