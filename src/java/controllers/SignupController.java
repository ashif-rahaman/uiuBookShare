/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashif
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        //field values from the registration form
        String uiuId = request.getParameter("uiu_id");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPasswrd = request.getParameter("confirm_password");

        //Variable for null fields messages
        String uiuIdMsg, emailMsg, nameMsg, passwordMsg, confirmPasswordMsg;

        //first guess that the fields are not empty or have no problem
        boolean notNull = true;

        //check the fields are not empty
        if ("".equals(uiuId)) {

            uiuIdMsg = "Please insert your UIU ID";
            notNull = false;
            request.getSession().setAttribute("uiuIdMsg", uiuIdMsg);
        }

        if ("".equals(email)) {

            emailMsg = "Please insert your email";
            notNull = false;
            request.getSession().setAttribute("emailMsg", emailMsg);
        }

        if ("".equals(name)) {

            nameMsg = "Please insert your name";
            notNull = false;
            request.getSession().setAttribute("nameMsg", nameMsg);
        }

        if ("".equals(password)) {

            passwordMsg = "Please insert password";
            notNull = false;
            request.getSession().setAttribute("passwordMsg", passwordMsg);
        }

        if (!confirmPasswrd.equals(password)) {

            confirmPasswordMsg = "Password does not match";
            notNull = false;
            request.getSession().setAttribute("confirmPasswordMsg", confirmPasswordMsg);
        }

        if (!notNull) {

            request.getSession().setAttribute("uiuId", uiuId);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("password", password);
            response.sendRedirect("register.jsp");
        } else {

        }
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
