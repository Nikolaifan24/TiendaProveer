package com.mintic.tienda.entities;



import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Ventas.TABLE_NAME)
public class Ventas {
	
	public static final String TABLE_NAME = "ventas";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDVenta;

	@JsonIgnore
	@OneToMany(mappedBy="ventas" )
  	private List<Cartera> carteras;

	@JsonIgnore
	@OneToMany(mappedBy="ventas" )
  	private List<Detalleventa> detalleventas;

	@JsonIgnore
	@OneToMany(mappedBy = "ventas")
	private List<Pagos> pagos;

	@ManyToOne
	@JoinColumn(name="IDCliente")
	private Clientes clientes;
	
	@ManyToOne
    @JoinColumn(name="IDVendedor")
    private Vendedor vendedor;

	private Date FechaVenta;

	private Date FechaEntrega;
	
	private Double totalVenta;

	private Double ivaVenta;

	private Double valorPago;

	private Double saldo;

	private String formaPago;
	
	private Date FechaPago;

	private String zonaventa;

	
	public Ventas() {
	}


	public Ventas(Long IDVenta, List<Cartera> carteras, List<Detalleventa> detalleventas, List<Pagos> pagos, Clientes clientes, Vendedor vendedor, Date FechaVenta, Date FechaEntrega, Double totalVenta, Double ivaVenta, Double valorPago, Double saldo, String formaPago, Date FechaPago, String zonaventa) {
		this.IDVenta = IDVenta;
		this.carteras = carteras;
		this.detalleventas = detalleventas;
		this.pagos = pagos;
		this.clientes = clientes;
		this.vendedor = vendedor;
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

	public Long getIDVenta() {
		return this.IDVenta;
	}

	public void setIDVenta(Long IDVenta) {
		this.IDVenta = IDVenta;
	}

	public List<Cartera> getCarteras() {
		return this.carteras;
	}

	public void setCarteras(List<Cartera> carteras) {
		this.carteras = carteras;
	}

	public List<Detalleventa> getDetalleventas() {
		return this.detalleventas;
	}

	public void setDetalleventas(List<Detalleventa> detalleventas) {
		this.detalleventas = detalleventas;
	}

	public List<Pagos> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pagos> pagos) {
		this.pagos = pagos;
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
