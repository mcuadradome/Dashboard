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
@Table(name = "DIM_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimEmpleado.findAll", query = "SELECT d FROM DimEmpleado d")
    , @NamedQuery(name = "DimEmpleado.findByIdEmpleado", query = "SELECT d FROM DimEmpleado d WHERE d.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "DimEmpleado.findByNombre", query = "SELECT d FROM DimEmpleado d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DimEmpleado.findByIdentificacion", query = "SELECT d FROM DimEmpleado d WHERE d.identificacion = :identificacion")
    , @NamedQuery(name = "DimEmpleado.findByDireccion", query = "SELECT d FROM DimEmpleado d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DimEmpleado.findByTelefono", query = "SELECT d FROM DimEmpleado d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "DimEmpleado.findByEmail", query = "SELECT d FROM DimEmpleado d WHERE d.email = :email")
    , @NamedQuery(name = "DimEmpleado.findByEstadoCivil", query = "SELECT d FROM DimEmpleado d WHERE d.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "DimEmpleado.findByFechaNacimiento", query = "SELECT d FROM DimEmpleado d WHERE d.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "DimEmpleado.findBySalario", query = "SELECT d FROM DimEmpleado d WHERE d.salario = :salario")})
public class DimEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private long salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimEmpleado")
    private List<HechoVentas> hechoVentasList;

    public DimEmpleado() {
    }

    public DimEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public DimEmpleado(Integer idEmpleado, String nombre, String identificacion, String direccion, String telefono, String email, String estadoCivil, String fechaNacimiento, long salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
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
