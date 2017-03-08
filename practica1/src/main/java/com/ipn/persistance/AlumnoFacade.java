
package com.ipn.persistance;

import com.ipn.vo.Alumno;
import java.util.List;

/**
 *
 * @author alopeze
 */
public interface AlumnoFacade  {
    public void create(Alumno a);
    public void update(Alumno a);
    public void remove(Alumno a);
    public Alumno find(int id);
    public List<Alumno> findAll();
}
