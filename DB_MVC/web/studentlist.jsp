<%-- 
    Document   : studentlist
    Created on : Jun 6, 2020, 8:34:40 AM
    Author     : tangminhtin
--%>

<%@page import="java.sql.ResultSet"%>
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
            if (request.getParameter("id") != null) {
                String id = request.getParameter("id");
                StudentDAO sdao = new StudentDAO();

                if (sdao.deleteStudent(id) != 0) {
                    out.print("<script>alert('Delete Success!')</script>");
                } else {
                    out.print("<script>alert('Delete Failed!')</script>");
                }
                out.print("<script>location.href='studentlist.jsp'</script>");
            }
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full name</th>
                    <th>Birthday</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    StudentDAO sdao = new StudentDAO();
                    ResultSet rs = sdao.getStudents();

                    while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rs.getString("id") + "</td>");
                        out.print("<td>" + rs.getString("fullname") + "</td>");
                        out.print("<td>" + rs.getString("birthday") + "</td>");
                        out.print("<td>" + rs.getString("email") + "</td>");
                        out.print("<td>" + rs.getString("phone") + "</td>");
                        out.print("<td>" + rs.getString("address") + "</td>");
                        out.print("<td><a href='?id=" + rs.getString("id") + "'>Delete</a></td>");
                        out.print("<td><a href='updatestudent.jsp?id=" + rs.getString("id") + "'>Update</a></td>");
                        out.print("</tr>");
                    }

                %>
            </tbody>
        </table>

    </body>
</html>
