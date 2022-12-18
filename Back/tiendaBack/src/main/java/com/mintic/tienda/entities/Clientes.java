package com.mintic.tienda.entities;

import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;s
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Clientes.TABLE_NAME)
public class Clientes {
		
	public static final String TABLE_NAME = "clientes";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCliente;
	
    @JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<Cartera> cartera;

	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<Ventas> ventas;

	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<Pagos> pagos;

	private Long documentoCliente;

	private String nombreCliente;

	private String apellidoCliente;
	
	private String direccionCliente;
	
	private String barrioCliente;

	private String zonaCliente;
		
	private String telefonoCliente;

	private String telefonoadicional;

	private String correoCliente;


	public Clientes() {
	}


	public Clientes(Long IDCliente, List<Cartera> cartera, List<Ventas> ventas, List<Pagos> pagos, Long documentoCliente, String nombreCliente, String apellidoCliente, String direccionCliente, String barrioCliente, String zonaCliente, String telefonoCliente, String telefonoadicional, String correoCliente) {
		this.IDCliente = IDCliente;
		this.cartera = cartera;
		this.ventas = ventas;
		this.pagos = pagos;
		this.documentoCliente = documentoCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.barrioCliente = barrioCliente;
		this.zonaCliente = zonaCliente;
		this.telefonoCliente = telefonoCliente;
		this.telefonoadicional = telefonoadicional;
		this.correoCliente = correoCliente;
	}

	public Long getIDCliente() {
		return this.IDCliente;
	}

	public void setIDCliente(Long IDCliente) {
		this.IDCliente = IDCliente;
	}

	public List<Cartera> getCartera() {
		return this.cartera;
	}

	public void setCartera(List<Cartera> cartera) {
		this.cartera = cartera;
	}

	public List<Ventas> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}

	public List<Pagos> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pagos> pagos) {
		this.pagos = pagos;
	}

	public Long getDocumentoCliente() {
		return this.documentoCliente;
	}

	public void setDocumentoCliente(Long documentoCliente) {
		this.documentoCliente = documentoCliente;
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
