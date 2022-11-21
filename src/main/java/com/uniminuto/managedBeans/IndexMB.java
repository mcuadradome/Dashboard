/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.managedBeans;

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

    String user="", password="", emailRecovery="", passwordRegister="", email="";
    
    public IndexMB() {
    }

    @PostConstruct
    public void init() {
      

    }   
    
    public String ingresar(){
     
       return  "/protected/products";
        
     
       
    }
    
    public boolean recovery(){
        return true;
    }
    
    
     public String register(){
         return null;
     }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailRecovery() {
        return emailRecovery;
    }

    public void setEmailRecovery(String emailRecovery) {
        this.emailRecovery = emailRecovery;
    }

    public String getPasswordRegister() {
        return passwordRegister;
    }

    public void setPasswordRegister(String passwordRegister) {
        this.passwordRegister = passwordRegister;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
     
     
}
