<%-- 
    Document   : index
    Created on : Aug 20, 2017, 9:53:54 PM
    Author     : ashif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/w3-theme-blue.css" rel="stylesheet" type="text/css"/>

        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet"> 
        <title>Book Share</title>
    </head>
    <body>

        <!--Start of Navigation bar-->
        <div class="w3-container w3-theme">
            <a href="<%= request.getContextPath()%>/index"><img src="resources/images/logo.png" alt="logo" style="width: 10%; height: 10%"></a>
            <a href="<%= request.getContextPath()%>/index"><img src="resources/images/logo2.png"></a>
            <a href="<%= request.getContextPath()%>/signup" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Register</a>
            <a href="<%= request.getContextPath()%>/login" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Login</a>
        </div>
        <!--End of Navigation bar-->
    </body>
</html>
