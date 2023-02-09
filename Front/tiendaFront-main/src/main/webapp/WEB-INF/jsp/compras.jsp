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

				<li class="nav-item"><a class="nav-link" href="/compraEditars">compraEditars</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

                <li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Compras</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/compras">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label>Seleccionar una Accion</label>
						 <select name="IDCompras" id ="ID"
								class="form-select">
								<option name="IDCompras" value=" ">Seleccionar</option>
								<option name="IDCompras" value="1">Editar Usuario</option>
								<option name="IDCompras" value="0">Crear Usuario</option>
		
								
							</select>
					</div>
					
					
				
					<div class="form-group">
						<label for="nitProveedor"> Nit proveedor</label>
						<input type="text"
							name="nitProveedor" id="nitProveedor"
							value="${compraEditar.nitProveedor}" class="form-control" />
						<label for="codigoCompra"> Codigo de la Compra:</label>
						<input type="text"
							name="codigoCompra" id="codigoCompra"
							value="${compraEditar.codigoCompra}" class="form-control" />
					</div>
					

					<div class="form-group">
						<label for="fechaCompra"> Fecha de la Compra:</label>
						<input type="date"
							name="fechaCompra" id="fechaCompra"
							value="${compraEditar.fechaCompra}" class="form-control" />
						
					</div>
					
					<div class="btn-group" role="group" aria-label="Basic example">
					<button type="submit" class="btn btn-primary" formmethod="post" >Crear</button>
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
					
					<th>Codigo Compra</th>
					<th>Fecha Compra</th>
					<th>Nombre proveedor</th>
					<th>Tipo Producto</th>
					<th>Total Compra</th>
					<th>Iva Compra</th>
					


					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${compras}" var="compra">
				
					<tr style=" color: black"> 
						
						<td>${compra.codigoCompra}</td>
						<td>${compra.fechaCompra}</td>
						<td>${compra.proveedores.nombreProveedor}</td>
						<td>${compra.proveedores.tipoProducto}</td>
						<td>${compra.totalCompra}</td>
						<td>${compra.ivaCompra}</td>
						
						<td><a class="btn btn-success" href="/detallecompra/${compra.codigoCompra}">Ver</a></td>
						<td><a class="btn btn-danger" href="/BuscarComprasPorCodigo/${compra.codigoCompra}">Actualizar</a></td>
						
					</tr>
				
			</c:forEach>
				
			
			</tbody>
		</table>
				
	</div>
	
</body>
</html>
<script>
	function relocate_buscar()
		{
			var inputVal = document.getElementById("codigoCompra").value;
			location.href = "/BuscarComprasPorCodigo/" + inputVal; 
			console.log("El valor es");
		} 
</script>