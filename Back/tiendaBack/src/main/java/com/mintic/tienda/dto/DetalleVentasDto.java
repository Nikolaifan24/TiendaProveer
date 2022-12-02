package com.mintic.tienda.dto;

public class DetalleVentasDto {
	private Long id;
	
	private Long codigoDetalleVenta;
	
	private int cantidadProducto;
	
	private Long idProducto;
	
	private Long idVenta;
	
	private Double valorTotal;
	
	private Double valorVenta;
	
	private Double valorIva;
	
	public DetalleVentasDto() {
		
	}

	public DetalleVentasDto(Long id, Long codigoDetalleVenta, int cantidadProducto, Long idProducto, Long idVenta,
			Double valorTotal, Double valorVenta, Double valorIva) {
		super();
		this.id = id;
		this.codigoDetalleVenta = codigoDetalleVenta;
		this.cantidadProducto = cantidadProducto;
		this.idProducto = idProducto;
		this.idVenta = idVenta;
		this.valorTotal = valorTotal;
		this.valorVenta = valorVenta;
		this.valorIva = valorIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	
}
