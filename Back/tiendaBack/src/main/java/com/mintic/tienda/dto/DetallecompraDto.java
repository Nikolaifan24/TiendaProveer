package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Compras;
import com.mintic.tienda.entities.Productos;

public class DetallecompraDto {
    
   private Long ID;

   private Compras compras;
   
   private Productos productos;

   private String nombreProducto;

   private Double ValorUnitario;

   private int cantidadProducto;

   private Double ValorTotal;


    public DetallecompraDto() {
    }


    public DetallecompraDto(Long ID, Compras compras, Productos productos, String nombreProducto, Double ValorUnitario, int cantidadProducto, Double ValorTotal) {
        this.ID = ID;
        this.compras = compras;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
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

    public Compras getCompras() {
        return this.compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
