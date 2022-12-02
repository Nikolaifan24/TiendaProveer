package com.mintic.tiendafront.dto;

public class ProductoVenta {
	
	
	private Long cedulaCliente;
	
	
	private Long codigoProducto1;
	private Integer cantidadProducto1;
	private Long codigoProducto2;
	private Integer cantidadProducto2;
	private Long codigoProducto3;
	private Integer cantidadProducto3;
	
	public ProductoVenta() {
		
	}

	public ProductoVenta(Long cedulaCliente, Long codigoProducto1, Integer cantidadProducto1, Long codigoProducto2,
			Integer cantidadProducto2, Long codigoProducto3, Integer cantidadProducto3) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.codigoProducto1 = codigoProducto1;
		this.cantidadProducto1 = cantidadProducto1;
		this.codigoProducto2 = codigoProducto2;
		this.cantidadProducto2 = cantidadProducto2;
		this.codigoProducto3 = codigoProducto3;
		this.cantidadProducto3 = cantidadProducto3;
	}

	public Long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Long getCodigoProducto1() {
		return codigoProducto1;
	}

	public void setCodigoProducto1(Long codigoProducto1) {
		this.codigoProducto1 = codigoProducto1;
	}

	public Integer getCantidadProducto1() {
		return cantidadProducto1;
	}

	public void setCantidadProducto1(Integer cantidadProducto1) {
		this.cantidadProducto1 = cantidadProducto1;
	}

	public Long getCodigoProducto2() {
		return codigoProducto2;
	}

	public void setCodigoProducto2(Long codigoProducto2) {
		this.codigoProducto2 = codigoProducto2;
	}

	public Integer getCantidadProducto2() {
		return cantidadProducto2;
	}

	public void setCantidadProducto2(Integer cantidadProducto2) {
		this.cantidadProducto2 = cantidadProducto2;
	}

	public Long getCodigoProducto3() {
		return codigoProducto3;
	}

	public void setCodigoProducto3(Long codigoProducto3) {
		this.codigoProducto3 = codigoProducto3;
	}

	public Integer getCantidadProducto3() {
		return cantidadProducto3;
	}

	public void setCantidadProducto3(Integer cantidadProducto3) {
		this.cantidadProducto3 = cantidadProducto3;
	}
	
	

}
