<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
    <head>
        <title>Products</title>
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
            background: linear-gradient(to right, #0B74AF, window);
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
            right: 820px;
            z-index: 3;
            
        }
        </style>
    <body>
        <%
                 ResultSet rs1 = (ResultSet) request.getAttribute("rsSup"),
                    rs2 = (ResultSet) request.getAttribute("rsCate");
        %>
        <form class="form" action = "ControllerProduct" method="post">
            <input type="hidden" name="do" value="insertProduct">
            <table>
                <tr>
                    <td>
                        <p>ProductName</p>
                    </td>
                    <td>
                        <input type="text" name="pName" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="suppId">Suppliers</label>
                    </td>
                    <td>
                        <select name="suppId" id="suppID">
                            <%while(rs1.next()){%>
                            <option value="<%=rs1.getString(1)%>"><%=rs1.getString(2)%></option> 
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="cateId">Category Name</label>
                    </td>
                    <td>
                        <select name="cateId" id="cateid">
                             <%while(rs2.next()){%>
                            <option value="<%=rs2.getString(1)%>"><%=rs2.getString(2)%></option> 
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>QuantityPerUnit</p>
                    </td>
                    <td>
                        <input type="text" name="qPerUnit" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>UnitPrice</p>
                    </td>
                    <td>
                        <input type="number" name="uPrice" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>UnitsInStock</p>
                    </td>
                    <td>
                        <input type="number" name="uInStock" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>UnitsOnOrder</p>
                    </td>
                    <td>
                        <input type="number" name="uOnOrder" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ReorderLevel</p>
                    </td>
                    <td>
                        <input type="number" name="reOLevel" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Discontinued</p>
                    </td>
                    <td>
                        <input type="number" name="discontinute" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Image</p>
                    </td>
                    <td>
                        <input type="text" name="img" value="">
                    </td>
                </tr>
                <h4 class="er" style="color: red;font-size: 14px;">${requestScope.er}</h4>
                <tr>
                    <td><input name="submit" type="submit" value = "insert"></td>
                    <td><input type="reset" value = "clear"></td>
                </tr>
            </table>           
        </form>
    </body>
</html>