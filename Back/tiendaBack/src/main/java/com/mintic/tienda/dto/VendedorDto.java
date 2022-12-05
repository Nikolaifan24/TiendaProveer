package com.mintic.tienda.dto;

public class VendedorDto {
    private Long ID;
	
	private Long IUsuario;

	private Long Documento;
	
	private String Nombre;
	
	private String Dirrecion;
	
	private Double Telefono;
	
	private Float Comision;

	private String FechaIngreso;

	private Double Salario;


    public VendedorDto() {
    }


    public VendedorDto(Long ID, Long IUsuario, Long Documento, String Nombre, String Dirrecion, Double Telefono, Float Comision, String FechaIngreso, Double Salario) {
        this.ID = ID;
        this.IUsuario = IUsuario;
        this.Documento = Documento;
        this.Nombre = Nombre;
        this.Dirrecion = Dirrecion;
        this.Telefono = Telefono;
        this.Comision = Comision;
        this.FechaIngreso = FechaIngreso;
        this.Salario = Salario;
    }


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIUsuario() {
        return this.IUsuario;
    }

    public void setIUsuario(Long IUsuario) {
        this.IUsuario = IUsuario;
    }

    public Long getDocumento() {
        return this.Documento;
    }

    public void setDocumento(Long Documento) {
        this.Documento = Documento;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirrecion() {
        return this.Dirrecion;
    }

    public void setDirrecion(String Dirrecion) {
        this.Dirrecion = Dirrecion;
    }

    public Double getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(Double Telefono) {
        this.Telefono = Telefono;
    }

    public Float getComision() {
        return this.Comision;
    }

    public void setComision(Float Comision) {
        this.Comision = Comision;
    }

    public String getFechaIngreso() {
        return this.FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public Double getSalario() {
        return this.Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

}
