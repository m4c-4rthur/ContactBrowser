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
public class AdminDaoImpl {

    public void addContact(ContactModel contact) throws Exception{
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();

        try {
            LogUtil.info("Adding new contact" + contact.toString() + " to DB ");
            con = ConnectionManager.getConnection();
            sqlStatment.append("insert into " + DBDefines.TxContact.TABLE_NAME + " (");
            sqlStatment.append(DBDefines.TxContact.NAME);
            sqlStatment.append(",");
            sqlStatment.append(DBDefines.TxContact.EMAIL);
            sqlStatment.append(",");
            sqlStatment.append(DBDefines.TxContact.PHONE_NUMBER);
            sqlStatment.append(",");
            sqlStatment.append(DBDefines.TxContact.CREATION_DATE);
            sqlStatment.append(")");
            sqlStatment.append(" values ");
            sqlStatment.append("(?,?,?," + DBDefines.TIMESTAMP + ")");
            LogUtil.debug("Executing the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            int x = 1;
            statment.setString(x++, contact.getName());
            statment.setString(x++, contact.getEmail());
            statment.setString(x++, contact.getPhoneNumber());
            statment.executeUpdate();

        } catch (SQLException ex) {
            LogUtil.error("Sql exception occured", ex);
            throw new Exception();
        } catch (Exception ex) {
            LogUtil.error("General Exception", ex);
            throw new Exception();
        } finally {
            ConnectionManager.closeConnection(con);
        }

    }

    public void editContact(ContactModel contact) throws Exception{

        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        try {
            LogUtil.info("Editing contact" + contact.toString() + " to DB ");
            con = ConnectionManager.getConnection();
            sqlStatment.append("UPDATE " + DBDefines.TxContact.TABLE_NAME);
            sqlStatment.append(" SET " + DBDefines.TxContact.NAME);
            sqlStatment.append(" = ? " + ",");
            sqlStatment.append(DBDefines.TxContact.EMAIL);
            sqlStatment.append(" = ? " + ",");
            sqlStatment.append(DBDefines.TxContact.PHONE_NUMBER);
            sqlStatment.append(" = ? " + ",");
            sqlStatment.append(DBDefines.TxContact.LAST_MODIFIED_DATE);
            sqlStatment.append(" = " + DBDefines.TIMESTAMP);
            sqlStatment.append(" WHERE " + DBDefines.TxContact.CONTACT_ID);
            sqlStatment.append(" = ? ");
            LogUtil.debug("Executing the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            int x = 1;
            statment.setString(x++, contact.getName());
            statment.setString(x++, contact.getEmail());
            statment.setString(x++, contact.getPhoneNumber());
            statment.setString(x++, contact.getContactId());
            statment.executeUpdate();
        } catch (SQLException ex) {
            LogUtil.error("Sql exception occured", ex);
            throw new Exception();
        } catch (Exception ex) {
            LogUtil.error("General Exception", ex);
            throw new Exception();
        } finally {
            ConnectionManager.closeConnection(con);
        }

    }

    public List<ContactModel> getContacts() throws Exception{
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        ContactModel contactModel;
        List<ContactModel> contactList = new ArrayList<>();
        try {
            LogUtil.info("Getting contacts List");
            con = ConnectionManager.getConnection();
            sqlStatment.append("SELECT * FROM " + DBDefines.TxContact.TABLE_NAME);
            LogUtil.debug("Executing the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            ResultSet rs = statment.executeQuery();
            while (rs.next()) {
                contactModel = new ContactModel();
                contactModel.setEmail(rs.getString(DBDefines.TxContact.EMAIL));
                contactModel.setName(rs.getString(DBDefines.TxContact.NAME));
                contactModel.setPhoneNumber(rs.getString(DBDefines.TxContact.PHONE_NUMBER));
                contactModel.setContactId(rs.getString(DBDefines.TxContact.CONTACT_ID));
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

    public ContactModel getContactById(String contactId) throws Exception{
        Connection con = null;
        PreparedStatement statment = null;
        StringBuilder sqlStatment = new StringBuilder();
        ContactModel contactModel = new ContactModel();
        try {
            LogUtil.info("Getting Contact ID " + contactId + " info from DB ");
            con = ConnectionManager.getConnection();
            sqlStatment.append("SELECT * FROM " + DBDefines.TxContact.TABLE_NAME + " WHERE ");
            sqlStatment.append(DBDefines.TxContact.CONTACT_ID);
            sqlStatment.append(" = ? ");
            LogUtil.debug("Executing the following Query " + sqlStatment.toString());
            statment = con.prepareStatement(sqlStatment.toString());
            statment.setString(1, contactId);
            ResultSet rs = statment.executeQuery();
            while (rs.next()) {
                contactModel.setEmail(rs.getString(DBDefines.TxContact.EMAIL));
                contactModel.setName(rs.getString(DBDefines.TxContact.NAME));
                contactModel.setPhoneNumber(rs.getString(DBDefines.TxContact.PHONE_NUMBER));
                contactModel.setContactId(rs.getString(DBDefines.TxContact.CONTACT_ID));
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
        return contactModel;
    }
}
