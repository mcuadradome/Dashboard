/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "DIM_ALMACEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimAlmacen.findAll", query = "SELECT d FROM DimAlmacen d")
    , @NamedQuery(name = "DimAlmacen.findByIdAlmacen", query = "SELECT d FROM DimAlmacen d WHERE d.idAlmacen = :idAlmacen")
    , @NamedQuery(name = "DimAlmacen.findByNombre", query = "SELECT d FROM DimAlmacen d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DimAlmacen.findByDireccion", query = "SELECT d FROM DimAlmacen d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DimAlmacen.findByLocalidad", query = "SELECT d FROM DimAlmacen d WHERE d.localidad = :localidad")
    , @NamedQuery(name = "DimAlmacen.findByMunicipio", query = "SELECT d FROM DimAlmacen d WHERE d.municipio = :municipio")
    , @NamedQuery(name = "DimAlmacen.findByCiudad", query = "SELECT d FROM DimAlmacen d WHERE d.ciudad = :ciudad")})
public class DimAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_almacen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer idAlmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimAlmacen")
    private List<HechoVentas> hechoVentasList;

    public DimAlmacen() {
    }

    public DimAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public DimAlmacen(Integer idAlmacen, String nombre, String direccion, String localidad, String municipio, String ciudad) {
        this.idAlmacen = idAlmacen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.municipio = municipio;
        this.ciudad = ciudad;
    }

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DimAlmacen other = (DimAlmacen) obj;
        return Objects.equals(this.idAlmacen, other.idAlmacen);
    }


    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimAlmacen[ idAlmacen=" + idAlmacen + " ]";
    }
    
}
