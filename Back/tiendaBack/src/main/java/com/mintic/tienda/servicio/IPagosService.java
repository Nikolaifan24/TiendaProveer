package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;

public interface IPagosService {

    PagosDto buscarPagosPorFechaPago(Date fehcaPago);

    void crearPagos(PagosDto pagosDto);

    void eliminarPagos(Date fehcaPago);

    void actualizarPagos(Date fehcaPago, PagosDto pagosDto);

    List<Pagos> listaPagos();

    List<Pagos> listaPagosCliente(Long iDCliente);

    List<Pagos> listarPagosMedioPago(String MedioPago);

    List<Pagos> listarPagosPorFechaPagoyVenta(Date fechaVenta, Date fechaPago);

    List<Pagos> listarPagosPorFechaPagoyTipo(Date FechaVenta, String TipoPago); 
    
}
