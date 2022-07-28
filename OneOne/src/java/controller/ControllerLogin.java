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
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import model.DAOCustomers;
import model.DAOOrderDetails;
import model.DAOOrders;
import model.DAOProducts;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {

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
            HttpSession session = request.getSession();
            DAOCustomers dao = new DAOCustomers();
            DAOProducts dao1 = new DAOProducts();
            DAOOrders dao2 = new DAOOrders();
            DAOOrderDetails dao3 = new DAOOrderDetails();
            Vector<Products> vector = dao1.listAllProduct("");
            String service = request.getParameter("do");
            if (service == null) {
                service = "Login";
            }
            if (service.equals("Login")) {
                request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
            }
            if (service.equals("CheckLogin")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
//                Vector<Customers> account = dao.Account(username, password);
                ResultSet rs = dao.getData("select * from Customers where username='" + username + "' and password='" + password + "'");
                if (rs.next() == true) {
                    String titleTable = "OrderProduct";
                    request.setAttribute("list", vector);
                    session.setAttribute("login", new Productitem(0, "", 0, 0.0, "", username, password));
                    request.setAttribute("titletable", titleTable);
                    request.getRequestDispatcher("ControllerAddtoCart?do=listAllProduct").forward(request, response);
                } else {
                    String error ="Incorrect username or Password";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
                }
            }
            if (service.equals("Checkout")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");                             
//                Vector<Customers> account = dao.Account(username, password);
                ResultSet rs = dao.getData("select * from Customers where username='" + username + "' and password='" + password + "'");               
                if (rs.next() == true) {
                    double discount=Double.parseDouble(request.getParameter("discount").toString());
                    request.setAttribute("discount", discount);  
                    session.setAttribute("login", new Productitem(0, "", 0, 0.0, "", username, password));
                    request.getRequestDispatcher("checkout.jsp").forward(request, response);
                } else {
                    String error ="Incorrect username or Password";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("JSP/LoginCheckout.jsp").forward(request, response);
                }
            }
            if (service.equals("showPro")) {
                String titleTable = "OrderProduct";
                request.setAttribute("titletable", titleTable);
                request.setAttribute("list", vector);
                //select jsp
                System.out.println("showpro");
                RequestDispatcher dispath = request.getRequestDispatcher("/JSP/ListOrderProduct.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("Logout")) {
                session.invalidate();
                request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
            }
            if (service.equals("Done")) {
                java.util.Enumeration em1 = session.getAttributeNames();
                String date = java.time.LocalDate.now().toString();
                Productitem pro1 = (Productitem) session.getAttribute("login");
                ResultSet rs = dao.getData("select * from Customers where username='" + pro1.getUsername() + "' and password='" + pro1.getPassword() + "'");
                String NameCus ="";
                if (rs.next() == true) {
                    NameCus =rs.getString(1);
                }
                System.out.println(NameCus);
                dao2.addOrders1(new Orders(NameCus,3, date, date, date,1, 1));                
                    while (em1.hasMoreElements()) {
                        String key = em1.nextElement().toString();
                        if(key!="login" && key!="admin"){
                        Productitem pro = (Productitem) session.getAttribute(key);
                        dao3.addOrderProduct(new OrderDetails(pro.getProductID(), pro.getPrice(), pro.getQuantity()));
                        ResultSet rs1 = dao1.getData("select UnitsInStock from Products where ProductID="+Integer.parseInt(key));
                        int quantity=0;
                        if(rs1.next()){
                            quantity = rs1.getInt(1);
                        }
                            System.out.println(quantity);
                            System.out.println(pro.getQuantity());
                        dao1.updateQuantity(new Products(Integer.parseInt(key), quantity-pro.getQuantity()));
                        }
                    }            
                response.sendRedirect("ControllerLogin?do=AddSuccess");
            }
            if (service.equals("AddSuccess")) {
                java.util.Enumeration em1 = session.getAttributeNames();
                while (em1.hasMoreElements()) {
                     String key = em1.nextElement().toString();
                        if(key!="login" && key!="admin"){
                            session.removeAttribute(key);
                        }
                 }
               request.getRequestDispatcher("ControllerAddtoCart?do=listAllProduct").forward(request, response); 
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
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
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
