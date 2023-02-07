package com.mintic.tienda.entities;

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

	private Long CodigoVenta;

	private String FechaVenta;

	private String FechaEntrega;

	private Long documentoCliente;

	private String nombreVendedor;

	private int descuento;

	private Double totalVenta;

	private Double ivaVenta;

	private String zonaventa;

	
	public Ventas() {
	}


	public Ventas(Long IDVenta, List<Cartera> carteras, List<Detalleventa> detalleventas, List<Pagos> pagos, Clientes clientes, Vendedor vendedor, Long CodigoVenta, String FechaVenta, String FechaEntrega, Long documentoCliente, String nombreVendedor, int descuento, Double totalVenta, Double ivaVenta, String zonaventa) {
		this.IDVenta = IDVenta;
		this.carteras = carteras;
		this.detalleventas = detalleventas;
		this.pagos = pagos;
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
