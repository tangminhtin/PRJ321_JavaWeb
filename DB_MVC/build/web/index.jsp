<%-- 
    Document   : index
    Created on : Jun 6, 2020, 8:12:38 AM
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
        <form action="StudentController" method="POST">
            ID: <input type="text" name="txtID" id="txtID" /> <br>
            Fullname: <input type="text" name="txtFullname"  id="txtFullname"/> <br>
            Birthday <input type="date" name="txtBirthday" id="txtBirthday" /> <br>
            Email: <input type="text" name="txtEmail" id="txtEmail" /> <br>
            Phone: <input type="text" name="txtPhone" id="txtPhone"/> <br>
            Address <textarea type="text" name="txtAddress"  id="txtAddress"> </textarea> <br>
            <input type="submit" value="Submit" /> <input type="reset" value="Reset" />
        </form>
    </body>
</html>
