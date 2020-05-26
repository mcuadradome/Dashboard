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
@Table(name = "DIM_PROMOCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimPromocion.findAll", query = "SELECT d FROM DimPromocion d")
    , @NamedQuery(name = "DimPromocion.findByIdPromocion", query = "SELECT d FROM DimPromocion d WHERE d.idPromocion = :idPromocion")
    , @NamedQuery(name = "DimPromocion.findByNombre", query = "SELECT d FROM DimPromocion d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DimPromocion.findByTipo", query = "SELECT d FROM DimPromocion d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "DimPromocion.findByFechaInicio", query = "SELECT d FROM DimPromocion d WHERE d.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "DimPromocion.findByFechaFin", query = "SELECT d FROM DimPromocion d WHERE d.fechaFin = :fechaFin")})
public class DimPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_fin")
    private String fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimPromocion")
    private List<HechoVentas> hechoVentasList;

    public DimPromocion() {
    }

    public DimPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public DimPromocion(Integer idPromocion, String nombre, String tipo, String fechaInicio, String fechaFin) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<HechoVentas> getHechoVentasList() {
        return hechoVentasList;
    }

    public void setHechoVentasList(List<HechoVentas> hechoVentasList) {
        this.hechoVentasList = hechoVentasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimPromocion)) {
            return false;
        }
        DimPromocion other = (DimPromocion) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimPromocion[ idPromocion=" + idPromocion + " ]";
    }
    
}
