package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.servicio.ProductoImp;
import com.mintic.tienda.servicio.ProveedorImp;

public interface IProducto extends CrudRepository<Productos, Long> {

	@Query(value = "SELECT * FROM Productos  where NombreProducto=:NombreProducto", nativeQuery = true)
	Productos buscarProductoPorNombre(@Param("NombreProducto") String nombreProducto);
		
}
