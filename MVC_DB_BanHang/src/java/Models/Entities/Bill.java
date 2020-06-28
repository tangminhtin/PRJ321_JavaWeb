/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

import java.sql.Date;

/**
 *
 * @author tangminhtin
 */
public class Bill {

    private int id; // id bill
    private String cusId; // id customer
    private double totalPrice; // total price
    private Date dateBuy; // date buy

    /**
     * constructor of bill
     *
     * @param cusId
     * @param totalPrice
     * @param dateBuy
     */
    public Bill(String cusId, double totalPrice, Date dateBuy) {
        this.cusId = cusId;
        this.totalPrice = totalPrice;
        this.dateBuy = dateBuy;
    }

    /**
     * constructor of bill
     *
     * @param id
     * @param cusId
     * @param totalPrice
     * @param dateBuy
     */
    public Bill(int id, String cusId, double totalPrice, Date dateBuy) {
        this.id = id;
        this.cusId = cusId;
        this.totalPrice = totalPrice;
        this.dateBuy = dateBuy;
    }

    /**
     * get id bill
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * set id bill
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get id customer
     *
     * @return
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * set id customer
     *
     * @param cusId
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
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

    /**
     * get date buy
     *
     * @return
     */
    public Date getDateBuy() {
        return dateBuy;
    }

    /**
     * set date buy
     *
     * @param dateBuy
     */
    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

}
