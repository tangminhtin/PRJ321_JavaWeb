/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class UserService {
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User("minhtin", "123", "Tang Minh Tin", "minhtintang@gmail.com", "Tien Giang"));
        users.add(new User("thinh", "123", "Bach Nguyen Phuc Thinh", "thinh@gmail.com", "Hau Giang"));
        users.add(new User("khang", "123", "Nguyen Vu Khang", "khang@gmail.com", "Soc Trang"));
        users.add(new User("nam", "123", "Truong Nhat Nam", "nam@gmail.com", "Vinh Long"));
        users.add(new User("vinh", "123", "Hua Quoc Vinh", "vinh@gmail.com", "Can Tho"));
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }
    
    public User isLogin(String username, String password) {
        for(User u: users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
