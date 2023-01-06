package com.mintic.tiendafront.dto;

public class ComprasResponse {
    
    private Long IDCompras;

	private ProveedorResponse proveedores;
	
	private String FechaCompra;

	private Double totalCompra;

    private Double ivaCompra;


    public ComprasResponse() {
    }


    public ComprasResponse(Long IDCompras, ProveedorResponse proveedores, String FechaCompra, Double totalCompra, Double ivaCompra) {
        this.IDCompras = IDCompras;
        this.proveedores = proveedores;
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
