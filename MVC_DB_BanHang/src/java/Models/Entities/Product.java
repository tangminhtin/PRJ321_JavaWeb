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
public class Product {

    private int id; // id product
    private String name; // name
    private double price; // price
    private int quantity; // quantity
    private String Des; // description

    /**
     * constructor of Product
     */
    public Product() {
    }

    /**
     * constructor of Product
     *
     * @param id
     * @param name
     * @param price
     * @param quantity
     * @param Des
     */
    public Product(int id, String name, double price, int quantity, String Des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Des = Des;
    }

    /**
     * get id product
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * set id product
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set get name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get price
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
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
     * get description
     *
     * @return
     */
    public String getDes() {
        return Des;
    }

    /**
     * set description
     *
     * @param Des
     */
    public void setDes(String Des) {
        this.Des = Des;
    }

}
