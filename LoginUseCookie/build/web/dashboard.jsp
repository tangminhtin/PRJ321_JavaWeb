<%-- 
    Document   : dashboard
    Created on : Jun 3, 2020, 1:21:46 PM
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
        <h1>Dashboard</h1>
        <h2>Your login successful!</h2>
        <%
            Cookie[] cookies = request.getCookies();

            if (cookies.length <= 1) {
                response.sendRedirect("login.jsp");
            } else {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        out.println("Hello " + c.getValue() + "<br>");
                    }
                }

                if (request.getParameter("logout") != null) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("username")) {
                            c.setMaxAge(0);
                            response.addCookie(c);
                        }
                        if (c.getName().equals("password")) {
                            c.setMaxAge(0);
                            response.addCookie(c);
                        }
                    }
                    response.sendRedirect("login.jsp");
                }
            }
        %>
        
        <br><a href='?logout' name="logout">Logout</a>

    </body>
</html>
