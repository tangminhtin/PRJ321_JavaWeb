<%-- 
    Document   : index
    Created on : Jul 15, 2020, 8:53:18 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fnStatic" uri="/WEB-INF/tlds/staticFunction" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Users</h1>

        <table border="1" cellspacing="10" cellpadding="0">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
            </tr>
            <tr>
                ${fnStatic:getDatas()}
        </table>
    </body>
</html>
