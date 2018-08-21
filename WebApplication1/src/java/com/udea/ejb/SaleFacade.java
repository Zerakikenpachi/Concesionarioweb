/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Sale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor restrepo
 */
@Stateless
public class SaleFacade extends AbstractFacade<Sale> implements SaleFacadeLocal {

    @PersistenceContext(unitName = "ConcesionariowebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaleFacade() {
        super(Sale.class);
    }
    
}
