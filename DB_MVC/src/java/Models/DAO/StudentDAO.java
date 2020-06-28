/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO;

import Models.Entities.Student;
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
public class StudentDAO {

    public Connection connection;

    public StudentDAO() {
        DBConnection dBConnection = new DBConnection();
        
        this.connection = dBConnection.getConnection();
    }

    public boolean insertStudent(Student s) {
        try {
            String sql = "INSERT INTO `student`(`id`, `fullname`, `birthday`, `email`, `phone`, `address`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.setString(2, s.getFullname());
            ps.setDate(3, (Date) s.getBirthday());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setString(6, s.getAddress());
            
            return ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        try {
            String sql = "UPDATE `student` SET `fullname`=?,`birthday`=?,`email`=?,`phone`=?,`address`=? WHERE `id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getFullname());
            ps.setDate(2, (Date) s.getBirthday());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getPhone());
            ps.setString(5, s.getAddress());
            ps.setString(6, s.getId());
            
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int deleteStudent(String id) {
        try {
            String sql = "DELETE FROM `student` WHERE `id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public ResultSet getStudents() {
        try {
            String sql = "SELECT * FROM `student`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Student getStudent(String id) {
        try {
            String sql = "SELECT * FROM `student` WHERE `id`=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return new Student(resultSet.getString("id"), resultSet.getString("fullname"), 
                        resultSet.getDate("birthday"), resultSet.getString("email"), 
                        resultSet.getString("phone"), resultSet.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
}
