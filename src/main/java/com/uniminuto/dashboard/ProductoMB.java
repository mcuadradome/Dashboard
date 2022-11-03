
package com.uniminuto.dashboard;

import com.uniminuto.Entities.DimProducto;
import com.uniminuto.VO.DashboardVo;
import com.uniminuto.model.IndexEJB;
import com.uniminuto.model.ProductoEJB;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Miguel
 */
@Named(value = "productoMB")
@ViewScoped
public class ProductoMB implements Serializable {

    private PieChartModel pieModel1;
    private BarChartModel barModel;

    private Date date;
    private String age;
    private String city;
    private String month;
    private List<String> ciudades = new ArrayList<>();
    private List<String> años = new ArrayList<>();
    private List<String> meses = new ArrayList<>();

    private Map<String, String> ciudadesMap = new LinkedHashMap<>();
    private Map<String, String> añosMap = new LinkedHashMap<>();
    private Map<String, String> mesesMap = new LinkedHashMap<>();
    private boolean isRedendered;
    private List<DashboardVo> dashboards = new ArrayList<>();
    private List<DimProducto> products = new ArrayList<>();
    private DimProducto selectedProduct;
    private List<DimProducto> selectedProducts;
    
    @EJB
    ProductoEJB productoEJB;

    public ProductoMB() {
    }

    @PostConstruct
    public void init() {
        isRedendered=false;
        ciudades = productoEJB.getCiudades();
        años = productoEJB.getAnio();
        meses = productoEJB.getMes();
        System.out.println("Tamaños " + ciudades.size() + años.size() + meses.size());
        for (String ciudade : ciudades) {
            ciudadesMap.put(ciudade, ciudade);
        }

        for (String age : años) {
            añosMap.put(age, age);
        }

        for (String month : meses) {
            //int numberMonth = Integer.parseInt(month);
            //String nameMonth = getMonth(numberMonth+1);
            mesesMap.put(month, month);
        }

    }
    
       public String getMonth(int month) {
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"};
        return monthNames[month];
    }

    public void buscar() {
        
        try {
            
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //String newFecha = formatter.format(date);
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (age == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Año es requerido"));
            return;
        }

        if (month == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Mes es requerido"));
            return;
        }
        
        System.out.println("Filtros consulta " + age +" "+ month);
      
        if (city != null) {           
            dashboards = productoEJB.getData(age, month, city);
        } else{
            dashboards = productoEJB.getData(age, month, null);
        }
            if(!dashboards.isEmpty()){
               isRedendered=true;
                createPieModel1();
                createBarModel();
            }
            
        } catch (Exception e) {
            System.err.println("com.uniminuto.dashboard.IndexMB.buscar()" + e.getMessage());
        }

       
        
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        pieModel1.setTitle("Productos con mayor venta");
        //pieModel1.setLegendPosition("c");
        pieModel1.setFill(true);
        for (DashboardVo obj : dashboards) {
            pieModel1.set(obj.getNombreProducto(), obj.getVentasProducto());
        }
    }
    
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Venta por puntos");
        barModel.setLegendPosition("ne");
        barModel.setAnimate(true);
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Punto de venta");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Venta");
        yAxis.setMin(0);
        BigDecimal max = BigDecimal.valueOf(1000);
        yAxis.setMax(dashboards.get(0).getVentasProducto().add(max));
    }
    
     private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries pVenta = new ChartSeries();
        pVenta.setLabel("Ciudad");
        
         for (DashboardVo obj : dashboards) {
             String nombre = obj.getNombrePuntoDeVenta().substring(0, 3);
             pVenta.set(nombre, obj.getVentasProducto());
           
        }            
        model.addSeries(pVenta);
 
        return model;
    }
     
         
     public void openNew() {
        this.selectedProduct = new DimProducto();
    }

    public void saveProduct() {
        if (this.selectedProduct.getIdProducto() == null) {
            this.products.add(this.selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Creado"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.products.remove(this.selectedProduct);
        this.selectedProducts.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedProducts() {
        return this.selectedProducts != null && !this.selectedProducts.isEmpty();
    }

    public void deleteSelectedProducts() {
        this.products.removeAll(this.selectedProducts);
        this.selectedProducts = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
    
    

     
     

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<String> ciudades) {
        this.ciudades = ciudades;
    }

    public List<String> getAños() {
        return años;
    }

    public void setAños(List<String> años) {
        this.años = años;
    }

    public List<String> getMeses() {
        return meses;
    }

    public void setMeses(List<String> meses) {
        this.meses = meses;
    }

    public Map<String, String> getCiudadesMap() {
        return ciudadesMap;
    }

    public void setCiudadesMap(Map<String, String> ciudadesMap) {
        this.ciudadesMap = ciudadesMap;
    }

    public Map<String, String> getAñosMap() {
        return añosMap;
    }

    public void setAñosMap(Map<String, String> añosMap) {
        this.añosMap = añosMap;
    }

    public Map<String, String> getMesesMap() {
        return mesesMap;
    }

    public void setMesesMap(Map<String, String> mesesMap) {
        this.mesesMap = mesesMap;
    }

    public List<DashboardVo> getDashboards() {
        return dashboards;
    }

    public void setDashboards(List<DashboardVo> dashboards) {
        this.dashboards = dashboards;
    }

    public boolean isIsRedendered() {
        return isRedendered;
    }

    public void setIsRedendered(boolean isRedendered) {
        this.isRedendered = isRedendered;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public List<DimProducto> getProducts() {
        return products;
    }

    public void setProducts(List<DimProducto> products) {
        this.products = products;
    }

    public DimProducto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(DimProducto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<DimProducto> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<DimProducto> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }
    

    
}
