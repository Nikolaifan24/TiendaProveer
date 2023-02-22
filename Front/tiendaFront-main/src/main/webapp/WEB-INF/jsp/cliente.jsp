<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>
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
<!-- <body background="https://conceptoabc.com/wp-content/uploads/2021/12/Universo.jpg" style="background-repeat: no-repeat; background-size:cover; " > -->
<body>
<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/usuario">Usuarios</a></li>

				<li class="nav-item active"><a class="nav-link" href="/cliente">Clientes</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/producto">Productos</a></li>

				<li class="nav-item"><a class="nav-link" href="/producto">vendedor</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

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
	<h1> Clientes</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/cliente">		

				<div class="container overflow-hidden">
				<div class="form-group">
					<label>Seleccionar una Accion</label>
						 <select name="ID" id ="ID"
								class="form-select">
								<option name="ID" value="1">Editar Cliente</option>
								<option name="ID" value="0">Crear Cliente</option>
										
						</select>

					<label for="numero"> numero:</label>
					<input type="text"
						name="documentoCliente" id="documentoCliente"
						value="${clienteEditar.documentoCliente}" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label>Direccion Cliente:</label> <input type="text" name="direccionCliente" 
					class="form-control"
						value="${clienteEditar.direccionCliente}" />

					<label>Barrio Cliente:</label> <input type="text" name="barrioCliente" 
					class="form-control"
						value="${clienteEditar.barrioCliente}" />
						<label>Seleccionar una zona</label>
							<select name="zonaCliente" id ="zonaCliente"
								class="form-select">
								<option name="zonaCliente" value="Norte">Norte</option>
								<option name="zonaCliente" value="Sur">Sur</option>
								<option name="zonaCliente" value="Oriente">Oriente</option>
								<option name="zonaCliente" value="Occidente">Occidente</option>		
						</select>	
				</div>
				
				<div class="form-group">
					<label>Nombre Cliente:</label><input type="text" name="nombreCliente"
						class="form-control" value="${clienteEditar.nombreCliente}" />

					<label>Apellido Cliente:</label><input type="text" name="apellidoCliente"
					class="form-control" value="${clienteEditar.apellidoCliente}" />
				</div>
				
				<div class="form-group">
					<label>Email:</label><input type="text" name="correoCliente"
						class="form-control" value="${clienteEditar.correoCliente}" />
				</div>			
				
				
				<div class="form-group">
					<label>Telefono Cliente:</label> <input type="text" name="telefonoCliente"
						class="form-control" value="${clienteEditar.telefonoCliente}" />
					<label>Telefono adicional:</label> <input type="text" name="telefonoadicional"
					class="form-control" value="${clienteEditar.telefonoadicional}" />
				</div>
				
				</div>
				<br>
				<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-primary" formmethod="post" >Grabar</button>
				<button type="button" class="btn btn-secondary" onclick= relocate_buscar() >Consultar</button>
				
		 		</div>
				
				
			</form>
					
		</div>
		<br> 
		<br>	
		<div style="color: red">${mensaje}</div>			
		
    <table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Documento Cliente</th>
					<th>Nombre Cliente</th>
					<th>Apellido Cliente</th>
					<th>Direccion Cliente</th>
					<th>Barrio Cliente</th>
					<th>Zona Cliente</th>
					<th>Telefono Cliente</th>
					<th>Telefono adicional</th>
					<th>Correo Cliente</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cliente">
					<tr style=" color: #332c62"> 
						<td>${cliente.ID}</td>
						<td>${cliente.documentoCliente}</td>
						<td>${cliente.nombreCliente}</td>
						<td>${cliente.apellidoCliente}</td>
						<td>${cliente.direccionCliente}</td>
						<td>${cliente.barrioCliente}</td>
						<td>${cliente.zonaCliente}</td>
						<td>${cliente.telefonoCliente}</td>
						<td>${cliente.telefonoadicional}</td>
						<td>${cliente.correoCliente}</td>
						<td><a class="btn btn-success" href="/cliente/${cliente.documentoCliente}">Actualizar Cliente</a></td>
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
			var inputVal = document.getElementById("documentoCliente").value;
			location.href = "/BuscarClientesDocumento/" + inputVal; 
			console.log("El valor es");
		} 
</script>
