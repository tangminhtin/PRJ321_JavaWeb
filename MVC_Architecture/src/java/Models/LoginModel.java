/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tangminhtin
 */
public class LoginModel {

    public boolean Auth(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jsp", "root", "");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `login` WHERE `username`='"+username+"' AND `password`='"+password+"'");

        if (rs.next()) {
            return true;
        }
        return false;
    }
}
