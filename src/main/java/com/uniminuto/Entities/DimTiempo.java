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
@Table(name = "DIM_TIEMPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DimTiempo.findAll", query = "SELECT d FROM DimTiempo d")
    , @NamedQuery(name = "DimTiempo.findByIdTiempo", query = "SELECT d FROM DimTiempo d WHERE d.idTiempo = :idTiempo")
    , @NamedQuery(name = "DimTiempo.findByFecha", query = "SELECT d FROM DimTiempo d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "DimTiempo.findByAnio", query = "SELECT d FROM DimTiempo d WHERE d.anio = :anio")
    , @NamedQuery(name = "DimTiempo.findByTrimestre", query = "SELECT d FROM DimTiempo d WHERE d.trimestre = :trimestre")
    , @NamedQuery(name = "DimTiempo.findByMes", query = "SELECT d FROM DimTiempo d WHERE d.mes = :mes")
    , @NamedQuery(name = "DimTiempo.findBySemana", query = "SELECT d FROM DimTiempo d WHERE d.semana = :semana")
    , @NamedQuery(name = "DimTiempo.findByDia", query = "SELECT d FROM DimTiempo d WHERE d.dia = :dia")})
public class DimTiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tiempo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    private Integer idTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trimestre")
    private int trimestre;
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
    @Column(name = "dia")
    private int dia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dimTiempo")
    private List<HechoVentas> hechoVentasList;

    public DimTiempo() {
    }

    public DimTiempo(Integer idTiempo) {
        this.idTiempo = idTiempo;
    }

    public DimTiempo(Integer idTiempo, String fecha, int anio, int trimestre, int mes, int semana, int dia) {
        this.idTiempo = idTiempo;
        this.fecha = fecha;
        this.anio = anio;
        this.trimestre = trimestre;
        this.mes = mes;
        this.semana = semana;
        this.dia = dia;
    }

    public Integer getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(Integer idTiempo) {
        this.idTiempo = idTiempo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
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
