<%-- 
    Document   : thanhtoan
    Created on : Jun 17, 2020, 10:39:15 AM
    Author     : luong
--%>

<%@page import="DAO.HoaDonChiTietDAO"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="Entities.SanPham"%>
<%@page import="java.util.HashMap"%>
<%@page import="DAO.HoaDonDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("btnSubmit")!=null){
                String email = request.getParameter("txtEmail");
                int id = Integer.parseInt(request.getParameter("txtID"));
                
                HoaDonDAO dao = new HoaDonDAO();
                dao.themHoaDon(id, Integer.parseInt(session.getAttribute("sum").toString()));
                int maxid = dao.getMaxHD();
                SanPhamDAO spDAO = new SanPhamDAO();
                HashMap<Integer, Integer> giohang = new HashMap<Integer, Integer>();
                giohang = (HashMap<Integer, Integer>) session.getAttribute("giohang");
                for(Integer i : giohang.keySet()){
                    int soluong = giohang.get(i);
                    SanPham sp =  spDAO.getSP(i);
                    HoaDonChiTietDAO hdctDAO = new HoaDonChiTietDAO();
                    hdctDAO.themHDCT(maxid, i, soluong, soluong*sp.getSp_dongia());
                }
                session.removeAttribute("giohang");
                session.removeAttribute("tongtien");
                out.print("<script>alert('Thanh toan thanh cong');</script>");
                out.print("<script>location.href='sanpham.jsp';</script>");
            }
        %>
        <form>
            Email: <input type="email" name="txtEmail" />
            <br/>
            Ma khach hang:<input type="text" name="txtID"/>
            <br/>
            <input type="submit" value="Thanh toan" name="btnSubmit"/>
        </form>
    </body>
</html>
