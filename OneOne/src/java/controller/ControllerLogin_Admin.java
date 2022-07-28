/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Productitem;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOOrderDetails;
import model.DAOOrders;
import model.DAOProducts;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerLogin_Admin", urlPatterns = {"/ControllerLogin_Admin"})
public class ControllerLogin_Admin extends HttpServlet {

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
            String service = request.getParameter("do");
            DAOProducts dao = new DAOProducts();
            Vector<Products> vector = dao.listAllProduct("");
            if (service == null) {
                service = "Login";
            }
            if (service.equals("Login")) {
                request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
            }
            if (service.equals("logout")) {
                session.removeAttribute("admin");
                request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
            }
            if (service.equals("CheckLogin")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
//                Vector<Customers> account = dao.Account(username, password);
                ResultSet rs = dao.getData("select * from Employees where username='" + username + "' and password='" + password + "'");
                request.setAttribute("user", username);
                request.setAttribute("pass", password);
                if (rs.next() == true) {
                    session.setAttribute("admin", new Productitem(0, "", 0, 0.0, "", username, password));
                    String titleTable = "OrderProduct";
                    request.setAttribute("list", vector);
                    request.setAttribute("titletable", titleTable);
                    response.sendRedirect("ControllerOrder");
                } else {
                    String error ="Incorrect username or Password";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("adminlogin.jsp").forward(request, response);

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
            Logger.getLogger(ControllerLogin_Admin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerLogin_Admin.class.getName()).log(Level.SEVERE, null, ex);
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
