package com.mintic.tienda.repositories;
import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Pagos;

public interface IPagos extends CrudRepository<Pagos, Long> {
    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.TipoPago=:TipoPago", nativeQuery = true)
	Pagos buscarPagosPorFechayTipo(@Param("FechaPago") Date FechaPago,
			@Param("TipoPago") String TipoPago);

    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.MedioPago=:MedioPago", nativeQuery = true)
    Pagos buscarPagosPorFechayMedio(@Param("FechaPago") Date FechaPago,
            @Param("MedioPago") String MedioPago);

    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.TipoPago=: TipoPAgo and p.MedioPago =: MedioPago", nativeQuery = true)
    Pagos buscarPagosPorFechayTipoyMedio(@Param("FechaPago") Date FechaPago,
            @Param("TipoPago") String TipoPago, @Param("MedioPago") String MedioPago);
	
	@Query(value = "SELECT * FROM Pagos p where p.TipoPago=:TipoPago", nativeQuery = true)
	Pagos buscarPagosPorTipo(@Param("TipoPago") String TipoPago);
    
    @Query(value = "SELECT * FROM Pagos p where p.MedioPago=:MedioPago", nativeQuery = true)
	Pagos buscarPagosPorMedio(@Param("MedioPago") String MedioPago);
}
