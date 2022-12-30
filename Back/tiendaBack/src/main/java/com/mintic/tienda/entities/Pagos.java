package com.mintic.tienda.entities;

import java.util.Date;
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
@Table(name = Pagos.TABLE_NAME)

public class Pagos {

	public static final String TABLE_NAME = "pagos";
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDPagos;

    @JsonIgnore
    @OneToMany(mappedBy = "pagos")
    private List<Cartera> carteras;
	
	@ManyToOne
    @JoinColumn(name="IDCliente")
    private Clientes clientes;

    
	@ManyToOne
    @JoinColumn(name="IDVenta")
    private Ventas ventas;

	private Date FechaVenta;

	private Date FechaPago;

	private String TipoPago;

	private String MedioPago;

	private Double ValorPago;


    public Pagos() {
    }


    public Pagos(Long IDPagos, List<Cartera> carteras, Clientes clientes, Ventas ventas, Date FechaVenta, Date FechaPago, String TipoPago, String MedioPago, Double ValorPago) {
        this.IDPagos = IDPagos;
        this.carteras = carteras;
        this.clientes = clientes;
        this.ventas = ventas;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.TipoPago = TipoPago;
        this.MedioPago = MedioPago;
        this.ValorPago = ValorPago;
    }

    public Long getIDPagos() {
        return this.IDPagos;
    }

    public void setIDPagos(Long IDPagos) {
        this.IDPagos = IDPagos;
    }

    public List<Cartera> getCarteras() {
        return this.carteras;
    }

    public void setCarteras(List<Cartera> carteras) {
        this.carteras = carteras;
    }

    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Ventas getVentas() {
        return this.ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
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
