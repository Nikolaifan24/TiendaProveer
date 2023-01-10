package com.mintic.tienda.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Detalleventa;


public interface IDetalleVenta extends CrudRepository<Detalleventa, Long> {
    @Query(value = "SELECT * FROM detalle_venta d INNER JOIN ventas c ON d.IDventa = c.IDventa WHERE c.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Detalleventa buscarDetalleVentaPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);
}
