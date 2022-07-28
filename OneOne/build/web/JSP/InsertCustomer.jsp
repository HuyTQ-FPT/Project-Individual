<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Customers</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
    *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
            
        }
        body{
            background: linear-gradient(to right, #0B74AF, #0B1218);
        }
        .form table{
            position: relative;
            padding: 30px;
            margin:80px auto;
            height: 600px;
            width: 500px;
            background-color: #FFFFFF;
            border-radius: 15px;
            border: 2px solid background;
            box-shadow: 2px 2px 6px 4px #2c3e50;
        }
        .form table tr td input{
            display: flex;
            border: none;
            background: none;
            outline: none;
            color: black;
            padding-left: 10px; 
        }
        .form table tr td{
            border-bottom: 2px solid #0B74AF;
        }
        .form table tr:last-child td input{
            margin-top: 20px;
            margin-left:  30px;
            border: 1px solid rgb(7, 139, 247);
            outline: none;
            background: none;
            color: black;
            height: 30px;
            font-size: 18px;
            background-color: #0B74AF;
            cursor: pointer;
            transition: 0.2s;
            border-radius: 5px;
            justify-content: center;
        }
        .form table tr:last-child td input:hover{
            transform: scale(0.98);
        }
        .form table tr:last-child td{
            border: none;
        }
        .er{
            position: absolute;
            top: 576px;
            right: 750px;
            z-index: 3;
            
        }
        </style>
    <body>
        <form class="form" action = "ControllerCustomer" method="post">
            <input type="hidden" name="do" value="insertCustomer">
            <table>
                <tr>
                    <td>
                        <p>CustomerID</p>
                    </td>
                    <td>
                        <input type="text" name="CustomerID" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>CompanyName</p>
                    </td>
                    <td>
                        <input type="text" name="CompanyName" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ContactName</p>
                    </td>
                    <td>
                        <input type="text" name="ContactName" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ContactTitle</p>
                    </td>
                    <td>
                        <input type="text" name="ContactTitle" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Address</p>
                    </td>
                    <td>
                        <input type="text" name="Address" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>City</p>
                    </td>
                    <td>
                        <input type="text" name="City" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Region</p>
                    </td>
                    <td>
                        <input type="text" name="Region" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>PostalCode</p>
                    </td>
                    <td>
                        <input type="text" name="PostalCode" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Country</p>
                    </td>
                    <td>
                        <input type="text" name="Country" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Phone</p>
                    </td>
                    <td>
                        <input type="text" name="Phone" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Fax</p>
                    </td>
                    <td>
                        <input type="text" name="Fax" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Username</p>
                    </td>
                    <td>
                        <input type="text" name="username" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Password</p>
                    </td>
                    <td>
                        <input type="text" name="password" value="">
                    </td>
                </tr>
                    <h4 class="er" style="color: red;font-size: 14px;">${requestScope.er}</h4>              
                <tr>
                    <td><input type="submit" value = "Insert" name="submit"></td>
                    <td><input type="reset" value = "Reser"></td>
                </tr>               
            </table>                 
        </form>
    </body>
</html>
