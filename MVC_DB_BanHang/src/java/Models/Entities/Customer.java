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
public class Customer {

    private String id; // id customer
    private String name; // name 
    private String email; // email
    private String phone; // phone
    private String address; // address

    /**
     * constructor of Customer
     *
     * @param id
     * @param name
     * @param email
     * @param phone
     * @param address
     */
    public Customer(String id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * get id customer
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * set id customer
     *
     * @param id
     */
    public void setId(String id) {
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
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
