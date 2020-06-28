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
public class OrderDetail {
    private int orderId;
    private int phoneId;
    private int shipperId;
    private int employeeId;
    private double orderDetailTotalPrice;
    private int orderDetailQuantity;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int phoneId, int shipperId, int employeeId, double orderDetailTotalPrice, int orderDetailQuantity) {
        this.orderId = orderId;
        this.phoneId = phoneId;
        this.shipperId = shipperId;
        this.employeeId = employeeId;
        this.orderDetailTotalPrice = orderDetailTotalPrice;
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getOrderDetailTotalPrice() {
        return orderDetailTotalPrice;
    }

    public void setOrderDetailTotalPrice(double orderDetailTotalPrice) {
        this.orderDetailTotalPrice = orderDetailTotalPrice;
    }

    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(int orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderId=" + orderId + ", phoneId=" + phoneId + ", shipperId=" + shipperId + ", employeeId=" + employeeId + ", orderDetailTotalPrice=" + orderDetailTotalPrice + ", orderDetailQuantity=" + orderDetailQuantity + '}';
    }
}
