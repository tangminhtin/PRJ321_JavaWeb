/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Bill;
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
public class BillDAO {

    private Connection connection; // create connection

    /**
     * constructor BillDAO
     */
    public BillDAO() {
        DBConnection dBConnection = new DBConnection(); // create db connection
        connection = dBConnection.getConnection(); // get connection
    }

    /**
     * insert
     *
     * @param b
     * @return
     */
    public boolean insert(Bill b) {
        try {
            String sql = "INSERT INTO `hoadon`(`khMa`, `hdTongTien`, `hdNgayMua`) VALUES (?, ?, ?)"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setString(1, b.getCusId());  // set id
            ps.setDouble(2, b.getTotalPrice()); // set total price
            ps.setDate(3, b.getDateBuy()); // set date of buy

            return ps.execute(); // execute query
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * get current bill
     *
     * @return
     */
    public Bill getCurrentBill() {
        try {
            String sql = "SELECT * FROM `hoadon`"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ResultSet rs = ps.executeQuery(); // execute query

            if (rs.last()) {
                // return bill
                return new Bill(rs.getInt("hdMa"), rs.getString("khMa"), rs.getInt("hdTongTien"), rs.getDate("hdNgayMua"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
