/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.model;

import com.uniminuto.VO.DashboardVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    
    

}
