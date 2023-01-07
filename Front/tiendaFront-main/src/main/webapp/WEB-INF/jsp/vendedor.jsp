<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>vendedor</title>
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
<link href="Style.css" rel="stylesheet" type="text/css" />	
	
</head>

<body background="https://img.lovepik.com/photo/40109/9825.jpg_wh860.jpg" style="background-repeat: no-repeat; background-size:cover; " >
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
	<h1> Vendedores</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/vendedor">
				<div class="form-group">
				 <select name="idTipoDocumento"
						class="form-select">
						<option value="0">Seleccionar</option>
						
					</select>
				</div>

				<div class="container overflow-hidden">
                <div class="form-group">
                    <label> Nombre vendedor:</label> <input type="text" name="nombrevendedor" class="form-control"
                        value="${vendedorEditar.nombrevendedor}" />
                </div>    
				<div class="form-group">
					<input type="hidden" name="id" value="${vendedorEditar.id}">

					<label for="numero"> Documento:</label><input type="text"
						name="documentoVendedor" id="numero"
						value="${vendedorEditar.documentoVendedor}" class="form-control" />
				</div>
				<div class="form-group">
					<label>Dirección:</label><input type="text" name="direccionVendedor"
						class="form-control" value="${vendedorEditar.documentoVendedor}" />
				</div>
				<div class="form-group">
					<label>Telefono:</label><input type="text" name="telefonoVendedor"
						class="form-control" value="${vendedorEditar.telefonoVendedor}" />
				</div>
				<div class="form-group">
					<label>password:</label> <input type="password" name="password"
						class="form-control" value="${vendedorEditar.password}" />
				</div>
				</div>
				<br>
				<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-primary" formmethod="post" >Crear</button>
				<a type="button" class="btn btn-secondary" href= "/vendedor" >Consultar</a>
		 		</div>
				
				
			</form>
					
		</div>
		<br> 		
		
    <table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Documento</th>
					<th>Nombre</th>
					<th>Dirección</th>
					<th>Teléfono</th>
					<th>Comisión</th>
					<th>Fecha Ingreso</th>
					<th>Salario</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vendedor}" var="vendedor">
					<tr style=" color: #FFF35F"> 
						<td>${vendedor.usuario.usuario}</td>
						<td>${vendedor.documentoVendedor}</td>
						<td>${vendedor.nombreVendedor}</td>
						<td>${vendedor.direccionVendedor}</td>
						<td>${vendedor.telefonoVendedor}</td>
						<td>${vendedor.comisionVendedor}</td>
						<td>${vendedor.fechaIngreso}</td>
						<td>${vendedor.salario}</td>
                       
						<td><a class="btn btn-success" href="/vendedor/${vendedor.documentoVendedor}">Actualizar</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>