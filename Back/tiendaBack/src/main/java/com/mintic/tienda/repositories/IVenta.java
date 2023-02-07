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

    @Query(value = "SELECT * FROM Ventas c where c.zonaventa=:zonaventa", nativeQuery = true)
	List<Ventas> buscarVentaPorZona(@Param("zonaventa") String zonaventa); 

    @Query(value = "SELECT * FROM Ventas p INNER JOIN Clientes c ON c.IDCliente = p.IDCliente WHERE c.documentoCliente= :documentoCliente", nativeQuery = true)
	List<Ventas> buscarVentaPorDocumentoCliente(@Param("documentoCliente") String documentoCliente);

    @Query(value = "SELECT * FROM Ventas v INNER JOIN detalle_venta d ON v.IDVenta = d.IDVenta INNER JOIN Productos p ON p.IDProductos = d.IDProducto WHERE p.nombreProducto= :nombreProducto", nativeQuery = true)
	List<Ventas> buscarVentaPorNombreProdcuto(@Param("nombreProducto") String nombreProducto);

    @Query(value = "SELECT * FROM Ventas p INNER JOIN Vendedor c ON c.IDVendedor = p.IDVendedor WHERE c.nombreVendedor= :nombreVendedor", nativeQuery = true)
	List<Ventas> buscarVentaPorNombreVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * FROM Ventas p where p.CodigoVenta=:CodigoVenta", nativeQuery = true)
	Ventas buscarVentasPorCodigo(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT SUM(d.totalDetalle) FROM detalle_venta d  INNER JOIN Ventas v on d.IDVenta = v.IDVenta WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Double TotaldelaVenta(@Param("CodigoVenta") Long CodigoVenta);

	@Query(value = "SELECT * from Ventas v ORDER BY v.FechaVenta DESC", nativeQuery = true)
	List<Ventas> ListarVentasenOrden();

	@Query(value = "select count(*) from Ventas v WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Integer ContadorRepetidosdeunaVenta(@Param("CodigoVenta") Long CodigoVenta);
   
}