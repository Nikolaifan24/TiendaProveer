package com.mintic.tienda.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Detallecompra;


public interface IDetalleCompra extends CrudRepository<Detallecompra, Long> {
    @Query(value = "SELECT * FROM detalle_compra d INNER JOIN compras c ON d.IDCompra = c.IDCompras WHERE c.FechaCompra = :FechaCompra", nativeQuery = true)
	List<Detallecompra> buscarDetalleCompraPorFecha(@Param("FechaCompra") String FechaCompra);

    	
}
