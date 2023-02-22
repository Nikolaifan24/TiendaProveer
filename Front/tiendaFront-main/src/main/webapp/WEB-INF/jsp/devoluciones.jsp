<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>devoluciones</title>
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

				<li class="nav-item"><a class="nav-link" href="/producto">Prodcutos</a></li>

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
	<h1> devoluciones</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/devoluciones">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label>Seleccionar una Accion</label>
						 <select name="IDdevoluciones" id ="ID"
								class="form-select">
								<option name="IDdevoluciones" value=" ">Seleccionar</option>
								<option name="IDdevoluciones" value="1">Editar Usuario</option>
								<option name="IDdevoluciones" value="0">Crear Usuario</option>
		
								
							</select>
					</div>
					
					
				
					<div class="form-group">
						<label for="codigoventa">Codigo de la Venta</label>
						<input type="text"
							name="codigoventa" id="codigoventa"
							value="${devolucionesEditar.codigoventa}" class="form-control" />
                        <label>Seleccionar un Vendedor</label>
                        <select name="nombreVendedor" id ="nombreVendedor"class="form-select">
                            <c:forEach items="${vendedor}" var="vendedor">
                                <option name="nombreVendedor" value="${vendedor.nombreVendedor}">${vendedor.nombreVendedor}</option>
                            </c:forEach>
                                
                        </select>
					</div>
					

					<div class="form-group">
						<label for="fechaVenta"> Fecha de la Venta:</label>
						<input type="date"
							name="fechaVenta" id="fechaVenta"
							value="${devolucionesEditar.fechaVenta}" class="form-control" />
						
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
					
					<th>Codigo Venta</th>
					<th>Fecha Venta</th>
					<th>Nombre Vendedor</th>
					<th>Total Devoluciones</th>
					


					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${devoluciones}" var="devoluciones">
				
					<tr style=" color: black"> 
						
						<td>${devoluciones.codigoventa}</td>
						<td>${devoluciones.fechaVenta}</td>
						<td>${devoluciones.vendedor.nombreVendedor}</td>
						<td>${devoluciones.TotalDevoluciones}</td>
										
						<td><a class="btn btn-success" href="/detalledevoluciones/${devoluciones.codigoventa}">Ver</a></td>
						<td><a class="btn btn-danger" href="/BuscardevolucionesPorVenta/${devoluciones.codigoventa}">Actualizar</a></td>
						
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
			var inputVal = document.getElementById("codigoventa").value;
			location.href = "/BuscardevolucionesPorVenta/" + inputVal; 
			console.log("El valor es");
		} 
</script>