<%-- 
    Document   : index
    Created on : Jul 10, 2020, 1:37:32 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fnStatic" uri="/WEB-INF/tlds/staticFunction" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL - Static function call</title>
    </head>
    <body>
        <h1>EL - Static function call</h1>
        <form method="post" name="frmData">
            <table border="1" cellspacing="10" cellpadding="0">
                <tr>
                    <td align="right">First Number:</td>
                    <td><input type="number" name="txtNum1"/></td>
                </tr>
                <tr>
                    <td align="right">Second Number:</td>
                    <td><input type="number" name="txtNum2"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="btnCal" value="Calculate"/></td>
                </tr>
            </table>
        </form>
        
        <hr>
        
        Add: ${fnStatic:add(param.txtNum1, param.txtNum2)}
        Sub: ${fnStatic:sub(param.txtNum1, param.txtNum2)}
        
    </body>
</html>
