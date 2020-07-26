<%-- 
    Document   : index
    Created on : Jul 24, 2020, 10:49:25 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="de2tag2" uri="WEB-INF/tlds/tag2.tld" %>
<%@taglib prefix="de2tag1" uri="WEB-INF/tlds/tag1.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>LAB 1</h1>
        <de2tag1:tag1>
            SELECT * FROM `user` ORDER BY id ASC
        </de2tag1:tag1>



        <h1>LAB 2</h1>
        <de2tag2:tag2 start="1" end="3"/>

    </body>
</html>
