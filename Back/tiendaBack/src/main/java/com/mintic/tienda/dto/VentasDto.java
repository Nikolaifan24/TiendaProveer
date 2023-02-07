package com.mintic.tienda.dto;


import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Vendedor;

public class VentasDto {
	
	private Long IDVenta;

	private Clientes clientes;
	
	private Vendedor vendedor;

	private Long CodigoVenta;

	private String FechaVenta;

	private String FechaEntrega;

	private Long documentoCliente;

	private String nombreVendedor;

	private int descuento;
	
	private Double totalVenta;

	private Double ivaVenta;

	private String zonaventa;

	public VentasDto() {
	}

	public VentasDto(Long IDVenta, Clientes clientes, Vendedor vendedor, Long CodigoVenta, String FechaVenta, String FechaEntrega, Long documentoCliente, String nombreVendedor, int descuento, Double totalVenta, Double ivaVenta, String zonaventa) {
		this.IDVenta = IDVenta;
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

	public Long getIDVenta() {
		return this.IDVenta;
	}

	public void setIDVenta(Long IDVenta) {
		this.IDVenta = IDVenta;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
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
	
