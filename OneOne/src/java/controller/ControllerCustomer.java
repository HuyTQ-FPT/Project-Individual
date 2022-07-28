/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
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
import model.DAOCustomers;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerCustomer", urlPatterns = {"/ControllerCustomer"})
public class ControllerCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            DAOCustomers dao = new DAOCustomers();
            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllCustomer";
            }
            if (service.equals("insertCustomer")) {
                String submit = request.getParameter("submit");
                System.out.println(submit);
                if (submit == null) { // chua nhan submit
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/InsertCustomer.jsp");
                    dispath.forward(request, response);                   
                } else {
                String CustomerID = request.getParameter("CustomerID");
                String CompanyName = request.getParameter("CompanyName");
                String ContactName = request.getParameter("ContactName");
                String ContactTitle = request.getParameter("ContactTitle");
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String Phone = request.getParameter("Phone");
                String Fax = request.getParameter("Fax");
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                    System.out.println(Address+City);
                if (CustomerID == null || CustomerID.equals("") || CustomerID.length() > 5) {
                    String error="CustomerID is not empty adn size<5";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertCustomer.jsp").forward(request, response);
                }
                if (CompanyName == null || CompanyName.equals("") || CompanyName.length() > 40) {
                    String error="CompanyName is not empty and size <40";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertCustomer.jsp").forward(request, response);
                }
                if (user.length() <8) {
                    String error="username size  more than 8 character";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertCustomer.jsp").forward(request, response);
                }
                if (pass.length() <8) {
                    String error="password size  more than 8 character";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertCustomer.jsp").forward(request, response);
                }

                DAOCustomers cus = new DAOCustomers();
                int n = cus.addCustomer(new Customers(CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax,user,pass));
                response.sendRedirect("ControllerCustomer?do=listAllCustomer");
                }
            }
            if (service.equals("listAllCustomer")) {
                //out.print("list all");
                //list all
                String c;
                String cusid=request.getParameter("cusid");
                if(cusid==null) c="";   
                else c= request.getParameter("cusid");
                Vector<Customers> vector = dao.listAllCustomers(c);
                String titlePage ="Customer manager";
                    String titleTable ="List of Customer";
                    //set data for request                    
                    request.setAttribute("list", vector);
                    request.setAttribute("titlepage", titlePage);
                    request.setAttribute("titletable", titleTable);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/ManagerCustomer.jsp");
                    //run
                    dispath.forward(request, response);

            }
            if (service.equals("updateCustomer")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // chua nhan submit
                    //step 1: get record --> display form
                    String idcus = request.getParameter("idcus");
                    ResultSet rs = dao.getData("select * from Customers where CustomerID='" + idcus+"'");
                    request.setAttribute("rsCus", rs);;
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/updateCustomer.jsp");
                    //run
                    dispath.forward(request, response);
                } else {
                    //step 2: update
                    String idc = request.getParameter("CustomerID");
                    String CompanyName = request.getParameter("CompanyName");
                    String ContactName = request.getParameter("ContactName");
                    String ContactTitle = request.getParameter("ContactTitle");
                    String Address = request.getParameter("Address");
                    String City = request.getParameter("City");
                    String Region = request.getParameter("Region");
                    String PostalCode = request.getParameter("PostalCode");
                    String Country = request.getParameter("Country");
                    String Phone = request.getParameter("Phone");
                    String Fax = request.getParameter("Fax");
                    String user = request.getParameter("username");
                    String pass = request.getParameter("password");
                    //convert
                    Customers cus= new Customers(idc, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax,user,pass);
                    int n = dao.updateCustomer(cus);
                    response.sendRedirect("ControllerCustomer?do=listAllCustomer");
                }
            }
            if(service.equals("deleteCustomer")){
                String cusid =request.getParameter("idcus").toString();
                dao.DeleteCustomers(cusid);
                response.sendRedirect("ControllerCustomer?do=listAllCustomer");
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
