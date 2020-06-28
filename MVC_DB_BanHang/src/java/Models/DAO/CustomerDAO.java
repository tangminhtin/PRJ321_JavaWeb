/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Customer;
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
public class CustomerDAO {

    private Connection connection; // create connection

    /**
     * constructor CustomerDAO
     */
    public CustomerDAO() {
        DBConnection dBConnection = new DBConnection(); // create db connection
        connection = dBConnection.getConnection(); // get connection
    }

    /**
     * insert
     *
     * @param c
     * @return
     */
    public boolean insert(Customer c) {
        try {
            String sql = "INSERT INTO `khachhang`(`khMa`, `khTen`, `khEmail`, `khSDT`, `khDiaChi`) VALUES (?, ?, ?, ?, ?)"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setString(1, c.getId()); // set id
            ps.setString(2, c.getName()); //set name
            ps.setString(3, c.getEmail()); // set email
            ps.setString(4, c.getPhone()); // set phone
            ps.setString(5, c.getAddress()); // set address

            return ps.execute(); // execute query
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * get customer
     *
     * @param id
     * @return
     */
    public Customer getCustomer(String id) {
        try {
            String sql = "SELECT `khTen`, `khEmail`, `khSDT`, `khDiaChi` FROM `khachhang` WHERE `khMa`=?"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setString(1, id); // set id
            ResultSet rs = ps.executeQuery(); // execute query
            if (rs.next()) {
                // return customer
                return new Customer(id, rs.getString("khTen"), rs.getString("khEmail"),
                        rs.getString("khSDT"), rs.getString("khDiaChi"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
