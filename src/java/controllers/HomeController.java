/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mongodb.client.MongoCollection;
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
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

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

        MongoCollection<Document> advertiseCollection = null;

        try {

            ConnectToDatabase database = ConnectToDatabase.getConnection("bookshare");
            advertiseCollection = database.getCollection("advertise");
        } catch (ConnectException | UnknownHostException e) {

            response.sendRedirect("index.jsp");
        }

        Document user = (Document) request.getSession().getAttribute("user");
        if (user != null) {

            request.getSession().setAttribute("username", user.get("name"));

            if (advertiseCollection != null) {

//                DBCursor advertises = (DBCursor) advertiseCollection.find();
            }

            response.sendRedirect("home.jsp");
        } else {

            response.sendRedirect("login.jsp");
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
