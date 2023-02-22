package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.FaltantesDto;
import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;

public interface IFaltantesServices {

    void crearFaltantes(FaltantesDto FaltantesDto); 
    
    List<Faltantes> listaFaltantes() ;

    FaltantesDto buscarFaltantesPorCodigoventa(Long Codigoventa) ;

    void eliminarFaltantes(Long Codigoventa) ;

    void actualizarFaltantes(Long Codigoventa, FaltantesDto FaltantesDto) ;

    List<Faltantes> listaFaltantesporVendedor(String nombreVendedor) ;

    List<Productos> listaFaltantesPorProductos(String nombreProducto) ;

    Double cargarCalculosdeunFaltante(Long CodigoVenta); 

    Integer ContarFaltantes(Long CodigoVenta);
}
