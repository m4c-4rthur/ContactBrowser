/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etisalat.assignment.statics;

/**
 *
 * @author hesham.ibrahim
 */
public class DBDefines {
        public static final String TIMESTAMP = "CURRENT_TIMESTAMP()";
        public static class TxContact {

        public static final String TABLE_NAME = "TX_CONTACTS";
        public static final String CONTACT_ID = "CONTACT_ID";
        public static final String NAME = "NAME";
        public static final String EMAIL = "EMAIL";
        public static final String PHONE_NUMBER = "PHONE_NUMBER";
        public static final String CREATION_DATE = "CREATION_DATE";
        public static final String LAST_MODIFIED_DATE = "LAST_MODIFIED_DATE";
    }

    public static class Users {

        public static final String TABLE_NAME = "ADM_USERS";
        public static final String USER_ID = "USER_ID";
        public static final String USER_NAME = "USER_NAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String CREATION_DATE = "CREATION_DATE";
        public static final String LAST_LOGIN_DATE = "LAST_LOGIN_DATE";
        public static final String ADMIN = "ADMIN";

    }

    
}
