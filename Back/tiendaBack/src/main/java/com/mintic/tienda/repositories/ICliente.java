package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Clientes;

public interface ICliente extends CrudRepository<Clientes, Long>{
	
	@Query(value = "SELECT * FROM Clientes c where c.documentoCliente= :documentoCliente", nativeQuery = true)
	Clientes buscarClientePorCedula(@Param("documentoCliente") Long documentoCliente);

	@Query(value = "SELECT * FROM Clientes c where c.zonaCliente= :zonaCliente", nativeQuery = true)
	List<Clientes> buscarClientePorZona(@Param("zonaCliente") String zonaCliente);

	// @Query(value = "SELECT * FROM Clientes c where c.zonaCliente= :zonaCliente", nativeQuery = true)
	// Integer contarClientePorZona(@Param("zonaCliente") String zonaCliente);

	@Query(value = "SELECT * from Clientes p where p.nombreCliente= :nombreCliente and p.apellidoCliente=:apellidoCliente", nativeQuery = true)
	List<Clientes> buscarClientePorNombreyApellido(@Param("nombreCliente") String nombreCliente,
			@Param("apellidoCliente") String apellidoCliente);

	@Query(value = "SELECT c.zonaCliente FROM clientes c WHERE c.documentoCliente = :documentoCliente", nativeQuery = true)
	String buscarzonaClientePorCedula(@Param("documentoCliente") Long documentoCliente);	
}
