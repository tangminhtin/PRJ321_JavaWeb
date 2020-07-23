/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tangminhtin
 */
public class ResetController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        try {
//            Random rand = new Random();
//            int randomCode = rand.nextInt(999999);
//
//            String host = "smtp.gmail.com";
//            String user = "minhtintang@gmail.com";
//            String pass = "669954784";
//
//            String to = "tintmce130438@fpt.edu.vn";
//            String subject = "Your Password has been reset";
//            String message = "Hi, this is your new password: " + randomCode
//                    + "\nNote: for security reason, "
//                    + "you must change your password after logging in.";
//
//            boolean sessionDebug = false;
//
//            // sets SMTP server properties
//            Properties properties = new Properties();
//            properties.put("mail.smtp.starttls.enable", "true");
//            properties.put("mail.smtp.host", "host");
//            properties.put("mail.smtp.port", "587");
//            properties.put("mail.smtp.auth", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//            Session mailSession = Session.getDefaultInstance(properties, null);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(user));
//            InternetAddress[] address = {new InternetAddress(to)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setText(message);
//            Transport transport = mailSession.getTransport("smtp");
//            transport.connect(host, user, pass);
//            transport.sendMessage(msg, msg.getAllRecipients());
//            
//            transport.close();
//            Transport.send(msg);
//            
////            if(Integer.parseInt(request.getParameter("txtCode"))==randomCode) {
////                response.getWriter().print("OK");
////            } else {
////                response.getWriter().print("FAIL");
////            }
//        } catch (MessagingException ex) {
//            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        String recipient = request.getParameter("email");
        String subject = "Your Password has been reset";

//        CustomerServices customerServices = new CustomerServices(request, response);
//        String newPassword = customerServices.resetCustomerPassword(recipient);
        int newPassword = resetCustomerPassword("minhtintang@gmail.com");
        String content = "Hi, this is your new password: " + newPassword;
        content += "\nNote: for security reason, "
                + "you must change your password after logging in.";

        String message = "";

        try {
//            EmailUtility.sendEmail(host, port, email, name, pass,
//                    recipient, subject, content);
            sendEmail("smtp.gmail.com", "587", "minhtintang@gmail.com", "tang minh tin", "669954784",
                    recipient, subject, content);
            message = "Your password has been reset. Please check your e-mail.";
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static void sendEmail(String host, String port,
            final String senderEmail, String senderName, final String password,
            String recipientEmail, String subject, String message) throws AddressException,
            MessagingException, UnsupportedEncodingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(senderEmail, senderName));
        InternetAddress[] toAddresses = {new InternetAddress(recipientEmail)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        // sends the e-mail
        Transport.send(msg);

    }

    public int resetCustomerPassword(String email) {
//        Customer customer = customerDAO.findByEmail(email);

//        String randomPassword = RandomStringUtils.randomAlphanumeric(10);
//
//        customer.setPassword(randomPassword);
//        customerDAO.update(customer);

//        return randomPassword;
        return 213;
    }

}
