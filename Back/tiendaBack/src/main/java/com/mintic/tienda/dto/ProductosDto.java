package com.mintic.tienda.dto;

public class ProductosDto {
	
	private Long idProducto;

	private Long idProveedor;

	private Long idCompras;
	
	private Long codigoProducto;

	private String nombreProducto;

	private String tipoProducto;
	
	private Double precioCompra;
	
	private Double precioVenta;

	private Long cantidadProducto;

	private Long unidadesVendidas;

	private Long unidadesCompradas;

	private Long devoluciones;

	


	public ProductosDto() {
	}


	public ProductosDto(Long idProducto, Long idProveedor, Long idCompras, Long codigoProducto, String nombreProducto, String tipoProducto, Double precioCompra, Double precioVenta, Long cantidadProducto, Long unidadesVendidas, Long unidadesCompradas, Long devoluciones) {
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
		this.idCompras = idCompras;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadProducto = cantidadProducto;
		this.unidadesVendidas = unidadesVendidas;
		this.unidadesCompradas = unidadesCompradas;
		this.devoluciones = devoluciones;
	}

	public Long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Long getIdCompras() {
		return this.idCompras;
	}

	public void setIdCompras(Long idCompras) {
		this.idCompras = idCompras;
	}

	public Long getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Double getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Long getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(Long cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Long getUnidadesVendidas() {
		return this.unidadesVendidas;
	}

	public void setUnidadesVendidas(Long unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Long getUnidadesCompradas() {
		return this.unidadesCompradas;
	}

	public void setUnidadesCompradas(Long unidadesCompradas) {
		this.unidadesCompradas = unidadesCompradas;
	}

	public Long getDevoluciones() {
		return this.devoluciones;
	}

	public void setDevoluciones(Long devoluciones) {
		this.devoluciones = devoluciones;
	}


}
