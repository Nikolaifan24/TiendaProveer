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
@Table(name = Compras.TABLE_NAME)
public class Compras {
    
    public static final String TABLE_NAME ="compras";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCompras;
	
	// @OneToMany(mappedBy = "compras")
    // private List<Productos> productos;
    @JsonIgnore
    @OneToMany(mappedBy = "compras")
	private List<Detallecompra> detallecompras;
    
    @ManyToOne
    @JoinColumn(name="IDProveedor")
	private Proveedores proveedores;

    private Long CodigoCompra;

    private String FechaCompra;

	private Double totalCompra;

    private Double ivaCompra;


    public Compras() {
    }


    public Compras(Long IDCompras, List<Detallecompra> detallecompras, Proveedores proveedores, Long CodigoCompra, String FechaCompra, Double totalCompra, Double ivaCompra) {
        this.IDCompras = IDCompras;
        this.detallecompras = detallecompras;
        this.proveedores = proveedores;
        this.CodigoCompra = CodigoCompra;
        this.FechaCompra = FechaCompra;
        this.totalCompra = totalCompra;
        this.ivaCompra = ivaCompra;
    }

    public Long getIDCompras() {
        return this.IDCompras;
    }

    public void setIDCompras(Long IDCompras) {
        this.IDCompras = IDCompras;
    }

    public List<Detallecompra> getDetallecompras() {
        return this.detallecompras;
    }

    public void setDetallecompras(List<Detallecompra> detallecompras) {
        this.detallecompras = detallecompras;
    }

    public Proveedores getProveedores() {
        return this.proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public Long getCodigoCompra() {
        return this.CodigoCompra;
    }

    public void setCodigoCompra(Long CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
    }

    public String getFechaCompra() {
        return this.FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public Double getTotalCompra() {
        return this.totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Double getIvaCompra() {
        return this.ivaCompra;
    }

    public void setIvaCompra(Double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }
   
   }
