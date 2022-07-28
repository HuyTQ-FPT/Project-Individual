<%-- 
    Document   : ListOrder
    Created on : Feb 16, 2022, 4:40:40 PM
    Author     : Admin
--%>

<%@page import="entity.OrderList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOOrders"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Orders"%>
<%@page import="javax.persistence.criteria.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%String titlepage = (String) request.getAttribute("titlepage");%>
        <title><%=titlepage%></title>
    </head>
    <body>
        <%
            Vector<OrderList> vector = (Vector<OrderList>)request.getAttribute("list");
            String titletable = (String) request.getAttribute("titletable");
            DAOOrders dao = new DAOOrders();
            String status = "";
        %>
        <form action="ControllerOrder" method="post">
            <input type="hidden" name="do" value="SelectStatus">           
                <select name="status" style="font-size: 17px; font-weight: bold; margin-left: 30px">
                    <option value="1">New</option>
                    <option value="2">Process</option>
                    <option value="3">Done</option>
                </select>  
                <input value="Select" type="submit" name="submit">
                                      
        </form>
            <table border="1">
                <caption><%=titletable%></caption>
                <thead>
                    <tr>
                        <th>OrderID</th>
                        <th>CustomerName</th>
                        <th>OrderDate</th>
                        <th>EmployeeName</th>                                                             
                        <th>ShippedDate</th> 
                        <th>Status</th>  
                        <th>OrderDetail</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (OrderList or : vector) {%> 
                    <tr>
                        <td><%= or.getOrderID()%></td>
                        <td><%= or.getCompanyName()%></td>
                        <td><%=or.getOrderDate()%></td>
                        <td><%=or.getFirtName() + " " + or.getLastName()%></td>                
                        <td><%=or.getShippedDate()%></td>                       
                        <td><%=or.getStatus()%></td>
                        <%
                            switch (or.getStatus()) {
                                case 1: {
                                    status = "New";
                                    break;
                                }
                                case 2: {
                                    status = "Process";
                                    break;
                                }
                                case 3: {
                                    status = "Done";
                                    break;
                                }
                            }
                            %>
                            <td <%if(or.getStatus()==1){%>style="font-weight: boder;font-size: 17px"<%}%> 
                                <%if(or.getStatus()==2){%>style="font-weight: bolder;font-size: 17px"<%}%>
                                <%if(or.getStatus()==3){%>style="font-weight: bold;font-size: 20px"<%}%>>
                            <%=status%></td>
                        <td><a href="ControllerOrder?do=Orderdetail&oid=<%=or.getOrderID()%>&status=<%=status%>">Detail</a></td>
                    </tr>
                    <%}%>
                </tbody>   
    </body>
</html>
