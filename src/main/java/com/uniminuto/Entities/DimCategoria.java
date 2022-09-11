/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "DIM_CATEGORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimCategoria.findAll", query = "SELECT d FROM DimCategoria d")
    , @NamedQuery(name = "DimCategoria.findByIdCategoria", query = "SELECT d FROM DimCategoria d WHERE d.idCategoria = :idCategoria")
    , @NamedQuery(name = "DimCategoria.findByNombre", query = "SELECT d FROM DimCategoria d WHERE d.nombre = :nombre")})
public class DimCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimCategoriaFk")
    private List<DimProducto> dimProductoList;

    public DimCategoria() {
    }

    public DimCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public DimCategoria(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<DimProducto> getDimProductoList() {
        return dimProductoList;
    }

    public void setDimProductoList(List<DimProducto> dimProductoList) {
        this.dimProductoList = dimProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimCategoria)) {
            return false;
        }
        DimCategoria other = (DimCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
