<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReporteUsuario</title>
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

<body background="https://10guards.com/wp-content/uploads/online-shopping_1-1024x626.png" style="background-repeat: no-repeat; background-size:cover; " >
<body>
<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios

				</a></li>
				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1 style="text-align: center; font-weight: bold;">Reporte Usuarios</h1>
	<br> 
	<br>	
	<div style="color: red">${mensaje}</div>	
	
	<div class="container col-2">
		<br>
		<button type="button" class="btn btn-success btn-lg btn-block" onclick=" relocate_reporte()">Reportes</button>
		<br>
		<br>
	</div>		
		
    <table class="table" style="font-weight:bold; color:white ">
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
					<tr> 
						<td>${usuario.id}</td>
						<td>${usuario.cedulaUsuario}</td>
						<td>${usuario.emailUsuario}</td>
						<td>${usuario.usuario}</td>
						<td>${usuario.nombreUsuario}</td>
						
						</tr>
				</c:forEach>
			</tbody>
		</table>
	

<script>
function relocate_reporte()
{
     location.href = "/reporte";
} 
</script>
</body>
</html>