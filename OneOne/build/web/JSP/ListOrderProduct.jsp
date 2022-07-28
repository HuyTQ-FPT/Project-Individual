<%-- 
    Document   : ListOrderProduct
    Created on : Feb 25, 2022, 4:08:36 PM
    Author     : Admin
--%>

<%@page import="model.DAOCustomers"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.Customers"%>
<%@page import="entity.Productitem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Products"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JSP/AddtoCart.jsp"></script>
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
            Vector<Products> vector = (Vector<Products>) request.getAttribute("list");
//            Vector<Customers> ac = (Vector<Customers>)request.getAttribute("account");          
            String titletable = (String) request.getAttribute("titletable");
            ResultSet rs1 = dao.getData("select * from Categories");
//            ResultSet rs2 = (ResultSet)request.getAttribute("customer");
//            ResultSet rs=(ResultSet)request.getAttribute("user");
//            user.get(0).getUsername()

            String rs = (String) request.getAttribute("user");
            String pass = (String) request.getAttribute("pass");
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
        <%if (rs!= null) {%>
        <form action="ControllerLogin?do=Logout" method="post">
            <button type="submit" name="log-out" class="log-out">Log Out</button>
        </form>
        <%}%>
        <%if (rs== null) {%>
        <form action="ControllerLogin?do=Login" method="post">
            <button type="submit" name="log-out" class="log-out">Login</button>            
        </form>
        <form action="ControllerLogin?do=register" method="post">
            <button type="submit" name="register" class="register">Register</button>            
        </form>

        <%}%>
        <%if (rs!= null){%>
            <h3><%=rs%></h3> 
        <%}%>
        <a href="ControllerAddtoCart?do=ShowCart">ShowCart</a>
        <br>

        <table border="1">
            <caption><%=titletable%></caption>
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
                <%for (Products pro : vector) {%>
            <form action="ControllerAddtoCart?do=AddtoCart" method="post">
                <input type="hidden" name="pid" value="<%=pro.getProductID()%>">
                <input type="hidden" name="pname" value="<%= pro.getProductName()%>">
                <input type="hidden" name="price" value="<%=pro.getUnitPrice()%>">
                <input type="hidden" name="quantity" value="<%=pro.getUnitsInStock()%>">
                <input type="hidden" name="user" value="<%=rs%>">
                <input type="hidden" name="pass" value="<%=pass%>">
                <tr>
                    <td><%=  pro.getProductID()%></td>
                    <td><%= pro.getProductName()%></td>
                    <td><%=pro.getSupplierID()%></td>
                    <td><%=pro.getCategoryID()%></td>
                    <td><%= pro.getQuantityPerUnit()%></td>
                    <td><%=pro.getUnitPrice()%></td>
                    <td><%=pro.getUnitsInStock()%></td>
                    <td><%= pro.getUnitsOnOrder()%></td>
                    <td><%=pro.getReorderLevel()%></td>
                    <td><%= pro.getDiscontinued()%></td>
                    <td><button type="submit">Add to Cart</button></td>
                </tr>
            </form>
                <%}%>                   
            </tbody>
        </table>
        <div class="cate">
            <table border="1">
                <thead>Category</thead>
                <tbody>
                    <%while (rs1.next()) {%>
                <form action="ControllerCategory?do=ShowCate" method="post">
                    <input type="hidden" name="cid" value="<%=rs1.getString(1)%>">
                    <tr>                
                        <th>
                            <button type="submit"><%=rs1.getString(2)%></button>
                        </th> 
                    </tr>
                </form>                                          
                    <%}%>
                </tbody>
            </table> 
        </div>

    </body>
</html>
