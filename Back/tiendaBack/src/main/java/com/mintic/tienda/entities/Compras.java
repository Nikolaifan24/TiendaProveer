package com.mintic.tienda.entities;


import java.util.Date;
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

@Entity
@Table(name = Compras.TABLE_NAME)
public class Compras {
    
    public static final String TABLE_NAME ="compras";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	// @OneToMany(mappedBy = "compras")
    // private List<Productos> productos;

    @OneToMany(mappedBy = "compras")
	private List<Detallecompra> detallecompras;
    
    @ManyToOne
    @JoinColumn(name="IDProveedor")
	private Proveedores proveedores;

    private Date FechaCompra;

	private Double totalCompra;

    private Double ivaCompra;


    public Compras() {
    }

    public Compras(Long ID, List<Detallecompra> detallecompras, Proveedores proveedores, Date FechaCompra, Double totalCompra, Double ivaCompra) {
        this.ID = ID;
        this.detallecompras = detallecompras;
        this.proveedores = proveedores;
        this.FechaCompra = FechaCompra;
        this.totalCompra = totalCompra;
        this.ivaCompra = ivaCompra;
    }


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Date getFechaCompra() {
        return this.FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
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
