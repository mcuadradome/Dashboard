/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "DIM_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimProducto.findAll", query = "SELECT d FROM DimProducto d")
    , @NamedQuery(name = "DimProducto.findByIdProducto", query = "SELECT d FROM DimProducto d WHERE d.idProducto = :idProducto")
    , @NamedQuery(name = "DimProducto.findByNombre", query = "SELECT d FROM DimProducto d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DimProducto.findByCodProdcuto", query = "SELECT d FROM DimProducto d WHERE d.codProdcuto = :codProdcuto")
    , @NamedQuery(name = "DimProducto.findByPeso", query = "SELECT d FROM DimProducto d WHERE d.peso = :peso")
    , @NamedQuery(name = "DimProducto.findByFabricante", query = "SELECT d FROM DimProducto d WHERE d.fabricante = :fabricante")
    , @NamedQuery(name = "DimProducto.findByCantidad", query = "SELECT d FROM DimProducto d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DimProducto.findByFechaIngreso", query = "SELECT d FROM DimProducto d WHERE d.fechaIngreso = :fechaIngreso")})
public class DimProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cod_prodcuto")
    private String codProdcuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private Integer peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private long cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
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

    public DimProducto(Integer idProducto, String nombre, String codProdcuto, Integer peso, String fabricante, long cantidad, Date fechaIngreso) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.codProdcuto = codProdcuto;
        this.peso = peso;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodProdcuto() {
        return codProdcuto;
    }

    public void setCodProdcuto(String codProdcuto) {
        this.codProdcuto = codProdcuto;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimProducto[ idProducto=" + idProducto + " ]";
    }
    
}
