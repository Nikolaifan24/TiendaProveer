package com.mintic.tienda.dto;

public class ClienteDto {
	
	private Long ID;
	
	private Long cedulaCliente;

	private String nombreCliente;

	private String apellidoCliente;
	
	private String direccionCliente;
	
	private String barrioCliente;

	private String zonaCliente;
		
	private String telefonoCliente;

	private String telefonoadicional;

	private String correoCliente;
		

	public ClienteDto() {
	}

	public ClienteDto(Long ID, Long cedulaCliente, String nombreCliente, String apellidoCliente, String direccionCliente, String barrioCliente, String zonaCliente, String telefonoCliente, String telefonoadicional, String correoCliente) {
		this.ID = ID;
		this.cedulaCliente = cedulaCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.barrioCliente = barrioCliente;
		this.zonaCliente = zonaCliente;
		this.telefonoCliente = telefonoCliente;
		this.telefonoadicional = telefonoadicional;
		this.correoCliente = correoCliente;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getCedulaCliente() {
		return this.cedulaCliente;
	}

	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return this.apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getBarrioCliente() {
		return this.barrioCliente;
	}

	public void setBarrioCliente(String barrioCliente) {
		this.barrioCliente = barrioCliente;
	}

	public String getZonaCliente() {
		return this.zonaCliente;
	}

	public void setZonaCliente(String zonaCliente) {
		this.zonaCliente = zonaCliente;
	}

	public String getTelefonoCliente() {
		return this.telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getTelefonoadicional() {
		return this.telefonoadicional;
	}

	public void setTelefonoadicional(String telefonoadicional) {
		this.telefonoadicional = telefonoadicional;
	}

	public String getCorreoCliente() {
		return this.correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	
}
