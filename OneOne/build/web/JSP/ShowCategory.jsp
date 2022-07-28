<%-- 
    Document   : ShowCategory
    Created on : Mar 9, 2022, 2:22:08 AM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOCustomers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
            body{
                position: relative;
            }
            .cate{
                position: absolute;
                top:100px;
                right:10px;
                width: 200px;   
                height: 400px;
            }
            .log-out{
                position: absolute;
                top: 30px;
                right: 70px;
                cursor: pointer;
            }
            .register{
                position: absolute;
                top: 30px;
                right: 150px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <%
            DAOCustomers dao = new model.DAOCustomers();
//            Vector<Customers> rs = (Vector<Customers>)request.getAttribute("user");          
            String cid = (String) request.getAttribute("cate");
            int cateid=(int)Integer.parseInt(cid);
            ResultSet rs=dao.getData("select * from Products where CategoryID="+cateid);
            ResultSet rs1 =dao.getData("select * from Categories");
        %> 
        <form action="ControllerProduct?do=listAllProduct">
            <p>Search By Name: <input type="text" name="pname" value="" >
                <input type="submit" value="search by name" name="submit">

        </form>
        <form action="ControllerProduct?do=listAllProduct">
            <p>Search by Unitprice from <input type="text" name="from" value="" >
                to <input type="text" name="to" value="" >
                <input  type="submit" value="search by price" name="submit1">
        </form>
       
        <a href="ControllerAddtoCart?do=ShowCart">ShowCart</a>
        <br>

        <table border="1">
            <caption><%=rs.getString(2)%></caption>
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>ProductName</th>
                    <th>SupplierID</th>
                    <th>CategoryID</th>
                    <th>QuantityPerUnit</th>
                    <th>UnitPrice</th>
                    <th>UnitsInStock</th>
                    <th>UnitsOnOrder</th>
                    <th>ReorderLevel</th>
                    <th>Discontinued</th>
                    <th>Add To Cart</th>
                </tr>
            </thead>
            <tbody>
                <%while(rs.next()) {%>            
                <tr>
                    <td><%=  rs.getString(1)%></td>
                    <td><%=  rs.getString(2)%></td>
                    <td><%=  rs.getString(3)%></td>
                    <td><%=  rs.getString(4)%></td>
                    <td><%=  rs.getString(5)%></td>
                    <td><%=  rs.getString(6)%></td>
                    <td><%=  rs.getString(7)%></td>
                    <td><%=  rs.getString(8)%></td>
                    <td><%=  rs.getString(9)%></td>
                    <td><%=  rs.getString(10)%></td>
                    <td><a href="ControllerAddtoCart?do=AddtoCart&pid=<%=rs.getInt(1)%>&pname=<%=rs.getString(2)%>&price=<%=rs.getDouble(6)%>&quantity=<%=rs.getString(7)%>">AddtoCart</a></td>
                </tr>               
                <%}%>                   
            </tbody>
        </table>
        <div class="cate">
            <table border="1">
                <thead>Category</thead>
                <tbody>
                    <%while (rs1.next()) {%>                    
                    <tr>                
                        <th>
                            <a href="ControllerCategory?do=ShowCate&cid=<%=rs1.getString(1)%>"><button><%=rs1.getString(2)%></button></a>
                        </th> 
                    </tr>  
                    <%}%>
                </tbody>
            </table> 
        </div>
    </body>
</html>
