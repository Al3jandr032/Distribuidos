
package com.ipn.vo;

import java.io.Serializable;

/**
 *
 * @author alopeze
 */

public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    protected AsignacionPK asignacionPK;
 
    private String horario;
    
    private int tipoCurso;
    
    private Alumno alumno;
    
    private Curso curso;

    public Asignacion() {
    }

    public Asignacion(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    public Asignacion(AsignacionPK asignacionPK, String horario, int tipoCurso) {
        this.asignacionPK = asignacionPK;
        this.horario = horario;
        this.tipoCurso = tipoCurso;
    }

    public Asignacion(int idAlumno, int idCurso) {
        this.asignacionPK = new AsignacionPK(idAlumno, idCurso);
    }

    public AsignacionPK getAsignacionPK() {
        return asignacionPK;
    }

    public void setAsignacionPK(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(int tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionPK != null ? asignacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.asignacionPK == null && other.asignacionPK != null) || (this.asignacionPK != null && !this.asignacionPK.equals(other.asignacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "asignacionPK=" + asignacionPK + ", horario=" + horario + ", tipoCurso=" + tipoCurso + ", alumno=" + alumno + ", curso=" + curso + '}';
    }

    
    
}
