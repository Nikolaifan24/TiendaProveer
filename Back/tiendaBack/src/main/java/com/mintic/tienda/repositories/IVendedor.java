package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Vendedor;

public interface IVendedor extends CrudRepository<Vendedor, Long>{

    @Query(value = "SELECT * FROM Vendedor c where c.nombreVendedor=:nombreVendedor", nativeQuery = true)
	Vendedor buscarVendedorPorNombre(@Param("nombreVendedor") String NombreProducto);    

    @Query(value = "SELECT * FROM Vendedor c where c.documentoVendedor= :documentoVendedor", nativeQuery = true)
	Vendedor buscarVendedorPorDocumento(@Param("documentoVendedor") Long documentoVendedor);
}

