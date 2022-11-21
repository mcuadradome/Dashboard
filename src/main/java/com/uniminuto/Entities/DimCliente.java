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
@Table(name = "dim_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimCliente.findAll", query = "SELECT d FROM DimCliente d"),
    @NamedQuery(name = "DimCliente.findByIdCliente", query = "SELECT d FROM DimCliente d WHERE d.idCliente = :idCliente"),
    @NamedQuery(name = "DimCliente.findByCiudad", query = "SELECT d FROM DimCliente d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DimCliente.findByDireccion", query = "SELECT d FROM DimCliente d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DimCliente.findByEmail", query = "SELECT d FROM DimCliente d WHERE d.email = :email"),
    @NamedQuery(name = "DimCliente.findByFechaRegistro", query = "SELECT d FROM DimCliente d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "DimCliente.findByIdentificacion", query = "SELECT d FROM DimCliente d WHERE d.identificacion = :identificacion"),
    @NamedQuery(name = "DimCliente.findByNombre", query = "SELECT d FROM DimCliente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DimCliente.findByTelefono", query = "SELECT d FROM DimCliente d WHERE d.telefono = :telefono")})
public class DimCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimCliente")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimCliente() {
    }

    public DimCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public DimCliente(Integer idCliente, String ciudad, String direccion, String email, Date fechaRegistro, String identificacion, String nombre, String telefono) {
        this.idCliente = idCliente;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimCliente)) {
            return false;
        }
        DimCliente other = (DimCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimCliente[ idCliente=" + idCliente + " ]";
    }
    
}
