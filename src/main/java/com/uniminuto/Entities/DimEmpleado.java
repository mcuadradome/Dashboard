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
@Table(name = "dim_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimEmpleado.findAll", query = "SELECT d FROM DimEmpleado d"),
    @NamedQuery(name = "DimEmpleado.findByIdEmpleado", query = "SELECT d FROM DimEmpleado d WHERE d.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "DimEmpleado.findByDireccion", query = "SELECT d FROM DimEmpleado d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DimEmpleado.findByEmail", query = "SELECT d FROM DimEmpleado d WHERE d.email = :email"),
    @NamedQuery(name = "DimEmpleado.findByEstadoCivil", query = "SELECT d FROM DimEmpleado d WHERE d.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "DimEmpleado.findByFechaNacimiento", query = "SELECT d FROM DimEmpleado d WHERE d.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "DimEmpleado.findByIdentificacion", query = "SELECT d FROM DimEmpleado d WHERE d.identificacion = :identificacion"),
    @NamedQuery(name = "DimEmpleado.findByNombre", query = "SELECT d FROM DimEmpleado d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DimEmpleado.findBySalario", query = "SELECT d FROM DimEmpleado d WHERE d.salario = :salario"),
    @NamedQuery(name = "DimEmpleado.findByTelefono", query = "SELECT d FROM DimEmpleado d WHERE d.telefono = :telefono")})
public class DimEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
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
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
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
    @Column(name = "salario")
    private double salario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimEmpleado")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimEmpleado() {
    }

    public DimEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public DimEmpleado(Integer idEmpleado, String direccion, String email, String estadoCivil, String fechaNacimiento, String identificacion, String nombre, double salario, String telefono) {
        this.idEmpleado = idEmpleado;
        this.direccion = direccion;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.salario = salario;
        this.telefono = telefono;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimEmpleado)) {
            return false;
        }
        DimEmpleado other = (DimEmpleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimEmpleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
