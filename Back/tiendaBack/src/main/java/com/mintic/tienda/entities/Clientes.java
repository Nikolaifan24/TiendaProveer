package com.mintic.tienda.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Clientes.TABLE_NAME)
public class Clientes {
		
	public static final String TABLE_NAME = "clientes";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "cedulaCliente")
	//private List<Ventas> ventas;
	
	private Long cedulaCliente;
	
	private String direccionCliente;
	
	private String emailCliente;
	
	private String nombreCliente;
	
	private String telefonoCliente;

	public Clientes() {
	
	}

	public Clientes(Long id, Long cedulaCliente, String direccionCliente, String emailCliente, String nombreCliente,
			String telefonoCliente) {
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
