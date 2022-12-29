package com.mintic.tienda.servicio;

import java.util.Date;
import java.util.List;

import com.mintic.tienda.dto.CarteraDto;
import com.mintic.tienda.entities.Cartera;

public interface ICarteraService {

    CarteraDto buscarCarteraPorFechaPago(Date FechaPago); 

    void crearCartera(CarteraDto CarteraDto);
    
    void eliminarCartera(Date FechaPago);
    
    void actualizarCartera(Date FechaPago, CarteraDto CarteraDto); 

    List<Cartera> listaCartera();

    List<Cartera> listaCarteraCliente(Long IDCliente);

    List<Cartera> listarCarteraPorFechaPagoyVenta(Date FechaVenta, Date FechaPago);

    List<Cartera> listarCarteraFechaVenta(Date FechaVenta);
    
}
