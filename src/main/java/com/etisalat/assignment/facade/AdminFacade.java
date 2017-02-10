/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.facade;

import com.etisalat.assignment.model.ContactModel;
import com.etisalat.assignment.service.AdminService;
import java.util.List;

/**
 *
 * @author hesham.ibrahim
 */
public class AdminFacade {

    private AdminService adminService;

    public AdminFacade() {
        adminService = new AdminService();
    }

    public void addContact(ContactModel contact) throws Exception {
        adminService.addContact(contact);

    }


    public void editContact(ContactModel contact) throws Exception {
        adminService.editContact(contact);

    }

    public List<ContactModel> getContacts() throws Exception {
       return adminService.getContacts();
    }
    
    public ContactModel getContactById(String contactId) throws Exception {
       return adminService.getContactById(contactId);
    }
}
