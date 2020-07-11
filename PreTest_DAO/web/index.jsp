<%-- 
    Document   : index
    Created on : Jul 11, 2020, 1:24:35 PM
    Author     : tangminhtin
--%>

<%@page import="Models.DAO.CustomerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entities.Customer"%>
<%@page import="Models.Entities.Customer"%>
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
        <table cellspacing="10">
            <tr>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Address</th>
                <th colspan="2">Action</th>
            </tr>
            <%
                CustomerDAO cdao = new CustomerDAO();
                ArrayList<Customer> customers = cdao.getCustomers();
            %>
            <c:forEach var="c" items="<%=customers%>">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.birthday}</td>
                    <td>${c.gender}</td>
                    <td>${c.address}</td>
                    <td><a href="update.jsp?n=${c.name}&b=${c.birthday}&g=${c.gender}&a=${c.address}&i=${c.id}">Update</a></td>
                    <td><a href="Controllers?id=${c.id}&del=ok">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
