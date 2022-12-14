package com.mintic.tienda.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Detalleventa;


public interface IDetalleVenta extends CrudRepository<Detalleventa, Long> {
    @Query(value = "SELECT * FROM Detalle_venta  where IDVenta=:IDVenta", nativeQuery = true)
	Detalleventa buscarDetalleVentaPorIdVenta(@Param("IDVenta") Long IDCompra);
}
