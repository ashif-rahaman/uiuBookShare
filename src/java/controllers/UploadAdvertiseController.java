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
@WebServlet(name = "UploadAdvertise", urlPatterns = {"/upload"})
public class UploadAdvertiseController extends HttpServlet {

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
            response.sendRedirect("upload.jsp");
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

        MongoCollection<Document> advertiseCollection = null;

        try {

            ConnectToDatabase database = ConnectToDatabase.getConnection("bookshare");
            advertiseCollection = database.getCollection("advertise");
        } catch (ConnectException | UnknownHostException e) {

            response.sendRedirect("index.jsp");
        }

        String bookname = request.getParameter("bookname").trim();
        String author = request.getParameter("author").trim();
        String edition = request.getParameter("edition").trim();
        String priceString = request.getParameter("price").trim();
        int price;

        String booknameMsg, authorMsg, editionMsg, priceMsg;
        boolean notNull = true;

        if ("".equals(bookname) || "".equals(author) || "".equals(edition) || "".equals(priceString)) {

            response.sendRedirect("upload");
        } else {

            try {

                price = Integer.parseInt(priceString);
            } catch (NumberFormatException e) {

                response.sendRedirect("upload");
                return;
            }

            if (advertiseCollection != null) {

                Document user = (Document) request.getSession().getAttribute("user");

                //Inserting user info to database as signup
                Document advertise = new Document("userid", user.get("_id"))
                        .append("bookname", bookname)
                        .append("author", author)
                        .append("edition", edition)
                        .append("price", price);

                advertiseCollection.insertOne(advertise);

            }
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
