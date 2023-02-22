package com.mintic.tiendafront.dto;

public class ProveedorResponse {
	
	private Long IDProveedor;
		
	private String nombreProveedor;
	
	private Long nitProveedor;
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String telefonoProveedor;

	private String TipoProducto;


	public ProveedorResponse(Long IDProveedor, String nombreProveedor, Long nitProveedor, String ciudadProveedor, String direccionProveedor, String telefonoProveedor, String TipoProducto) {
		this.IDProveedor = IDProveedor;
		this.nombreProveedor = nombreProveedor;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.TipoProducto = TipoProducto;
	}


	public Long getIDProveedor() {
		return this.IDProveedor;
	}

	public void setIDProveedor(Long IDProveedor) {
		this.IDProveedor = IDProveedor;
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
