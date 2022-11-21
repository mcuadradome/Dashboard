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
@Table(name = "dim_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimProveedor.findAll", query = "SELECT d FROM DimProveedor d"),
    @NamedQuery(name = "DimProveedor.findByIdProvedor", query = "SELECT d FROM DimProveedor d WHERE d.idProvedor = :idProvedor"),
    @NamedQuery(name = "DimProveedor.findByCorreo", query = "SELECT d FROM DimProveedor d WHERE d.correo = :correo"),
    @NamedQuery(name = "DimProveedor.findByDireccion", query = "SELECT d FROM DimProveedor d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DimProveedor.findByMunicipio", query = "SELECT d FROM DimProveedor d WHERE d.municipio = :municipio"),
    @NamedQuery(name = "DimProveedor.findByNit", query = "SELECT d FROM DimProveedor d WHERE d.nit = :nit"),
    @NamedQuery(name = "DimProveedor.findByNombreEmpresa", query = "SELECT d FROM DimProveedor d WHERE d.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "DimProveedor.findByTelefono", query = "SELECT d FROM DimProveedor d WHERE d.telefono = :telefono")})
public class DimProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_provedor")
    private Integer idProvedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimProveedor")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimProveedor() {
    }

    public DimProveedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public DimProveedor(Integer idProvedor, String correo, String direccion, String municipio, String nit, String nombreEmpresa, String telefono) {
        this.idProvedor = idProvedor;
        this.correo = correo;
        this.direccion = direccion;
        this.municipio = municipio;
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
    }

    public Integer getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (idProvedor != null ? idProvedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimProveedor)) {
            return false;
        }
        DimProveedor other = (DimProveedor) object;
        if ((this.idProvedor == null && other.idProvedor != null) || (this.idProvedor != null && !this.idProvedor.equals(other.idProvedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimProveedor[ idProvedor=" + idProvedor + " ]";
    }
    
}
