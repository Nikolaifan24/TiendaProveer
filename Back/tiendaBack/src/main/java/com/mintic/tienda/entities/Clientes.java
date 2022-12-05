package com.mintic.tienda.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Clientes.TABLE_NAME)
public class Clientes {
		
	public static final String TABLE_NAME = "clientes";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@OneToMany(mappedBy = "cliente")
	private List<Clientes> clientes;

	private String nombreCliente;

	private String apellidoCliente;
	
	private String direccionCliente;
	
	private String barrioCliente;

	private String zonaCliente;
		
	private String telefonoCliente;


	public Clientes() {
	}

	public Clientes(Long ID, List<Clientes> clientes, String nombreCliente, String apellidoCliente, String direccionCliente, String barrioCliente, String zonaCliente, String telefonoCliente) {
		this.ID = ID;
		this.clientes = clientes;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.barrioCliente = barrioCliente;
		this.zonaCliente = zonaCliente;
		this.telefonoCliente = telefonoCliente;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public List<Clientes> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
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

	
}
