<%-- 
    Document   : index
    Created on : Jun 4, 2020, 7:28:08 PM
    Author     : TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
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
        <hr>
        <form action="UserServlet" method="POST"> 
            Username <input type="text" name="username" /> <br>
            Password <input type="password" name="password" /> <br>
            <input type="submit" value="Login" />
        </form>        
    </body>
</html>
