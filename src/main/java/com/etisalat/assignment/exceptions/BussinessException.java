/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.exceptions;

/**
 *
 * @author hesham.ibrahim
 */
public class BussinessException extends Exception {

    public BussinessException() {
        super();
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(Throwable cause) {
        super(cause);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
