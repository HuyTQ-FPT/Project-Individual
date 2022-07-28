<%-- 
    Document   : Login
    Created on : Feb 26, 2022, 1:34:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        *{
            padding: 0px;
            margin: 0px;
            box-sizing: border-box;
        }
        body{
            background-image: url(img/login.jpg);
            background-repeat: no-repeat;
            background-size: cover;

        }
        .content{
            position: relative;
            color: white;
        }
        .content .card{
            position: absolute;
            top: 50%;
            left: 45%;
            transform: scale(1.8);
            margin-top: 300px;
            color: white;
            height: fit-content;
            width: fit-content;
            cursor: pointer;
        }
        .logo p{
            width: fit-content;
            font-size: 30px;
            box-shadow: 0px 0px 1px 1px rgb(31, 30, 8);
            padding-bottom: 4px;
            margin-bottom: 30px;
        }
        .content .username{
            display: flex;
            border-bottom: 1px solid green;
            padding: 5px;
        }
        .content .password{
            display: flex;
            padding: 5px;
            border-bottom: 1px solid green;
        }
        .content .username input{
            margin-left: 10px;
            border: none;
            background: none;
            outline: none;
            color: white;
        }
        input :-ms-input-placeholder{
            color: rgb(224, 20, 20);
        }
        .content .password input{
            margin-left: 10px;
            border: none;
            background: none;
            outline: none;
            color: white;
        }
        .sign_in button{
            margin-top: 30px;
            width: 100%;
            border: 1px solid rgb(7, 139, 247);
            outline: none;
            background: none;
            color: white;
            height: 30px;
            font-size: 18px;
            background-color: #0B1218;
            cursor: pointer;
            transition: 0.2s;
            opacity: 0.8;
        }
        .sign_in button:hover{
            opacity: 0.6;
            box-shadow: 0px 0px 1px 2px white;
            font-size: 17px;
        }

    </style>
    <body>
        
        
        
        <form action="ControllerLogin?do=CheckLogin" method="post">
            <div class="content">
            <div class="Opacity"></div>
            <div class="card">
                <div class="logo">
                    <p>Login</p>
                </div>
                <div class="username">
                    <i class='bx bxs-user'></i>
                    <input name="username" type="text" placeholder="username" value="">
                </div>
                <div class="password">
                    <i class='bx bxs-lock-alt'></i>
                    <input name="password" type="password" placeholder="password" value="">
                </div>
                <br>
                <h4 id="er" style="color: white;font-size: 10px; position: fixed;">${requestScope.error}</h4>
                <div class="sign_in">
                    <button type="submit" name="sign_in">Sign in</button>
                </div>
            </div>

        </div>
        </form>       
    </body>
    
    
</html>
