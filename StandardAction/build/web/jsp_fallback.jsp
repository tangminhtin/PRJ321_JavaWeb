<%-- 
    Document   : jsp_fallback
    Created on : Jun 17, 2020, 9:30:59 AM
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
        <h1>jsp_fallback</h1>
        <jsp:plugin type="applet" code="MyClass.class" codebase="/html">
            <jsp:params>
                <jsp:param name="username" value="Tom" />
            </jsp:params>
            <jsp:fallback>
                <p>Could not load applet!</p>
            </jsp:fallback>
        </jsp:plugin>
    </body>
</html>
