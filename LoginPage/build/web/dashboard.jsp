<%-- 
    Document   : dashboard
    Created on : Jun 1, 2020, 10:57:16 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String user = application.getAttribute("user").toString();
            String pass = application.getAttribute("pass").toString();
            
            out.println("Username: " + user);
            out.println("Password: " + pass);
        %>
    </body>
</html>
