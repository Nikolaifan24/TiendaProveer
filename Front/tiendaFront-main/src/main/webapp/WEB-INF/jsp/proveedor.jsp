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
<body background="https://thumbs.dreamstime.com/b/fondo-oscuro-vac%C3%ADo-iluminado-por-puntos-suelo-de-hormig%C3%B3n-blanco-azul-rojo-y-brillante-172023908.jpg" style="background-repeat: no-repeat; background-size:cover; " >
<body>
<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/usuario">Usuarios</a></li>

				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a></li>
				
				<li class="nav-item active"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/producto">Productos</a></li>

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
	<h1> Proveedores</h1>
	
	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/proveedor">
				
				<div class="container overflow-hidden">
				<div class="form-group">
					<label>Seleccionar una Accion</label>
						 <select name="IDProveedor" id ="IDProveedor"
								class="form-select">
								<option name="IDProveedor" value="1">Editar Proveedor</option>
								<option name="IDProveedor" value="0">Crear Proveedor</option>
										
						</select>

					<label for="nitProveedor"> Nit:</label><input type="text"
						name="nitProveedor" id="nitProveedor"
						value="${proveedorEditar.nitProveedor}" class="form-control" />
				</div>
				<div class="form-group">
					<label>nombre:</label><input type="text" name="nombreProveedor"
						class="form-control" value="${proveedorEditar.nombreProveedor}" />
				</div>
				<div class="form-group">
					<label>Seleccionar una Accion</label>
						 <select name="TipoProducto" id ="TipoProducto"
								class="form-select">
								<option name="Escobas" value="Escobas">Escobas</option>
								<option name="Traperos" value="Traperos">Traperos</option>
								<option name="Liquidos" value="Liquidos">Liquidos</option>

										
						</select>
					<label>Ciudad:</label><input type="text" name="ciudadProveedor"
						class="form-control" value="${proveedorEditar.ciudadProveedor}" />
				</div>
				<div class="form-group">
					<label> Direccion:</label> <input type="text"
						name="direccionProveedor" class="form-control"
						value="${proveedorEditar.direccionProveedor}" />
				</div>
				<div class="form-group">
					<label>Telefono:</label> <input type="text" name="telefonoProveedor"
						class="form-control" value="${proveedorEditar.telefonoProveedor}" />
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
						<td>${proveedor.nitProveedor}</td>
						<td>${proveedor.nombreProveedor}</td>
						<td>${proveedor.ciudadProveedor}</td>
						<td>${proveedor.direccionProveedor}</td>
						<td>${proveedor.telefonoProveedor}</td>
						<td><a class="btn btn-danger" href="/eliminarproveedor/${proveedor.nitProveedor}">Eliminar proveedor</a></td>
						<td><a class="btn btn-success" href="/proveedorPorNit/${proveedor.nitProveedor}" >Actualizar proveedor</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>

</html>