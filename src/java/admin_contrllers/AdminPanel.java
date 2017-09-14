/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_contrllers;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.io.IOException;
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
@WebServlet(name = "AdminPanel", urlPatterns = {"/admin"})
public class AdminPanel extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ConnectToDatabase database;
    private MongoCollection<Document> collection;

    private Document document;
    private MongoCursor<Document> cursor;

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

        database = ConnectToDatabase.getConnection("bookshare");
        collection = database.getCollection("user_authentication");
        document = collection.find().first();

        System.out.println(document.get("userid") + " " + document.get("pass"));

        request.getSession().setAttribute("user", document.get("userid"));
        request.getSession().setAttribute("pass", document.get("password"));

        response.sendRedirect("adminViewAll.jsp");
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
