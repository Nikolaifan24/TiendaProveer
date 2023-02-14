<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagos</title>
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

				<li class="nav-item"><a class="nav-link" href="/producto">Productos</a></li>

				<li class="nav-item"><a class="nav-link" href="/venta">Ventas</a></li>

                <li class="nav-item"><a class="nav-link" href="/faltantes">Faltantes</a></li>

                <li class="nav-item"><a class="nav-link" href="/devoluciones">Devoluciones</a></li>

				<li class="nav-item active"><a class="nav-link" href="/Pagos">Pagos</a></li>

            	<li class="nav-item"><a class="nav-link" href="/Cartera">Cartera</a></li>

                <li class="nav-item"><a class="nav-link" href="/vendedor">Vendedores</a></li>

                <li class="nav-item"><a class="nav-link" href="/reporte">Reportes</a></li>

			</ul>

		</div>
	</nav>
	<br>
	<h1> Pagos</h1>

	<div class="container overflow-hidden">

		<div class=" col-xl-2 col-lg-3 col-md-4 col-sm-6" id="formulario">
			<form method="post" action="/pagos">
					
				<div class="container overflow-hidden">
					<div class="form-group">
						<label>Seleccionar una Accion</label>
						 <select name="TipoPago" id ="ID"
								class="form-select">
								<option name="TipoPago" value="1">Editar Pagos</option>
								<option name="TipoPago" value="0">Crear Pagos</option>
		
								
							</select>
					</div>
					
					
				
					<div class="form-group">
						<label for="codigoVenta"> Codigo de la Venta</label>
						<input type="text"
							name="codigoVenta" id="codigoVenta"
							value="${pagoEditar.codigoVenta}" class="form-control" />
					
					</div>
					

					<div class="form-group">
						<label for="FechaVenta"> Fecha de la Venta:</label>
						<input type="date"
							name="FechaVenta" id="FechaVenta"
							value="${pagoEditar.FechaVenta}" class="form-control" />
                        <label for="FechaPago"> Fecha de la Pago:</label>
                        <input type="date"
                            name="FechaPago" id="FechaPago"
                            value="${pagoEditar.FechaPago}" class="form-control" />
					</div>
					<div class="form-group">
						<label>Seleccionar tipo de Pago</label>
						 <select name="TipoPago" id ="ID"
								class="form-select">
								<option name="TipoPago" value="Parcial">Parcial</option>
								<option name="TipoPago" value="Total">Total</option>
		
								
							</select>
                        <label>Seleccionar Medio de Pago</label>
                        <select name="MedioPago" id ="MedioPago"
                                class="form-select">
                                <option name="MedioPago" value="1">EFectivo</option>
                                <option name="MedioPago" value="0">Consignacion</option>
                                <option name="Nequi" value="0">Nequi</option>
                                
                            </select>
					</div>

                    <div class="form-group">
						<label for="ValorPago"> Valor del Pago</label>
						<input type="text"
							name="ValorPago" id="ValorPago"
							value="${pagoEditar.ValorPago}" class="form-control" />
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
					<th>Documento Cliente</th>
					<th>Fecha  Venta</th>
					<th>Fecha Pago</th>
					<th>Tipo Pago</th>
					<th>Medio Pago</th>
					<th>Valor Pago</th>
					
			
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Pagos}" var="pagos">
				
					<tr style=" color: black"> 
						
						<td>${pagos.codigopagos}</td>
						<td>${pagos.FechaVenta}</td>
						<td>${pagos.proveedores.nombreProveedor}</td>
						<td>${pagos.proveedores.tipoProducto}</td>
						<td>${pagos.totalpagos}</td>
						<td>${pagos.totalpagos*0.16}</td>
						
						<td><a class="btn btn-success" href="/BuscarPagos/${pagos.codigoVenta}-${pagos.FechaPago}">Actualizar</a></td>
						
						
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
			var inputVal = document.getElementById("codigoVenta").value;
            var inputVal1 =document.getElementById("FechaPago").value;
			location.href = "/BuscarPagos/" + inputVal + "/" + inputVal1; 
			console.log("El valor es");
		} 
</script>