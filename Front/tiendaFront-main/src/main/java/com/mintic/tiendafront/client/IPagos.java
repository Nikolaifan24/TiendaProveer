package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.PagosDto;
import com.mintic.tiendafront.dto.PagosResponse;

public interface IPagos {
    
    public List<PagosResponse> getPagos();

	public PagosResponse nuevoPagos(PagosDto PagosDto);
	
	public PagosResponse ActualizarPagos(PagosDto PagosDto, Long CodigoVenta, String FechaPago);

	public PagosResponse buscarPagos(Long CodigoVenta, String FechaPago);

	public int borrarPagos(Long CodigoVenta, String FechaPago);

	List<PagosResponse> PagosByCliente(Long documentoCliente) ;

	List<PagosResponse> PagosByFechaVenta(String FechaVenta) ;
	
}
