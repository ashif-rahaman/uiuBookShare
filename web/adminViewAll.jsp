<%-- 
    Document   : adminViewAll
    Created on : Aug 23, 2017, 8:15:12 PM
    Author     : ashif
--%>

<%@page import="org.bson.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/w3-theme-blue.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>

        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet"> 

        <title>Admin View</title>
    </head>
    <body style="font-family: 'Lato', sans-serif;">

        <!--Start of Navigation bar-->

        <div class="w3-container w3-theme">
            <a href="#"><img src="resources/images/logo.png" alt="logo" style="width: 10%; height: 10%"></a>

            <a href="" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">User Details</a>
            <a href="" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Users</a>
        </div>

        <!--End of Navigation bar-->

        <div class="w3-container">
            <div class="w3-panel w3-blue-grey w3-center w3-xlarge">
                <label>User information</label>
            </div>

            <div class="w3-responsive">
                <table class="w3-table-all">
                    <thead>
                        <tr class="w3-gray">
                            <th>Serial</th>
                            <th>UIU ID</th>
                            <th>Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 1;
                            String user = (String) request.getSession().getAttribute("user");
                            String pass = (String) request.getSession().getAttribute("pass");
                        %>

                        <tr>
                            <td><%= i++%></td>
                            <td><%= user%></td>
                            <td><%= pass%></td>
                        </tr>

                        <%

                        %>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
