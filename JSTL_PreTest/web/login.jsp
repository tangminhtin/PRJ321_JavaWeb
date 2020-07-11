<%-- 
    Document   : login
    Created on : Jul 11, 2020, 1:24:55 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1> <hr>
        <form>
            Username <input type="text" name="user" /> <br>
            Password <input type="password" name="pass" /> <br>
            <input type="submit" name="login" value="Login" />
        </form>

        <sql:setDataSource var="con" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost/pretest"
                           user="root" password="" />
        <c:if test="${param.user!= null && param.pass != null}" >
            <sql:query var="admin" dataSource="${con}" 
                       sql="SELECT * FROM `Admin` WHERE username='${param.user}' AND password=MD5('${param.pass}')" />
            <c:forEach var="a" items="${admin.rows}">
                <c:set var="ses_username" value="${a.username}" scope="session"/>
                <c:if test="${!empty a.username}">
                    <c:redirect url="index.jsp"/>
                </c:if>
            </c:forEach>
        </c:if>         
    </body>
</html>
