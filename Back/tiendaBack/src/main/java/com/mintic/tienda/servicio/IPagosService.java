package com.mintic.tienda.servicio;

// import java.util.String;
import java.util.List;

import com.mintic.tienda.dto.PagosDto;
import com.mintic.tienda.entities.Pagos;

public interface IPagosService {

    PagosDto buscarPagosPorFechaPago(Long CodigoVenta, String FechaPago); 

    void crearPagos(PagosDto pagosDto);

    void eliminarPagos(Long CodigoVenta, String FechaPago); 

    void actualizarPagos(Long CodigoVenta, String FechaPago, PagosDto PagosDto) ;

    List<Pagos> listaPagos();

    List<Pagos> listaPagosCliente(String nombreCliente, String apellidoCliente);

    List<Pagos> listarPagosMedioPago(String MedioPago);

    List<Pagos> listaPagosFechaVenta(String Fechaventa);

    List<Pagos> listarPagosPorFechaPagoyVenta(String fechaVenta, String fechaPago);

    List<Pagos> listarPagosPorFechaPagoyTipo(String FechaVenta, String TipoPago); 
    
}
