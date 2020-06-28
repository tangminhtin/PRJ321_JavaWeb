<%-- 
    Document   : sanpham.jsp
    Created on : Jun 15, 2020, 11:24:09 AM
    Author     : luong
--%>

<%@page import="DAO.SanPhamDAO"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <th>Ma sp</th>
                <th>Ten san pham</th>
                <th>So luong</th>
                <th>Don gia</th>
                <th>Mo ta </th>
                <th></th>
            </tr>
        <%
            SanPhamDAO dao = new SanPhamDAO();
            ResultSet rs = dao.getAll();
            while(rs.next()){
                out.print("<tr>");
                    out.print("<td>"+rs.getInt("sp_ma") +"</td>");
                    out.print("<td>"+rs.getString("sp_ten") +"</td>");
                    out.print("<td>"+rs.getInt("sp_soluong") +"</td>");
                    out.print("<td>"+rs.getInt("sp_dongia") +"</td>");
                    out.print("<td>"+rs.getString("sp_mota") +"</td>");
                    out.print("<td><a href='giohang.jsp?masp="+rs.getInt("sp_ma")+"'>Mua</a></td>");
                out.print("</tr>");
            }
        %>
        </table>
    </body>
</html>
