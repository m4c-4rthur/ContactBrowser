/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.facade;

import com.etisalat.assignment.model.ContactModel;
import com.etisalat.assignment.service.ClientService;
import java.util.List;

/**
 *
 * @author hesham.ibrahim
 */
public class ClientFacade {

    private ClientService clientService;

    public ClientFacade() {
        clientService = new ClientService();
    }

    public List<ContactModel> getContacts() throws Exception {
       return clientService.getContacts();
    }
    
}
