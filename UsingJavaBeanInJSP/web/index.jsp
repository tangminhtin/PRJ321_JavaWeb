<%-- 
    Document   : index
    Created on : Jun 28, 2020, 6:45:02 PM
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
        <jsp:useBean id="personObj" class="com.demo.Person">
            <jsp:setProperty name="personObj" property="firstName" value="Minh Tin" />
            <jsp:setProperty name="personObj" property="lastName" value="Tang" />
        </jsp:useBean>
        <h3>First name: <jsp:getProperty name="personObj" property="firstName"/></h3>
        <h3>Last name: <jsp:getProperty name="personObj" property="lastName"/></h3>
    </body>
</html>
