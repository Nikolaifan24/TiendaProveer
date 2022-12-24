package com.mintic.tienda.dto;

import java.util.List;

// import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Productos;

public class ProveedoresDto {
	
	private Long id;
		
	// private List<Compras> compras;

	private List<Productos> productos;

	private String nombreProveedor;
	
	private Long nitProveedor;
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String telefonoProveedor;

	private String TipoProducto;


	public ProveedoresDto() {
	}

	public ProveedoresDto(Long id, List<Productos> productos, String nombreProveedor, Long nitProveedor, String ciudadProveedor, String direccionProveedor, String telefonoProveedor, String TipoProducto) {
		this.id = id;
		this.productos = productos;
		this.nombreProveedor = nombreProveedor;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.TipoProducto = TipoProducto;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Productos> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public Long getNitProveedor() {
		return this.nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudadProveedor() {
		return this.ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getTipoProducto() {
		return this.TipoProducto;
	}

	public void setTipoProducto(String TipoProducto) {
		this.TipoProducto = TipoProducto;
	}
	
}
