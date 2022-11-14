/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniminuto.model;

import com.uniminuto.Entities.DimCategoria;
import com.uniminuto.Entities.DimMarca;
import com.uniminuto.Entities.DimProducto;
import com.uniminuto.VO.DashboardVo;
import java.math.BigDecimal;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class ProductoEJB extends AbstractFacade {

    @PersistenceContext(unitName = "D1DBO_PU")
    private EntityManager em;

    public ProductoEJB() {
    }

    @PostConstruct
    public void init() {

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoEJB(Class EnClass) {
        super(EnClass);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<DimMarca> getMarcas() {
        List<DimMarca> result = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("DimMarca.findAllOrder", DimMarca.class);
            result = query.getResultList();

        } catch (Exception e) {
            System.out.println("Error al consultar ciudades " + e.getMessage());

        }

        return result;

    }

    public List<DimCategoria> getCategorias() {
        List<DimCategoria> result = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("DimCategoria.findAllOrder", DimCategoria.class);
            result = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al consultar ciudades " + e.getMessage());

        }

        return result;

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

    public List<Integer> getMes() {
        List<Integer> meses = new ArrayList<>();
        try {

            Query query = em.createNativeQuery("select DISTINCT mes from DIM_TIEMPO ORDER BY mes;");
            List<Object> result = query.getResultList();
            if (!result.isEmpty()) {
                result.forEach((objects) -> {
                    int mes = (int) objects;               
                    meses.add(mes);
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
            query.setParameter("anio", anio);
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

    public List<DimProducto> getProducts() {
        System.out.println("com.uniminuto.model.ProductoEJB.getProducts()");
        Query query = em.createNamedQuery("DimProducto.findAll");
        return query.getResultList();
    }

}
