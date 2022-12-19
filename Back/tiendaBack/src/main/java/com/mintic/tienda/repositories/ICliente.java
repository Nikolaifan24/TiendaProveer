package com.mintic.tienda.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Clientes;

public interface ICliente extends CrudRepository<Clientes, Long>{
	
	@Query(value = "SELECT * FROM Clientes c where c.documentoCliente= :documentoCliente", nativeQuery = true)
	Clientes buscarClientePorCedula(@Param("documentoCliente") Long documentoCliente);

	@Query(value = "SELECT * FROM Clientes c where c.zonaCliente= :zonaCliente", nativeQuery = true)
	Clientes buscarClientePorZona(@Param("zonaCliente") String zonaCliente);


	@Query(value = "SELECT * from Clientes p where p.nombreCliente= :nombreCliente and p.apellidoCliente=:apellidoCliente", nativeQuery = true)
	Clientes buscarClientePorNombreyApellido(@Param("nombreCliente") String nombreCliente,
			@Param("apellidoCliente") String apellidoCliente);

    		
}
