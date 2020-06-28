<%-- 
    Document   : jsp_plugin
    Created on : Jun 17, 2020, 9:20:25 AM
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
        <h1>jsp:plugin</h1>
        <jsp:plugin type="applet" code="MyApplet.CustomApplet" codebase="">
            <jsp:fallback>
                <p>Unable to load applet</p>
            </jsp:fallback>
        </jsp:plugin>

        <div align="center">
            <jsp:plugin type="applet" code="mypackage.GetData.class" codebase="mypackage">
                <jsp:params>
                    <jsp:param name="firstName" value="James" />
                    <jsp:param name="lastName" value="Bond" />
                </jsp:params>
                
                <jsp:fallback>
                    <p>Could not load applet!</p>
                </jsp:fallback>
            </jsp:plugin>
        </div>
    </body>
</html>
