package com.mintic.tienda.entities;



// import java.util.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Cartera.TABLE_NAME)
public class Cartera {
    public static final String TABLE_NAME = "cartera";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCartera;
    
	@ManyToOne
    @JoinColumn(name="IDCliente")
    private Clientes clientes;

    
	@ManyToOne
    @JoinColumn(name="IDVenta")
    private Ventas ventas;

    
	@ManyToOne
    @JoinColumn(name="IDPagos")
    private Pagos pagos;

    private Long documentoCliente;

    private Long codigoVenta;

    private String FechaVenta;

    private String FechaPago;

    private Double Saldo;
    

    public Cartera() {
    }

    public Cartera(Long IDCartera, Clientes clientes, Ventas ventas, Pagos pagos, Long documentoCliente, Long codigoVenta, String FechaVenta, String FechaPago, Double Saldo) {
        this.IDCartera = IDCartera;
        this.clientes = clientes;
        this.ventas = ventas;
        this.pagos = pagos;
        this.documentoCliente = documentoCliente;
        this.codigoVenta = codigoVenta;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.Saldo = Saldo;
    }

    public Long getIDCartera() {
        return this.IDCartera;
    }

    public void setIDCartera(Long IDCartera) {
        this.IDCartera = IDCartera;
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

    public Pagos getPagos() {
        return this.pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public Long getDocumentoCliente() {
        return this.documentoCliente;
    }

    public void setDocumentoCliente(Long documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public Long getCodigoVenta() {
        return this.codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaVenta() {
        return this.FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public String getFechaPago() {
        return this.FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

    }
