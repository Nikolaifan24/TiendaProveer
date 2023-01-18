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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script> 
<!-- <script src="
https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>  -->
<body background="https://img.lovepik.com/photo/40109/9825.jpg_wh860.jpg" style="background-repeat: no-repeat; background-size:cover; " >
<body>
	<nav class="navbar navbar-expand-lg navbar--dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda<img src="C:\Users\nikol\Documents\GitHub\TiendaProveer\proveer.jpg" alt="" width="20" height="15"></a>

		<div class="collapse navbar-collapse" id="navbarText">
			
			<ul class="navbar-nav mr-auto">

				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios</a></li>

				<li class="nav-item"><a class="nav-link" href="/cliente">Clientes</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/proveedor">Proveedores</a></li>

				<li class="nav-item"><a class="nav-link" href="/producto">Productos</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

                <li class="nav-item"><a class="nav-link" href="/compras">Compras</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>

				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					  Dropdown link
					</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					  <li><a class="dropdown-item" href="#">Action</a></li>
					  <li><a class="dropdown-item" href="#">Another action</a></li>
					  <li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul>
				</li>
			</ul>

		</div>
	</nav>
	<br>
	<h1> Usuarios</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-3 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/usuario">
				<div class="form-group">
					<label>Seleccionar una Accion</label>
					 <select name="ID" id ="ID"
							class="form-select">
							<option name="ID" value=" ">Seleccionar</option>
							<option name="ID" value="1">Editar Usuario</option>
							<option name="ID" value="0">Crear Usuario</option>
	
							
						</select>
				</div>

				<div class="form-group">
				<label>Seleccionar Tipo Perfil</label>
				 <select name="perfil" id="Perfil"
						class="form-select">
						<option name="perfil" value=" ">Seleccionar</option>
						<option name="perfil" value="Usuario">Usuario</option>
						<option name="perfil" value="Administrador">Administrador</option>

						
					</select>
				</div>

				<div class="container overflow-hidden">
				<div class="form-group">
					<label>Nombre del Usuario</label><input type="text" name="usuario" id="Usuario"
						class="form-control" placeholder="Nombre de Usuario" value="${usuarioEditar.usuario}" />
				</div>
				<div class="form-group">
					<label>Email:</label><input type="text" name="correo" id="Correo"
						class="form-control" placeholder="Correo Electronico" value="${usuarioEditar.correo}" />
				</div>
				<div class="form-group">
					<label> Usuario:</label> <input type="text"
						name="nombreUsuario" id="Nombre" class="form-control" placeholder="Usuario" value="${usuarioEditar.nombreUsuario}" />
				</div>
				<div class="form-group">
					<label>Contraseña:</label> <input type="password" name="password" id="Contraseña"
						class="form-control" placeholder="Contraseña" value="${usuarioEditar.password}" />
				</div>
				</div>
				<br>
				<div class="btn-group" role="group" aria-label="Basic example">
				<button type="button" class="btn btn-primary" onclick= alerta() >Grabar</button>
				<button type="button" class="btn btn-secondary" onclick= relocate_buscar() >Buscar</button>
				<button type="button" class="btn btn-success" onclick= alerta2() >Actualizar</button>

				
				</div>
				
				
			</form>
					
		</div>
		<br> 		
		<div style="color: red">${mensaje}</div>			
		
    <table class="table">
			<thead>
				<tr>
					<!-- <th>#</th> -->
					<th>Perfil de Usuarios</th>
					<th>Email</th>
					<th>Usuario</th>
					<th>Nombre usuario</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr style=" color: #FFF35F"> 
						<!-- <td>${usuario.id}</td> -->
						<td>${usuario.perfil}</td>
						<td>${usuario.correo}</td>
						<td>${usuario.usuario}</td>
						<td>${usuario.nombreUsuario}</td>
						<td><a class="btn btn-danger"
							href="/eliminarusuario/${usuario.nombreUsuario}">Eliminar</a></td>
						<td><a class="btn btn-success" href="/usuario/${usuario.nombreUsuario}">Actualizar</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>

		function success1(){
			setTimeout(() => {
			console.log("Delayed for 1 second.");
			}, "5000") 
			location.href = "/usuario";
		}
		function relocate_buscar()
		{
			var inputVal = document.getElementById("Nombre").value;
			location.href = "/BuscarUsuario/" + inputVal; 
			console.log("El valor es");
		} 
		function alerta()
    	{
		// var mensaje;
				
			var opcion = confirm("Clicka en Aceptar o Cancelar");
			if (opcion == true) {
				mensaje = "Has clickado OK";
				const Url = 'http://localhost:8092/usuario'
				let payload = {
				ID: document.getElementById("ID").value,
				usuario: document.getElementById("Nombre").value,
				// console.log(nombreval);
				nombreUsuario: document.getElementById("Usuario").value,
				correo: document.getElementById("Correo").value,
				password: document.getElementById("Contraseña").value,
				perfil: document.getElementById("Perfil").value
			};
			console.log(payload);
			$.ajax({
				type: "POST",
				url: "http://localhost:8092/usuario",
				data: {
					ID: document.getElementById("ID").value,
					usuario: document.getElementById("Usuario").value,
					// console.log(nombreval);
					nombreUsuario: document.getElementById("Nombre").value,
					correo: document.getElementById("Correo").value,
					password: document.getElementById("Contraseña").value,
					perfil: document.getElementById("Perfil").value
				},
				success: success1(),
				dataType: "json"
				});
			// $('.btn btn-primary').click(function(){
			// 	$.post(Url,payload, function(payload, status){console.log(`${data} and status is ${status}`)})
			// })
			
			} else {
				mensaje = "Has clickado Cancelar";
				location.href = "/usuario "
			}
		// document.getElementById("ejemplo").innerHTML = mensaje;
		}
		function alerta2(){

			var opcion = confirm("Clicka en Aceptar o Cancelar");
			if (opcion == true) {
				mensaje = "Has clickado OK";
				const Url = 'http://localhost:8092/usuario'
				let payload = {
				ID: document.getElementById("ID").value,
				usuario: document.getElementById("Nombre").value,
				// console.log(nombreval);
				nombreUsuario: document.getElementById("Usuario").value,
				correo: document.getElementById("Correo").value,
				password: document.getElementById("Contraseña").value,
				perfil: document.getElementById("Perfil").value
			};
			console.log(payload);
			$.ajax({
				type: "PATCH",
				url: "http://localhost:8092/usuario",
				data: {
					ID: document.getElementById("ID").value,
					usuario: document.getElementById("Usuario").value,
					// console.log(nombreval);
					nombreUsuario: document.getElementById("Nombre").value,
					correo: document.getElementById("Correo").value,
					password: document.getElementById("Contraseña").value,
					perfil: document.getElementById("Perfil").value
				},
				success: success1(),
				dataType: "json"
				});
			// $('.btn btn-primary').click(function(){
			// 	$.post(Url,payload, function(payload, status){console.log(`${data} and status is ${status}`)})
			// })
			
			} else {
				mensaje = "Has clickado Cancelar";
				location.href = "/usuario "
			}
		}
	</script>
</body>
</html>