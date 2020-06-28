/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luong
 */
public class HoaDonChiTietDAO {
    public void themHDCT(int hd_ma, int sp_ma, int soluong, int thanhtien){
        DBConnection db = new DBConnection();
        String sql="Insert into hoadonchitiet values(?,?,?,?)";
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            st.setInt(1, hd_ma);
            st.setInt(2, sp_ma);
            st.setInt(3, soluong);
            st.setInt(4, thanhtien);
            st.executeUpdate();
            
            SanPhamDAO sp = new SanPhamDAO();
            sp.updateSL(sp_ma, soluong);
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
