<%-- 
    Document   : register
    Created on : Aug 20, 2017, 10:01:09 PM
    Author     : ashif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <a href="<%= request.getContextPath()%>/register" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Register</a>
            <a href="<%= request.getContextPath()%>/login" class="w3-hover-blue w3-hover-text-dark-gray w3-right w3-button w3-large w3-margin-top">Login</a>
        </div>

        <!--End of Navigation bar-->


        <!--Registration body started-->

        <div class="w3-container w3-padding-64">
            <div class="w3-row" style="margin-left: 25%">
                <div class="w3-half w3-large" style="font-family: 'Lato', sans-serif;">
                    <div class="w3-margin-bottom">
                        <label class="w3-xxlarge"><b>Register in Book Share</b></label>
                    </div>
                    <div>
                        <form action="<%= request.getContextPath()%>/signup" method="POST">


                            <label class="">UIU ID</label>
                            <%
                                String uiuIdMsg = (String) request.getSession().getAttribute("uiuIdMsg");
                                if (uiuIdMsg != null && !"".equals(uiuIdMsg)) {
                            %>
                            <label class="w3-small w3-text-red"><%= uiuIdMsg%></label>
                            <%
                                }
                            %>
                            <input name="uiu_id" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="<%= ((request.getParameter("uiuId") != null) ? request.getParameter("uiuId") : "")%>" placeholder="e.g., 011131006">


                            <label>Email</label>
                            <%
                                String emailMsg = (String) request.getSession().getAttribute("emailMsg");
                                if (emailMsg != null) {
                            %>
                            <label class="w3-small w3-text-red"><%= emailMsg%></label>
                            <%
                                }
                            %>
                            <input name="email" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="email" value="<%= ((request.getParameter("email") != null) ? request.getParameter("email") : "")%>" placeholder="e.g., email@example.com">


                            <label>Name</label>
                            <%
                                String nameMsg = (String) request.getSession().getAttribute("nameMsg");
                                if (nameMsg != null) {
                            %>
                            <label class="w3-small w3-text-red"><%= nameMsg%></label>
                            <%
                                }
                            %>
                            <input name="name" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="text" value="<%= ((request.getParameter("name") != null) ? request.getParameter("name") : "")%>" placeholder="e.g., Bantu Khan">


                            <label>Password</label>
                            <%
                                String passwordMsg = (String) request.getSession().getAttribute("passwordMsg");
                                if (uiuIdMsg != null) {
                            %>
                            <label class="w3-small w3-text-red"><%= passwordMsg%></label>
                            <%
                                }
                            %>
                            <input name="password" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="password" value="<%= ((request.getParameter("password") != null) ? request.getParameter("password") : "")%>" placeholder="e.g., *********">


                            <label>Confirm Password</label>
                            <%
                                String confirmPasswordMsg = (String) request.getSession().getAttribute("confirmPasswordMsg");
                                if (confirmPasswordMsg != null) {
                            %>
                            <label class="w3-small w3-text-red"><%= confirmPasswordMsg%></label>
                            <%
                                }
                            %>
                            <input name="confirm_password" class="w3-xlarge w3-input w3-border w3-round-large w3-light-gray w3-margin-bottom" type="password" placeholder="e.g., *********">

                            <div class="w3-row w3-margin-top">
                                <input type="submit" name="register" value="Register" class="w3-btn w3-theme-l1 w3-round" style="padding-left: 7%; padding-right: 7%;">
                                <a  href="<%= request.getContextPath()%>/login" class="w3-half w3-right w3-text-theme" style="margin-top: 3%">Already have an account</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--Registration body ended-->
    </body>
</html>

