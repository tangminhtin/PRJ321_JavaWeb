<%-- 
    Document   : buy
    Created on : Jun 12, 2020, 11:55:38 AM
    Author     : tangminhtin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Cart</h1> <hr>
        
        <!--table of cart-->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart"); // get cart 
                    if (cart != null) { // check existed or not
                        for (Product p : cart) { // show each item in cart
                            out.println("<tr>");
                            out.println("<td>" + p.getId() + "</td>");
                            out.println("<td>" + p.getName() + "</td>");
                            out.println("<td>" + p.getQuantity() + "</td>");
                            out.println("<td>" + p.getPrice() * p.getQuantity() + "</td>");
                            out.println("<tr>");
                        }
                    }
                %>
            </tbody>
        </table>

        <a href="index.jsp">Continue buy</a>
        <a href="payment.jsp">Payment</a>
    </body>
</html>
