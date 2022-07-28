/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrderDetails;
import entity.Orders;
import entity.Productitem;
import entity.Products;
import java.awt.Frame;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Spring;
import model.DAOCustomers;
import model.DAOOrderDetails;
import model.DAOOrders;
import model.DAOProducts;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerAddtoCart", urlPatterns = {"/ControllerAddtoCart"})

public class ControllerAddtoCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            String service = request.getParameter("do");
            DAOOrders dao2 = new DAOOrders();
            DAOOrderDetails dao3 = new DAOOrderDetails();
            if (service == null) {
                service = "listAllProduct";
            }
            DAOProducts dao = new DAOProducts();
            DAOCustomers dao1 = new DAOCustomers();
            
            
            if (service.equals("listAllProduct")) {
                Vector<Products> vector1 = dao.PageProduct_1();
                String titlePage = "Product manager";
                String titleTable = "List of Product";
                request.setAttribute("list", vector1);
                request.setAttribute("page", 1);
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                //select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("index.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("Search")) {
                String name =request.getParameter("name");
                System.out.println("name product"+name);
                Vector<Products> vector1 = dao.listAllProduct(name);
                String titlePage = "Product manager";
                String titleTable = "List of Product";

//                Vector<Customers> account = dao1.Account("huy", "huy");
                //set data for request
//                    request.setAttribute("user", account);
                request.setAttribute("list", vector1);   
                request.setAttribute("page", 1);   
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                //select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("index.jsp");
                //run
                dispath.forward(request, response);
            }           
            if (service.equals("PageProduct")) {                
                String titlePage = "Product manager";
                String titleTable = "List of Product";
                String page=request.getParameter("page");
                Vector<Products> vector1 = dao.PageProduct(page);
//                Vector<Customers> account = dao1.Account("huy", "huy");
                //set data for request
//                    request.setAttribute("user", account);
                request.setAttribute("list", vector1);   
                request.setAttribute("page", page);   
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                //select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("index.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("AddtoCart")) {
                String pid = request.getParameter("pid");
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                int ProductID = Integer.parseInt(pid);
                request.setAttribute("user", user);
                request.setAttribute("pass", pass);
                ResultSet rs = dao.getData("select * from Products where ProductID=" + ProductID);
                if (rs.next()) {
                    if (rs.getInt(7) > 0) {
                        Productitem pro = (Productitem) session.getAttribute(pid);
                        if (pro == null) {
                            int quantity = 1;
                            String ProductName = rs.getString(2);
                            double Price =rs.getDouble(6);
                            String image =rs.getString(11);
                            Productitem pro1 = new Productitem(ProductID, ProductName, quantity, Price,image,user,pass);
                            session.setAttribute(pid, pro1);
                        } else {
                            pro.setQuantity(pro.getQuantity() + 1);
                            session.setAttribute(pid, pro);
                        }
//                    response.sendRedirect("ControllerAddtoCart");
                    request.getRequestDispatcher("ControllerAddtoCart?do=listAllProduct").forward(request, response);
                } else {
                    request.getRequestDispatcher("ControllerAddtoCart").forward(request, response);
                }
                }
            }
            
            if (service.equals("updateQuantity")){                
                int quantity=Integer.parseInt(request.getParameter("updateQuantity"));
                Productitem pro =(Productitem) session.getAttribute(request.getParameter("pid"));
                pro.setQuantity(quantity);
                session.setAttribute(request.getParameter("pid"), pro);             
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
            if (service.equals("ShowCart")){
                request.getRequestDispatcher("JSP/ShowCart.jsp").forward(request, response);
            }            
            if (service.equals("deleteCart")) {
                System.out.println("delete11111"); 
                String key=request.getParameter("pid");
                session.removeAttribute(key);
                response.sendRedirect("cart.jsp");
            }
            if (service.equals("deleteAllCart")) {
                session.invalidate();
                response.sendRedirect("cart.jsp");
            }
            if (service.equals("Checkout")) {
                String user = "";
                String pass = "";                             
                if (session.getAttribute("login")== null) {
                    double discount=Double.parseDouble(request.getParameter("discount").toString());
                    request.setAttribute("discount", discount);
                    request.getRequestDispatcher("JSP/LoginCheckout.jsp").forward(request, response);
                } else {
                    double discount=Double.parseDouble(request.getParameter("discount").toString());
                    request.setAttribute("discount", discount);                                                        
                    request.getRequestDispatcher("checkout.jsp").forward(request, response);
                }
                
            }           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAddtoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAddtoCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
