/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.service;

import com.etisalat.assignment.dao.impl.AdminDaoImpl;
import com.etisalat.assignment.model.ContactModel;
import java.util.List;

/**
 *
 * @author hesham.ibrahim
 */
public class AdminService {

    private AdminDaoImpl adminDaoImpl;

    public AdminService() {
        adminDaoImpl = new AdminDaoImpl();
    }

    public void addContact(ContactModel contact) throws Exception  {

        
        adminDaoImpl.addContact(contact);

    }

    public void deleteContact(String id) {

    }

    public void editContact(ContactModel contact) throws Exception {

        adminDaoImpl.editContact(contact);

    }

    public List<ContactModel> getContacts() throws Exception {
        return adminDaoImpl.getContacts();
    }

    public ContactModel getContactById(String contactId) throws Exception {

        return adminDaoImpl.getContactById(contactId);
    }

}
