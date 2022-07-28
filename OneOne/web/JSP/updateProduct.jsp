<%-- 
    Document   : updateProduct
    Created on : Feb 18, 2022, 4:23:01 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <style>
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
            
        }
        body{
            background: linear-gradient(to right, #0B74AF, gray);
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
            ResultSet rs = (ResultSet) request.getAttribute("rsPro"),
                    rs1 = (ResultSet) request.getAttribute("rsSup"),
                    rs2 = (ResultSet) request.getAttribute("rsCate");
            if (rs.next()) {
        %>

        <form class="form" action="ControllerProduct" method="post">
            <input type="hidden" name="do" value="updateProduct">
            <table>
                <tr>
                    <td>ProductID</td>
                    <td><input readonly="" type="text" name="pid" value="<%=rs.getInt(1)%>"></td>
                </tr>
                <tr>
                    <td>ProductName</td>
                    <td><input type="text" name="pName" value="<%=rs.getString(2)%>"></td>
                </tr>
                <tr>
                    <td><label for="suppId">SupplierID</label></td>
                    <td>
                        <select name="suppId" id="suppId">
                            <% while (rs1.next()) {%>
                            <option value="<%=rs1.getInt(1)%>" <%if(rs1.getInt(1)==rs.getInt(3)){%>
                                selected <%}%> ><%=rs1.getString(2)%></option>                                                      
                            <%}%>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="cateId">CategoryID</label></td>
                    <td><select name="cateId" id="cateId">

                            <% while (rs2.next()) {%>
                            <option value="<%=rs2.getInt(1)%>" <%if(rs2.getInt(1)==rs.getInt(4)){%>
                                selected <%}%> ><%=rs2.getString(2)%></option>                                                      
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>QuantityPerUnit</td>
                    <td><input type="text" name="qPerUnit" value="<%=rs.getString(5)%>"></td>
                </tr>
                <tr>
                    <td>UnitPrice</td>
                    <td><input type="number" name="uPrice" value="<%=rs.getString(6)%>"></td>
                </tr>
                <tr>
                    <td>UnitsInStock</td>
                    <td><input type="number" name="uInStock" value="<%=rs.getString(7)%>"></td>
                </tr>
                <tr>
                    <td>UnitsOnOrder</td>
                    <td><input type="number" name="uOnOrder" value="<%=rs.getString(8)%>"></td>
                </tr>
                <tr>
                    <td>ReorderLevel</td>
                    <td><input type="number" name="reOLevel" value="<%=rs.getString(9)%>"></td>
                </tr>
                <tr>
                    <td>Discontinued</td>
                    <td>
                        <%if(rs.getInt(10) == 0){%>
                        <input type="radio" name="discontinute" value="0" checked>Continue
                        <input type="radio" name="discontinute" value="1">DisContinue
                        <%}else{%>
                        <input type="radio" name="discontinute" value="0" >Continue
                        <input type="radio" name="discontinute" value="1" checked>DisContinue
                        <%}%>
                    </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="text" name="img" value="<%=rs.getString(11)%>"></td>
                </tr>
                <h3></h3>
                <tr>
                    <td><input type="submit" value="Update" name="submit"></td>
                    <td><input type="reset" value="Clear"></td>
                </tr>
            </table>
        </form> 
        <%}%>
    </body>
</html>
