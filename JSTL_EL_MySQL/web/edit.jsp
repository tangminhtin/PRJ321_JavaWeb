<%-- 
    Document   : edit
    Created on : Jul 10, 2020, 8:57:17 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="myStyle.css" />
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Page</h1>
        <a href="insert.jsp">Add New</a>
        <a href="list.jsp">List All</a>
        
        <form action="edit.jsp" method="post">
            <table align="center">
                <tr>
                    <td colspan="2" align="center">
                        <h1>JSP Page</h1>
                    </td>
                </tr>
                <tr>
                    <td><input type="hidden" name="txtId" value="${param.id}"></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="txtFirst" value="${param.f}"></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="txtLast" value="${param.l}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </table>
                
            <c:if test="${!empty param.txtId}">
                <sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/db_employees" user="root" password=""/>
        
                <sql:update var="update" dataSource="${conn}">
                    UPDATE Employees SET FirstName=?, LastName=? WHERE EmployeeID=?

                    <sql:param value="${param.txtFirst}"/>
                    <sql:param value="${param.txtLast}"/>
                    <sql:param value="${param.txtId}"/>
                </sql:update>
            </c:if>
                            
        </form>
        
         <div class="footer" align="right">
            <br><br>
            <h5>Web Component Development</h5>
        </div>
    </body>
</html>
