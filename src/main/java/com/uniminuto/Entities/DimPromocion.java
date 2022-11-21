/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "dim_promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimPromocion.findAll", query = "SELECT d FROM DimPromocion d"),
    @NamedQuery(name = "DimPromocion.findByIdPromocion", query = "SELECT d FROM DimPromocion d WHERE d.idPromocion = :idPromocion"),
    @NamedQuery(name = "DimPromocion.findByFechaFin", query = "SELECT d FROM DimPromocion d WHERE d.fechaFin = :fechaFin"),
    @NamedQuery(name = "DimPromocion.findByFechaInicio", query = "SELECT d FROM DimPromocion d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "DimPromocion.findByNombre", query = "SELECT d FROM DimPromocion d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DimPromocion.findByTipo", query = "SELECT d FROM DimPromocion d WHERE d.tipo = :tipo")})
public class DimPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fecha_fin")
    private String fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimPromocion")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimPromocion() {
    }

    public DimPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public DimPromocion(Integer idPromocion, String fechaFin, String fechaInicio, String nombre, String tipo) {
        this.idPromocion = idPromocion;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    @XmlTransient
    public Collection<HechoVentas> getHechoVentasCollection() {
        return hechoVentasCollection;
    }

    public void setHechoVentasCollection(Collection<HechoVentas> hechoVentasCollection) {
        this.hechoVentasCollection = hechoVentasCollection;
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
