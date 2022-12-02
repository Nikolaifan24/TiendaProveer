package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Productos;

public interface IProducto extends CrudRepository<Productos, Long> {

	@Query(value = "SELECT * FROM Productos  where codigoProducto=:codigoProducto", nativeQuery = true)
	Productos buscarProductoPorCodigo(@Param("codigoProducto") Long codigoProducto);
	
}
