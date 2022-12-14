package com.mintic.tienda.dto;

import java.util.Date;

public class VentasDto {
	
	private Long ID;

	private Long IDCliente;
	
	private Long IDVendedor;

	private Long IDProducto;

	private Date FechaVenta;

	private Date FechaEntrega;
	
	private Double totalVenta;

	private Double ivaVenta;

	private Double valorPago;

	private Double saldo;

	private String formaPago;
	
	private Date FechaPago;

	private String zonaventa;



	
	public VentasDto() {
	}

	public VentasDto(Long ID, Long IDCliente, Long IDVendedor, Date FechaVenta, Date FechaEntrega, Double totalVenta, Double ivaVenta, Double valorPago, Double saldo, String formaPago, Date FechaPago, String zonaventa) {
		this.ID = ID;
		this.IDCliente = IDCliente;
		this.IDVendedor = IDVendedor;
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

	public Long getIDCliente() {
		return this.IDCliente;
	}

	public void setIDCliente(Long IDCliente) {
		this.IDCliente = IDCliente;
	}

	public Long getIDVendedor() {
		return this.IDVendedor;
	}

	public void setIDVendedor(Long IDVendedor) {
		this.IDVendedor = IDVendedor;
	}

	public Long getIDProducto() {
		return this.IDProducto;
	}

	public void setIDProducto(Long IDProducto) {
		this.IDProducto = IDProducto;
	}

	public Date getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(Date FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public Date getFechaEntrega() {
		return this.FechaEntrega;
	}

	public void setFechaEntrega(Date FechaEntrega) {
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

	public Date getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(Date FechaPago) {
		this.FechaPago = FechaPago;
	}

	public String getZonaventa() {
		return this.zonaventa;
	}

	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}
	
	
		
}
