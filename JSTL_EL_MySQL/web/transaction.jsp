<%-- 
    Document   : transaction
    Created on : Jul 10, 2020, 9:14:25 PM
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
        <title>Transaction Page</title>
    </head>
    <body>
        <h1>Transaction demo</h1>
        
        <sql:setDataSource var="conn" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" url="jdbc:sqlserver://TANGMINHTIN;database=Northwind;" user="tangminhtin" password="123"/>
        
        <sql:transaction dataSource="${conn}">
            <sql:update var="update1">
                UPDATE Employees SET FirstName=?, LastName=? WHERE EmployeeID=?
                
                <sql:param value="Mr"/>
                <sql:param value="Tin"/>
                <sql:param value="1"/>
            </sql:update>
                
            <sql:update var="update2">
                 UPDATE Employees SET FirstName=?, LastName=? WHERE EmployeeID=?

                <sql:param value="Mr"/>
                <sql:param value="Khang"/>
                <sql:param value="a"/>
            </sql:update>
        </sql:transaction>
    </body>
</html>
