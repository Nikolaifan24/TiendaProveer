package com.mintic.tiendafront.client;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mintic.tiendafront.dto.ClienteDto;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.ProductoDto;
import com.mintic.tiendafront.dto.VentaDto;
import com.mintic.tiendafront.dto.VentaResponse;
import com.mintic.tiendafront.dto.DetalleVentaDto;
import com.mintic.tiendafront.dto.DetalleVentaResponse;

public interface IVenta {
	
	List<VentaResponse> ListarVentas(); 

	public void guardarVenta(VentaDto totalVenta, Long idUsuario, ClienteResponse cliente);


	List<DetalleVentaResponse> ListarDetalleVentas(Long CodigoVenta) ;
}
