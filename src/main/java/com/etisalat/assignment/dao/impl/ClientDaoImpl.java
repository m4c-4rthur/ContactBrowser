/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.dao.impl;

import com.etisalat.assignment.model.ContactModel;
import com.etisalat.assignment.statics.DBDefines;
import com.etisalat.assignment.utils.ConnectionManager;
import com.etisalat.assignment.utils.LogUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hesham.ibrahim
 */
public class ClientDaoImpl {

    public List<ContactModel> getContacts() throws Exception{
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        ContactModel contactModel;
        List<ContactModel> contactList = new ArrayList<>();
        try {
            LogUtil.info("Getting Client Contact List");
            con = ConnectionManager.getConnection();
            sqlStatment.append("SELECT * FROM " + DBDefines.TxContact.TABLE_NAME + " LIMIT 3");
            LogUtil.info("Executing the following Query" + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            ResultSet rs = statment.executeQuery();
            while (rs.next()) {
                contactModel = new ContactModel();
                contactModel.setEmail(rs.getString(DBDefines.TxContact.EMAIL));
                contactModel.setName(rs.getString(DBDefines.TxContact.NAME));
                contactModel.setPhoneNumber(rs.getString(DBDefines.TxContact.PHONE_NUMBER));
                contactList.add(contactModel);
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
        return contactList;
    }
}
