/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Categories;
import entity.Productitem;
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
import model.DAOCategories;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerCategory", urlPatterns = {"/ControllerCategory"})
public class ControllerCategory extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session= request.getSession();
            DAOCategories dao = new DAOCategories();
            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllCategory";
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
                        request.getRequestDispatcher("category.jsp").forward(request, response);
//                    request.getRequestDispatcher("/JSP/ListOrderProduct.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("category.jsp").forward(request, response);
                    }                    
                }
            }
            if (service.equals("insertCategory")) {
                String CategoryName = request.getParameter("CategoryName");
                String Description = request.getParameter("Description");
                String Picture = request.getParameter("Picture");
                
                if (CategoryName == null || CategoryName.equals("") || CategoryName.length() > 15) {
                    out.print("<h3 style='color:red'>CategoryName is not empty and size<15</h3>");
                    return;
                }
                
                DAOCategories cate = new DAOCategories();
                int n = cate.addCategories(new Categories(CategoryName, Description, Picture));
                if (n > 0) {
                    out.print("Inserted");
                } else {
                    out.print("<h3 style='color:red'>Fail insert</h3>");
                }
            }
            if (service.equals("listAllCategory")) {
                Vector<Categories> vector = dao.listAllCategories();
                 String titlePage ="Category manager";
                    String titleTable ="List of Category";
                    //set data for request
                    
                    request.setAttribute("list", vector);
                    request.setAttribute("titlepage", titlePage);
                    request.setAttribute("titletable", titleTable);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("category.jsp");
                    //run
                    dispath.forward(request, response);
            }
            if (service.equals("listCate")) {
                String cateid=request.getParameter("cateid");
                request.setAttribute("cateid", cateid);
                System.out.println(cateid);
                    RequestDispatcher dispath= request.getRequestDispatcher("category.jsp");
                    //run
                    dispath.forward(request, response);
            }
            if (service.equals("updateCategory")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    ResultSet rs = dao.getData("select * from Categories where CategoryID=" + cid);
                    request.setAttribute("rsCate", rs);;
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/updateCategory.jsp");
                    //run
                    dispath.forward(request, response);
                    
                } else {
                    int cid = Integer.parseInt(request.getParameter("CateID"));
                    String CategoryName = request.getParameter("CategoryName");
                    String Description = request.getParameter("Description");
                    String Picture = request.getParameter("Picture");
                    dao.updateCategories(new Categories(cid, CategoryName, Description, Picture));
                    response.sendRedirect("ControllerCategory");
                }
            }
            if (service.equals("deleteCategory")) {
                
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
            Logger.getLogger(ControllerCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerCategory.class.getName()).log(Level.SEVERE, null, ex);
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
