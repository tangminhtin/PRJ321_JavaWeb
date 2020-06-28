<%-- 
    Document   : login
    Created on : Jun 3, 2020, 1:21:35 PM
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
        <h1>Login Form</h1>
        <%
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");

            if ((user != null) && (pass != null)) {
                if (user.equals("admin") && pass.equals("123")) {
                    Cookie cUser = new Cookie("username", user);
                    Cookie cPass = new Cookie("password", pass);

                    cUser.setMaxAge(60 * 60 * 24);
                    cPass.setMaxAge(60 * 60 * 24);

                    response.addCookie(cUser);
                    response.addCookie(cPass);

                    response.sendRedirect("dashboard.jsp");
                }
            }
        %>

        <form method="POST">
            Username <input type="text" name="user" /> <br>
            Password <input type="password" name="pass" /> <br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
