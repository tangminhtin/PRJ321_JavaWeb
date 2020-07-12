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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class CustomerDAO {

    private Connection connection;

    public CustomerDAO() {
        DBConnection dBConnection = new DBConnection();
        connection = dBConnection.getConnection();
    }

    public ArrayList<Customer> getCustomers() {
        try {
            ArrayList<Customer> customers = new ArrayList<>();
            String sql = "SELECT * FROM `customer`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            customers.clear();

            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("name"),
                        new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday")), rs.getString("gender"),
                        rs.getString("address")));

            }

            return customers;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(int id, String name, Date birthday, String gender, String address) {
        try {
            String sql = "UPDATE `customer` SET name`=?,`birthday`=?,`gender`=?,`address`=? WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, new java.sql.Date(birthday.getTime()));
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, id);

            return preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Customer getCustomer(int id) {
        try {
            String sql = "SELECT * FROM `customer` WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            return new Customer(rs.getInt("id"), rs.getString("name"),
                    new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("birthday")), rs.getString("gender"),
                    rs.getString("address"));

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
