/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.service;

import com.etisalat.assignment.dao.impl.LoginDao;
import com.etisalat.assignment.exceptions.BussinessException;
import com.etisalat.assignment.model.UserModel;

/**
 *
 * @author hesham.ibrahim
 */
public class LoginService {

    private LoginDao loginDao;

    public LoginService() {
        loginDao = new LoginDao();
    }

    public UserModel authorizeUser(String username, String password) throws BussinessException, Exception {
        UserModel userModel = new UserModel();
            userModel = loginDao.checkUserExistance(username, password);
            userModel.setUserName(username);
        return userModel;
    }

    public UserModel authorizeUser(String username, String password, String adminFlag)
            throws BussinessException, Exception {
        UserModel userModel = new UserModel();

        userModel = loginDao.checkUserExistance(username, password, adminFlag);
        userModel.setUserName(username);

        return userModel;
    }
}
