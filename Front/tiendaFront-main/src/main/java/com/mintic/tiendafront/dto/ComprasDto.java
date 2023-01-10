package com.mintic.tiendafront.dto;

public class ComprasDto {

    private Long IDCompras;

	private ProveedorResponse proveedores;

    private Long CodigoCompra;
	
	private String FechaCompra;

	private Double totalCompra;

    private Double ivaCompra;


    public ComprasDto() {
    }


    public ComprasDto(Long IDCompras, ProveedorResponse proveedores, Long CodigoCompra, String FechaCompra, Double totalCompra, Double ivaCompra) {
        this.IDCompras = IDCompras;
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

    public ProveedorResponse getProveedores() {
        return this.proveedores;
    }

    public void setProveedores(ProveedorResponse proveedores) {
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
