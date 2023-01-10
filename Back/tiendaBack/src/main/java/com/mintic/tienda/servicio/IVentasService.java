package com.mintic.tienda.servicio;

// import java.util.Date;
import java.util.List;

// import com.mintic.tienda.dto.CalculoDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Detalleventa;
import com.mintic.tienda.entities.Ventas;

public interface IVentasService {

	void crearVentas(VentasDto VentasDto) ;

    VentasDto buscarVentasPorCodigoventa(Long Codigoventa) ;

    void eliminarVentas(Long Codigoventa);

    void actualizarVentas(Long Codigoventa, VentasDto VentasDto) ;

    List<Ventas> listaVentas();
    
    List<Ventas> listaVentasProveedor(String nombreProveedor);

    List<Ventas> listarVentasPorProveedor(String nombreProveedor);

    List<Ventas> listaVentasPorProductos(String nombreProducto);

    List<Detalleventa> listaVentasPordetalles(Long Codigoventa);

    DetalleventaDto realizarCalculoventa(DetalleventaDto detalleventaDto);

}
