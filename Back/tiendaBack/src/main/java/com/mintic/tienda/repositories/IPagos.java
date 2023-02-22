package com.mintic.tienda.repositories;

// import java.util.String;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Pagos;

public interface IPagos extends CrudRepository<Pagos, Long> {
    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.TipoPago=:TipoPago", nativeQuery = true)
	List<Pagos> buscarPagosPorFechayTipo(@Param("FechaPago") String FechaPago,	@Param("TipoPago") String TipoPago);

    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.MedioPago=:MedioPago", nativeQuery = true)
    List<Pagos> buscarPagosPorFechayMedio(@Param("FechaPago") String FechaPago,   @Param("MedioPago") String MedioPago);
    
	@Query(value = "SELECT * FROM Pagos p where p.TipoPago=:TipoPago", nativeQuery = true)
	List<Pagos> buscarPagosPorTipo(@Param("TipoPago") String TipoPago);
    
    @Query(value = "SELECT * FROM Pagos p where p.MedioPago=:MedioPago", nativeQuery = true)
	List<Pagos> buscarPagosPorMedio(@Param("MedioPago") String MedioPago);

    @Query(value = "SELECT * from Pagos p where p.codigoVenta = :CodigoVenta AND p.FechaPago=:FechaPago ", nativeQuery = true)
    Pagos buscarPagosporCodigoVentaFechapago(@Param("CodigoVenta") Long CodigoVenta, @Param("FechaPago") String FechaPago);

    @Query(value = "SELECT * FROM Pagos p INNER JOIN Clientes c ON p.IDCliente= c.IDCliente WHERE c.documentoCliente= :", nativeQuery = true)
	List<Pagos> buscarPagosPorCliente(@Param("documentoCliente") Long documentoCliente);

    @Query(value = "SELECT * FROM Pagos p INNER JOIN Ventas c ON c.IDVenta= p.IDVenta WHERE c.FechaVenta= :FechaVenta", nativeQuery = true)
	List<Pagos> buscarPagosPorFechaVenta(@Param("FechaVenta") String FechaVenta);

    @Query(value = "SELECT * from Pagos p where p.FechaPago= :FechaPago and p.FechaVenta=:FechaVenta", nativeQuery = true)
    List<Pagos> buscarPagosPorFechaPagoFechaVenta(@Param("FechaPago") String FechaPago,   @Param("FechaVenta") String FechaVenta);
}
