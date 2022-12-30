package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;


// import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Ventas;

public interface IVentaService {

	void crearVentas(VentasDto VentasDto);

	VentasDto buscarVentaPorFechaVenta(Date FechaVenta);

	void eliminarVenta(Date FechaVenta);

	void actualizarVenta(Date FechaVenta, VentasDto VentasDto);

    List<Ventas> listarVentas();
	
	List<Ventas> encontrarVentasPorNombre(Date FechaVenta);



}
