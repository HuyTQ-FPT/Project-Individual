<%-- 
    Document   : OrderProduct
    Created on : Feb 16, 2022, 10:00:57 PM
    Author     : Admin
--%>

<%@page import="model.DAOCustomers"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="entity.OrderList"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.OrderProduct"%>
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
//            ResultSet rs=(ResultSet)request.getAttribute("list");
            DAOCustomers dao = new model.DAOCustomers();
            Vector<OrderProduct> vector = (Vector<OrderProduct>) request.getAttribute("list");           
            String status = (String) request.getAttribute("status");
            String oid = (String)request.getAttribute("oid");
            int o=Integer.parseInt(oid);
            ResultSet rs=dao.getData("select p.ProductID,p.ProductName,od.Quantity,p.UnitPrice from [Order Details] od join Products p on od.ProductID=p.ProductID where OrderID="+o);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            int total = 0;
            for (OrderProduct or : vector) {
                String strDate = formatter.format(or.getOrderDate());
                String strDate1 = formatter.format(or.getShippedDate());
        %>

        <a href="ControllerOrder"><button>Back to List Order</button></a>
        <h3>OrderID: <%=or.getOrderID()%></h3> 
        <h3>CustomerName: <%=or.getFirtName() + " " + or.getLastName()%></h3>
        <h3>OrderDate: <%=strDate%></h3>
        <h3>ShipDate: <%=strDate1%></h3>    
        
        <form action="ControllerOrder">
            <input type="hidden" name="do" value="Orderdetail">
            <input type="hidden" name="oid" value="<%=o%>">
            <h3>Status: <%=or.getStatus()%>
                <select name="status" style="font-size: 17px; font-weight: bold; margin-left: 30px">
                    <option value="1" <%if(or.getStatus()==1){%>selected<%}%>>New</option>
                    <option value="2" <%if(or.getStatus()==2){%>selected<%}%>>Process</option>
                    <option value="3" <%if(or.getStatus()==3){%>selected<%}%>>Done</option>
                </select>  
                <input value="Update" type="submit" name="submit">
            </h3>                           
        </form>                  
        <h3>OrderStatus: <%=status%></h3>

        <%break;}%>
        
        <table border="1">
            <caption>Order Detail</caption>
            <thead>
                <tr>
                    <th>ProducID</th>
                    <th>ProductName</th>
                    <th>Quantity</th>
                    <th>UnitPrice</th>                   
                    <th>Total=Quantity*UnitPrice</th>                   
                </tr>
            </thead>
            <tbody>
                <%
                    while(rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt(1)%></td>
                    <td><%= rs.getString(2)%></td>
                    <td><%= rs.getInt(3)%></td>
                    <td><%= rs.getDouble(4)%></td>
                    <td style='text-align: center'><%=rs.getInt(3) * rs.getDouble(4)%></td>
                </tr>
                <% total += rs.getInt(3) * rs.getDouble(4);
                    }
                %>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Grand Total </td>
                    <td style='text-align: center'><%=total%></td>
                </tr>
            </tbody>

        </table>


    </body>

</html>
