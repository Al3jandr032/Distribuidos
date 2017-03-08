/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.support;

import com.ipn.persistance.DbConnectionAbstract;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alopeze
 */
public class MysqlDb extends DbConnectionAbstract{
 
    private static final String driver = "com.mysql.jdbc.Driver";
     
     
    public MysqlDb(String url,String user,String password) throws ClassNotFoundException, SQLException {
        super(url,user,password);
        this.getConnection();
    }
 
     
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        // Setup the connection with the DB
        connect = DriverManager.getConnection(url, user, password);
        return connect;
    }
     
    @Override
    public void closeConnection() throws SQLException{
        this.connect.close();
    }

    public static void main(String[] args) {
       
    }
     
    public static void printResultSet(ResultSet rs) throws SQLException{
        while (rs.next()) {
            for (int i = 1; i <= 4; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = rs.getString(i);
                System.out.println(columnValue);
//                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
 
     
     
     
}