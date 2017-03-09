package com.ipn.support;

import com.ipn.persistance.AsignacionFacade;
import com.ipn.vo.Asignacion;
import com.ipn.vo.AsignacionPK;
import com.ipn.vo.Curso;
import com.ipn.vo.CursoAlumno;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author alopeze
 */
public class AsignacionImpl extends MysqlDb implements AsignacionFacade{
    private static final String TABLE   = "Asignacion";
    private static final String create  = "{call AsignacionCreate(?,?,?,?)}";
    private static final String delete  = "{call AsignacionDelete(?,?)}";
    private static final String find    = "{call AsignacionFind(?,?)}";
    private static final String update  = "{call AsignacionUpdate(?,?,?,?)}";
    private static final String findAll = "{call AsignacionSelectAll()}";
    private static final String findcursoalumno = "{call listCursoAlumno()}";
    
    public AsignacionImpl(String url, String user, String password) throws ClassNotFoundException, SQLException {
        super(url, user, password);
    }
    
    public AsignacionImpl(Properties p) throws ClassNotFoundException, SQLException{
        super(p.getProperty("connection"),p.getProperty("user"),p.getProperty("pass"));
    }

    @Override
    public void create(Asignacion a) {
        try {
            System.out.println("Creating a new " + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(create);
            this.call.setInt(1, a.getAsignacionPK().getIdAlumno());
            this.call.setInt(2, a.getAsignacionPK().getIdCurso());
            this.call.setString(3, a.getHorario());
            this.call.setInt(4, a.getTipoCurso());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        } finally {
            try {
                this.call.close();
                this.connect.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar conexion");
                System.out.println(ex.getClass());
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
            }
        }
    }

    @Override
    public void update(Asignacion a) {
        try {
            System.out.println("Creating a new " + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(update);
            this.call.setInt(1, a.getAsignacionPK().getIdAlumno());
            this.call.setInt(2, a.getAsignacionPK().getIdCurso());
            this.call.setString(3, a.getHorario());
            this.call.setInt(4, a.getTipoCurso());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        } finally {
            try {
                this.call.close();
                this.connect.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar conexion");
                System.out.println(ex.getClass());
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
            }
        }
    }

    @Override
    public void remove(Asignacion a) {
        try {
            System.out.println("Deleting the fact :" + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(delete);
            this.call.setInt(1, a.getAsignacionPK().getIdAlumno());
            this.call.setInt(2, a.getAsignacionPK().getIdCurso());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        } finally {
            try {
                this.call.close();
                this.connect.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar conexion");
                System.out.println(ex.getClass());
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
            }
        }
    }

    @Override
    public Asignacion find(int id , int id_c) {
        Asignacion aux = null;
        try {
            System.out.println("looking for the :" + id + "asignacion");
            this.getConnection();
            this.call = this.connect.prepareCall(find);
            this.call.setInt(1, id);
            this.call.setInt(2, id_c);
            ResultSet rs = this.call.executeQuery();

            if (rs.next()) {
                aux = new Asignacion(new AsignacionPK(rs.getInt("id_Alumno"),rs.getInt("id_Curso"))
                        ,rs.getString("horario"),rs.getInt("tipoCurso"));
            }
            return aux;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        } finally {
            try {
                this.call.close();
                this.connect.close();
                System.out.println("done");
            } catch (SQLException ex) {
                System.out.println(ex.getClass());
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
            }
        }
        return aux;
    }

    @Override
    public List<Asignacion> findAll() {
        ArrayList<Asignacion> lst = new ArrayList();
        Asignacion aux = null;
        try {
            
            this.getConnection();
            this.call = this.connect.prepareCall(findAll);
            ResultSet rs = this.call.executeQuery(findAll);

            if (rs.next()) {
                aux = new Asignacion(new AsignacionPK(rs.getInt("id_Alumno"),rs.getInt("id_Curso")),rs.getString("horario"),
                rs.getInt("tipoCurso"));
                lst.add(aux);
            }
            return lst;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        } finally {
            try {
                this.call.close();
                this.connect.close();
                System.out.println("done");
            } catch (SQLException ex) {
                System.out.println(ex.getClass());
                System.out.println(ex.getMessage());
                System.out.println(ex.getCause());
            }
        }
        return lst;
    }
    
    public List<CursoAlumno> getListCursoAlumno(){
        
        try {
            ArrayList<CursoAlumno> lst = new ArrayList();
            CursoAlumno cat = null;
            this.getConnection();
            this.call = this.connect.prepareCall(findcursoalumno);
            ResultSet rs = this.call.executeQuery();
            while (rs.next()) {

                cat = new CursoAlumno(rs.getString("alumno"),rs.getInt("id_a"),
                        rs.getString("curso"),rs.getInt("id_c"));
                lst.add(cat);
            }
            return lst;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
        return null;
    }
}
