/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Vehicles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor restrepo
 */
@Stateless
public class VehiclesFacade extends AbstractFacade<Vehicles> implements VehiclesFacadeLocal {

    @PersistenceContext(unitName = "ConcesionariowebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiclesFacade() {
        super(Vehicles.class);
    }
    
}
