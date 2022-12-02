package com.mintic.tienda.dto;

public class ProveedoresDto {
	
	private Long id;
	
	private Long nitProveedor;
	
	private String ciudadProveedor;
	
	private String direccionProveedor;
	
	private String nombreProveedor;
	
	private String telefonoProveedor;
	
	public ProveedoresDto() {
		
	}

	public ProveedoresDto(Long id, Long nitProveedor, String ciudadProveedor, String direccionProveedor,
			String nombreProveedor, String telefonoProveedor) {
		super();
		this.id = id;
		this.nitProveedor = nitProveedor;
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	
}
