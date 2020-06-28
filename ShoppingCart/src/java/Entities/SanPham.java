package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class SanPham {
    private int sp_ma;
    private String sp_ten;
    private int sp_soluong;
    private int sp_dongia;
    private String sp_mota;

    public int getSp_ma() {
        return sp_ma;
    }

    public void setSp_ma(int sp_ma) {
        this.sp_ma = sp_ma;
    }

    public String getSp_ten() {
        return sp_ten;
    }

    public void setSp_ten(String sp_ten) {
        this.sp_ten = sp_ten;
    }

    public int getSp_soluong() {
        return sp_soluong;
    }

    public void setSp_soluong(int sp_soluong) {
        this.sp_soluong = sp_soluong;
    }

    public int getSp_dongia() {
        return sp_dongia;
    }

    public void setSp_dongia(int sp_dongia) {
        this.sp_dongia = sp_dongia;
    }

    public String getSp_mota() {
        return sp_mota;
    }

    public void setSp_mota(String sp_mota) {
        this.sp_mota = sp_mota;
    }

    public SanPham() {
    }

    public SanPham(int sp_ma, String sp_ten, int sp_soluong, int sp_dongia, String sp_mota) {
        this.sp_ma = sp_ma;
        this.sp_ten = sp_ten;
        this.sp_soluong = sp_soluong;
        this.sp_dongia = sp_dongia;
        this.sp_mota = sp_mota;
    }
    
    
}
