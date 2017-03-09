package com.ipn.vo;

import java.io.Serializable;

/**
 *
 * @author alopeze
 */
public class CursoAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombreAlumno;
    private int alumnoID;
    private String nombreCurso;
    private int cursoID;

    public CursoAlumno(String nombreAlumno, int alumnoID, String nombreCurso, int cursoID) {
        this.nombreAlumno = nombreAlumno;
        this.alumnoID = alumnoID;
        this.nombreCurso = nombreCurso;
        this.cursoID = cursoID;
    }

    

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoID = alumnoID;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }
    
    
}
