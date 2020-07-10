<%-- 
    Document   : index
    Created on : Jul 10, 2020, 12:55:44 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using Expression Language in JSP</title>
    </head>
    <body>
        <h1>Using Expression Language in JSP</h1>
        <form method="post" name="frmEL">
            <table border="1" cellspacing="5" cellpadding="0">
                <tr>
                    <td>Product name</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="txtPrice"></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="txtQuantity"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="btnOK" value="Add product"></td>
                </tr>
            </table>
        </form>
        
        <hr>
        
        <form method="post" name="frmEL">
            <table border="1" cellspacing="5" cellpadding="0">
                <tr>
                    <td align="right">Product name:</td>
                    <td>${param.txtName}</td>
                </tr>
                <tr>
                    <td align="right">Price:</td>
                    <td>${param.txtPrice}</td>
                </tr>
                <tr>
                    <td align="right">Quantity:</td>
                    <td>${param.txtQuantity}</td>
                </tr>
                <tr>
                    <td align="right">Total:</td>
                    <td>${param.txtPrice * param.txtQuantity}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
