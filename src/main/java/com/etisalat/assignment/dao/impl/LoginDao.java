/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.dao.impl;

import com.etisalat.assignment.exceptions.BussinessException;
import com.etisalat.assignment.model.UserModel;
import com.etisalat.assignment.statics.DBDefines;
import com.etisalat.assignment.utils.ConnectionManager;
import com.etisalat.assignment.utils.LogUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hesham.ibrahim
 */
public class LoginDao {

    public UserModel checkUserExistance(String userName, String password) throws BussinessException, Exception {
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        UserModel userModel = new UserModel();
        try {
            LogUtil.info("Check the User" + userName + " on the Database");
            con = ConnectionManager.getConnection();
            sqlStatment.append("SELECT * FROM " + DBDefines.Users.TABLE_NAME + " WHERE ");
            sqlStatment.append(DBDefines.Users.USER_NAME);
            sqlStatment.append(" = ? AND ");
            sqlStatment.append(DBDefines.Users.PASSWORD);
            sqlStatment.append(" = ? ");
            LogUtil.debug("Execute the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            statment.setString(1, userName);
            statment.setString(2, password);
            ResultSet rs = statment.executeQuery();
            if (rs.next()) {
                do {
                    userModel.setPassword(rs.getString(DBDefines.Users.PASSWORD));
                    userModel.setUserId(rs.getString(DBDefines.Users.USER_ID));
                    userModel.setLastLoginDate(rs.getDate(DBDefines.Users.LAST_LOGIN_DATE));
                    userModel.setCreationDate(rs.getDate(DBDefines.Users.CREATION_DATE));
                } while (rs.next());

            } else {
                throw new BussinessException("user not found");
            }

        } catch (SQLException ex) {
            LogUtil.error("Sql exception occured", ex);
            throw new Exception();
        } catch (Exception ex) {
            LogUtil.error("General Exception", ex);
            throw new Exception();
        } finally {
            ConnectionManager.closeConnection(con);
        }
        return userModel;
    }

    public UserModel checkUserExistance(String userName, String password, String adminFlag)
            throws BussinessException, Exception {
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        UserModel userModel = new UserModel();
        try {
            LogUtil.info("Check Admin" + userName + " on the Database");
            con = ConnectionManager.getConnection();
            sqlStatment.append("SELECT * FROM " + DBDefines.Users.TABLE_NAME + " WHERE ");
            sqlStatment.append(DBDefines.Users.USER_NAME);
            sqlStatment.append(" = ? AND ");
            sqlStatment.append(DBDefines.Users.PASSWORD);
            sqlStatment.append(" = ? AND ");
            sqlStatment.append(DBDefines.Users.ADMIN);
            sqlStatment.append(" = ? ");
            LogUtil.debug("Execute the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            statment.setString(1, userName);
            statment.setString(2, password);
            statment.setString(3, adminFlag);
            ResultSet rs = statment.executeQuery();
            if (rs.next()) {
                do {
                    userModel.setPassword(rs.getString(DBDefines.Users.PASSWORD));
                    userModel.setUserId(rs.getString(DBDefines.Users.USER_ID));
                    userModel.setLastLoginDate(rs.getDate(DBDefines.Users.LAST_LOGIN_DATE));
                    userModel.setCreationDate(rs.getDate(DBDefines.Users.CREATION_DATE));
                } while (rs.next());

            } else {
                throw new BussinessException("user not found");
            }

        } catch (SQLException ex) {
            LogUtil.error("Sql exception occured", ex);
            throw new Exception();
        } catch (Exception ex) {
            LogUtil.error("General Exception", ex);
            throw new Exception();
        } finally {
            ConnectionManager.closeConnection(con);
        }
        return userModel;
    }

}
