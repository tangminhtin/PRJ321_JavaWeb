<%-- 
    Document   : update
    Created on : Jul 11, 2020, 2:54:05 PM
    Author     : tangminhtin
--%>

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
        <h1>Update</h1>
        <form>
            Name <input type="text" name="txtName" value="${param.n}"/> <br>
            Birthday <input type="date" name="txtBirthday" value="${param.b}"/> <br>
            Gender <input type="text" name="txtGender" value="${param.g}"/> <br>
            Address <input type="text" name="txtAddress" value="${param.a}"/> <br>
            <input type="hidden" name="txtId" value="${param.i}"/> <br>
            <input type="submit" name="btnUpdate" value="Update"/> <br>
        </form>
            <c:if test="${!empty param.btnUpdate}">
                <sql:setDataSource var="con" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost/pretest"
                           user="root" password="" />
        
                <sql:update var="cus" dataSource="${con}">
                    UPDATE `Customer` SET `name`=?, `birthday`=?,`gender`=?,`address`=? WHERE `id`=?
                    
                    <sql:param value="${param.txtName}"/>
                    <sql:param value="${param.txtBirthday}"/>
                    <sql:param value="${param.txtGender}"/>
                    <sql:param value="${param.txtAddress}"/>
                    <sql:param value="${param.txtId}"/>
                </sql:update>
                <script>window.location.href="index.jsp";</script>
            </c:if>
    </body>
</html>
