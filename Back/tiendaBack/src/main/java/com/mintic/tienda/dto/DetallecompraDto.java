package com.mintic.tienda.dto;

public class DetallecompraDto {
    
   private Long ID;

   private Long IDCompra;
   
   private Long IDProducto;

   private Double ValorUnitario;

   private int cantidadProducto;

   private Double ValorTotal;


    public DetallecompraDto() {
    }

    public DetallecompraDto(Long ID, Long IDCompra, Long IDProducto, Double ValorUnitario, int cantidadProducto, Double ValorTotal) {
        this.ID = ID;
        this.IDCompra = IDCompra;
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

    public Long getIDCompra() {
        return this.IDCompra;
    }

    public void setIDCompra(Long IDCompra) {
        this.IDCompra = IDCompra;
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
