/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luong
 */
public class HoaDonDAO {
    public boolean themHoaDon(int cusID, int tongtien){
        DBConnection db = new DBConnection();
        String sql="Insert into hoadon(kh_ma, hd_tongtien, hd_ngaymua) values(?,?,?)";
        int rs=0;
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            st.setInt(1, cusID);
            st.setInt(2, tongtien);
            st.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            rs = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs>0?true:false;
    }
    
    public int getMaxHD(){
        DBConnection db = new DBConnection();
        String sql="Select max(hd_ma) as hd_ma from hoadon";
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return rs.getInt("hd_ma");
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
