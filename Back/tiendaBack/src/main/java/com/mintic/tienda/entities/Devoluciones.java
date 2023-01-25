package com.mintic.tienda.entities;


// import java.util.String;
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
@Table(name = Devoluciones.TABLE_NAME)
public class Devoluciones {

    public static final String TABLE_NAME ="devoluciones";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	// @OneToMany(mappedBy = "compras")
    // private List<Productos> productos;
    @JsonIgnore
    @OneToMany(mappedBy = "devoluciones")
	private List<Detalledevoluciones> detalledevoluciones;
    
    @ManyToOne
    @JoinColumn(name="IDVenta")
	private Ventas ventas;

    @ManyToOne
    @JoinColumn(name="IDVendedor")
	private Vendedor vendedor;

    private Long codigoVenta;

    private String fechaVenta;

    private String nombreVendedor;

    private Double TotalDevoluciones;


    public Devoluciones() {
    }

    public Devoluciones(Long ID, List<Detalledevoluciones> detalledevoluciones, Ventas ventas, Vendedor vendedor, Long codigoVenta, String fechaVenta, String nombreVendedor, Double TotalDevoluciones) {
        this.ID = ID;
        this.detalledevoluciones = detalledevoluciones;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.nombreVendedor = nombreVendedor;
        this.TotalDevoluciones = TotalDevoluciones;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public List<Detalledevoluciones> getDetalledevoluciones() {
        return this.detalledevoluciones;
    }

    public void setDetalledevoluciones(List<Detalledevoluciones> detalledevoluciones) {
        this.detalledevoluciones = detalledevoluciones;
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

    public Long getCodigoVenta() {
        return this.codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
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

    public Double getTotalDevoluciones() {
        return this.TotalDevoluciones;
    }

    public void setTotalDevoluciones(Double TotalDevoluciones) {
        this.TotalDevoluciones = TotalDevoluciones;
    }


    
}
