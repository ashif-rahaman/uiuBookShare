<%-- 
    Document   : home
    Created on : Aug 29, 2017, 2:38:03 AM
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
    <body class="w3-theme-light" style="font-family: 'Lato', sans-serif;">

        <!--Start of Navigation bar-->
        <div class="w3-container w3-theme w3-row">
            <a href="<%= request.getContextPath()%>/home"><img src="resources/images/logo.png" alt="logo" class="w3-half" style="width: 8%; height: 8%; margin-left: 40%;"></a>
            <a href="#" class="w3-half w3-button w3-hover-blue w3-hover-opacity" style="margin-top: 1%;">
                <img src="resources/images/me.jpg" alt="profile" class="w3-round" style="width: 4%; height: 4%;"/>
                <span style="padding-bottom: 1%">Bantu Khan</span>
            </a>
        </div>
        <!--End of Navigation bar-->

        <div class="w3-row">

            <div class="w3-col w3-theme-l4 w3-centered w3-sidebar w3-bar-block w3-card" style="width: 20%">

                <div class="w3-container w3-theme-d4">
                    <h3 class="w3-center">Menu</h3>
                </div>

                <img src="resources/images/logo2.png" alt="bookshare_image" class="w3-margin-bottom" style="width: 100%;"/>

                <!--                <div class="w3-container">
                                    <div class="w3-large w3-card-2 w3-margin-top">-->

                <a href="<%= request.getContextPath()%>/books/all" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">All</a>

                <a href="<%= request.getContextPath()%>/books/cse" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">CSE</a>

                <a href="<%= request.getContextPath()%>/books/eee" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">EEE</a>

                <a href="<%= request.getContextPath()%>/books/ete" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">ETE</a>

                <a href="<%= request.getContextPath()%>/books/bba" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">BBA</a>

                <a href="<%= request.getContextPath()%>/books/eco" class="w3-bar-item w3-button w3-hover-theme" style="padding-left: 20%">ECONOMICS</a>
                <!--                    </div>
                                </div>-->
            </div>

            <div class="w3-container" style="margin-left: 20%">

                <div class="w3-row-padding w3-margin-top">
                    <div class="w3-half">
                        <input name="" class="w3-large w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="" placeholder="e.g., 011131006">
                    </div>
                    <div class="w3-half w3-large">
                        <a href="#" class="w3-button w3-theme-d1 w3-round">Search</a>
                    </div>
                </div>

                <div class="w3-container">


                </div>
            </div>
        </div>
    </body>
</html>
