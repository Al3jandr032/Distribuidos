package com.ipn.support;

import com.ipn.persistance.AlumnoFacade;
import com.ipn.vo.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author alopeze
 */
public class AlumnoImpl extends MysqlDb implements AlumnoFacade{
    private static final String TABLE = "Alumno";
    private static final String create = "{call alumnoCreate(?,?,?,?,?,?,?,?,?,?)}";
    private static final String delete = "{call alumnoDelete(?)}";
    private static final String find = "{call alumnoFind(? )}";
    private static final String update = "{call alumnoUpdate(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String findAll = "{call alumnoSelectAll()}";

    public AlumnoImpl(String url, String user, String password) throws ClassNotFoundException, SQLException {
        super(url, user, password);
    }

    public AlumnoImpl(Properties p) throws ClassNotFoundException, SQLException {
        super(p.getProperty("connection"),p.getProperty("user"),p.getProperty("pass"));
    }

    @Override
    public void create(Alumno a) {
        try {
            System.out.println("Creating a new "+ a +"in database");
            this.getConnection();
            this.call = this.connect.prepareCall(create);
            this.call.setString(1, a.getNombre());
            this.call.setString(2, a.getPaterno());
            this.call.setString(3, a.getMaterno());
            this.call.setString(4, a.getEmail());
            this.call.setString(5, a.getCalle());
            this.call.setString(6, a.getNumero());
            this.call.setString(7, a.getColonia());
            this.call.setString(8, a.getDelegacion());
            this.call.setString(9, a.getEntidad());
            this.call.setString(10, a.getNoTelefono());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error añ insertar");
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());

        }finally{
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
    public void update(Alumno a) {
         try {
            this.getConnection();
            this.call = this.connect.prepareCall(update);
            this.call.setInt(1, a.getIdAlumno());
            this.call.setString(2, a.getNombre());
            this.call.setString(3, a.getPaterno());
            this.call.setString(4, a.getMaterno());
            this.call.setString(5, a.getEmail());
            this.call.setString(6, a.getCalle());
            this.call.setString(7, a.getNumero());
            this.call.setString(8, a.getColonia());
            this.call.setString(9, a.getDelegacion());
            this.call.setString(10, a.getEntidad());
            this.call.setString(11, a.getNoTelefono());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }finally{
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
    }

    @Override
    public void remove(Alumno a) {
        try {
            System.out.println("Deleting the fact :" + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(delete);
            this.call.setInt(1, a.getIdAlumno());
            this.call.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error al borrar alumno"+a.getIdAlumno());
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
    public Alumno find(int id) {
        Alumno aux = null;
        try {
            System.out.println("looking for the :" + id + "fact");
            this.getConnection();
            this.call = this.connect.prepareCall(find);
            this.call.setInt(1, id);
            ResultSet rs = this.call.executeQuery();

            if (rs.next()) {
                aux = new Alumno(rs.getInt("id_Alumno"),
                        rs.getString("nombre"),
                        rs.getString("paterno"),
                        rs.getString("materno"),
                        rs.getString("email"),
                        rs.getString("calle"),
                        rs.getString("numero"),
                        rs.getString("colonia"),
                        rs.getString("delegacion"),
                        rs.getString("entidad"),
                        rs.getString("noTelefono"));
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
    public List<Alumno> findAll() {
        try {
            ArrayList<Alumno> lst = new ArrayList();
            Alumno cat = null;
            this.getConnection();
            this.call = this.connect.prepareCall(findAll);
            ResultSet rs = this.call.executeQuery(findAll);
            while (rs.next()) {

                cat = new Alumno(rs.getInt("id_Alumno"),
                        rs.getString("nombre"),
                        rs.getString("paterno"),
                        rs.getString("materno"),
                        rs.getString("email"),
                        rs.getString("calle"),
                        rs.getString("numero"),
                        rs.getString("colonia"),
                        rs.getString("delegacion"),
                        rs.getString("entidad"),
                        rs.getString("noTelefono"));
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
    public static void main(String[] args){
        try {
            Properties p = new Properties();
            p.setProperty("connection", "jdbc:mysql://maquinavirtual/practica1");
            p.setProperty("user", "debian");
            p.setProperty("pass", "debianpass");
            AlumnoImpl dao = new AlumnoImpl(p);
            for(Alumno a : dao.findAll()){
                System.out.println(a);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
       
    }

   
    
    
}
