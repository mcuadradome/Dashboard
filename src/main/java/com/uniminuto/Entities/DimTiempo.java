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
@Table(name = "dim_tiempo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimTiempo.findAll", query = "SELECT d FROM DimTiempo d"),
    @NamedQuery(name = "DimTiempo.findByIdTiempo", query = "SELECT d FROM DimTiempo d WHERE d.idTiempo = :idTiempo"),
    @NamedQuery(name = "DimTiempo.findByAnio", query = "SELECT d FROM DimTiempo d WHERE d.anio = :anio"),
    @NamedQuery(name = "DimTiempo.findByDia", query = "SELECT d FROM DimTiempo d WHERE d.dia = :dia"),
    @NamedQuery(name = "DimTiempo.findByMes", query = "SELECT d FROM DimTiempo d WHERE d.mes = :mes"),
    @NamedQuery(name = "DimTiempo.findBySemana", query = "SELECT d FROM DimTiempo d WHERE d.semana = :semana"),
    @NamedQuery(name = "DimTiempo.findByTrimestre", query = "SELECT d FROM DimTiempo d WHERE d.trimestre = :trimestre"),
    @NamedQuery(name = "DimTiempo.findByFecha", query = "SELECT d FROM DimTiempo d WHERE d.fecha = :fecha")})
public class DimTiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tiempo")
    private Integer idTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    private int dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    private int mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semana")
    private int semana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trimestre")
    private int trimestre;
    @Size(max = 2147483647)
    @Column(name = "fecha")
    private String fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimTiempo")
    private Collection<HechoVentas> hechoVentasCollection;

    public DimTiempo() {
    }

    public DimTiempo(Integer idTiempo) {
        this.idTiempo = idTiempo;
    }

    public DimTiempo(Integer idTiempo, int anio, int dia, int mes, int semana, int trimestre) {
        this.idTiempo = idTiempo;
        this.anio = anio;
        this.dia = dia;
        this.mes = mes;
        this.semana = semana;
        this.trimestre = trimestre;
    }

    public Integer getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(Integer idTiempo) {
        this.idTiempo = idTiempo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        hash += (idTiempo != null ? idTiempo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DimTiempo)) {
            return false;
        }
        DimTiempo other = (DimTiempo) object;
        if ((this.idTiempo == null && other.idTiempo != null) || (this.idTiempo != null && !this.idTiempo.equals(other.idTiempo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.DimTiempo[ idTiempo=" + idTiempo + " ]";
    }
    
}
