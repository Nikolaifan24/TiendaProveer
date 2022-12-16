package com.mintic.tienda.entities;


import java.util.List;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = Vendedor.TABLE_NAME)
public class Vendedor {

    public static final String TABLE_NAME = "vendedor";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
    @ManyToOne
    @JoinColumn(name="IDUsuario")
    private Usuario usuario;

	@OneToMany(mappedBy = "vendedor")
    private List<Ventas> ventas;
	
    private Long documentoVendedor;
	
	private String nombreVendedor;
	
	private String dirrecionVendedor;
	
	private Double telefonoVendedor;
	
	private Float comisionVendedor;

	private String FechaIngreso;

	private Double Salario;


    public Vendedor() {
    }

    public Vendedor(Long ID, Usuario usuario, List<Ventas> ventas, Long documentoVendedor, String nombreVendedor, String dirrecionVendedor, Double telefonoVendedor, Float comisionVendedor, String FechaIngreso, Double Salario) {
        this.ID = ID;
        this.usuario = usuario;
        this.ventas = ventas;
        this.documentoVendedor = documentoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.dirrecionVendedor = dirrecionVendedor;
        this.telefonoVendedor = telefonoVendedor;
        this.comisionVendedor = comisionVendedor;
        this.FechaIngreso = FechaIngreso;
        this.Salario = Salario;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Ventas> getVentas() {
        return this.ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
    }

    public Long getDocumentoVendedor() {
        return this.documentoVendedor;
    }

    public void setDocumentoVendedor(Long documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDirrecionVendedor() {
        return this.dirrecionVendedor;
    }

    public void setDirrecionVendedor(String dirrecionVendedor) {
        this.dirrecionVendedor = dirrecionVendedor;
    }

    public Double getTelefonoVendedor() {
        return this.telefonoVendedor;
    }

    public void setTelefonoVendedor(Double telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }

    public Float getComisionVendedor() {
        return this.comisionVendedor;
    }

    public void setComisionVendedor(Float comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
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
