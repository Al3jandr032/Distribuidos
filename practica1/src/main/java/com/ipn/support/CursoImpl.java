package com.ipn.support;

import com.ipn.persistance.CursoFacade;
import com.ipn.vo.Curso;
import java.math.BigDecimal;
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
public class CursoImpl extends MysqlDb implements CursoFacade{
    private static final String TABLE = "Curso";
    private static final String create = "{call cursoCreate(?,?,?,?)}";
    private static final String delete = "{call cursoDelete(?)}";
    private static final String find = "{call cursoFind(? )}";
    private static final String update = "{call cursoUpdate(?,?,?,?,?)}";
    private static final String findAll = "{call cursoSelectAll()}";
    
    public CursoImpl(String url, String user, String password) throws ClassNotFoundException, SQLException {
        super(url, user, password);
    }
    
    public CursoImpl(Properties p)throws ClassNotFoundException, SQLException{
        super(p.getProperty("connection"),p.getProperty("user"),p.getProperty("pass"));
        
    }

    @Override
    public void create(Curso a) {
          try {
            System.out.println("Creating a new " + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(create);
            this.call.setString(1, a.getNombre());
            this.call.setDate(2, (Date) a.getInicio());
            this.call.setDate(3, (Date) a.getFin());
            this.call.setBigDecimal(4, a.getCoutaDeRecuperacion());
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
    public void update(Curso a) {
        try {
            this.getConnection();
            this.call = this.connect.prepareCall(update);
            this.call.setInt(1, a.getIdCurso());
            this.call.setString(2, a.getNombre());
            this.call.setDate(3, (Date) a.getInicio());
            this.call.setDate(4, (Date) a.getFin());
            this.call.setBigDecimal(5, a.getCoutaDeRecuperacion());
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
    public void remove(Curso a) {
        try {
            System.out.println("Deleting the fact :" + a + "in database");
            this.getConnection();
            this.call = this.connect.prepareCall(delete);
            this.call.setInt(1, a.getIdCurso());
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
    public Curso find(int id) {
        Curso aux = null;
        try {
            System.out.println("lokking for the :" + id + "fact");
            this.getConnection();
            this.call = this.connect.prepareCall(find);
            this.call.setInt(1, id);
            ResultSet rs = this.call.executeQuery();

            if (rs.next()) {
                aux = new Curso(rs.getInt("id_Curso"),rs.getString("nombre"),rs.getDate("fechaInicio"),
                rs.getDate("fechaFin"), rs.getBigDecimal("coutaDeRecuperacion"));
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
    public List<Curso> findAll() {
       try {
            ArrayList<Curso> lst = new ArrayList();
            Curso cat = null;
            this.getConnection();
            this.call = this.connect.prepareCall(findAll);
            ResultSet rs = this.call.executeQuery(findAll);
            while (rs.next()) {

                cat = new Curso(rs.getInt("id_Curso"),rs.getString("nombre"),rs.getDate("fechaInicio"),
                rs.getDate("fechaFin"), rs.getBigDecimal("coutaDeRecuperacion"));
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
            p.setProperty("connection", "jdbc:mysql://localhost/practica1");
            p.setProperty("user", "aletz");
            p.setProperty("pass", "aletz");
            CursoImpl dao = new CursoImpl(p);
            for(Curso a : dao.findAll()){
                System.out.println(a);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
       
    }
    
}
