package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.VendedorDto;
import com.mintic.tiendafront.dto.VendedorResponse;

public interface IVendedor {

    List<VendedorResponse> ListarVendedors() ;

    VendedorResponse nuevoVendedor(VendedorDto VendedorDto);

    VendedorResponse buscarVendedor(String nombreVendedor) ;
    
    void borrarVendedor(String nombreVendedor);
    
}
