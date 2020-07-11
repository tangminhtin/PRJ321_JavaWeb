<%-- 
    Document   : index
    Created on : Jul 11, 2020, 1:24:35 PM
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
        <h1>List of Customers</h1>
        <sql:setDataSource var="con" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost/pretest"
                           user="root" password=""/>

        <sql:query var="cus" dataSource="${con}" sql="SELECT * FROM `Customer`"/>
        <table cellspacing="10">
            <tr>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Address</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach var="c" items="${cus.rows}">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.birthday}</td>
                    <td>${c.gender}</td>
                    <td>${c.address}</td>
                    <td><a href="update.jsp?n=${c.name}&b=${c.birthday}&g=${c.gender}&a=${c.address}&i=${c.id}">Update</a></td>
                    <td><a href="index.jsp?id=${c.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${!empty param.id}">
            <sql:update var="del" dataSource="${con}" sql="DELETE FROM `Customer` WHERE id='${param.id}'"/>
            <c:if test="${del > 0}" >
                <script> alert('Delete Successfull');location.reload();</script>
            </c:if>
        </c:if>

        <c:out value="Session: ${sessionScope.ses_username}"/>
    </body>
</html>
