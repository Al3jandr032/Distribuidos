/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.persistance;

import com.ipn.vo.Asignacion;
import java.util.List;

/**
 *
 * @author alopeze
 */
public interface AsignacionFacade {
    public void create(Asignacion a);
    public void update(Asignacion a);
    public void remove(Asignacion a);
    public Asignacion find(int id , int id_c);
    public List<Asignacion> findAll();
}
