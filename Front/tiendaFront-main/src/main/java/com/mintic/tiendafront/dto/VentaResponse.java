package com.mintic.tiendafront.dto;

public class VentaResponse {
	
	private Long ID;

	private ClienteResponse clientes;
	
	private VendedorResponse vendedor;

	private Long CodigoVenta;

	private String FechaVenta;

	private String FechaEntrega;

	private Long documentoCliente;

	private String nombreVendedor;

	private int descuento;

	private Double totalVenta;

	private Double ivaVenta;

	private String zonaventa;


	public VentaResponse() {
	}


	public VentaResponse(Long ID, ClienteResponse clientes, VendedorResponse vendedor, Long CodigoVenta, String FechaVenta, String FechaEntrega, Long documentoCliente, String nombreVendedor, int descuento, Double totalVenta, Double ivaVenta, String zonaventa) {
		this.ID = ID;
		this.clientes = clientes;
		this.vendedor = vendedor;
		this.CodigoVenta = CodigoVenta;
		this.FechaVenta = FechaVenta;
		this.FechaEntrega = FechaEntrega;
		this.documentoCliente = documentoCliente;
		this.nombreVendedor = nombreVendedor;
		this.descuento = descuento;
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

	public Long getCodigoVenta() {
		return this.CodigoVenta;
	}

	public void setCodigoVenta(Long CodigoVenta) {
		this.CodigoVenta = CodigoVenta;
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

	public Long getDocumentoCliente() {
		return this.documentoCliente;
	}

	public void setDocumentoCliente(Long documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getNombreVendedor() {
		return this.nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
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
