package com.mintic.tienda.servicio;
import java.util.List;

import com.mintic.tienda.dto.DetallefaltantesDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.entities.Detallefaltantes;

public interface IDetalleFaltantesService {

    List<Detallefaltantes> ListarDetallefaltantes() ; 

    DetallefaltantesDto buscarDetallefaltantesCodigoyNombre(Long codigoventa, String nombreProducto)  ;

    void crearDetallefaltantess(Long CodigoVenta, DetallefaltantesDto DetallefaltantessDto);
    
    void actualizarDetallefaltantes(Long codigoventa, String nombreProducto, DetallefaltantesDto detalleDto) ;

    List<Detallefaltantes> ListarDetallefaltantessPorCodigo(Long Codigoventa) ;

    void eliminarDetallefaltantes(Long codigoVenta, String nombreProdcuto); 

    int contadorDetallefaltantes(Long CodigoVenta, String nombreProducto); 
}
