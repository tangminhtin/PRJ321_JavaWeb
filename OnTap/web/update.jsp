<%-- 
    Document   : update
    Created on : Jul 11, 2020, 9:01:11 AM
    Author     : tangminhtin
--%>

<%@page import="Models.Entities.Customer"%>
<%@page import="Models.Entities.Admin"%>
<%@page import="Models.DAO.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update</h1>
        <form action="" method="post">
            <% 
                String id = request.getParameter("id");
                if(id != null) {
                    CustomerDAO cdao = new CustomerDAO();
                    Customer c = cdao.getCustomer(Integer.parseInt(id));
                }
            %>
            Name<input type="text" name="txtName" value=""/>
            Birthday<input type="text" name="txtBirthday"/>
            Gender<input type="text" name="txtGender"/>
            Address<input type="text" name="txtAddress"/>
            <input type="submit" name="btnUpdate" value="Update"/>
        </form>
    </body>
</html>
