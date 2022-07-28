<%-- 
    Document   : AddtoCart
    Created on : Feb 25, 2022, 4:15:23 PM
    Author     : Admin
--%>

<%@page import="entity.Productitem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
           String quantity = (String) request.getAttribute("quantity");
            int quantity1=(int)Integer.parseInt(quantity);
       %>
       <script>
           if(quantity1>0){
               function AddCart(){
                   alert("add thanh công");
                   <%response.sendRedirect("ControllerAddtoCart");%>
               }
           }else{
               function AddCart(){
                   alert("het hang");
                   <%response.sendRedirect("ControllerAddtoCart");%>
               }
           }
       </script>       
     </body>   
     
    
    
    

</html>
