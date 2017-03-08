package com.ipn.support;

import com.ipn.persistance.AsignacionFacade;
import com.ipn.vo.Asignacion;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author alopeze
 */
public class AsignacionImpl extends MysqlDb implements AsignacionFacade{

    public AsignacionImpl(String url, String user, String password) throws ClassNotFoundException, SQLException {
        super(url, user, password);
    }
    
    public AsignacionImpl(Properties p) throws ClassNotFoundException, SQLException{
        super(p.getProperty("connection"),p.getProperty("user"),p.getProperty("pass"));
    }

    @Override
    public void create(Asignacion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Asignacion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Asignacion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asignacion find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asignacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
