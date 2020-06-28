<%-- 
    Document   : index
    Created on : Jun 11, 2020, 7:46:36 PM
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
        <h1>Login Form</h1> <hr>
        
        <form action="UserController" method="post">
            Username <input type="text" name="txtUsername" /> <br>
            Password <input type="password" name="txtPassword" /> <br>
            <input type="submit" value="Login" />
        </form>
        
    </body>
</html>
