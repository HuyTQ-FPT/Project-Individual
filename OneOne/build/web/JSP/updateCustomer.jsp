<%-- 
    Document   : updateCustomer
    Created on : Feb 21, 2022, 4:44:23 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

    </style>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rsCus");
            if (rs.next()) {
        %>
        <form class="form" action = "ControllerCustomer" method="post">
            <input type="hidden" name="do" value="updateCustomer">
            <table>
                <tr>
                    <td>
                        <p>CustomerID</p>
                    </td>
                    <td>
                        <input readonly="" type="text" name="CustomerID" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>CompanyName</p>
                    </td>
                    <td>
                        <input type="text" name="CompanyName" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ContactName</p>
                    </td>
                    <td>
                        <input type="text" name="ContactName" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ContactTitle</p>
                    </td>
                    <td>
                        <input type="text" name="ContactTitle" value="<%=rs.getString(4)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Address</p>
                    </td>
                    <td>
                        <input type="text" name="Address" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>City</p>
                    </td>
                    <td>
                        <input type="text" name="City" value="<%=rs.getString(6)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Region</p>
                    </td>
                    <td>
                        <input type="text" name="Region" value="<%=rs.getString(7)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>PostalCode</p>
                    </td>
                    <td>
                        <input type="text" name="PostalCode" value="<%=rs.getString(8)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Country</p>
                    </td>
                    <td>
                        <input type="text" name="Country" value="<%=rs.getString(9)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Phone</p>
                    </td>
                    <td>
                        <input type="text" name="Phone" value="<%=rs.getString(10)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Fax</p>
                    </td>
                    <td>
                        <input type="text" name="Fax" value="<%=rs.getString(11)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Username</p>
                    </td>
                    <td>
                        <input type="text" name="username" value="<%=rs.getString(12)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Password</p>
                    </td>
                    <td>
                        <input type="text" name="password" value="<%=rs.getString(13)%>">
                    </td>
                </tr>
                 <tr>
                     <td><input type="submit" value="Update   " name="submit"></td>
                     <td><input type="reset" value="Reset   "></td>
                </tr>              
            </table>                     
        </form>
        <%}%>
    </body>
</html>
