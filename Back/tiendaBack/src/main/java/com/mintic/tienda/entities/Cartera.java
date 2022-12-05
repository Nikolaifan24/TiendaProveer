package com.mintic.tienda.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Ventas.TABLE_NAME)
public class Cartera {
    public static final String TABLE_NAME = "cartera";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCartera;
    
	@ManyToOne
    @JoinColumn(name="IIDCliente")
    private Long IDClientes;

    
	@ManyToOne
    @JoinColumn(name="IIVenta")
    private Long IDVenta;

    private Date FechaVenta;

    private Double Saldo;
    

    public Cartera() {
    }

    public Cartera(Long IDCartera, Long IDClientes, Long IDVenta, Date FechaVenta, Double Saldo) {
        this.IDCartera = IDCartera;
        this.IDClientes = IDClientes;
        this.IDVenta = IDVenta;
        this.FechaVenta = FechaVenta;
        this.Saldo = Saldo;
    }

    public Long getIDCartera() {
        return this.IDCartera;
    }

    public void setIDCartera(Long IDCartera) {
        this.IDCartera = IDCartera;
    }

    public Long getIDClientes() {
        return this.IDClientes;
    }

    public void setIDClientes(Long IDClientes) {
        this.IDClientes = IDClientes;
    }

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Date getFechaVenta() {
        return this.FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }
    
}
