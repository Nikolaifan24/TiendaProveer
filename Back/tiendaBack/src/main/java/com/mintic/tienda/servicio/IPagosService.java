package com.mintic.tienda.servicio;

// import java.util.String;
import java.util.List;

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;

public interface IPagosService {

    PagosDto buscarPagosPorFechaPago(String fehcaPago);

    void crearPagos(PagosDto pagosDto);

    void eliminarPagos(String fehcaPago);

    void actualizarPagos(String fehcaPago, PagosDto pagosDto);

    List<Pagos> listaPagos();

    List<Pagos> listaPagosCliente(Long iDCliente);

    List<Pagos> listarPagosMedioPago(String MedioPago);

    List<Pagos> listarPagosPorFechaPagoyVenta(String fechaVenta, String fechaPago);

    List<Pagos> listarPagosPorFechaPagoyTipo(String FechaVenta, String TipoPago); 
    
}
