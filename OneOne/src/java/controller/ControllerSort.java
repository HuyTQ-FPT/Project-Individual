/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
@WebServlet(name = "ControllerSort", urlPatterns = {"/ControllerSort"})
public class ControllerSort extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String service = request.getParameter("do");
            DAOOrders dao2 = new DAOOrders();
            DAOOrderDetails dao3 = new DAOOrderDetails();
            
            DAOProducts dao = new DAOProducts();
            DAOCustomers dao1 = new DAOCustomers();
            
            
            if (service.equals("Sort_Max_to_Min")) {
                System.out.println("Max to Min");
                Vector<Products> vector1 = dao.PageProductSort_Home_MaxtoMin();
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
                RequestDispatcher dispath = request.getRequestDispatcher("SortUp.jsp");
                //run
                dispath.forward(request, response);
            }                      
            if (service.equals("Sort_Min_to_Max")) {
                Vector<Products> vector1 = dao.PageProductSort_Home_MintoMax();
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
                RequestDispatcher dispath = request.getRequestDispatcher("SortDown.jsp");
                //run
                dispath.forward(request, response);
            }                      
            if (service.equals("PageProductSort_MaxtoMin")) {                
                String titlePage = "Product manager";
                String titleTable = "List of Product";
                String page=request.getParameter("page");
                Vector<Products> vector1 = dao.PageProductSortMax_Min(page);
//                Vector<Customers> account = dao1.Account("huy", "huy");
                //set data for request
//                    request.setAttribute("user", account);
                request.setAttribute("list", vector1);   
                request.setAttribute("page", page);   
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                //select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("SortUp.jsp");
                //run
                dispath.forward(request, response);
            }
            if (service.equals("PageProductSort_MintoMax")) {                
                String titlePage = "Product manager";
                String titleTable = "List of Product";
                String page=request.getParameter("page");
                Vector<Products> vector1 = dao.PageProductSortMin_Max(page);
//                Vector<Customers> account = dao1.Account("huy", "huy");
                //set data for request
//                    request.setAttribute("user", account);
                request.setAttribute("list", vector1);   
                request.setAttribute("page", page);   
                request.setAttribute("titlepage", titlePage);
                request.setAttribute("titletable", titleTable);
                //select jsp
                RequestDispatcher dispath = request.getRequestDispatcher("SortDown.jsp");
                //run
                dispath.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
