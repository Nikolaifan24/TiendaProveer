package com.mintic.tienda.servicio;

// import java.util.Date;
import java.util.List;

// import com.mintic.tienda.dto.CalculoDto;
// import com.mintic.tienda.dto.ProductosDto;
import com.mintic.tienda.dto.DetalleventaDto;
import com.mintic.tienda.dto.VentasDto;
import com.mintic.tienda.entities.Ventas;

public interface IVentasService {

	List<Ventas> ListarVentas();

	VentasDto buscarVentaPorfecha(String fechaVenta);

	void crearVenta(VentasDto ventasDto);

	DetalleventaDto realizarCalculo(DetalleventaDto detalleventaDto, Integer cantidad);


}
