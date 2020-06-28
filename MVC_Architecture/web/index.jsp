<%-- 
    Document   : index
    Created on : Jun 28, 2020, 6:52:02 PM
    Author     : tangminhtin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN PAGE</title>
        <style>
            form {
                border: 3px solid #f1f1f1;
            }

            input[type=text]{ 
                width: 100%;
                padding: 12px 20px; margin: 8px 0;
                display: inline-block; border: 1px solid #ccc; box-sizing: border-box;
            }

            input[type=password]{ 
                width: 100%;
                padding: 12px 20px; margin: 8px 0;
                display: inline-block; border: 1px solid #ccc; box-sizing: border-box;
            }

            .btn{
                background-color: #4CAF50; color: white;
                padding: 14px 20px; margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            .btn:hover { 
                opacity: 0.8;
            }

            .cancelbtn { 
                width: auto;
                padding: 10px 18px;
                background-color: #f44336; 
            }

            .sendbtn {
                width: auto;
                padding: 10px 18px; background-color: green;
            }

            .container { 
                padding: 16px;
            }
            span.psw {
                float: right;
                padding-top: 16px; }
            /* Change styles for span and cancel button on extra small screens*/
            @media screen and (max-width: 300px) { 
                span.psw {
                    display: block;
                    float: none;
                }

                .cancelbtn { 
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <h1>MVC Architecture</h1>

        <form method="POST" action="LoginController">
            <div class="container">
                <div class="container">
                    <label><b>Username</b></label>
                    <input type="text" placeholder="Enter your username" name="txtUser" required/>
                </div>
                <div class="container" style="background-color: #f1f1f1">
                    <input type="submit" class="btn sendbtn" name="btnLogin" value="Login" />
                    <input type="reset" class="btn cancelbtn" />
                </div>
            </div>
        </form>
    </body>
</html>
