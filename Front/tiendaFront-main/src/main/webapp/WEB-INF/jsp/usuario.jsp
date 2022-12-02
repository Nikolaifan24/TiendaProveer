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
<link href="Style.css" rel="stylesheet" type="text/css" />	
	
</head>

<body background="https://img.lovepik.com/photo/40109/9825.jpg_wh860.jpg" opacity=0.8>
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

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Usuarios</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/usuario">
				<div class="form-group">
				 <select name="idTipoDocumento"
						class="form-select">
						<option value="0">Seleccionar</option>
						
					</select>
				</div>

				<div class="container overflow-hidden">
				<div class="form-group">
					<input type="hidden" name="id" value="${usuarioEditar.id}">

					<label for="numero"> numero:</label><input type="text"
						name="cedulaUsuario" id="numero"
						value="${usuarioEditar.cedulaUsuario}" class="form-control" />
				</div>
				<div class="form-group">
					<label>nombre:</label><input type="text" name="usuario"
						class="form-control" value="${usuarioEditar.usuario}" />
				</div>
				<div class="form-group">
					<label>Email:</label><input type="text" name="emailUsuario"
						class="form-control" value="${usuarioEditar.emailUsuario}" />
				</div>
				<div class="form-group">
					<label> nombre usuario:</label> <input type="text"
						name="nombreUsuario" class="form-control"
						value="${usuarioEditar.nombreUsuario}" />
				</div>
				<div class="form-group">
					<label>password:</label> <input type="password" name="password"
						class="form-control" value="${usuarioEditar.password}" />
				</div>
				</div>
				<br>
				<div class="btn-group" role="group" aria-label="Basic example">
				<button type="submit" class="btn btn-primary" formmethod="post" >Crear</button>
				<a type="button" class="btn btn-secondary" href= "/usuario" >Consultar</a>
		 		</div>
				
				
			</form>
					
		</div>
		<br> 		
		
    <table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Numero</th>
					<th>Email</th>
					<th>Usuario</th>
					<th>Nombre usuario</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr style=" color: #FFF35F"> 
						<td>${usuario.id}</td>
						<td>${usuario.cedulaUsuario}</td>
						<td>${usuario.emailUsuario}</td>
						<td>${usuario.usuario}</td>
						<td>${usuario.nombreUsuario}</td>
						<td><a class="btn btn-danger"
							href="/eliminarusuario/${usuario.cedulaUsuario}">Eliminar</a></td>
						<td><a class="btn btn-success" href="/usuario/${usuario.cedulaUsuario}">Actualizar</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>