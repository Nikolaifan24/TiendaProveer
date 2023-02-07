package com.mintic.tienda.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Detalleventa;


public interface IDetalleVenta extends CrudRepository<Detalleventa, Long> {

    @Query(value = "SELECT * FROM detalle_venta d INNER JOIN ventas c ON d.IDventa = c.IDventa WHERE c.CodigoVenta = :CodigoVenta", nativeQuery = true)
	List<Detalleventa> buscarDetalleVentaPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM detalle_Venta d INNER JOIN ventas c ON d.IDVenta = c.IDventa INNER JOIN productos p on d.IDProducto = p.IDProductos WHERE c.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto", nativeQuery = true)
	Detalleventa buscarDetalleventaPorCodigoyNombreProducto(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);

    @Query(value = "select count(*) from detalle_venta d INNER JOIN productos p on d.IDProducto= p.IDProductos INNER JOIN ventas v on d.IDventa = v.IDVenta WHERE v.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto ", nativeQuery = true)
    Integer ContadorRepetidosventa(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);
}
