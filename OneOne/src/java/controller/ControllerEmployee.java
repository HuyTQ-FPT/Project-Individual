/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOEmployees;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerEmployee", urlPatterns = {"/ControllerEmployee"})
public class ControllerEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            DAOEmployees dao = new DAOEmployees();
            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllEmployee";
            }
            if (service.equals("insertEmployee")) {
                String LastName = request.getParameter("LastName");
                String FirstName = request.getParameter("FirstName");
                String Title = request.getParameter("Title");
                String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                String BirthDate = request.getParameter("BirthDate");
                String HireDate = request.getParameter("HireDate");
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String HomePhone = request.getParameter("HomePhone");
                String Extension = request.getParameter("Extension");
                String Photo = request.getParameter("Photo");
                String Notes = request.getParameter("Notes");
                String ReportsTo = request.getParameter("ReportsTo");
                String PhotoPath = request.getParameter("PhotoPath");

                int Reportsto = Integer.parseInt(ReportsTo);

                if (LastName == null || LastName.equals("") || LastName.length() > 20) {
                    out.print("<h3 style='color:red'>LastName is not empty and size <20</h3>");
                    return;
                }
                if (FirstName == null || FirstName.equals("") || FirstName.length() > 10) {
                    out.print("<h3 style='color:red'>FirstName is not empty and size <10</h3>");
                    return;
                }

                DAOEmployees emp = new DAOEmployees();
                int n = emp.addEmployees(new Employees(LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address,
                        City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, Reportsto, PhotoPath));
                if (n > 0) {
                    out.print("Inserted123");
                } else {
                    out.print("<h3 style='color:red'>Fail insert</h3>");
                }
            }
            if (service.equals("listAllEmployee")) {
                Vector<Employees> vector = dao.listAllEmployee();
                 String titlePage ="Employee manager";
                    String titleTable ="List of Employee";
                    //set data for request
                    
                    request.setAttribute("list", vector);
                    request.setAttribute("titlepage", titlePage);
                    request.setAttribute("titletable", titleTable);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/ListEmployee.jsp");
                    //run
                    dispath.forward(request, response);

            }
            if (service.equals("updateEmployee")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // chua nhan submit
                    //step 1: get record --> display form

                    int eid = Integer.parseInt(request.getParameter("eid"));
                    ResultSet rs = dao.getData("select * from Employees where EmployeeID=" + eid);
                    request.setAttribute("rsEmp", rs);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/updateEmployee.jsp");
                    //run
                    dispath.forward(request, response);
                
                } else {
                    //step 2: update
                    int eid=Integer.parseInt(request.getParameter("EmployeeID"));
                    String LastName = request.getParameter("LastName");
                    String FirtName = request.getParameter("FirstName");
                    String Title = request.getParameter("Title");
                    String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                    String BirthDate = request.getParameter("BirthDate");
                    String HireDate = request.getParameter("HireDate");
                    String Address = request.getParameter("Address");
                    String City = request.getParameter("City");
                    String Region = request.getParameter("Region");
                    String PostaCode = request.getParameter("PostalCode");
                    String Country = request.getParameter("Country");
                    String HomePhone = request.getParameter("HomePhone");
                    String Extension = request.getParameter("Extension");
                    String Photo = request.getParameter("Photo");
                    String Notes = request.getParameter("Notes");
                    String ReportsTo =request.getParameter("ReportsTo");
                    String PhotoPath = request.getParameter("PhotoPath");

                    //convert
                    int report=Integer.parseInt(ReportsTo);
                    Employees emp = new Employees(eid, LastName, FirtName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostaCode, Country, HomePhone, Extension, Photo, Notes, report, PhotoPath);
                    dao.updateEmployee(emp);
                    response.sendRedirect("ControllerEmployee");
                }
            }
    
                if (service.equals("deleteEmployee")) {

                }

            
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
