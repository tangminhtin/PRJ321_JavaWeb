<%-- 
    Document   : index
    Created on : Jun 1, 2020, 10:45:19 AM
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
        <h1>Login</h1>
         <form action="index.jsp" method="POST">
            Username <input type="text" name="username" /> <br>
            Password <input type="password" name="password" /> <br>
            <input type="submit" value="Login" />
        </form>
        
        <%
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            
            if(user != null && pass != null) {
                if (user.equals("admin") && pass.equals("admin")) {
                    application.setAttribute("user", user);
                    application.setAttribute("pass", pass);
                    response.sendRedirect("dashboard.jsp");
                }
            }
        %>
    </body>
</html>
