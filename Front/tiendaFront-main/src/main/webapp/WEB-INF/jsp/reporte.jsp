<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous">
</script>


<title>Reporte</title>
<link href="style.css" rel="stylesheet" type="text/css" />	
</head>
<body background="https://cdn.euroinnova.edu.es/img/subidasEditor/financial-4560047_640-1597884736.jpg" style="background-repeat: no-repeat; background-size:cover" >
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/menu">Tienda</a>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/usuario">Usuarios</a></li>
				<li class="nav-item"><a class="nav-link" href="/cliente"">Clientes</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/proveedores"">Proveedores</a></li>
				
				<li class="nav-item"><a class="nav-link" href="/productos"">Productos</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

				<li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>
			</ul>

		</div>
	</nav>
	<br>
	<h1 style="text-align: center; font-weight: bold;">Tipos de Reportes</h1>
	<div class="container col-2">
		
		<br>
		<br>
		<button type="button" class="btn btn-success btn-lg btn-block" onclick=" relocate_reporteCliente()">Reporte Cliente</button>
		<br>
		<br>
		<button type="button" class="btn btn-secondary btn-lg btn-block" onclick=" relocate_reporteUsuario()">Reporte Usuario</button>
		<br>
		<br>
		<button type="button" class="btn btn-primary btn-lg btn-block" onclick=" relocate_reporteVenta()">Reporte Venta</button>
	</div>
	

	
		

	

</body>
<script>
function relocate_reporteCliente()
{
     location.href = "/reporteCliente";
} 
function relocate_reporteUsuario()
{
     location.href = "/reporteUsuario";
}
function relocate_reporteVenta()
{
     location.href = "/reporteVenta";
}
</script>
</html>