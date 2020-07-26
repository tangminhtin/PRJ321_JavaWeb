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
public class tag2 extends SimpleTagSupport {

    private int start;
    private int end;

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
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_lab","root", "");
                String sql = "SELECT * FROM `user` WHERE id BETWEEN ? AND ? ORDER BY id ASC";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, start);
                ps.setInt(2, end);
                
                ResultSet rs = ps.executeQuery();
                
                String data = "<table border='1' cellspacing='10'>"
                        + "<th>ID</th>"
                        + "<th>Name</th>"
                        + "<th>Email</th>"
                        + "<th>Address</th>";
                while(rs.next()) {
                    
                    data += "<tr>"
                            + "<td>" + rs.getInt("id") + "</td>"
                            + "<td>" + rs.getString("name") + "</td>"
                            + "<td>" + rs.getString("email") + "</td>"
                            + "<td>" + rs.getString("address") + "</td>"
                            + "</tr>";
                    
                }
                data += "</table>";
                out.print(data);
            } catch (SQLException ex) {
                Logger.getLogger(tag2.class.getName()).log(Level.SEVERE, null, ex);
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
            throw new JspException("Error in tag2 tag", ex);
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
}
