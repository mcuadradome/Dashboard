/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "dim_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimProducto.findAll", query = "SELECT d FROM DimProducto d"),
    @NamedQuery(name = "DimProducto.findByIdProducto", query = "SELECT d FROM DimProducto d WHERE d.idProducto = :idProducto"),
    @NamedQuery(name = "DimProducto.findByCantidad", query = "SELECT d FROM DimProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DimProducto.findByCodProdcuto", query = "SELECT d FROM DimProducto d WHERE d.codProdcuto = :codProdcuto"),
    @NamedQuery(name = "DimProducto.findByFabricante", query = "SELECT d FROM DimProducto d WHERE d.fabricante = :fabricante"),
    @NamedQuery(name = "DimProducto.findByFechaIngreso", query = "SELECT d FROM DimProducto d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DimProducto.findByNombre", query = "SELECT d FROM DimProducto d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DimProducto.findByPeso", query = "SELECT d FROM DimProducto d WHERE d.peso = :peso")})
public class DimProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private long cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cod_prodcuto")
    private String codProdcuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private int peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimProducto")
    private Collection<HechoVentas> hechoVentasCollection;
    @JoinColumn(name = "dim_categoria_fk", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private DimCategoria dimCategoriaFk;
    @JoinColumn(name = "dim_marca_fk", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private DimMarca dimMarcaFk;

    public DimProducto() {
    }

    public DimProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public DimProducto(Integer idProducto, long cantidad, String codProdcuto, String fabricante, Date fechaIngreso, String nombre, int peso) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.codProdcuto = codProdcuto;
        this.fabricante = fabricante;
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.peso = peso;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodProdcuto() {
        return codProdcuto;
    }

    public void setCodProdcuto(String codProdcuto) {
        this.codProdcuto = codProdcuto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @XmlTransient
    public Collection<HechoVentas> getHechoVentasCollection() {
        return hechoVentasCollection;
    }

    public void setHechoVentasCollection(Collection<HechoVentas> hechoVentasCollection) {
        this.hechoVentasCollection = hechoVentasCollection;
    }

    public DimCategoria getDimCategoriaFk() {
        return dimCategoriaFk;
    }

    public void setDimCategoriaFk(DimCategoria dimCategoriaFk) {
        this.dimCategoriaFk = dimCategoriaFk;
    }

    public DimMarca getDimMarcaFk() {
        return dimMarcaFk;
    }

    public void setDimMarcaFk(DimMarca dimMarcaFk) {
        this.dimMarcaFk = dimMarcaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimProducto)) {
            return false;
        }
        DimProducto other = (DimProducto) object;
        if((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DimProducto{" + "idProducto=" + idProducto + ", cantidad=" + cantidad + ", codProdcuto=" + codProdcuto + ", fabricante=" + fabricante + ", fechaIngreso=" + fechaIngreso + ", nombre=" + nombre + ", peso=" + peso + ", dimCategoriaFk=" + dimCategoriaFk + ", dimMarcaFk=" + dimMarcaFk + '}';
    }

   
    
}
