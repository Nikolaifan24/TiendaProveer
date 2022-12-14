package com.mintic.tienda.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Detallecompra;


public interface IDetalleCompra extends CrudRepository<Detallecompra, Long> {
    @Query(value = "SELECT * FROM Detalle_compra  where IDCompra=:IDCompra", nativeQuery = true)
	Detallecompra buscarDetallePorIDCompra(@Param("IDCompra") Long IDCompra);
	
}
