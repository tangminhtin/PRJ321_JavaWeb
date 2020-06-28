<%-- 
    Document   : payment
    Created on : Jun 12, 2020, 10:29:30 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Payment</h1> <hr>
        <!--form for payment--> 
        <form action="PaymentController" method="post">
            Email <input type="email" name="txtEmail" /> <br>
            Code <input type="text" name="txtCode" /> <br>
            <input type="submit" value="Payment" />
        </form>
    </body>
</html>
