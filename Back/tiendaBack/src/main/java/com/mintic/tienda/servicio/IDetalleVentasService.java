package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.entities.Detalleventa;

public interface IDetalleVentasService {

	List<Detalleventa> getDetalleVentas();

	DetalleventaDto buscarDetalleVentasPorIdVenta(Long idVenta);

	void crearDetalleVentas(DetalleventaDto detalleVentasDto);

}
