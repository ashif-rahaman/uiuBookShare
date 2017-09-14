/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.io.IOException;
import java.net.ConnectException;
import java.rmi.UnknownHostException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import util.ConnectToDatabase;

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

        Document logedInUser = (Document) request.getSession().getAttribute("user");

        if (logedInUser != null) {

            request.getSession().setAttribute("user", logedInUser);
            response.sendRedirect("home");
        } else {

            response.sendRedirect("register.jsp");
        }
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

        MongoCollection<Document> userCollection = null;

        try {

            ConnectToDatabase database = ConnectToDatabase.getConnection("bookshare");
            userCollection = database.getCollection("user");
        } catch (ConnectException | UnknownHostException e) {

            response.sendRedirect("index.jsp");
        }

        //field values from the registration form
        String uiuId = request.getParameter("uiu_id").trim();
        String email = request.getParameter("email").trim();
        String name = request.getParameter("name").trim();
        String password = request.getParameter("password");
        String confirmPasswrd = request.getParameter("confirm_password");

        //Variable for null fields messages
        String uiuIdMsg, emailMsg, nameMsg, passwordMsg, confirmPasswordMsg;

        //first guess that the fields are not empty or have no problem
        boolean notNull = true;

        //checking wheather the input field UIU ID is empty or not
        //If not then checking wheather it exists in database or not
        if ("".equals(uiuId)) {

            uiuIdMsg = "Please insert your UIU ID";
            notNull = false;
            request.getSession().setAttribute("uiuIdMsg", uiuIdMsg);
        } else {

            //Checking if the UIU ID is used or not
            if (userCollection != null) {

                //Document user will be null if the UIU ID is not used
                Document user = userCollection.find(Filters.eq("uiuid", uiuId)).first();

                if (user != null) {

                    uiuIdMsg = "UIU Id is already used";
                    notNull = false;
                    request.getSession().setAttribute("uiuIdMsg", uiuIdMsg);
                }
            }

        }

        //Checking wheather the input field Email is empty or not
        //If Email is not empty then checking wheater it exists in database or not
        if ("".equals(email)) {

            emailMsg = "Please insert your email";
            notNull = false;
            request.getSession().setAttribute("emailMsg", emailMsg);
        } else {

            //Checking the Email is used or not
            if (userCollection != null) {

                //Document user will be null if Email is not used
                Document user = userCollection.find(Filters.eq("email", email)).first();

                if (user != null) {

                    emailMsg = "Email is already used";
                    notNull = false;
                    request.getSession().setAttribute("emailMsg", emailMsg);
                }
            }
        }

        //Checking the input field name
        if ("".equals(name)) {

            nameMsg = "Please insert your name";
            notNull = false;
            request.getSession().setAttribute("nameMsg", nameMsg);
        }

        //Checking input field password
        if ("".equals(password)) {

            passwordMsg = "Please insert password";
            notNull = false;
            request.getSession().setAttribute("passwordMsg", passwordMsg);
        }

        //Checking input field Confirm Password wheather 
        //it is matched with the password field or not
        if (!confirmPasswrd.equals(password)) {

            confirmPasswordMsg = "Password does not match";
            notNull = false;
            request.getSession().setAttribute("confirmPasswordMsg", confirmPasswordMsg);
        }

        // If any of fields is empty or
        // if the UIU ID or Email is already used
        if (!notNull) {

            request.getSession().setAttribute("uiuId", uiuId);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("name", name);
            response.sendRedirect("register.jsp");

        } else if (userCollection != null) {

            //Inserting user info to database as signup
            Document user = new Document("uiuid", uiuId)
                    .append("email", email)
                    .append("name", name)
                    .append("password", password);

            userCollection.insertOne(user);

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
