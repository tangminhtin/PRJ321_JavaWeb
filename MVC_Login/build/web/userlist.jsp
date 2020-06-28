<%-- 
    Document   : userlist
    Created on : Jun 11, 2020, 8:00:29 PM
    Author     : tangminhtin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Models.DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User List</h1> <hr>
        
        <%
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                UserDAO udao = new UserDAO();
                
                if(udao.delete(id) != 0) {
                    out.print("<script>alert('Delete Success!')</script>");
                } else {
                    out.print("<script>alert('Delete Failed!')</script>");
                }
                out.print("<script>location.href='userlist.jsp'</script>");
            }
        %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full name</th>
                    <th>Phone</th>
                    <th>Birthday</th>
                    <th>Email</th>
                    <th>Delete</th>
                    <th>Update</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    UserDAO udao = new UserDAO();
                    ResultSet rs = udao.getUsers();

                    while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rs.getString("id") + "</td>");
                        out.print("<td>" + rs.getString("fullname") + "</td>");
                        out.print("<td>" + rs.getString("phone") + "</td>");
                        out.print("<td>" + rs.getString("birthday") + "</td>");
                        out.print("<td>" + rs.getString("email") + "</td>");
                        out.print("<td><a href='?id=" + rs.getInt("id") + "'>Delete</a></td>");
                        out.print("<td><a href='update.jsp?id=" + rs.getInt("id") + "'>Update</a></td>");
                        out.print("<t/r>");
                    }
                %>
            </tbody>
        </table>
          
            <a href="insert.jsp">Insert new User</a>
            
    </body>
</html>
