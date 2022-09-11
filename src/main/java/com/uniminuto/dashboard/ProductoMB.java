
package com.uniminuto.dashboard;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "productoMB")
@ViewScoped
public class ProductoMB implements Serializable {

    public ProductoMB() {
    }
    
     @PostConstruct
    public void init() {
        
    }
    
}
