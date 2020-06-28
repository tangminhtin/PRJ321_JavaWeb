<%-- 
    Document   : jsp_param
    Created on : Jun 17, 2020, 8:55:44 AM
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
        <h1>jsp:param Page</h1>
        <jsp:include page="show_param.jsp" flush="true" >
            <jsp:param name="username" value="Tang Minh Tin" />
            <jsp:param name="password" value="123456" />
        </jsp:include>
    </body>
</html>
