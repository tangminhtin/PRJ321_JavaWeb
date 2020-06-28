/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class BillDetailDAO {

    private Connection connection; // create connection

    /**
     * constructor BillDetailDAO
     */
    public BillDetailDAO() {
        DBConnection dBConnection = new DBConnection(); // create db connection
        connection = dBConnection.getConnection(); // get connection
    }

    /**
     * insert
     *
     * @param bd
     * @return
     */
    public boolean insert(BillDetail bd) {
        try {
            String sql = "INSERT INTO `hoadonchitiet`(`hdMa`, `spMa`, `hdctSoLuong`, `hdctThanhTien`) VALUES (?, ?, ?, ?)"; // query
            PreparedStatement ps = connection.prepareStatement(sql); // prepareStatement
            ps.setInt(1, bd.getBId()); // set id bill
            ps.setInt(2, bd.getProId()); // set id product
            ps.setInt(3, bd.getQuantity()); // set quantity
            ps.setDouble(4, bd.getTotalPrice()); // set total price

            return ps.execute(); // excute query
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
