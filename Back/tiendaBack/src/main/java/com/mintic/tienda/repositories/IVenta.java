package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Ventas;

public interface IVenta extends CrudRepository<Ventas, Long>{

    @Query(value = "SELECT * FROM Ventas c where c.FechaVenta=:FechaVenta", nativeQuery = true)
	Ventas buscarVentaPorfecha(@Param("FechaVenta") String FechaVenta);    

    @Query(value = "SELECT * FROM Ventas c where c.FechaEntrega=:FechaEntrega", nativeQuery = true)
	List<Ventas> buscarVentaPorfechaEntrega(@Param("FechaEntrega") String FechaEntrega);  

    @Query(value = "SELECT * FROM Ventas c where c.FormaPago=:FormaPago", nativeQuery = true)
	List<Ventas> buscarVentaPorFormaPago(@Param("FormaPago") String FormaPago); 
    
    @Query(value = "SELECT * FROM Ventas c where c.zonaventa=:zonaventa", nativeQuery = true)
	List<Ventas> buscarVentaPorZona(@Param("zonaventa") String zonaventa); 

    @Query(value = "SELECT * FROM Ventas p INNER JOIN Clientes c ON c.IDCliente = p.IDCliente WHERE c.nombreCliente= :nombreCliente", nativeQuery = true)
	List<Ventas> buscarVentaPorNombreCliente(@Param("nombreCliente") String nombreCliente);

    @Query(value = "SELECT * FROM Ventas v INNER JOIN detalle_venta d ON v.IDVenta = d.IDVenta INNER JOIN Productos p ON p.IDProductos = d.IDProducto WHERE p.nombreProducto= :nombreProducto", nativeQuery = true)
	List<Ventas> buscarVentaPorNombreProdcuto(@Param("nombreProducto") String nombreProducto);

    @Query(value = "SELECT * FROM Ventas p INNER JOIN Vendedor c ON c.IDVendedor = p.IDVendedor WHERE c.nombreVendedor= :nombreVendedor", nativeQuery = true)
	List<Ventas> buscarVentaPorNombreVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * FROM Ventas p where p.CodigoVenta=:CodigoVenta", nativeQuery = true)
	Ventas buscarVentasPorCodigo(@Param("CodigoVenta") Long CodigoVenta);
   
}