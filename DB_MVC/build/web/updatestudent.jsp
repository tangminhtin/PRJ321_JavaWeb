<%-- 
    Document   : updatestudent
    Created on : Jun 10, 2020, 11:11:14 AM
    Author     : tangminhtin
--%>

<%@page import="Models.Entities.Student"%>
<%@page import="Models.DAO.StudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = "";
            String fullname = "";
            String birthday = "";
            String email = "";
            String phone = "";
            String address = "";
            
            if (request.getParameter("id") != null) {
                id = request.getParameter("id");
                StudentDAO sdao = new StudentDAO();
                
                Student student = sdao.getStudent(id);
                fullname = student.getFullname();
                birthday = student.getBirthday().toString();
                email = student.getEmail();
                phone = student.getPhone();
                address = student.getAddress();
            }
        %>
        
        <form action="StudentController" method="POST">
            <input type="hidden" name="id" value="<%= id %>" /> <br>
            Fullname: <input type="text" name="txtFullname"  id="txtFullname" value="<%= fullname %>" /> <br>
            Birthday <input type="date" name="txtBirthday" id="txtBirthday" value="<%= birthday %>" /> <br>
            Email: <input type="text" name="txtEmail" id="txtEmail" value="<%= email %>" /> <br>
            Phone: <input type="text" name="txtPhone" id="txtPhone" value="<%= phone %>" /> <br>
            Address <textarea type="text" name="txtAddress"  id="txtAddress"><%= address %></textarea> <br>
            <input type="submit" value="Update" name="btnUpdate" /> <input type="reset" value="Reset" />
        </form>
    </body>
</html>