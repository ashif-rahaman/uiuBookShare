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
import org.bson.conversions.Bson;
import util.ConnectToDatabase;

/**
 *
 * @author ashif
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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

        response.sendRedirect("login.jsp");
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

        ConnectToDatabase database;
        MongoCollection<Document> userCollection = null;

        String id = request.getParameter("idOrEmail").trim();
        String password = request.getParameter("password");

        boolean empty = false;

        if (id.isEmpty()) {

            empty = true;
            request.getSession().setAttribute("uiuIdMsg", "Enter UIU ID or email");
        }

        if (password.isEmpty()) {

            empty = true;
            request.getSession().setAttribute("uiuId", id);
            request.getSession().setAttribute("passwordMsg", "Enter password");
        }

        if (empty) {

            response.sendRedirect("login.jsp");
            return;
        }

        try {

            database = ConnectToDatabase.getConnection("bookshare");
            userCollection = database.getCollection("user");
        } catch (ConnectException | UnknownHostException e) {

            response.sendRedirect("index.jsp");
            return;
        }

        if (userCollection == null) {

            response.sendRedirect("index.jsp");
            return;
        }

        Bson query[] = {Filters.eq("uiuid", id), Filters.eq("email", id)};
        Document user = userCollection.find(Filters.or(query)).first();

        if (user == null) {

            request.getSession().setAttribute("uiuIdMsg", "Incorrect UIU ID or email");
            response.sendRedirect("login.jsp");
        } else if (!password.equals(user.getString("password"))) {

            request.getSession().setAttribute("uiuId", id);
            request.getSession().setAttribute("passwordMsg", "Incorrect Password");
            response.sendRedirect("login.jsp");
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
