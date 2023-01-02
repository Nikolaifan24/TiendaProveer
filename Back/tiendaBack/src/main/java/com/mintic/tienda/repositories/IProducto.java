package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.entities.Productos;
// import com.mintic.tienda.servicio.ProductoImp;
// import com.mintic.tienda.servicio.ProveedorImp;

public interface IProducto extends CrudRepository<Productos, Long> {

	@Query(value = "SELECT * FROM Productos c where nombreProducto= :nombreProducto", nativeQuery = true)
	Productos buscarProductoPorNombre(@Param("nombreProducto") String nombreProducto);

	@Query(value = "SELECT * FROM Productos c where c.tipoProducto= :tipoProducto", nativeQuery = true)
	List<Productos> buscarProductoPorTipo(@Param("tipoProducto") String tipoProducto);
	
	@Query(value = "SELECT * FROM Productos p INNER JOIN Proveedores c ON c.IDProveedor= p.IDProveedor WHERE c.nombreProveedor= :nombreProveedor", nativeQuery = true)
	List<Productos> buscarProductoPorNombreProveedor(@Param("nombreProveedor") String nombreProveedor);
}
