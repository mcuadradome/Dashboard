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
@Table(name = "DIM_MARCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimMarca.findAll", query = "SELECT d FROM DimMarca d")
    , @NamedQuery(name = "DimMarca.findByIdMarca", query = "SELECT d FROM DimMarca d WHERE d.idMarca = :idMarca")
    , @NamedQuery(name = "DimMarca.findByNombre", query = "SELECT d FROM DimMarca d WHERE d.nombre = :nombre")})
public class DimMarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_marca")
    private Integer idMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimMarcaFk")
    private List<DimProducto> dimProductoList;

    public DimMarca() {
    }

    public DimMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public DimMarca(Integer idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
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
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimMarca)) {
            return false;
        }
        DimMarca other = (DimMarca) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimMarca[ idMarca=" + idMarca + " ]";
    }
    
}
