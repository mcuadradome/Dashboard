/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "HECHO_VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HechoVentas.findAll", query = "SELECT h FROM HechoVentas h")
    , @NamedQuery(name = "HechoVentas.findById", query = "SELECT h FROM HechoVentas h WHERE h.id = :id")
    , @NamedQuery(name = "HechoVentas.findByDimCategoria", query = "SELECT h FROM HechoVentas h WHERE h.dimCategoria = :dimCategoria")
    , @NamedQuery(name = "HechoVentas.findByDimMarca", query = "SELECT h FROM HechoVentas h WHERE h.dimMarca = :dimMarca")
    , @NamedQuery(name = "HechoVentas.findByUnidades", query = "SELECT h FROM HechoVentas h WHERE h.unidades = :unidades")
    , @NamedQuery(name = "HechoVentas.findByPrecio", query = "SELECT h FROM HechoVentas h WHERE h.precio = :precio")})
public class HechoVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dim_categoria")
    private int dimCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dim_marca")
    private int dimMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;
    @JoinColumn(name = "dim_almacen", referencedColumnName = "id_almacen")
    @ManyToOne(optional = false)
    private DimAlmacen dimAlmacen;
    @JoinColumn(name = "dim_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private DimCliente dimCliente;
    @JoinColumn(name = "dim_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private DimEmpleado dimEmpleado;
    @JoinColumn(name = "dim_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private DimProducto dimProducto;
    @JoinColumn(name = "dim_promocion", referencedColumnName = "id_promocion")
    @ManyToOne(optional = false)
    private DimPromocion dimPromocion;
    @JoinColumn(name = "dim_proveedor", referencedColumnName = "id_provedor")
    @ManyToOne(optional = false)
    private DimProveedor dimProveedor;
    @JoinColumn(name = "dim_tiempo", referencedColumnName = "id_tiempo")
    @ManyToOne(optional = false)
    private DimTiempo dimTiempo;

    public HechoVentas() {
    }

    public HechoVentas(Integer id) {
        this.id = id;
    }

    public HechoVentas(Integer id, int dimCategoria, int dimMarca, int unidades, long precio) {
        this.id = id;
        this.dimCategoria = dimCategoria;
        this.dimMarca = dimMarca;
        this.unidades = unidades;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDimCategoria() {
        return dimCategoria;
    }

    public void setDimCategoria(int dimCategoria) {
        this.dimCategoria = dimCategoria;
    }

    public int getDimMarca() {
        return dimMarca;
    }

    public void setDimMarca(int dimMarca) {
        this.dimMarca = dimMarca;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public DimAlmacen getDimAlmacen() {
        return dimAlmacen;
    }

    public void setDimAlmacen(DimAlmacen dimAlmacen) {
        this.dimAlmacen = dimAlmacen;
    }

    public DimCliente getDimCliente() {
        return dimCliente;
    }

    public void setDimCliente(DimCliente dimCliente) {
        this.dimCliente = dimCliente;
    }

    public DimEmpleado getDimEmpleado() {
        return dimEmpleado;
    }

    public void setDimEmpleado(DimEmpleado dimEmpleado) {
        this.dimEmpleado = dimEmpleado;
    }

    public DimProducto getDimProducto() {
        return dimProducto;
    }

    public void setDimProducto(DimProducto dimProducto) {
        this.dimProducto = dimProducto;
    }

    public DimPromocion getDimPromocion() {
        return dimPromocion;
    }

    public void setDimPromocion(DimPromocion dimPromocion) {
        this.dimPromocion = dimPromocion;
    }

    public DimProveedor getDimProveedor() {
        return dimProveedor;
    }

    public void setDimProveedor(DimProveedor dimProveedor) {
        this.dimProveedor = dimProveedor;
    }

    public DimTiempo getDimTiempo() {
        return dimTiempo;
    }

    public void setDimTiempo(DimTiempo dimTiempo) {
        this.dimTiempo = dimTiempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HechoVentas)) {
            return false;
        }
        HechoVentas other = (HechoVentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.HechoVentas[ id=" + id + " ]";
    }
    
}
