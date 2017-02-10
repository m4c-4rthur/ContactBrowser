/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.controller;

import com.etisalat.assignment.exceptions.BussinessException;
import com.etisalat.assignment.facade.AdminFacade;
import com.etisalat.assignment.facade.LoginFacade;
import com.etisalat.assignment.model.ContactModel;
import com.etisalat.assignment.model.UserModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hesham.ibrahim
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginFacade loginfacade = new LoginFacade();
        AdminFacade adminFacade = new AdminFacade();
        List<ContactModel> contactList;
        ContactModel contactModel;
        UserModel userModel;
        String name;
        String contactId;
        String password;
        String adminFlag;
        try {
            String action = request.getParameter("action");

            switch (action) {
                case "editPage":
                    contactId = request.getParameter("contactId");
                    contactModel = adminFacade.getContactById(contactId);
                    request.setAttribute("contactModel", contactModel);
                    request.getRequestDispatcher("editUser.jsp").forward(request, response);
                    break;
                case "editUser":
                    contactModel = new ContactModel();
                    contactModel.setName(request.getParameter("name"));
                    contactModel.setEmail(request.getParameter("email"));
                    contactModel.setPhoneNumber(request.getParameter("phoneNumber"));
                    contactModel.setContactId(request.getParameter("contactId"));
                    adminFacade.editContact(contactModel);
                    request.setAttribute("contactModel", contactModel);
                    forwardMessage(request, response, "error", "User Has been editied successfully", "editUser.jsp");
                    break;
                case "backToPanel":
                    contactList = adminFacade.getContacts();
                    request.setAttribute("contactList", contactList);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                case "addPage":
                    request.getRequestDispatcher("addUser.jsp").forward(request, response);
                    break;
                case "addUser":
                    contactModel = new ContactModel();
                    contactModel.setName(request.getParameter("name"));
                    contactModel.setEmail(request.getParameter("email"));
                    contactModel.setPhoneNumber(request.getParameter("phoneNumber"));
                    adminFacade.addContact(contactModel);
                    //request.setAttribute("contactModel", contactModel);
                    forwardMessage(request, response, "error", "User Has been Added successfully", "addUser.jsp");
                    break;
                default:
                    name = request.getParameter("username");
                    password = request.getParameter("password");
                    adminFlag = request.getParameter("admin");
                    userModel = loginfacade.authorizeUser(name, password, adminFlag);
                    contactList = adminFacade.getContacts();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userName", name);
                    request.setAttribute("contactList", contactList);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);

            }

        } catch (BussinessException e) {
            forwardMessage(request, response, "error", "Invaild Username or Password", "index.jsp");
        } catch (Exception ex) {
            forwardMessage(request, response, "error", "General Error kindly contact you system administrator", "index.jsp");
        }

    }

    private void forwardMessage(HttpServletRequest request, HttpServletResponse response,
            String attribute, String message, String pageName)
            throws ServletException, IOException {
        request.setAttribute(attribute, message);
        request.getRequestDispatcher(pageName).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
