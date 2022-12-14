package com.mintic.tienda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Detallecompra.TABLE_NAME)

public class Detallecompra {
    
    public static final String TABLE_NAME = "detalle_compra";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDCompra")
    private Long IDVenta;


    @ManyToOne
    @JoinColumn(name="IDProducto")
    private Long IDProducto;
    
    private Double ValorUnitario;

    private int cantidadProducto;

    private Double ValorTotal;


    public Detallecompra() {
    }

    public Detallecompra(Long ID, Long IDVenta, Long IDProducto, Double ValorUnitario, int cantidadProducto, Double ValorTotal) {
        this.ID = ID;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
        this.ValorUnitario = ValorUnitario;
        this.cantidadProducto = cantidadProducto;
        this.ValorTotal = ValorTotal;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Long getIDProducto() {
        return this.IDProducto;
    }

    public void setIDProducto(Long IDProducto) {
        this.IDProducto = IDProducto;
    }

    public Double getValorUnitario() {
        return this.ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public int getCantidadProducto() {
        return this.cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getValorTotal() {
        return this.ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

}
