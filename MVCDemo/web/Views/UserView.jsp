<%-- 
    Document   : UserView
    Created on : Jun 4, 2020, 7:07:43 PM
    Author     : TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your information!</h1>
        <hr>
        <% User user = (User) request.getAttribute("user"); %>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Full name</th>
                <th>Email</th>
                <th>Address</th>
            </tr>
            <tr>
                <th><%= user.getUsername() %></th>
                <th><%= user.getFullname() %></th>
                <th><%= user.getEmail()%></th>
                <th><%= user.getAddress()%></th>
            </tr>
        </table>
    </body>
</html>
