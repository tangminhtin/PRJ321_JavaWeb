<%-- 
    Document   : action_cookies
    Created on : Jul 11, 2020, 12:42:45 AM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie username = new Cookie("username", request.getParameter("username"));
            Cookie email = new Cookie("email", request.getParameter("email"));
        
            username.setMaxAge(60*60*10);
            email.setMaxAge(60*60*10);
            
            response.addCookie(username);
            response.addCookie(email);
            
            Cookie[] cookieList = request.getCookies();
            for(Cookie c: cookieList) {
                if(!"JSESSIONID".startsWith(c.getName()))
                out.println(c.getName() + " : " + c.getValue());
            }
        %>
        
        
        
    </body>
</html>
