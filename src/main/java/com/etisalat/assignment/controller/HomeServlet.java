/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etisalat.assignment.controller;

import com.etisalat.assignment.exceptions.BussinessException;
import com.etisalat.assignment.facade.LoginFacade;
import com.etisalat.assignment.model.UserModel;
import com.etisalat.assignment.utils.LogUtil;
import java.io.IOException;
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
@WebServlet(name = "HomeServlet", urlPatterns = {"/login"})
public class HomeServlet extends HttpServlet {

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
        UserModel userModel ;
        try {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            LogUtil.info("Authenticating request with username " + name);
            userModel = loginfacade.authorizeUser(name, password);
            LogUtil.info("User" + name + "has been authenticated succefully");
            request.setAttribute("userModel", userModel);
            HttpSession session = request.getSession(true);
            session.setAttribute("userName", name);
            request.getRequestDispatcher("client.jsp").forward(request, response);

        } catch (BussinessException e) {
            forwardMessage(request, response, "error", "Invaild Username or Password","index.jsp");
        }catch(Exception ex)
        {
            forwardMessage(request, response,"error", "System error ,Kindly check with you system admin","index.jsp");
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
