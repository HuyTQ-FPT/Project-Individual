package controller;

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
import model.DAOProducts;

/**
 *
 * @author MT Bac Ninh
 */
@WebServlet(name = "ControllerProduct", urlPatterns = {"/ControllerProduct"})
public class ControllerProduct extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Get Data
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            DAOProducts dao = new DAOProducts();
            String service = request.getParameter("do");
            if (service == null) {
                service = "listAllProduct";
            }
            if (service.equals("insertProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // chua nhan submit
                    ResultSet rs1 = dao.getData("select * from Suppliers");
                    ResultSet rs2 = dao.getData("select * from Categories");
                    request.setAttribute("rsSup", rs1);
                    request.setAttribute("rsCate", rs2);
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/InsertProduct.jsp");
                    //run
                    dispath.forward(request, response);
                    
                } else {
                String ProductName = request.getParameter("pName");
                String SupplierID = request.getParameter("suppId");
                String CategoryID = request.getParameter("cateId");
                String QuantityPerUnit = request.getParameter("qPerUnit");
                String UnitPrice = request.getParameter("uPrice");
                String UnitsInStock = request.getParameter("uInStock");
                String UnitsOnOrder = request.getParameter("uOnOrder");
                String ReorderLevel = request.getParameter("reOLevel");
                String Discontinued = request.getParameter("discontinute");
                String image = request.getParameter("img");
                    System.out.println(image);
                //Check/ Validate data
                if (ProductName == null || ProductName.isEmpty()) {
                    String error="ProductName cannot Null";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                }
                if (ProductName.length() > 40) {
                    String error="ProductName must <= 40 char";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                }
                if (QuantityPerUnit.length() > 20) {
                    String error="QuantityPerUnit must <= 20 char";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                  
                }
                if (Double.parseDouble(UnitPrice) < 0) {
                    String error="UnitPrice must >=0";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                   
                }
                if (Integer.parseInt(ReorderLevel) < 0) {
                    String error="ReorderLevel must >=0";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                   
                }
                if (Integer.parseInt(UnitsInStock) < 0) {
                    String error="UnitsInStock must >=0";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);
                  
                }
                if (Integer.parseInt(UnitsOnOrder) < 0) {
                    String error="UnitsOnOrder must >=0";
                    request.setAttribute("er", error);
                    request.getRequestDispatcher("/JSP/InsertProduct.jsp").forward(request, response);                 
                }               
                //Convert
//            private double UnitPrice;
//            private int UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued;
                int suppId = Integer.parseInt(SupplierID);
                int cateId = Integer.parseInt(CategoryID);
                double uPrice = Double.parseDouble(UnitPrice);
                int uInStock = Integer.parseInt(UnitsInStock);
                int uOnOrder = Integer.parseInt(UnitsOnOrder);
                int reOrLevel = Integer.parseInt(ReorderLevel);
                int discon = Integer.parseInt(Discontinued);
                //Display
                Products pro = new Products(ProductName, suppId, cateId, QuantityPerUnit, uPrice, uInStock, uOnOrder, reOrLevel, discon,image);
                int n = dao.addProducts(pro);
                response.sendRedirect("ControllerProduct?do=listAllProduct");
                }
            }            
            if (service.equals("listAllProduct")) {
                String c;
                String cusid=request.getParameter("name");
                if(cusid==null) c="";   
                else c= request.getParameter("name");
                System.out.println(c);
                    Vector<Products> vector = dao.listAllProduct(c);
                    String titlePage ="Product manager123";
                    String titleTable ="List of Product";
                    //set data for request                    
                    request.setAttribute("list", vector);
                    request.setAttribute("titlepage", titlePage);
                    request.setAttribute("titletable", titleTable);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/ManagerProduct.jsp");
                    //run
                    dispath.forward(request, response);
                
            }
            if (service.equals("updateProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // chua nhan submit
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    ResultSet rs = dao.getData("select * from Products where ProductID=" + pid);
                    ResultSet rs1 = dao.getData("select * from Suppliers");
                    ResultSet rs2 = dao.getData("select * from Categories");
                    request.setAttribute("rsPro", rs);
                    request.setAttribute("rsSup", rs1);
                    request.setAttribute("rsCate", rs2);
                    request.setAttribute("pid", pid);
                    //select jsp
                    RequestDispatcher dispath= request.getRequestDispatcher("/JSP/updateProduct.jsp");
                    //run
                    dispath.forward(request, response);
                    
                } else {
                    //step 2: update
                    String spid = request.getParameter("pid");
                    String ProductName = request.getParameter("pName");
                    String SupplierID = request.getParameter("suppId");
                    String CategoryID = request.getParameter("cateId");
                    String QuantityPerUnit = request.getParameter("qPerUnit");
                    String UnitPrice = request.getParameter("uPrice");
                    String UnitsInStock = request.getParameter("uInStock");
                    String UnitsOnOrder = request.getParameter("uOnOrder");
                    String ReorderLevel = request.getParameter("reOLevel");
                    String Discontinued = request.getParameter("discontinute");
                    String img = request.getParameter("img");
                    //convert
                    System.out.println(img);
                    int pid = Integer.parseInt(spid);
                    int suppId = Integer.parseInt(SupplierID);
                    int cateId = Integer.parseInt(CategoryID);
                    double uPrice = Double.parseDouble(UnitPrice);
                    int uInStock = Integer.parseInt(UnitsInStock);
                    int uOnOrder = Integer.parseInt(UnitsOnOrder);
                    int reOrLevel = Integer.parseInt(ReorderLevel);
                    int discon = Integer.parseInt(Discontinued);
                    Products pro = new Products(pid,ProductName, suppId, cateId, QuantityPerUnit, uPrice, uInStock, uOnOrder, reOrLevel, discon,img);
                    int n = dao.updateProduct(pro);
                    response.sendRedirect("ControllerProduct?do=listAllProduct");
                }
            }
            if (service.equals("deleteProduct")) {
                int pid =Integer.parseInt(request.getParameter("pid").toString());
                dao.removeProduct(pid);
                response.sendRedirect("ControllerProduct?do=listAllProduct");
                //delete
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
