<%-- 
    Document   : insert
    Created on : Jun 11, 2020, 10:36:20 PM
    Author     : tangminhtin
--%>

<%@page import="java.sql.Date"%>
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
        <h1>Insert New User</h1> <hr>
        <%
            if(request.getParameter("btnInsert") != null) {
                User user = new User();
                user.setUsername(request.getParameter("txtUsername"));
                user.setPassword(request.getParameter("txtPassword"));
                user.setFullname(request.getParameter("txtFullname"));
                user.setPhone(request.getParameter("txtPhone"));
                user.setBirthday(Date.valueOf(request.getParameter("txtBirthday")));
                user.setEmail(request.getParameter("txtEmail"));

                UserDAO udao = new UserDAO();
                udao.insert(user);
                response.sendRedirect("userlist.jsp");
            }
            
        %>
        <form action="" method="">
            Username <input type="text" name="txtUsername" /> <br>
            Password <input type="password" name="txtPassword" /> <br>
            Fullname <input type="text" name="txtFullname" /> <br>
            Phone <input type="text" name="txtPhone" /> <br>
            Birthday <input type="date" name="txtBirthday" /> <br>
            Email <input type="email" name="txtEmail" /> <br>
            <input type="submit" value="Insert User" name="btnInsert"/>
        </form>
    </body>
</html>
