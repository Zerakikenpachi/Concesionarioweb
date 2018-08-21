/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Vehicles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor restrepo
 */
@Local
public interface VehiclesFacadeLocal {

    void create(Vehicles vehicles);

    void edit(Vehicles vehicles);

    void remove(Vehicles vehicles);

    Vehicles find(Object id);

    List<Vehicles> findAll();

    List<Vehicles> findRange(int[] range);

    int count();
    
}
