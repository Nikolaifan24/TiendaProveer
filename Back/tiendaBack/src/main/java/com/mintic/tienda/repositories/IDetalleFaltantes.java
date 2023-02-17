package com.mintic.tienda.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.dto.DetallefaltantesDto;
import com.mintic.tienda.entities.Detallefaltantes;

public interface IDetalleFaltantes  extends CrudRepository<Detallefaltantes, Long>{

    @Query(value = "SELECT * FROM detalle_faltantes d INNER JOIN faltantes c ON d.IDFaltantes = c.IDFaltantes WHERE c.CodigoVenta = :CodigoVenta", nativeQuery = true)
	List<Detallefaltantes> buscarDetallefaltantesPorCodigoVenta(@Param("CodigoVenta") Long CodigoVenta);

    @Query(value = "SELECT * FROM detalle_faltantes d INNER JOIN faltantes c ON d.IDfaltantes = c.IDFaltantes INNER JOIN productos p on d.IDProducto = p.IDProductos WHERE c.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto", nativeQuery = true)
	Detallefaltantes buscarDetallefaltantesPorCodigoyNombreProducto(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);

    @Query(value = "select count(*) from detalle_faltantes d INNER JOIN productos p on d.IDProducto= p.IDProductos INNER JOIN faltantes v on d.IDfaltantes = v.IDfaltantes WHERE v.CodigoVenta = :CodigoVenta AND p.nombreProducto = :nombreProducto ", nativeQuery = true)
    Integer ContadorRepetidos(@Param("CodigoVenta") Long CodigoVenta, @Param("nombreProducto") String nombreProducto);
}
