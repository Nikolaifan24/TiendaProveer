package com.mintic.tienda.dto;

public class CalculoDto {
	private Long codigoProducto;
	private Double precioCompra;
	private Double ivaCompra;
	private Integer cantidadProducto;
	private Double valorProductos;
	private Double valorIvas;
	private Double valorVenta;
	public CalculoDto() {
		
	}
	public CalculoDto(Long codigoProducto, Double precioCompra, Double ivaCompra, Integer cantidadProducto,
			Double valorProductos, Double valorIvas, Double valorVenta) {
		this.codigoProducto = codigoProducto;
		this.precioCompra = precioCompra;
		this.ivaCompra = ivaCompra;
		this.cantidadProducto = cantidadProducto;
		this.valorProductos = valorProductos;
		this.valorIvas = valorIvas;
		this.valorVenta = valorVenta;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Double getIvaCompra() {
		return ivaCompra;
	}
	public void setIvaCompra(Double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public Double getValorProductos() {
		return valorProductos;
	}
	public void setValorProductos(Double valorProductos) {
		this.valorProductos = valorProductos;
	}
	public Double getValorIvas() {
		return valorIvas;
	}
	public void setValorIvas(Double valorIvas) {
		this.valorIvas = valorIvas;
	}
	public Double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(Double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	
	
}
