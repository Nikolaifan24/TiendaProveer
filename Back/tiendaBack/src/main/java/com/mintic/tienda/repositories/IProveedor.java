package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.mintic.tienda.entities.Proveedores;

public interface IProveedor extends CrudRepository<Proveedores, Long> {
	
	@Query(value = "SELECT * FROM Proveedores c where c.nitProveedor=:nitProveedor", nativeQuery = true)
	Proveedores buscarProveedorPorNit(@Param("nitProveedor") Long nitProveedor);

	@Query(value = "SELECT * FROM Proveedores c where c.TipoProducuto=:TipoProducto", nativeQuery = true)
	Proveedores buscarProveedorPorTipoproducto(@Param("TipoProducto") String TipoProducto);

}
