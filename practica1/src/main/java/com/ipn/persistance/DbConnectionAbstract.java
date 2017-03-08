
package com.ipn.persistance;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alopeze
 */
public abstract class DbConnectionAbstract {
    protected String url = null;
    protected String user = null;
    protected String password = null;
    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement prepared = null;
    protected CallableStatement call = null;
    protected String create;
    protected String delete;
    protected String update;
    protected String find;
 
     
 
    public DbConnectionAbstract(String url,String user,String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
     
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    public abstract void closeConnection()throws SQLException;
 
    public String getCreate() {
        return create;
    }
 
    public void setCreate(String create) {
        this.create = create;
    }
 
    public String getDelete() {
        return delete;
    }
 
    public void setDelete(String delete) {
        this.delete = delete;
    }
 
    public String getUpdate() {
        return update;
    }
 
    public void setUpdate(String update) {
        this.update = update;
    }
 
    public String getFind() {
        return find;
    }
 
    public void setFind(String find) {
        this.find = find;
    }
     
    public Connection getConnect() {
        return connect;
    }
 
    public void setConnect(Connection connect) {
        this.connect = connect;
    }
 
    public Statement getStatement() {
        return statement;
    }
 
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
 
    public PreparedStatement getPrepared() {
        return prepared;
    }
 
    public void setPrepared(PreparedStatement prepared) {
        this.prepared = prepared;
    }
 
    public CallableStatement getCall() {
        return call;
    }
 
    public void setCall(CallableStatement call) {
        this.call = call;
    }
 
}