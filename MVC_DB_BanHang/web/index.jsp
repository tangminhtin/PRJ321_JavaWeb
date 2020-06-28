<%-- 
    Document   : index
    Created on : Jun 12, 2020, 11:37:12 AM
    Author     : tangminhtin
--%>

<%@page import="Models.Entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Models.DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Product</h1> <hr>

        <!--table of product-->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Description</th>
                    <th>Buy</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ProductDAO pdao = new ProductDAO(); // create new product
                    ResultSet rs = pdao.getProducts(); // get all product

                    while (rs.next()) { // show each product in result set
                        if(rs.getInt("spSoLuong") != 0) {
                            out.println("<tr>");
                            out.println("<td>" + rs.getInt("spMa") + "</td>");
                            out.println("<td>" + rs.getString("spTen") + "</td>");
                            out.println("<td>" + rs.getDouble("spGia") + "</td>");
                            out.println("<td>" + rs.getInt("spSoLuong") + "</td>");
                            out.println("<td>" + rs.getString("spMoTa") + "</td>");
                            out.println("<td><a href='CartController?id=" + rs.getInt("spMa") + "'>Buy</a></td>");
                            out.println("<tr>");
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
