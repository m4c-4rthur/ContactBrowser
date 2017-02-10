/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.service;

import com.etisalat.assignment.dao.impl.ClientDaoImpl;
import com.etisalat.assignment.model.ContactModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hesham.ibrahim
 */
public class ClientService {
    
    
  private ClientDaoImpl clientDaoImpl;

    public ClientService() {
        clientDaoImpl = new ClientDaoImpl();
    }

    public List<ContactModel> getContacts() throws Exception{
          return clientDaoImpl.getContacts();

    }
    
}
