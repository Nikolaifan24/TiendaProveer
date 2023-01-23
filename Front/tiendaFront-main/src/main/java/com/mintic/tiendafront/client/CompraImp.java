package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.mintic.tiendafront.dto.ComprasDto;
import com.mintic.tiendafront.dto.ComprasResponse;
import com.mintic.tiendafront.dto.DetalleCompraDto;
import com.mintic.tiendafront.dto.DetalleCompraResponse;
import com.mintic.tiendafront.dto.ComprasResponse;

import reactor.core.publisher.Mono;

@Service
public class CompraImp implements ICompra{

    private static final String URL = "http://localhost:8091/tienda";

    @Autowired
	private WebClient.Builder webClient;

    @Override
	public List<ComprasResponse> ListarCompras() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/Compraslistar").retrieve()
					.bodyToMono(List.class);
			// System.out.println(response.block() + "estoy saliendo del try");	
			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public ComprasResponse nuevaCompras(ComprasDto ComprasDto) {
				
		try {
			ComprasResponse u = null;
			Mono<ComprasResponse> response = webClient.build().post().uri(URL + "/crearCompras")
					.body(Mono.just(ComprasDto), ComprasResponse.class).retrieve().bodyToMono(ComprasResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}

	@Override
	public ComprasResponse buscarCompraCodigo(Long CodigoCompra) {
		try {

			Mono<ComprasResponse> response = webClient.build().get().uri(URL + "/BuscarComprasPorCodigo/" + CodigoCompra)
					.retrieve().bodyToMono(ComprasResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

		
	@Override
	public ComprasResponse ActualizarCompra(ComprasDto CompraDto, Long CodigoCompra) {
		
		try {
			
			ComprasResponse u = null;
			Mono<ComprasResponse> response = webClient.build().patch().uri(URL + "/actualizarCompras/" + CodigoCompra )
					.body(Mono.just(CompraDto), ComprasResponse.class).retrieve().bodyToMono(ComprasResponse.class);
				
			
			u = response.block();
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}	


	@Override
		public List<DetalleCompraResponse> ListarDetalleCompras(Long CodigoCompra) {
			System.out.println("estoy entrando al metodo");
			try {
				Mono<List> response = webClient.build().get().uri(URL + "/compras/detalle/"+ CodigoCompra).retrieve()
						.bodyToMono(List.class);
				System.out.println(response.block() + "estoy saliendo del try");	
				return response.block();
			} catch (Exception e) {

				return null;
			}

		}

		@Override
		public List<ComprasResponse> ListarComprasPorProducto(String nombreProducto) {
			System.out.println("estoy entrando al metodo");
			try {
				Mono<List> response = webClient.build().get().uri(URL + "/compraslistar/producto/"+ nombreProducto).retrieve()
						.bodyToMono(List.class);
				System.out.println(response.block() + "estoy saliendo del try");	
				return response.block();
			} catch (Exception e) {

				return null;
			}

		}

		@Override
		public List<ComprasResponse> ListarComprasPorProveedor(String nombreProveedor) {
			System.out.println("estoy entrando al metodo");
			try {
				Mono<List> response = webClient.build().get().uri(URL + "/compraslistar/proveedor/"+ nombreProveedor).retrieve()
						.bodyToMono(List.class);
				System.out.println(response.block() + "estoy saliendo del try");	
				return response.block();
			} catch (Exception e) {

				return null;
			}

		}
		
		@Override
		public DetalleCompraResponse DetalladeunaCompra(Long CodigoCompra, String nombreProducto) {
			try {

				Mono<DetalleCompraResponse> response = webClient.build().get().uri(URL + "/compras/detalle/codigo/" + CodigoCompra +"/"+ nombreProducto)
						.retrieve().bodyToMono(DetalleCompraResponse.class);
	
				return response.block();
			} catch (Exception e) {
	
				return null;
			}

		}
		@Override
		public ComprasResponse CargarDatosdeunaCompra(ComprasDto ComprasDto, Long CodigoCompra) {
		
			try {
				
				ComprasResponse u = null;
				Mono<ComprasResponse> response = webClient.build().patch().uri(URL + "/Compras/cargar-productos/" + CodigoCompra )
						.body(Mono.just(ComprasDto), ComprasResponse.class).retrieve().bodyToMono(ComprasResponse.class);
					
				
				u = response.block();
				return u;
	
			} catch (WebClientResponseException e) {
				e.getMessage();
				System.out.println("---->" + e.getMessage());
				return null;
			}
		}	
		

		@Override
		public DetalleCompraResponse nuevoCompraDetalle(Long CodigoCompra, DetalleCompraDto detalleCompraDto) {
					
			try {
				DetalleCompraResponse u = null;
				Mono<DetalleCompraResponse> response = webClient.build().post().uri(URL + "/crearCompras/detalles/" + CodigoCompra)
						.body(Mono.just(detalleCompraDto), DetalleCompraResponse.class).retrieve().bodyToMono(DetalleCompraResponse.class);
					
				
				u = response.block();
				return u;
	
			} catch (WebClientResponseException e) {
				e.getMessage();
				System.out.println("---->" + e.getMessage());
				return null;
			}
	
		}


		@Override
		public DetalleCompraResponse ActualizarDetalledeCompra(Long CodigoCompra, String nombreProducto, DetalleCompraDto detalleCompraDto) {
		
			try {
				
				DetalleCompraResponse u = null;
				Mono<DetalleCompraResponse> response = webClient.build().patch().uri(URL + "/Compras/actualizar/detalles/" + CodigoCompra +"/" + nombreProducto )
						.body(Mono.just(detalleCompraDto), DetalleCompraResponse.class).retrieve().bodyToMono(DetalleCompraResponse.class);
					
				
				u = response.block();
				return u;
	
			} catch (WebClientResponseException e) {
				e.getMessage();
				System.out.println("---->" + e.getMessage());
				return null;
			}
		}


		@Override
		public Double totalCompra(Long CodigoCompra) {
			try {
				/*
				* aqui nos conectamos al back  directamente al controlador donde estan las rutas 
				* el back espera recibir un dto  por eso enviamos el dto login dto
				* */

				Mono<Double> response = webClient.build().get().uri(URL + "/compras/detalle-total/codigo/" + CodigoCompra).retrieve()
				.bodyToMono(Double.class);
				System.out.println(response.block() + "estoy saliendo del try");	
				return response.block();

							} catch (WebClientResponseException e) {
				e.getMessage();
				System.out.println("---->" + e.getMessage());
				return 0.0;
			}

		}

		@Override
		public void borrarDetalleCompras(Long codigoCompra, String nombreProducto) {
			try {

				webClient.build().delete().uri(URL + "/eliminarDetalleCompra/" + codigoCompra + "/" +nombreProducto)
						.retrieve().bodyToMono(Void.class).block();


			} catch (WebClientResponseException e) {
				e.getMessage();
				System.out.println("---->" + e.getMessage());
			}
		}
}
