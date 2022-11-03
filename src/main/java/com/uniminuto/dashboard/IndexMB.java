/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.dashboard;

import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Miguel
 */
@Named(value = "indexMB")
@ViewScoped
public class IndexMB implements Serializable {

    String user, password;
    
    public IndexMB() {
    }

    @PostConstruct
    public void init() {
      

    }   
    
    public void ingresar(){
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            System.out.println("com.uniminuto.dashboard.IndexMB.ingresar()");
            externalContext.redirect("products.xhtml");
       
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
       
    }
    
}
