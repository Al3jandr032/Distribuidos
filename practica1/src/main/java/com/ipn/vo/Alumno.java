
package com.ipn.vo;

import java.io.Serializable;
import java.util.Collection;


/**
 *
 * @author alopeze
 */

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idAlumno;
    
    private String nombre;
    
    private String paterno;
    
    private String materno;
    
    private String email;
    
    private String calle;
    
    private String numero;
    
    private String colonia;
    
    private String delegacion;
    
    private String entidad;

    private String noTelefono;
    
    private Collection<Asignacion> asignacionCollection;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String nombre, String paterno, String materno, String email, String calle, String numero, String colonia, String delegacion, String entidad, String noTelefono) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.entidad = entidad;
        this.noTelefono = noTelefono;
    }
    
    public Alumno( String nombre, String paterno, String materno, String email, String calle, String numero, String colonia, String delegacion, String entidad, String noTelefono) {
        
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.entidad = entidad;
        this.noTelefono = noTelefono;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
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
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", email=" + email + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", delegacion=" + delegacion + ", entidad=" + entidad + ", noTelefono=" + noTelefono + ", asignacionCollection=" + asignacionCollection + '}';
    }

    
    
}
