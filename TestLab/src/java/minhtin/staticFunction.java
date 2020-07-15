/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtin;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tangminhtin
 */
public class staticFunction {

    private static Connection connection;

    public staticFunction() {

    }

    public static String getDatas() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test_lab", "root", "");
            String sql = "SELECT * FROM `users`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String data = "";
            while (rs.next()) {
                data += "<tr>"
                        + "<td>" + rs.getInt("id") + "</td>"
                        + "<td>" + rs.getString("Name") + "</td>"
                        + "<td>" + rs.getString("Address") + "</td>"
                        + "</tr>";
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(staticFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
