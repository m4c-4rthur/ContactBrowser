/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.model;

import java.io.Serializable;

/**
 *
 * @author hesham.ibrahim
 */
public class ContactModel implements Serializable{
    private String name;
    private String email;
    private String phoneNumber;
    private String contactId;

    @Override
    public String toString() {
        return "ContactModel{" + "name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", contactId=" + contactId + '}';
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
