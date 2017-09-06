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
    <body class="w3-theme-light" style="font-family: 'Lato', sans-serif;">

        <!--Start of Navigation bar-->
        <div class="w3-container w3-theme">
            <a href="<%= request.getContextPath()%>/index"><img src="resources/images/logo.png" alt="logo" style="width: 10%; height: 10%"></a>
            <a href="<%= request.getContextPath()%>/index"><img src="resources/images/logo2.png"></a>
        </div>
        <!--End of Navigation bar-->

        <div class="w3-container w3-padding-64">
            <div class="w3-row" style="margin-left: 25%">
                <div class="w3-half w3-large">
                    <div class="w3-margin-bottom">
                        <label class="w3-xxlarge"><b>Add an advertise</b></label>
                    </div>
                    <div>
                        <form action="#" method="POST">
                            <label class="">Book Name</label>
                            <input name="bookname" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="" placeholder="e.g., Discrete Mathematics">

                            <label class="">Author(s)</label>
                            <input name="author" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="" placeholder="e.g., Roscen, Andrew">

                            <label class="">Edition</label>
                            <input name="edition" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="" placeholder="e.g., 4th">

                            <label class="">Price( in Taka)</label>
                            <input name="price" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="number" min="0" value="" placeholder="e.g., 250">

                            <label class="">Upload a photo of book</label>
                            <input name="bookphoto" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="file" value="" placeholder="e.g., 250">

                            <div class="w3-row w3-margin-top">
                                <input type="submit" value="Upload" class="w3-btn w3-theme-l1 w3-round" style="padding-left: 7%; padding-right: 7%;">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
