/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.model;

import com.uniminuto.VO.DashboardVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Miguel
 */
@Stateless
public class IndexEJB extends AbstractFacade {

    @PersistenceContext(unitName = "D1DBO_PU")
    private EntityManager em;

    public IndexEJB() {
    }

    @PostConstruct
    public void init() {

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndexEJB(Class EnClass) {
        super(EnClass);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<String> getCiudades() {
        List<String> ciudad = new ArrayList<>();
        try {

            Query query = em.createNativeQuery("select DISTINCT ciudad from DIM_ALMACEN order by ciudad;");

            List<Object> result = query.getResultList();
            if (!result.isEmpty()) {

                for (Object objects : result) {
                    ciudad.add((String) objects);
                }
            }
            System.out.println("valor " + ciudad.size());
        } catch (Exception e) {
            System.out.println("Error al consultar ciudades " + e.getMessage());
        }
        return ciudad;
    }

    public List<String> getAnio() {
        List<String> anios = new ArrayList<>();
        try {

            Query query = em.createNativeQuery("select DISTINCT anio from DIM_TIEMPO ORDER BY anio DESC;");

            List<Object> result = query.getResultList();
            if (!result.isEmpty()) {
                for (Object objects : result) {
                    int anio = (int) objects;
                    anios.add(String.valueOf(anio));
                }
            }

            System.out.println("valor " + anios.size());
        } catch (Exception e) {
            System.out.println("Error al consultar Años " + e.getMessage());
        }
        return anios;
    }

    public List<String> getMes() {
        List<String> meses = new ArrayList<>();
        try {

            Query query = em.createNativeQuery("select DISTINCT mes from DIM_TIEMPO ORDER BY mes;");

            List<Object> result = query.getResultList();
            if (!result.isEmpty()) {
                result.forEach((objects) -> {
                    int mes = (int) objects;
                    meses.add(String.valueOf(mes));
                });
            }

            System.out.println("valor " + meses.size());
        } catch (Exception e) {
            System.out.println("Error al consultar Meses " + e.getMessage());
        }
        return meses;
    }

    public List<DashboardVo> getData(String anio, String mes, String ciudad) {
        
        System.out.println("Entro get data");
        List<DashboardVo> dashboardVos = new ArrayList<>();
        String sql;
        boolean isFecha = false;

        try {

            sql = "SELECT dp.nombre, SUM(hv.unidades*hv.precio) ventasPro, da.ciudad\n"
                    + "FROM HECHO_VENTAS hv INNER JOIN DIM_ALMACEN da ON hv.dim_almacen=da.id_almacen\n"
                    + "INNER JOIN DIM_CLIENTE dc ON hv.dim_cliente=dc.id_cliente							 \n"
                    + "INNER JOIN DIM_PRODUCTO dp ON hv.dim_producto=dp.id_producto							\n"
                    + "INNER JOIN DIM_TIEMPO dt ON hv.dim_tiempo=dt.id_tiempo\n";

            if (ciudad == null) {
                isFecha = true;
                sql += "WHERE dt.mes= CAST( :mes  AS INTEGER) AND dt.anio= CAST( :anio AS INTEGER) GROUP BY dp.nombre, da.ciudad ORDER BY ventasPro DESC";
            } else {
                sql += "WHERE dt.mes= CAST(:mes  AS INTEGER) AND dt.anio= CAST( :anio AS INTEGER) and da.ciudad=:ciudad  GROUP BY dp.nombre, da.ciudad ORDER BY ventasPro DESC";
            }
            
            System.out.println("sql " + sql);
            Query query = em.createNativeQuery(sql);
            query.setParameter("mes", mes);
            query.setParameter("anio",anio);
            if (!isFecha) {
                query.setParameter("ciudad", ciudad);
            }
            System.out.println("query " + query.toString());
            
            //retorna la primera consulta
            List<Object[]> result = query.getResultList();
            System.out.println("resutl " + result.size());
            if (!result.isEmpty()) {
                for (Object[] objects : result) {
                    DashboardVo dashboardVo = new DashboardVo();

                    dashboardVo.setNombreProducto((String) objects[0]);
                    dashboardVo.setVentasProducto(new BigDecimal(objects[1].toString()));
                    dashboardVo.setNombrePuntoDeVenta((String) objects[2]);

                    BigDecimal num = new BigDecimal(objects[1].toString());

                    dashboardVo.setVentalTotales(dashboardVo.getVentasProducto().add(num));
                    dashboardVo.setNombreProductoTotal((String) objects[0]);

                    dashboardVos.add(dashboardVo);
                }
            }

        } catch (Exception e) {
            System.out.println("Error consultando data " + e.getMessage());
        }

        return dashboardVos;
    }

 

    public List<Object[]> getDataAlmacen(String anio, String mes, String ciudad) {

        String sql;
        boolean isFecha = false;

        try {

            sql = "select dp.nombre, SUM(hv.unidades*hv.precio) ventasPro\n"
                    + "		  \n"
                    + " from HECHO_VENTAS hv INNER JOIN DIM_ALMACEN da ON hv.dim_almacen=da.id_almacen\n"
                    + " INNER JOIN DIM_CLIENTE dc ON hv.dim_cliente=dc.id_cliente							 \n"
                    + "INNER JOIN DIM_PRODUCTO dp ON hv.dim_producto=dp.id_producto							\n"
                    + " INNER JOIN DIM_TIEMPO dt ON hv.dim_tiempo=dt.id_tiempo\n";

            if (ciudad == null) {
                isFecha = true;
                sql += "WHERE dt.mes= CAST( :mes  AS INTEGER) AND dt.anio= CAST( :anio  AS INTEGER)  GROUP BY dp.nombre, da.ciudad ORDER BY ventasPro DESC";
            } else {
                sql += "WHERE dt.mes= CAST( :mes  AS INTEGER) AND dt.anio= CAST( :anio  AS INTEGER) and da.ciudad0 :ciudad  GROUP BY dp.nombre, da.ciudad ORDER BY ventasPro DESC";
            }

            Query query = em.createNativeQuery(sql);
            query.setParameter("mes", mes);
            query.setParameter("anio", anio);
            if (!isFecha) {
                query.setParameter("ciudad", ciudad);
            }

            //retorna la primera consulta
            List<Object[]> result = query.getResultList();
            return result;

        } catch (Exception e) {
            System.out.println("Error consultando data Almacen " + e.getMessage());
        }

        return null;
    }
    

}
