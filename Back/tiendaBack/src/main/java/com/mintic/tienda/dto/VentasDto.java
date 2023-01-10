package com.mintic.tienda.dto;


import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Vendedor;

public class VentasDto {
	
	private Long ID;

	private Clientes clientes;
	
	private Vendedor vendedor;

	private Long CodigoVenta;

	private String FechaVenta;

	private String FechaEntrega;
	
	private Double totalVenta;

	private Double ivaVenta;

	private Double valorPago;

	private Double saldo;

	private String formaPago;
	
	private String FechaPago;

	private String zonaventa;



	
	public VentasDto() {
	}

	public VentasDto(Long ID, Clientes clientes, Vendedor vendedor, Long CodigoVenta, String FechaVenta, String FechaEntrega, Double totalVenta, Double ivaVenta, Double valorPago, Double saldo, String formaPago, String FechaPago, String zonaventa) {
		this.ID = ID;
		this.clientes = clientes;
		this.vendedor = vendedor;
		this.CodigoVenta = CodigoVenta;
		this.FechaVenta = FechaVenta;
		this.FechaEntrega = FechaEntrega;
		this.totalVenta = totalVenta;
		this.ivaVenta = ivaVenta;
		this.valorPago = valorPago;
		this.saldo = saldo;
		this.formaPago = formaPago;
		this.FechaPago = FechaPago;
		this.zonaventa = zonaventa;
	}

	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
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

	public Double getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(String FechaPago) {
		this.FechaPago = FechaPago;
	}

	public String getZonaventa() {
		return this.zonaventa;
	}

	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}

}
	
