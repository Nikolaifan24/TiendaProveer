package com.mintic.tienda.dto;

import java.sql.Date;

public class PagosDto {

    private Long id;

    private Long idClientes;

    private Long idVenta;

	private Date FechaVenta;

	private Date FechaPago;

	private String TipoPago;

	private String MedioPago;

	private Double ValorPago;


	public PagosDto() {
	}


	public PagosDto(Long id, Long idClientes, Long idVenta, Date FechaVenta, Date FechaPago, String TipoPago, String MedioPago, Double ValorPago) {
		this.id = id;
		this.idClientes = idClientes;
		this.idVenta = idVenta;
		this.FechaVenta = FechaVenta;
		this.FechaPago = FechaPago;
		this.TipoPago = TipoPago;
		this.MedioPago = MedioPago;
		this.ValorPago = ValorPago;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdClientes() {
		return this.idClientes;
	}

	public void setIdClientes(Long idClientes) {
		this.idClientes = idClientes;
	}

	public Long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFechaVenta() {
		return this.FechaVenta;
	}

	public void setFechaVenta(Date FechaVenta) {
		this.FechaVenta = FechaVenta;
	}

	public Date getFechaPago() {
		return this.FechaPago;
	}

	public void setFechaPago(Date FechaPago) {
		this.FechaPago = FechaPago;
	}

	public String getTipoPago() {
		return this.TipoPago;
	}

	public void setTipoPago(String TipoPago) {
		this.TipoPago = TipoPago;
	}

	public String getMedioPago() {
		return this.MedioPago;
	}

	public void setMedioPago(String MedioPago) {
		this.MedioPago = MedioPago;
	}

	public Double getValorPago() {
		return this.ValorPago;
	}

	public void setValorPago(Double ValorPago) {
		this.ValorPago = ValorPago;
	}

}
