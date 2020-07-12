<%-- 
    Document   : index
    Created on : Jul 11, 2020, 9:01:01 AM
    Author     : tangminhtin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entities.Customer"%>
<%@page import="Models.DAO.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of Customer</h1>
        <table border="1" cellspacing="10" cellpadding="10">
            
            <th>
                <td>Name</td>
                <td>Birthday</td>
                <td>Gender</td>
                <td>Address</td>
                <td>Action</td>
            </th>
            <tr>
                <%--<sql:setDataSource var="conn" driver="" url="jdbc:mysql://localhost/ontap" password="root" user=""/>--%>
                <%
                    CustomerDAO dAO = new CustomerDAO();
                    session.setAttribute("customer", dAO.getCustomers());
                %>
                <c:forEach var="c" items="${customer}">
                    <td>${c.name}</td>
                    <td>${c.birthday}</td>
                    <td>${c.gender}</td>
                    <td>${c.address}</td>
                    <td><a href="update.jsp?id=${c.id}">Update</a></td>
                    <td><a href="index.jsp?id=${c.id}">Delete</a></td>
                </c:forEach>
                
            </tr>
        </table>
    </body>
</html>
