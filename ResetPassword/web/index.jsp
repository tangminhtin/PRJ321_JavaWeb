<%-- 
    Document   : index
    Created on : Jul 23, 2020, 2:21:02 AM
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
        <h1>Reset Password</h1>
        <form action="ResetController" method="POST">
            Email <input type="email" name="txtEmail"/>
            <input type="submit" name="btnSend" value="Send"/>
            Verify Code <input type="text" name="txtCode"/>
            <input type="submit" name="btnCode" value="Active"/>
        </form>
        
        
    </body>
</html>
