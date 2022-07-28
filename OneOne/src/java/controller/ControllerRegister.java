/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.Productitem;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomers;
import model.DAOProducts;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerRegister", urlPatterns = {"/ControllerRegister"})
public class ControllerRegister extends HttpServlet {

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
            DAOCustomers dao = new DAOCustomers();
            if (service == null) {
                service = "Register";
            }
            if (service.equals("Register")) {
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (service.equals("CheckRegister")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String re_password = request.getParameter("re_password");
                String name = request.getParameter("name");
//                System.out.println(password+re_password);
//                String cus1 = dao.checkCus(name).trim();
//                System.out.println(cus1);
                if(name.length()>5){
                    String error ="NameID less than 5 characters";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                if(username.length()<8 || password.length()<8){
                    String error ="Passwords and Username more than 8 characters";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                if(!password.equalsIgnoreCase(re_password)){
                    String error ="Re-Passwords incorrect";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }               
                int n=dao.Register(new Customers(name, username, username, password));
                if(n>0){
                    session.setAttribute("login", new Productitem(0, "", 0, 0.0, "", username, password));
                    response.sendRedirect("ControllerAddtoCart?do=listAllProduct");
                } else{
                    String error ="NameID already exists";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
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
