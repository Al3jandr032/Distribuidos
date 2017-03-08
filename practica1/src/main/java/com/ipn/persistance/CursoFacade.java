/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.persistance;

import com.ipn.vo.Curso;
import java.util.List;

/**
 *
 * @author alopeze
 */
public interface CursoFacade {
    public void create(Curso a);
    public void update(Curso a);
    public void remove(Curso a);
    public Curso find(int id);
    public List<Curso> findAll();
}
