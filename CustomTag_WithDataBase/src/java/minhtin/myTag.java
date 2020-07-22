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
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author tangminhtin
 */
public class myTag extends SimpleTagSupport {

    private String database;
    private String user;
    private String pass;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            try {
                // TODO: insert code to write html before writing the body content.
                // e.g.:
                //
                // out.println("<strong>" + attribute_1 + "</strong>");
                // out.println("    <blockquote>");

                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/" + database, user, pass);
                String sql = "SELECT * FROM students";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                String data = "<table border='1' cellspacing='10'>"
                        + "<th>ID</th>"
                        + "<th>Name</th>"
                        + "<th>Phone</th>"
                        + "<th>Address</th>";
                while(rs.next()) {
                    
                    data += "<tr>"
                            + "<td>" + rs.getInt("id") + "</td>"
                            + "<td>" + rs.getString("name") + "</td>"
                            + "<td>" + rs.getString("phone") + "</td>"
                            + "<td>" + rs.getString("address") + "</td>"
                            + "</tr>";
                    
                }
                data += "</table>";
                out.print(data);
            } catch (SQLException ex) {
                Logger.getLogger(myTag.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in myTag tag", ex);
        }
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
