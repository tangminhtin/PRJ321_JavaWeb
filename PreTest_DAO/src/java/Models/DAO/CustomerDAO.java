/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class CustomerDAO {

    private Connection conn;

    public CustomerDAO() {
        DBConnection dBConnection = new DBConnection();
        conn = dBConnection.getConnection();
    }

    public ArrayList<Customer> getCustomers() {
        try {
            ArrayList<Customer> customers = new ArrayList<>();
            String sql = "SELECT * FROM `Customer`";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"),
                        rs.getString("name"), rs.getDate("birthday"), rs.getString("gender"), rs.getString("address")));
            }
            return customers;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int delete(int id) {
        try {
            String sql = "DELETE FROM `Customer` WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean update(String name, String birthday, String gender, String address, int id) {
        try {
            String sql = " UPDATE `Customer` SET `name`=?, `birthday`=?,`gender`=?,`address`=? WHERE `id`=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, Date.valueOf(birthday));
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setInt(5, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
