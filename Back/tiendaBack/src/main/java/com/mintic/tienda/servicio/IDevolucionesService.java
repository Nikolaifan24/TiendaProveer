package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.DevolucionesDto;
import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;

public interface IDevolucionesService {
    
    void crearDevoluciones(DevolucionesDto DevolucionesDto); 

    List<Devoluciones> listaDevoluciones(); 

    Double cargarCalculosdeunaDevolucion(Long CodigoVenta);

    DevolucionesDto buscarDevolucionesPorCodigoventa(Long Codigoventa) ;

    void eliminarDevoluciones(Long Codigoventa) ;

    void actualizarDevoluciones(Long Codigoventa, DevolucionesDto DevolucionesDto);

    List<Devoluciones> listaDevolucionesporVendedor(String nombreVendedor) ;

    List<Productos> listaDevolucionesPorProductos(String nombreProducto);

    Integer ContarDevoluciones(Long CodigoVenta);
}
