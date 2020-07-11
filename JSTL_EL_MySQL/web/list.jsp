<%-- 
    Document   : list
    Created on : Jul 10, 2020, 7:45:16 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style.css" />
        <title>Database demo</title>
    </head>
    <body>
        <h1>Demo sql tag library</h1>
        <a href="insert.jsp">Add New</a>
        
        <sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/db_employees" user="root" password=""/>
        <sql:update var="delete" dataSource="${conn}" sql="DELETE FROM `Employees` WHERE EmployeeID='${param.del}'"/>
        
        <sql:query var="top5" dataSource="${conn}">
            SELECT EmployeeID, FirstName, LastName FROM Employees LIMIT 0, 100
        </sql:query>
            
        <table width="100%" border="1px" align="center">
            <tr bgcolor="#CFCF99">
                <c:forEach var="colName" items="${top5.columnNames}">
                    <td width="27%"><c:out value="${colName}"/></td>
                </c:forEach>
                <td>Delete</td>
            </tr>

            <c:forEach var="row" items="${top5.rows}">
                <tr>
                    <c:forEach var="col" items="${row}">
                        <td><c:out value="${col.value}"/></td>
                    </c:forEach>

                    <td>
                        <a href="list.jsp?del=${row.EmployeeID}">Delete</a>
                        <a href="edit.jsp?id=${row.EmployeeID}&f=${row.FirstName}&l=${row.LastName}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="footer" align="right">
            <br><br>
            <h5>Web Component Development</h5>
        </div>
    </body>
</html>
