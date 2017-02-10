/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.facade;

import com.etisalat.assignment.exceptions.BussinessException;
import com.etisalat.assignment.model.UserModel;
import com.etisalat.assignment.service.LoginService;

/**
 *
 * @author hesham.ibrahim
 */
public class LoginFacade {

    private LoginService loginService;

    public LoginFacade() {
        loginService = new LoginService();
    }

    public UserModel authorizeUser(String username, String password) throws BussinessException, Exception {
        UserModel userModel = new UserModel();
        userModel = loginService.authorizeUser(username, password);
        return userModel;
    }

    public UserModel authorizeUser(String username, String password, String adminFlag) throws
            BussinessException, Exception {
        UserModel userModel = new UserModel();
        userModel = loginService.authorizeUser(username, password, adminFlag);
        return userModel;
    }

}
