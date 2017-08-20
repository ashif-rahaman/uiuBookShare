<%-- 
    Document   : login
    Created on : Aug 20, 2017, 10:00:56 PM
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
            <a><img src="resources/images/logo.png" alt="logo" style="width: 10%; height: 10%"></a>
            <a><img src="resources/images/logo2.png"></a>
            <a href="<%= request.getContextPath()%>/register" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Register</a>
            <a href="<%= request.getContextPath()%>/login" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Login</a>
        </div>
        <!--End of Navigation bar-->

        <div class="w3-container w3-padding-64">
            <div class="w3-row" style="margin-left: 25%">
                <div class="w3-half w3-large" style="font-family: 'Lato', sans-serif;">
                    <div class="w3-margin-bottom">
                        <label class="w3-xxlarge"><b>Login to UIU Book Share</b></label>
                    </div>
                    <div>

                        <label class="">UIU ID ( or Email )</label>
                        <input class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text">
                        <label>Password</label>
                        <input class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray" type="password">

                        <div class="w3-row w3-margin-top">
                            <a class="w3-btn w3-theme-l1 w3-round" style="padding-left: 7%; padding-right: 7%;">Login</a>
                            <a  href="<%= request.getContextPath()%>/register" class="w3-half w3-right w3-text-theme" style="margin-top: 3%">Create an account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
