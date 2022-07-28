/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrderList;
import entity.OrderProduct;
import entity.Orders;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCustomers;
import model.DAOOrderDetails;
import model.DAOOrders;

@WebServlet(name = "ControllerOrder", urlPatterns = {"/ControllerOrder"})
public class ControllerOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAOCustomers dao = new DAOCustomers();
            DAOOrders dao1 = new DAOOrders();
            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllOrder";
            }

            if (service.equals("listAllOrder")) {
                Vector<OrderList> vector = dao.Join_Customer_Vs_Order_OrderItem_Product_Employee();
                String titlePage = "Order manager";
                String titleTable = "List of Order";
                //set data for request                    
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                RequestDispatcher dispath = request.getRequestDispatcher("JSP/ManagerListOrder.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("orderdate")) {
                String from = request.getParameter("from");
                String to = request.getParameter("to");
                System.out.println(from +to);
                Vector<OrderList> vector = dao.Join_Customer_Vs_Order_OrderItem_Product_Employee(from, to);
                double total = 0;
                for (OrderList pro : vector) {
                    System.out.println(pro.getOrderID());
                    Vector<OrderProduct> vector1 =dao.Join_Customer_Vs_Order_OrderItem_Product_Employee_1(pro.getOrderID());
                    for (OrderProduct pro1 : vector1) {
                        total += pro1.getQuantity() * pro1.getUnitPrice();
                    }
                }
                System.out.println(total);
                String titlePage = "Order manager";
                String titleTable = "List of Order";
                //set data for request                    
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                request.setAttribute("totalbill", total);
                RequestDispatcher dispath = request.getRequestDispatcher("JSP/MoneyByOrderDate.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("search")) {
                int oid = Integer.parseInt(request.getParameter("oid"));
                Vector<OrderList> vector = dao.Join_Customer_Vs_Order_OrderItem_Product_Employee_by_orderid(oid);
                String titlePage = "Order manager";
                String titleTable = "List of Order";
                //set data for request                    
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                RequestDispatcher dispath = request.getRequestDispatcher("JSP/ManagerListOrder.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("Orderdetail")) {
                String submit = request.getParameter("submit");
                System.out.println(submit);
                int oid = Integer.parseInt(request.getParameter("oid"));
                System.out.println(oid);
                if (submit == null) {
                    String status = request.getParameter("status");
                    Vector<OrderProduct> vector = dao.Join_Customer_Vs_Order_OrderItem_Product_Employee_1(oid);
                    String titlePage = "Order manager";
                    String titleTable = "List of Order";
                    //set data for request                    
                    request.setAttribute("list", vector);
                    request.setAttribute("titlepage", titlePage);
                    request.setAttribute("titletable", titleTable);
                    request.setAttribute("status", status);
                    request.setAttribute("oid", request.getParameter("oid"));

                    RequestDispatcher dispath = request.getRequestDispatcher("/JSP/Order.jsp");
                    //run
                    dispath.forward(request, response);

                } else {
                    int stt = Integer.parseInt(request.getParameter("status"));
//                    int oid = Integer.parseInt(request.getParameter("oid"));
                    dao1.updateStatus(stt, oid);
                    response.sendRedirect("ControllerOrder");
                }
            }
            if (service.equals("SelectStatus")) {
                int status = Integer.parseInt(request.getParameter("status"));
                System.out.println("lay ra :" + status);
                Vector<OrderList> vector = dao.Join_Customer_Vs_Order_OrderItem_Product_Employee();
                String titlePage = "Order manager";
                String titleTable = "List of Order";
                //set data for request                    
                request.setAttribute("list", vector);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("huy", status);
                request.setAttribute("titletable", titleTable);
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/ManagerOrderByStatus.jsp");
                //run
                dispath.forward(request, response);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ResultSet getData(String sql1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
