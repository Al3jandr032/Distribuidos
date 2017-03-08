package com.ipn.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author alopeze
 */

public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idCurso;
    
    private String nombre;
   
    
    private Date inicio;
    
    private Date fin;
    
    private BigDecimal coutaDeRecuperacion;
   
    private Collection<Asignacion> asignacionCollection;

    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Integer idCurso, String nombre, Date inicio, Date fin, BigDecimal coutaDeRecuperacion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.coutaDeRecuperacion = coutaDeRecuperacion;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

   

    public BigDecimal getCoutaDeRecuperacion() {
        return coutaDeRecuperacion;
    }

    public void setCoutaDeRecuperacion(BigDecimal coutaDeRecuperacion) {
        this.coutaDeRecuperacion = coutaDeRecuperacion;
    }

    public Collection<Asignacion> getAsignacionCollection() {
        return asignacionCollection;
    }

    public void setAsignacionCollection(Collection<Asignacion> asignacionCollection) {
        this.asignacionCollection = asignacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombre=" + nombre + ", inicio=" + inicio + ", fin=" + fin + ", coutaDeRecuperacion=" + coutaDeRecuperacion + ", asignacionCollection=" + asignacionCollection + '}';
    }

    
    
}
