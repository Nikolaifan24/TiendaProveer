package com.mintic.tiendafront.dto;

public class ProveedoresDto {
	
	private Long id;
	
	private Long nit;

	private String nombre;

	private String ciudad;

	private String address;

	private String telefono;

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}
	
	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
