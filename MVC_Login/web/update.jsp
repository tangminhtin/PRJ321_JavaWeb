<%-- 
    Document   : update
    Created on : Jun 11, 2020, 11:46:53 PM
    Author     : tangminhtin
--%>

<%@page import="Models.Entities.User"%>
<%@page import="Models.DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update User!</h1> <hr>
        
        <%
            int id = -1;
            String username = "e";
            String password = "";
            String fullname = "";
            String phone = "";
            String birthday = "";
            String email = "";
            if(request.getParameter("id") != null) {
                UserDAO udao = new UserDAO();
                id = Integer.parseInt(request.getParameter("id"));
                User user = udao.getUser(id);
                
                username = user.getUsername();
                password = user.getPassword();
                fullname = user.getFullname();
                phone = user.getPhone();
                birthday = user.getBirthday().toString();
                email = user.getEmail();
            }
        %>
        <form action="" method="">
            <input type="hidden" name="id" value="<%= id %>" />
            Username <input type="text" name="txtUsername" value="<%= username %>" /> <br>
            Password <input type="password" name="txtPassword" value="<%= password %>"/> <br>
            Fullname <input type="text" name="txtFullname" value="<%= fullname %>"/> <br>
            Phone <input type="text" name="txtPhone" value="<%= phone %>" /> <br>
            Birthday <input type="date" name="txtBirthday" value="<%= birthday %>"/> <br>
            Email <input type="email" name="txtEmail" value="<%= email %>"/> <br>
            <input type="submit" value="Update User" name="btnUpdate"/>
        </form>
    </body>
</html>
