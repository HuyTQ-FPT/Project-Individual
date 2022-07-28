/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Productitem;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProducts;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerDetailProduct", urlPatterns = {"/ControllerDetailProduct"})
public class ControllerDetailProduct extends HttpServlet {

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
            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            DAOProducts daop = new DAOProducts();
            if (service == null) {
                service = "detail";
            }
            DAOProducts dao = new DAOProducts();
            if (service.equals("detail")) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                ResultSet rs = dao.getData("select * from Products p join Categories c on c.CategoryID=p.CategoryID where p.ProductID=" + pid);
                request.setAttribute("rspro", rs);
                request.getRequestDispatcher("single-product.jsp").forward(request, response);
            }
            if (service.equals("AddtoCart")) {
                String pid = request.getParameter("pid");
                int ProductID = Integer.parseInt(pid);
                request.setAttribute("pid", pid);
                ResultSet rs = dao.getData("select * from Products where ProductID=" + ProductID);
                if (rs.next()) {
                    if (rs.getInt(7) > 0) {
                        Productitem pro = (Productitem) session.getAttribute(pid);
                        if (pro == null) {
                            int quantity = 1;
                            String ProductName = rs.getString(2);
                            double Price =rs.getDouble(6);
                            String image =rs.getString(11);
                            Productitem pro1 = new Productitem(ProductID, ProductName, quantity, Price,image);
                            session.setAttribute(pid, pro1);
                        } else {
                            pro.setQuantity(pro.getQuantity() + 1);
                            session.setAttribute(pid, pro);
                        }
                        request.getRequestDispatcher("ControllerAddtoCart?do=listAllProduct").forward(request, response);
//                    request.getRequestDispatcher("/JSP/ListOrderProduct.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }                    
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
            Logger.getLogger(ControllerDetailProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerDetailProduct.class.getName()).log(Level.SEVERE, null, ex);
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
