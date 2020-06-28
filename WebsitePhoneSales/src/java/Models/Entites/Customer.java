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
public class Customer {
    private int customerId;
    private String customerFullname;
    private String customerAddress;
    private String customerPhone;
    private int userId;

    public Customer() {
    }

    public Customer(int customerId, String customerFullname, String customerAddress, String customerPhone, int userId) {
        this.customerId = customerId;
        this.customerFullname = customerFullname;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.userId = userId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFullname() {
        return customerFullname;
    }

    public void setCustomerFullname(String customerFullname) {
        this.customerFullname = customerFullname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerFullname=" + customerFullname + ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", userId=" + userId + '}';
    }
    
}
