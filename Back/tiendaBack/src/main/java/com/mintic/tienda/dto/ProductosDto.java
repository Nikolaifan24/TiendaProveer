package com.mintic.tienda.dto;

public class ProductosDto {
	
	private Long id;
	
	private Long codigoProducto;
	
	private Double ivaCompra;
	
	private Long idProveedor;
	
	private String nombreProducto;
	
	private Double precioCompra;
	
	private Double precioVenta;
	
	public ProductosDto() {
		
	}

	public ProductosDto(Long id, Long codigoProducto, Double ivaCompra, Long idProveedor, String nombreProducto,
			Double precioCompra, Double precioVenta) {
		this.id = id;
		this.codigoProducto = codigoProducto;
		this.ivaCompra = ivaCompra;
		this.idProveedor = idProveedor;
		this.nombreProducto = nombreProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Double getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(Double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
	

}
