package com.mintic.tienda.servicio;

// import java.util.String;
import java.util.List;

import com.mintic.tienda.dto.CarteraDto;
import com.mintic.tienda.entities.Cartera;

public interface ICarteraService {

    CarteraDto buscarCarteraPorFechaPago(String FechaPago); 

    void crearCartera(CarteraDto CarteraDto);
    
    void eliminarCartera(String FechaPago);
    
    void actualizarCartera(String FechaPago, CarteraDto CarteraDto); 

    List<Cartera> listaCartera();

    List<Cartera> listaCarteraCliente(Long IDCliente);

    List<Cartera> listarCarteraPorFechaPagoyVenta(String FechaVenta, String FechaPago);

    List<Cartera> listarCarteraFechaVenta(String FechaVenta);
    
}
