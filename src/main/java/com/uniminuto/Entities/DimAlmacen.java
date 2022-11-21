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
@Table(name = "dim_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimAlmacen.findAll", query = "SELECT d FROM DimAlmacen d"),
    @NamedQuery(name = "DimAlmacen.findByIdAlmacen", query = "SELECT d FROM DimAlmacen d WHERE d.idAlmacen = :idAlmacen"),
    @NamedQuery(name = "DimAlmacen.findByCiudad", query = "SELECT d FROM DimAlmacen d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DimAlmacen.findByDireccion", query = "SELECT d FROM DimAlmacen d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DimAlmacen.findByLocalidad", query = "SELECT d FROM DimAlmacen d WHERE d.localidad = :localidad"),
    @NamedQuery(name = "DimAlmacen.findByMunicipio", query = "SELECT d FROM DimAlmacen d WHERE d.municipio = :municipio"),
    @NamedQuery(name = "DimAlmacen.findByNombre", query = "SELECT d FROM DimAlmacen d WHERE d.nombre = :nombre")})
public class DimAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private Integer idAlmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 2147483647)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 2147483647)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimAlmacen")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimAlmacen() {
    }

    public DimAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public DimAlmacen(Integer idAlmacen, String ciudad, String direccion, String nombre) {
        this.idAlmacen = idAlmacen;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimAlmacen)) {
            return false;
        }
        DimAlmacen other = (DimAlmacen) object;
        if ((this.idAlmacen == null && other.idAlmacen != null) || (this.idAlmacen != null && !this.idAlmacen.equals(other.idAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimAlmacen[ idAlmacen=" + idAlmacen + " ]";
    }
    
}
