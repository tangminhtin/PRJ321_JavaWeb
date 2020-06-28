package DAO;


import Entities.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class SanPhamDAO {
    public SanPhamDAO(){
        
    }
    public ResultSet getAll(){
        DBConnection db = new DBConnection();
        String sql = "Select * from sanpham";
        
        ResultSet rs = null;
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public SanPham getSP(int i){
        DBConnection db = new DBConnection();
        String sql = "Select * from sanpham where sp_ma = ?";
        
        ResultSet rs = null;
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            st.setInt(1, i);
            rs = st.executeQuery();
            if(rs.next()){
                SanPham sp = new SanPham(rs.getInt("sp_ma"), rs.getString("sp_ten"), rs.getInt("sp_soluong"), rs.getInt("sp_dongia"), rs.getString("sp_mota"));
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getSLSP(int sp_ma){
        DBConnection db = new DBConnection();
        String sql = "Select sp_soluong from sanpham where sp_ma = ?";
        try {
            PreparedStatement st = db.getDBConnection().prepareStatement(sql);
            st.setInt(1, sp_ma);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt("sp_soluong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void updateSL(int sp_ma, int soluong){
        DBConnection db = new DBConnection();
        int soluonghientai = this.getSLSP(sp_ma);
        if(soluonghientai>0){
            String sql="Update sanpham set sp_soluong=? where sp_ma=?";
            try {
                PreparedStatement st = db.getDBConnection().prepareStatement(sql);
                st.setInt(1, soluonghientai - soluong);
                st.setInt(2, sp_ma);
                st.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
