<%-- 
    Document   : show_param
    Created on : Jun 17, 2020, 9:02:28 AM
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
        <h1>Take param from jsp_param.jsp</h1>
        <%
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            
            out.println("Your information");
            out.println("<h3>Username: " + user + "</h3>");
            out.println("<h3>Password: " + pass + "</h3>");
        %>
    </body>
</html>
