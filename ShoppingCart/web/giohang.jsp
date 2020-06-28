<%-- 
    Document   : giohang
    Created on : Jun 15, 2020, 11:34:00 AM
    Author     : luong
--%>

<%@page import="java.util.Set"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Entities.SanPham"%>
<%@page import="java.util.HashMap"%>
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
                <th>Thanh tien</th>
            </tr>
        <%
            if(request.getParameter("masp")!=null){
                int masp = Integer.parseInt(request.getParameter("masp"));
                if(session.getAttribute("giohang")==null){
                    HashMap<Integer, Integer> giohang = new HashMap<Integer, Integer>();
                    giohang.put(masp, 1);
                    SanPhamDAO dao = new SanPhamDAO();
                    SanPham sp = dao.getSP(masp);
                    out.print("<tr>");
                        out.print("<td>"+sp.getSp_ma()+"</td>");
                        out.print("<td>"+sp.getSp_ten() +"</td>");
                        out.print("<td>1</td>");
                        out.print("<td>"+ sp.getSp_dongia() +"</td>");
                        out.print("<td>"+ sp.getSp_dongia() +"</td>");
                    out.print("</tr>");
                    out.print("<tr><td colspan='4'>Tong tien</td><td>"+sp.getSp_dongia()+"</td></tr>");
                    session.setAttribute("giohang", giohang);
                    session.setAttribute("sum", sp.getSp_dongia());
                }
                else{//Co gio hang roi
                    HashMap<Integer, Integer> giohang = new HashMap<Integer, Integer>();
                    giohang = (HashMap<Integer, Integer>) session.getAttribute("giohang");
                    if(giohang.containsKey(masp)){
                        int soluonghientai = giohang.get(masp);
                        soluonghientai++;
                        giohang.put(masp, soluonghientai);
                        session.setAttribute("giohang", giohang);
                    }else{
                        giohang.put(masp, 1);
                        session.setAttribute("giohang", giohang);
                    }
                    
                    SanPhamDAO dao = new SanPhamDAO();
                    int tongtien=0;
                    for(Integer i : giohang.keySet()){
                        int soluong = giohang.get(i);
                        SanPham sp =  dao.getSP(i);
                        out.print("<tr>");
                            out.print("<td>"+sp.getSp_ma()+"</td>");
                            out.print("<td>"+sp.getSp_ten() +"</td>");
                            out.print("<td>"+giohang.get(i)+"</td>");
                            out.print("<td>"+ sp.getSp_dongia() +"</td>");
                            out.print("<td>"+ giohang.get(i)*sp.getSp_dongia() +"</td>");
                        out.print("</tr>");
                        tongtien+=giohang.get(i)*sp.getSp_dongia();
                    }
                    out.print("<tr><td colspan='4'>Tong tien</td><td>"+tongtien+"</td></tr>");
                    session.setAttribute("sum", tongtien);
                }
            }
        %>
        </table>
        <a href="sanpham.jsp">Mua tiep</a>
        <a href="thanhtoan.jsp">Thanh toan</a>
    </body>
</html>
