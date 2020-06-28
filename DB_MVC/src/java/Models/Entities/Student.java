/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Entities;

import java.util.Date;

/**
 *
 * @author tangminhtin
 */
public class Student {

    private String id;
    private String fullname;
    private Date birthday;
    private String email;
    private String phone;
    private String address;

    public Student(String id, String fullname, Date birthday, String email, String phone, String address) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullname=" + fullname + ", birthday=" + birthday + ", email=" + email + ", phone=" + phone + ", address=" + address + '}';
    }
    
    
}
