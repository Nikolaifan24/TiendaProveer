package com.mintic.tienda.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// import com.mintic.tienda.dto.DetallecompraDto;
// import com.mintic.tienda.dto.DetallecompraDto;
import com.mintic.tienda.entities.Detallecompra;


public interface IDetalleCompra extends CrudRepository<Detallecompra, Long> {
    @Query(value = "SELECT * FROM detalle_compra d INNER JOIN compras c ON d.IDCompra = c.IDCompras WHERE c.CodigoCompra = :CodigoCompra", nativeQuery = true)
	List<Detallecompra> buscarDetalleCompraPorCodigo(@Param("CodigoCompra") Long CodigoCompra);

    
    @Query(value = "SELECT * FROM detalle_compra d INNER JOIN compras c ON d.IDCompra = c.IDCompras INNER JOIN productos p on d.IDProducto = p.IDProductos WHERE c.CodigoCompra = :CodigoCompra AND p.nombreProducto = :nombreProducto", nativeQuery = true)
	Detallecompra buscarDetalleCompraPorCodigoyNombreProducto(@Param("CodigoCompra") Long CodigoCompra, @Param("nombreProducto") String nombreProducto);
    
    
    @Query(value = "select count(*) from detalle_compra d INNER JOIN productos p on d.IDProducto= p.IDProductos INNER JOIN compras c on d.IDCompra = c.IDCompras WHERE c.CodigoCompra = :CodigoCompra AND p.nombreProducto = :nombreProducto", nativeQuery = true)
    Integer ContadorRepetidosCompra(@Param("CodigoCompra") Long CodigoCompra, @Param("nombreProducto") String nombreProducto);
}
