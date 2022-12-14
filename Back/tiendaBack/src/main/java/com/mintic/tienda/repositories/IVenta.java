package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;

public interface IVenta extends CrudRepository<Ventas, Long> {

	@Query(value = "SELECT * FROM Ventas v where v.codigoVenta=:codigoVenta", nativeQuery = true)
	Ventas buscarVentaPorCodigo(@Param("codigoVenta") Long codigoVenta);
	
	
}
