<%-- 
    Document   : updateEmployee
    Created on : Feb 21, 2022, 4:44:02 PM
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
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rsEmp");
            if (rs.next()) {
        %>
        <form action = "ControllerEmployee" method="post">
            <input type="hidden" name="do" value="updateEmployee">
            <table>
                <tr>
                    <td>
                        <p>EmployeeID</p>
                    </td>
                    <td>
                        <input type="text" name="EmployeeID" value="<%=rs.getString(1)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>LastName</p>
                    </td>
                    <td>
                        <input type="text" name="LastName" value="<%=rs.getString(2)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>FirstName</p>
                    </td>
                    <td>
                        <input type="text" name="FirstName" value="<%=rs.getString(3)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Title</p>
                    </td>
                    <td>
                        <input type="text" name="Title" value="<%=rs.getString(4)%>"> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>TitleOfCourtesy</p>
                    </td>
                    <td>
                        <input type="text" name="TitleOfCourtesy" value="<%=rs.getString(5)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>BirthDate</p>
                    </td>
                    <td>
                        <input type="date" name="BirthDate" value="<%=rs.getString(6)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>HireDate</p>
                    </td>
                    <td>
                        <input type="date" name="HireDate" value="<%=rs.getString(7)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Address</p>
                    </td>
                    <td>
                        <input type="text" name="Address" value="<%=rs.getString(8)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>City</p>
                    </td>
                    <td>
                        <input type="text" name="City" value="<%=rs.getString(9)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Region</p>
                    </td>
                    <td>
                        <input type="text" name="Region" value="<%=rs.getString(10)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>PostalCode</p>
                    </td>
                    <td>
                        <input type="text" name="PostalCode" value="<%=rs.getString(11)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Country</p>
                    </td>
                    <td>
                        <input type="text" name="Country" value="<%=rs.getString(12)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>HomePhone</p>
                    </td>
                    <td>
                        <input type="text" name="HomePhone" value="<%=rs.getString(13)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Extension</p>
                    </td>
                    <td>
                        <input type="text" name="Extension" value="<%=rs.getString(14)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Photo</p>
                    </td>
                    <td>
                        <input type="text" name="Photo" value="<%=rs.getString(15)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>Notes</p>
                    </td>
                    <td>
                        <input type="text" name="Notes" value="<%=rs.getString(16)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>ReportsTo</p>
                    </td>
                    <td>
                        <input type="number" name="ReportsTo" value="<%=rs.getString(17)%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>PhotoPath</p>
                    </td>
                    <td>
                        <input type="text" name="PhotoPath" value="<%=rs.getString(18)%>">
                    </td>
                </tr>
                
            </table>
            <div>
                <input type="submit" value = "Update" name="submit">
                <input type="reset" value = "reset">
            </div>  
        </form>
        <%}%>
    </body>
</html>
