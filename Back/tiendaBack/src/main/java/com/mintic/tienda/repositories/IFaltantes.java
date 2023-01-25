package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Faltantes;

public interface IFaltantes  extends CrudRepository<Faltantes, Long> {
    
    @Query(value = "SELECT * FROM faltantes f INNER JOIN ventas v ON f.IDventas = v.IDventa WHERE v.CodigoVenta = :CodigoVenta", nativeQuery = true)
	Faltantes buscarfaltantesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    // @Query(value = "SELECT * FROM faltantes f INNER JOIN vendedor v ON f.IDVendedor = v.IDVendedor WHERE v.nombreVendedor = :v.nombreVendedor", nativeQuery = true)
	// List<Faltantes> buscarFaltantesPorVendedor(@Param("nombreVendedor") String nombreVendedor);

    @Query(value = "SELECT * from faltantes f ORDER BY c.fechaVenta DESC", nativeQuery = true)
	List<Faltantes> ListarFaltantesenOrden();


}
