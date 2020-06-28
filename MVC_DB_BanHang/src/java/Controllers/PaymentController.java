/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DAO.BillDAO;
import Models.DAO.BillDetailDAO;
import Models.DAO.CustomerDAO;
import Models.DAO.ProductDAO;
import Models.Entities.Bill;
import Models.Entities.BillDetail;
import Models.Entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tangminhtin
 */
public class PaymentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String email = request.getParameter("txtEmail"); // get email
            String cusId = request.getParameter("txtCode"); // get id customer

            HttpSession session = request.getSession(); // get session
            ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart"); // get cart of session

            CustomerDAO cdao = new CustomerDAO(); // create new customer dao
            if (cdao.getCustomer(cusId) != null) { // if customer is existed
                BillDAO bdao = new BillDAO(); // create bill dao

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // format for date
                Date date = new Date(); // get current date
                double totalPrice = 0; // store price

                // calculate total price list cart
                for (Product p : cart) {
                    totalPrice += p.getPrice() * p.getQuantity();
                }
                // insert new bill
                bdao.insert(new Bill(cusId, totalPrice, java.sql.Date.valueOf(sdf.format(date))));

                BillDetailDAO bddao = new BillDetailDAO(); // create bill detail dao
                ProductDAO pdao = new ProductDAO(); // create product dao

                Bill bill = bdao.getCurrentBill(); // get current bill
                if (bill != null) { // if bill is existed
                    // insert each item in list to bill detail
                    for (Product p : cart) {
                        bddao.insert(new BillDetail(bill.getId(), p.getId(), p.getQuantity(), p.getQuantity() * p.getPrice()));
//                        pdao.update(p.getId(), p.getQuantity());
                    }
                }

                session.removeAttribute("cart"); // remove session after payment
                out.println("Booking Successful!");
                out.println("<br><a href='index.jsp'>Back to home</a>");
            } else {
                response.sendRedirect("payment.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
