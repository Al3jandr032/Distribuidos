package com.ipn.vo;

import java.io.Serializable;

/**
 *
 * @author alopeze
 */

public class AsignacionPK implements Serializable {

    
    private int idAlumno;
    
    private int idCurso;

    public AsignacionPK() {
    }

    public AsignacionPK(int idAlumno, int idCurso) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlumno;
        hash += (int) idCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPK)) {
            return false;
        }
        AsignacionPK other = (AsignacionPK) object;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AsignacionPK{" + "idAlumno=" + idAlumno + ", idCurso=" + idCurso + '}';
    }

    
    
}
