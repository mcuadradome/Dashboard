package com.uniminuto.managedBeans;

import com.uniminuto.Entities.DimProducto;
import com.uniminuto.VO.DashboardVo;
import com.uniminuto.model.IndexEJB;
import com.uniminuto.model.ProductoEJB;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
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
    private List<String> years = new ArrayList<>();
    private List<Integer> meses = new ArrayList<>();

    private Map<String, String> ciudadesMap = new LinkedHashMap<>();
    private Map<String, String> yearsMap = new LinkedHashMap<>();
    private Map<Integer, String> mesesMap = new LinkedHashMap<>();
    private boolean isRedendered;
    private List<DashboardVo> dashboards = new ArrayList<>();
    private List<DimProducto> products = new ArrayList<>();
    private DimProducto selectedProduct;
    private List<DimProducto> selectedProducts;
    
//    NumberFormat usdCostFormat;

    @EJB
    ProductoEJB productoEJB;

    public ProductoMB() {
    }

    @PostConstruct
    public void init() {
        Locale locale = new Locale("es","CO");
        
//        usdCostFormat = NumberFormat.getCurrencyInstance(locale);
//        usdCostFormat.setMinimumFractionDigits( 1 );
//        usdCostFormat.setMaximumFractionDigits( 2 );
    
        isRedendered = false;
        ciudades = productoEJB.getCiudades();
        years = productoEJB.getAnio();
        meses = productoEJB.getMes();

        for (String ciudade : ciudades) {
            ciudadesMap.put(ciudade, ciudade);
        }

        years.forEach((ages) -> {
            yearsMap.put(ages, ages);
        });

        meses.forEach((value) -> {
            mesesMap.put(value, Month.of(value).getDisplayName(TextStyle.FULL, locale));
        });
        
        onLoadProducts();

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

            System.out.println("Filtros consulta " + age + " " + month);

            if (city != null) {
                dashboards = productoEJB.getData(age, month, city);
            } else {
                dashboards = productoEJB.getData(age, month, null);
            }
            if (!dashboards.isEmpty()) {
                isRedendered = true;
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
//            String val= usdCostFormat.format(obj.getVentasProducto().doubleValue());
            pieModel1.set(obj.getNombreProducto(), obj.getVentasProducto().doubleValue());
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

    public void onLoadProducts() {
        products = productoEJB.getProducts();
        System.out.println("Load products " + products.size());
    }

    public void openNew() {
        this.selectedProduct = new DimProducto();
    }

    public void saveProduct() {
        if (this.selectedProduct.getIdProducto() == null) {
            this.products.add(this.selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Creado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteProduct() {
        this.products.remove(this.selectedProduct);
        this.selectedProducts.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " productos seleccionados" : "1 producto seleccionado";
        }

        return "Eliminar";
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


    public List<Integer> getMeses() {
        return meses;
    }

    public void setMeses(List<Integer> meses) {
        this.meses = meses;
    }

    public Map<String, String> getCiudadesMap() {
        return ciudadesMap;
    }

    public void setCiudadesMap(Map<String, String> ciudadesMap) {
        this.ciudadesMap = ciudadesMap;
    }

    public Map<Integer, String> getMesesMap() {
        return mesesMap;
    }

    public void setMesesMap(Map<Integer, String> mesesMap) {
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

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public Map<String, String> getYearsMap() {
        return yearsMap;
    }

    public void setYearsMap(Map<String, String> yearsMap) {
        this.yearsMap = yearsMap;
    }
    
    

}
