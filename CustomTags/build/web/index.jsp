<%-- 
    Document   : index
    Created on : Jul 24, 2020, 8:33:51 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="WEB-INF/tlds/myTag.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Student</h1>
        <my:myTag database="db_student"  url="jdbc:mysql://localhost/" user="root" password=""/>
    </body>
</html>
