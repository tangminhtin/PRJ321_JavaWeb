/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class UserDAO {

    private Connection connection;

    public UserDAO() {
        DBConnection dBConnection = new DBConnection();
        this.connection = dBConnection.getConnection();
    }

    public ResultSet getUsers() {
        try {
            String sql = "SELECT * FROM `user`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public User getUser(int id) {
        try {
            String sql = "SELECT `username`, `password`, `fullname`, `phone`, `birthday`, `email` FROM `user` WHERE `id`=?`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");

                return new User(id, username, password, fullname, phone, birthday, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public User loginUser(String username, String password) {
        try {
            String sql = "SELECT `id`, `username`, `password`, `fullname`, `phone`, `birthday`, `email` FROM `user` WHERE `username`=? AND `password`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                String email = resultSet.getString("email");

                return new User(id, user, pass, fullname, phone, birthday, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insert(User user) {
        try {
            String sql = "INSERT INTO `user`(`username`, `password`, `fullname`, `phone`, `birthday`, `email`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPhone());
            ps.setDate(5, (Date) user.getBirthday());
            ps.setString(6, user.getEmail());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int delete(int id) {
        try {
            String sql = "DELETE FROM `user` WHERE `id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}

//            while(resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                String fullname = resultSet.getString("fullname");
//                Date phone = resultSet.getDate("phone");
//                String birthday = resultSet.getString("birthday");
//                String email = resultSet.getString("email");
//            }
