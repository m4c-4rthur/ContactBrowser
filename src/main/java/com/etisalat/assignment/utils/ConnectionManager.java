/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author hesham.ibrahim
 */
public class ConnectionManager {
    
    private static DataSource ds;

    public static void init() throws NamingException {
        try{
        InitialContext initialContext = new InitialContext();
        ds = (javax.sql.DataSource)initialContext.lookup("java:/comp/env/jdbc/testds");
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

    private static Connection getDataSourceConnection() throws NamingException, SQLException {
        if(ds == null) init();

        return ds.getConnection();
    }  
    
        public static Connection getConnection() {
        Connection con = null;
        try {
            con = getDataSourceConnection();
        }catch (NamingException ex) {
            //LogUtil.error("Failed to get database connections ", ex);
        }
        catch (SQLException ex) {
            //LogUtil.error("Failed to get database connections ", ex);
        }
        return con;
    }
    
        public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception ex) {
            //LogUtil.error("Failed to close connection ", ex);
        }
    }
    
    
}
