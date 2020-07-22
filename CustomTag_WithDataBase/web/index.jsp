<%-- 
    Document   : index
    Created on : Jul 23, 2020, 12:47:54 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myTags" uri="WEB-INF/tlds/myTag.tld" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Student</h1>
        <myTags:myTag database="db_student" user="root" pass=""/>
    </body>
</html>
