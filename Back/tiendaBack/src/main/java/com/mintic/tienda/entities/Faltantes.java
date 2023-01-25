package com.mintic.tienda.entities;

import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = Faltantes.TABLE_NAME)
public class Faltantes {

    public static final String TABLE_NAME ="faltantes";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDFaltantes;
	
	// @OneToMany(mappedBy = "compras")
    // private List<Productos> productos;
    @JsonIgnore
    @OneToMany(mappedBy = "faltantes")
	private List<Detallefaltantes> detallefaltantes;
    
    @ManyToOne
    @JoinColumn(name="IDVentas")
	private Ventas ventas;

    @ManyToOne
    @JoinColumn(name="IDVendedor")
	private Vendedor vendedor;

    private Long codigoventa;

    private String fechaVenta;

    private String nombreVendedor;

    private Double totalFaltanes;


    public Faltantes() {
    }

    public Faltantes(Long IDFaltantes, List<Detallefaltantes> detallefaltantes, Ventas ventas, Vendedor vendedor, Long codigoventa, String fechaVenta, String nombreVendedor, Double totalFaltanes) {
        this.IDFaltantes = IDFaltantes;
        this.detallefaltantes = detallefaltantes;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.codigoventa = codigoventa;
        this.fechaVenta = fechaVenta;
        this.nombreVendedor = nombreVendedor;
        this.totalFaltanes = totalFaltanes;
    }

    public Long getIDFaltantes() {
        return this.IDFaltantes;
    }

    public void setIDFaltantes(Long IDFaltantes) {
        this.IDFaltantes = IDFaltantes;
    }

    public List<Detallefaltantes> getDetallefaltantes() {
        return this.detallefaltantes;
    }

    public void setDetallefaltantes(List<Detallefaltantes> detallefaltantes) {
        this.detallefaltantes = detallefaltantes;
    }

    public Ventas getVentas() {
        return this.ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Long getCodigoventa() {
        return this.codigoventa;
    }

    public void setCodigoventa(Long codigoventa) {
        this.codigoventa = codigoventa;
    }

    public String getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Double getTotalFaltanes() {
        return this.totalFaltanes;
    }

    public void setTotalFaltanes(Double totalFaltanes) {
        this.totalFaltanes = totalFaltanes;
    }

}
