package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.CarteraDto;
import com.mintic.tiendafront.dto.CarteraResponse;

public interface ICartera {

    List<CarteraResponse> ListarCarteras();

    CarteraResponse nuevaCartera(CarteraDto CarteraDto) ;

    CarteraResponse buscarCartera(String nombreCliente); 

    CarteraResponse ActualizarCartera(CarteraDto CarteraDto, String nombreCliente);
    
}
