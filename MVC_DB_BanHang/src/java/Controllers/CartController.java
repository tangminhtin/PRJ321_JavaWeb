/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DAO.ProductDAO;
import Models.Entities.Product;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tangminhtin
 */
public class CartController extends HttpServlet {

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

        if (request.getParameter("id") != null) { // if id is existed
            HttpSession session = request.getSession(); // get session
            ProductDAO pdao = new ProductDAO(); // create productdao

            int id = Integer.parseInt(request.getParameter("id")); // get id

            if (session.getAttribute("cart") == null) { // if session cart is null
                ArrayList<Product> cart = new ArrayList<>(); // create list cart
                Product product = pdao.getProduct(id); // get product with id
                if (product.getQuantity() != 0) {
                    product.setQuantity(1); // set quantity equal 1
                    cart.add(product); // add product to cart
                    session.setAttribute("cart", cart); // add cart to session
                }
            } else {
                // if existed the get list of cart
                ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
                int index = -1; // store index of item existed

                // find item exist in list cart
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).getId() == id) {
                        index = i;
                        break;
                    }
                }

                // if not exist, create new item then add it to cart
                if (index == -1) {
                    if (pdao.getProduct(id).getQuantity() != 0) {
                        Product product = pdao.getProduct(id);
                        product.setQuantity(1);
                        cart.add(product);
                    }
                } else {
                    // otherwise update quantity of item
                    if (pdao.getProduct(id).getQuantity() != 0) {
                        int quantity = cart.get(index).getQuantity() + 1;
                        cart.get(index).setQuantity(quantity);
                    }
                }
                session.setAttribute("cart", cart); // add cart to session cart
            }
            if (pdao.getProduct(id).getQuantity() != 0) {
                pdao.update(id, pdao.getProduct(id).getQuantity() - 1); // get update quantity of product
            }
            response.sendRedirect("cart.jsp"); // send to cart.jsp
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
