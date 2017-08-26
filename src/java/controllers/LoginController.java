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

        String idOrEmail = request.getParameter("idOrEmail").trim();
        String password = request.getParameter("password");

        if (!idOrEmail.isEmpty()) {

            if (!password.isEmpty()) {

                try {

                    Integer.parseInt(idOrEmail);

                } catch (NumberFormatException e) {

                    if (idOrEmail.indexOf('@') < 0) {

                        request.getSession().setAttribute("uiuIdMsg", "Please insert a valid email");
                        response.sendRedirect("login.jsp");
                    } else {

                        try {

                            database = ConnectToDatabase.getConnection("bookshare");
                            userCollection = database.getCollection("user");
                        } catch (ConnectException | UnknownHostException err) {

                            response.sendRedirect("index.jsp");
                        }

                        if (userCollection != null) {

                            Document user = userCollection.find(Filters.eq("email", idOrEmail)).first();
                            if (user != null) {

                                if (user.get("password").equals(password)) {

                                    //Write response code here
                                    return;
                                } else {

                                    request.getSession().setAttribute("uiuId", idOrEmail);
                                    request.getSession().setAttribute("passwordMsg", "Incorrect Password");
                                    response.sendRedirect("login.jsp");
                                }
                            }
                        }
                    }

                }

                if (idOrEmail.length() == 9) {
                    try {

                        database = ConnectToDatabase.getConnection("bookshare");
                        userCollection = database.getCollection("user");
                    } catch (ConnectException | UnknownHostException e) {

                        response.sendRedirect("index.jsp");
                    }

                    if (userCollection != null) {

                        Document user = userCollection.find(Filters.eq("uiuid", idOrEmail)).first();
                        if (user != null) {

                            if (user.get("password").equals(password)) {
                                //Write response code here

                            } else {

                                request.getSession().setAttribute("uiuId", idOrEmail);
                                request.getSession().setAttribute("passwordMsg", "Incorrect Password");
                                response.sendRedirect("login.jsp");
                            }
                        }
                    }
                } else {

                    request.getSession().setAttribute("uiuIdMsg", "Please insert a correct uiu id");
                    response.sendRedirect("login.jsp");
                }

            } else {

                request.getSession().setAttribute("uiuId", idOrEmail);
                request.getSession().setAttribute("passwordMsg", "Please enter password");
                response.sendRedirect("login.jsp");
            }
        } else {

            request.getSession().setAttribute("uiuIdMsg", "Please enter UIU ID or email");
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
