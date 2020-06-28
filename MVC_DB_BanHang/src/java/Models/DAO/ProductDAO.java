/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class ProductDAO {

    private Connection connection; // create connection

    /**
     *
     */
    public ProductDAO() {
        DBConnection dBConnection = new DBConnection(); // create db connection
        connection = dBConnection.getConnection(); // get connection
    }

    /**
     * insert
     *
     * @param p
     * @return
     */
    public boolean insert(Product p) {
        try {
            String sql = "INSERT INTO `sanpham`(`spTen`, `spGia`, `spSoLuong`, `spMoTa`) VALUES (?, ?, ?, ?)"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setString(1, p.getName()); // set name
            ps.setDouble(2, p.getPrice()); // set price
            ps.setInt(3, p.getQuantity()); // set quantity
            ps.setString(4, p.getDes()); // set description

            return ps.execute(); // execute query
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * get products
     *
     * @return
     */
    public ResultSet getProducts() {
        try {
            String sql = "SELECT * FROM `sanpham`"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement

            return ps.executeQuery(); // execute query
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * get product by id
     *
     * @param id
     * @return
     */
    public Product getProduct(int id) {
        try {
            String sql = "SELECT `spTen`, `spGia`, `spSoLuong`, `spMoTa` FROM `sanpham` WHERE `spMa`=?"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setInt(1, id); // set id
            ResultSet rs = ps.executeQuery(); // execute query
            if (rs.next()) {
                // return product
                return new Product(id, rs.getString("spTen"),
                        rs.getDouble("spGia"), rs.getInt("spSoLuong"), rs.getString("spMoTa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * update
     *
     * @param id
     * @param quantity
     * @return
     */
    public boolean update(int id, int quantity) {
        try {
            String sql = "UPDATE `sanpham` SET `spSoLuong`=? WHERE `spMa`=?"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setInt(1, quantity); // set quantity
            ps.setInt(2, id); // set id

            return ps.execute(); // execute query
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
