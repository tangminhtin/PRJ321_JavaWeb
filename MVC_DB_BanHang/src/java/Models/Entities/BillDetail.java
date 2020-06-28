/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

/**
 *
 * @author tangminhtin
 */
public class BillDetail {

    private int bId; // id bill detail
    private int proId; // id product
    private int quantity; // quantity
    private double totalPrice; // total price

    /**
     * constructor
     *
     * @param bId
     * @param proId
     * @param quantity
     * @param totalPrice
     */
    public BillDetail(int bId, int proId, int quantity, double totalPrice) {
        this.bId = bId;
        this.proId = proId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     * get id bill detail
     *
     * @return
     */
    public int getBId() {
        return bId;
    }

    /**
     * set id bill detail
     *
     * @param bId
     */
    public void setBId(int bId) {
        this.bId = bId;
    }

    /**
     * get id product
     *
     * @return
     */
    public int getProId() {
        return proId;
    }

    /**
     * set id product
     *
     * @param proId
     */
    public void setProId(int proId) {
        this.proId = proId;
    }

    /**
     * get quantity
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * set quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * get total price
     *
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * set total price
     *
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
