<%-- 
    Document   : my_jsp_include
    Created on : Jun 17, 2020, 12:19:08 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page jsp:include</title>
    </head>
    <body>
        <h1>This is page <strong>my_jsp_include</strong></h1>
        <jsp:include page="say_hello.jsp" flush="true" />
    </body>
</html>

