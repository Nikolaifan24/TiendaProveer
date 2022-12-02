package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.DetalleVentas;

public interface IDetalleVentas extends CrudRepository<DetalleVentas, Long> {
	@Query(value = "SELECT * FROM detalleVentas d where d.idVenta:=idVenta", nativeQuery = true)
	DetalleVentas buscarDetalleVentaPorIdVenta(@Param("idVenta") Long idVenta);

}
