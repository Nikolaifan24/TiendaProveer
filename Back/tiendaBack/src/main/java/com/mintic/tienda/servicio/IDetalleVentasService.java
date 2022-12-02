package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DetalleVentasDto;
import com.mintic.tienda.entities.DetalleVentas;

public interface IDetalleVentasService {

	List<DetalleVentas> getDetalleVentas();

	DetalleVentasDto buscarDetalleVentasPorIdVenta(Long idVenta);

	void crearDetalleVentas(DetalleVentasDto detalleVentasDto);

}
