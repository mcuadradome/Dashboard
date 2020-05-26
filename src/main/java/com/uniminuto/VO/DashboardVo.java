/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.VO;

import java.math.BigDecimal;

/**
 *
 * @author Miguel
 */
public class DashboardVo {
    
    private String nombreProducto;
    private String nombrePuntoDeVenta;
    private BigDecimal ventasProducto;
    private BigDecimal ventasPunto;
    
    private String nombreProductoTotal;
    private BigDecimal ventalTotales;
      
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombrePuntoDeVenta() {
        return nombrePuntoDeVenta;
    }

    public void setNombrePuntoDeVenta(String nombrePuntoDeVenta) {
        this.nombrePuntoDeVenta = nombrePuntoDeVenta;
    }

    public BigDecimal getVentasProducto() {
        return ventasProducto;
    }

    public void setVentasProducto(BigDecimal ventasProducto) {
        this.ventasProducto = ventasProducto;
    }

    public BigDecimal getVentasPunto() {
        return ventasPunto;
    }

    public void setVentasPunto(BigDecimal ventasPunto) {
        this.ventasPunto = ventasPunto;
    }

    public String getNombreProductoTotal() {
        return nombreProductoTotal;
    }

    public void setNombreProductoTotal(String nombreProductoTotal) {
        this.nombreProductoTotal = nombreProductoTotal;
    }

    public BigDecimal getVentalTotales() {
        return ventalTotales;
    }

    public void setVentalTotales(BigDecimal ventalTotales) {
        this.ventalTotales = ventalTotales;
    }

  
    
    
}
