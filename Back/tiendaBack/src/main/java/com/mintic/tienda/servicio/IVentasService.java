package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.CalculoDto;
import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.dto.ResultadoVentaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Ventas;

public interface IVentasService {

	List<Ventas> getVentas();

	VentasDto buscarVentaPorCodigo(Long codigoVenta);

	void crearVenta(VentasDto ventasDto);

	CalculoDto realizarCalculo(ProductosDto productosDto, Integer cantidad);


}
