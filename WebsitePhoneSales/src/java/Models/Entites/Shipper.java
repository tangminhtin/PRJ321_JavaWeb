/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entites;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Shipper {
    private int shipperId;
    private String shipperName;
    private String shipperPhone;

    public Shipper() {
    }

    public Shipper(int shipperId, String shipperName, String shipperPhone) {
        this.shipperId = shipperId;
        this.shipperName = shipperName;
        this.shipperPhone = shipperPhone;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    @Override
    public String toString() {
        return "Shipper{" + "shipperId=" + shipperId + ", shipperName=" + shipperName + ", shipperPhone=" + shipperPhone + '}';
    }
    
}
