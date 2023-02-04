package com.mintic.tiendafront.dto;

public class VentaDto {
	
	private Long ID;

	private ClienteResponse clientes;
	
	private VendedorResponse vendedor;

	private String FechaVenta;

	private String FechaEntrega;
	
	private Double totalVenta;

	private Double ivaVenta;

	private String zonaventa;
	

	public VentaDto() {
	}


	public VentaDto(Long ID, ClienteResponse clientes, VendedorResponse vendedor, String FechaVenta, String FechaEntrega, Double totalVenta, Double ivaVenta, String zonaventa) {
		this.ID = ID;
		this.clientes = clientes;
		this.vendedor = vendedor;
		this.FechaVenta = FechaVenta;
		this.FechaEntrega = FechaEntrega;
		this.totalVenta = totalVenta;
		this.ivaVenta = ivaVenta;
		this.zonaventa = zonaventa;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public ClienteResponse getClientes() {
		return this.clientes;
	}

	public void setClientes(ClienteResponse clientes) {
		this.clientes = clientes;
	}

	public VendedorResponse getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(VendedorResponse vendedor) {
		this.vendedor = vendedor;
	}

	public String getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(String FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public String getFechaEntrega() {
		return this.FechaEntrega;
	}

	public void setFechaEntrega(String FechaEntrega) {
		this.FechaEntrega = FechaEntrega;
	}

	public Double getTotalVenta() {
		return this.totalVenta;
	}

	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Double getIvaVenta() {
		return this.ivaVenta;
	}

	public void setIvaVenta(Double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public String getZonaventa() {
		return this.zonaventa;
	}

	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}

}
