package com.mintic.tiendafront.dto;

public class ClienteResponse {
	
private Long id;	
	
	private Long cedulaCliente;
	
	private String direccionCliente;
	
	private String emailCliente;
	
	private String nombreCliente;
	
	private String telefonoCliente;

	
	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public Long getcedulaCliente() {
		return cedulaCliente;
	}

	public void setcedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getdireccionCliente() {
		return direccionCliente;
	}

	public void setdireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getemailCliente() {
		return emailCliente;
	}

	public void setemailCliente (String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getnombreCliente() {
		return nombreCliente;
	}

	public void setnombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String gettelefonoCliente() {
		return telefonoCliente;
	}

	public void settelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}	

}
