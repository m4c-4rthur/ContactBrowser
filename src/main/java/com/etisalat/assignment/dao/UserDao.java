/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.dao;

import com.etisalat.assignment.model.ContactModel;
import java.util.List;

/**
 *
 * @author hesham.ibrahim
 */
    public interface UserDao {

    public void addContact(ContactModel contact);
    public void deleteContact(String id);
    public void editContact(ContactModel contact);
    List<ContactModel> getContacts();

    }
