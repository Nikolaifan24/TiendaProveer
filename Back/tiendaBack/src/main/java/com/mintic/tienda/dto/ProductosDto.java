package com.mintic.tienda.dto;

// import java.util.List;

import com.mintic.tienda.entities.Proveedores;

// import com.mintic.tienda.entities.Compras;
// import com.mintic.tienda.entities.Proveedores;

public class ProductosDto {
	
	private Long IDProductos;
	
	private Proveedores proveedores;

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


	public ProductosDto(Long IDProductos, Proveedores proveedores, Long codigoProducto, String nombreProducto, String tipoProducto, Double precioCompra, Double precioVenta, Long cantidadProducto, Long unidadesVendidas, Long unidadesCompradas, Long devoluciones) {
		this.IDProductos = IDProductos;
		this.proveedores = proveedores;
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

	public Long getIDProductos() {
		return this.IDProductos;
	}

	public void setIDProductos(Long IDProductos) {
		this.IDProductos = IDProductos;
	}

	public Proveedores getProveedores() {
		return this.proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
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