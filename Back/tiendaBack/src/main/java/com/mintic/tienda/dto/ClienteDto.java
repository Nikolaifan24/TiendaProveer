package com.mintic.tienda.dto;

public class ClienteDto {
	
	private Long id;
	
	private Long cedulaCliente;
	
	private String direccionCliente;
	
	private String emailCliente;
	
	private String nombreCliente;
	
	private String telefonoCliente;
	
	public ClienteDto() {
		
	}

	public ClienteDto(Long id, Long cedulaCliente, String direccionCliente, String emailCliente, String nombreCliente,
			String telefonoCliente) {
		super();
		this.id = id;
		this.cedulaCliente = cedulaCliente;
		this.direccionCliente = direccionCliente;
		this.emailCliente = emailCliente;
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	

	

}
