package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import entity.OrderProduct;
import model.DAOCustomers;
import entity.OrderList;
import model.DAOOrders;
import java.util.Vector;

public final class Order_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Bootstrap Simple Data Table</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style_3.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                color: #566787;\n");
      out.write("                background: #f5f5f5;\n");
      out.write("                font-family: 'Roboto', sans-serif;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .table-responsive {\n");
      out.write("                margin: 30px 0;\n");
      out.write("            }\n");
      out.write("            .table-wrapper {\n");
      out.write("                min-width: 1000px;\n");
      out.write("                background: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                box-shadow: 0 1px 1px rgba(0,0,0,.05);\n");
      out.write("            }\n");
      out.write("            .table-title {\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("                margin: 0 0 10px;\n");
      out.write("                min-width: 100%;\n");
      out.write("            }\n");
      out.write("            .table-title h2 {\n");
      out.write("                margin: 8px 0 0;\n");
      out.write("                font-size: 22px;\n");
      out.write("            }\n");
      out.write("            .search-box {\n");
      out.write("                position: relative;        \n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("            .search-box input {\n");
      out.write("                height: 34px;\n");
      out.write("                border-radius: 20px;\n");
      out.write("                padding-left: 35px;\n");
      out.write("                border-color: #ddd;\n");
      out.write("                box-shadow: none;\n");
      out.write("            }\n");
      out.write("            .search-box input:focus {\n");
      out.write("                border-color: #3FBAE4;\n");
      out.write("            }\n");
      out.write("            .search-box i {\n");
      out.write("                color: #a0a5b1;\n");
      out.write("                position: absolute;\n");
      out.write("                font-size: 19px;\n");
      out.write("                top: 8px;\n");
      out.write("                left: 10px;\n");
      out.write("            }\n");
      out.write("            table.table tr th, table.table tr td {\n");
      out.write("                border-color: #e9e9e9;\n");
      out.write("            }\n");
      out.write("            table.table-striped tbody tr:nth-of-type(odd) {\n");
      out.write("                background-color: #fcfcfc;\n");
      out.write("            }\n");
      out.write("            table.table-striped.table-hover tbody tr:hover {\n");
      out.write("                background: #f5f5f5;\n");
      out.write("            }\n");
      out.write("            table.table th i {\n");
      out.write("                font-size: 13px;\n");
      out.write("                margin: 0 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            table.table td:last-child {\n");
      out.write("                width: 130px;\n");
      out.write("            }\n");
      out.write("            table.table td a {\n");
      out.write("                color: #a0a5b1;\n");
      out.write("                display: inline-block;\n");
      out.write("                margin: 0 5px;\n");
      out.write("            }\n");
      out.write("            table.table td a.view {\n");
      out.write("                color: #03A9F4;\n");
      out.write("            }\n");
      out.write("            table.table td a.edit {\n");
      out.write("                color: #FFC107;\n");
      out.write("            }\n");
      out.write("            table.table td a.delete {\n");
      out.write("                color: #E34724;\n");
      out.write("            }\n");
      out.write("            table.table td i {\n");
      out.write("                font-size: 19px;\n");
      out.write("            }    \n");
      out.write("            .pagination {\n");
      out.write("                float: right;\n");
      out.write("                margin: 0 0 5px;\n");
      out.write("            }\n");
      out.write("            .pagination li a {\n");
      out.write("                border: none;\n");
      out.write("                font-size: 95%;\n");
      out.write("                width: 30px;\n");
      out.write("                height: 30px;\n");
      out.write("                color: #999;\n");
      out.write("                margin: 0 2px;\n");
      out.write("                line-height: 30px;\n");
      out.write("                border-radius: 30px !important;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            .pagination li a:hover {\n");
      out.write("                color: #666;\n");
      out.write("            }\t\n");
      out.write("            .pagination li.active a {\n");
      out.write("                background: #03A9F4;\n");
      out.write("            }\n");
      out.write("            .pagination li.active a:hover {        \n");
      out.write("                background: #0397d6;\n");
      out.write("            }\n");
      out.write("            .pagination li.disabled i {\n");
      out.write("                color: #ccc;\n");
      out.write("            }\n");
      out.write("            .pagination li i {\n");
      out.write("                font-size: 16px;\n");
      out.write("                padding-top: 6px\n");
      out.write("            }\n");
      out.write("            .hint-text {\n");
      out.write("                float: left;\n");
      out.write("                margin-top: 6px;\n");
      out.write("                font-size: 95%;\n");
      out.write("            }\n");
      out.write("            .selectStatus{\n");
      out.write("                position: absolute;\n");
      out.write("                top:20px;\n");
      out.write("                right: 20px;\n");
      out.write("            }\n");
      out.write("            .but{\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            .but:hover{\n");
      out.write("                transform: scale(0.98);\n");
      out.write("            }\n");
      out.write("            .listorder h3{\n");
      out.write("                font-size: 17px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            DAOCustomers dao = new model.DAOCustomers();
            Vector<OrderProduct> vector = (Vector<OrderProduct>) request.getAttribute("list");
            String status = (String) request.getAttribute("status");
            String oid = (String) request.getAttribute("oid");
            int o = Integer.parseInt(oid);
            ResultSet rs = dao.getData("select p.ProductID,p.ProductName,od.Quantity,p.UnitPrice from [Order Details] od join Products p on od.ProductID=p.ProductID where OrderID=" + o);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            int total = 0;
            for (OrderProduct or : vector) {
                String strDate = formatter.format(or.getOrderDate());
                String strDate1 = formatter.format(or.getShippedDate());
        
      out.write("\n");
      out.write("        <section class=\"ftco-section\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light\" id=\"ftco-navbar\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <span class=\"admin\"></i>Admin</span>\n");
      out.write("                    <form action=\"#\" class=\"searchform order-lg-last\">\n");
      out.write("                        <div class=\"form-group d-flex\">\n");
      out.write("                            <input type=\"text\" class=\"form-control pl-3\" placeholder=\"Search\">\n");
      out.write("                            <button type=\"submit\" placeholder=\"\" class=\"form-control search\"><span class=\"fa fa-search\"></span></button>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"ftco-nav\">\n");
      out.write("                        <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                            <li class=\"nav-item \"><a href=\"ControllerProduct\" class=\"nav-link\">Manager<br>Products</a></li>\n");
      out.write("                            <li class=\"nav-item \"><a href=\"ControllerOrder\" class=\"nav-link\">Manager<br>ListOrders</a></li>\n");
      out.write("                            <li class=\"nav-item \"><a href=\"ControllerCustomer\" class=\"nav-link\">Manager<br>Customers</a></li>\n");
      out.write("                            <li class=\"nav-item active\"><a href=\"#\" class=\"nav-link\">OrderID<br>");
      out.print(o);
      out.write("</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </section>\n");
      out.write("        <div class=\"table-wrapper\">\n");
      out.write("            <div class=\"table-title\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-8\" style=\"font-size:15px;\">\n");
      out.write("                        <h2><a href=\"ControllerOrder\" style=\"color:black;\"><b>Order</b></a></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"listorder\" style=\"font-size:15px;\">\n");
      out.write("                            <h3>OrderID: ");
      out.print(or.getOrderID());
      out.write("</h3> \n");
      out.write("                            <h3>CustomerName: ");
      out.print(or.getFirtName() + " " + or.getLastName());
      out.write("</h3>\n");
      out.write("                            <h3>OrderDate: ");
      out.print(strDate);
      out.write("</h3>\n");
      out.write("                            <h3>ShipDate: ");
      out.print(strDate1);
      out.write("</h3>\n");
      out.write("                            <form action=\"ControllerOrder\">\n");
      out.write("                                <input type=\"hidden\" name=\"do\" value=\"Orderdetail\">\n");
      out.write("                                <input type=\"hidden\" name=\"oid\" value=\"");
      out.print(o);
      out.write("\">\n");
      out.write("                                <h3>Status: ");
      out.print(or.getStatus());
      out.write("\n");
      out.write("                                    <select name=\"status\" style=\"font-size: 17px; font-weight: bold; margin-left: 30px\">\n");
      out.write("                                        <option value=\"1\" ");
if (or.getStatus() == 1) {
      out.write("selected");
}
      out.write(">New</option>\n");
      out.write("                                        <option value=\"2\" ");
if (or.getStatus() == 2) {
      out.write("selected");
}
      out.write(">Process</option>\n");
      out.write("                                        <option value=\"3\" ");
if (or.getStatus() == 3) {
      out.write("selected");
}
      out.write(">Done</option>\n");
      out.write("                                    </select>  \n");
      out.write("                                    <input value=\"Update\" type=\"submit\" name=\"submit\">\n");
      out.write("                                </h3>                           \n");
      out.write("                            </form>                  \n");
      out.write("                            <h3>OrderStatus: ");
      out.print(status);
      out.write("</h3>\n");
      out.write("                            ");
break;
                                        }
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>                   \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <table class=\"table table-striped table-hover table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ProducID</th>\n");
      out.write("                        <th>ProductName</th>\n");
      out.write("                        <th>Quantity</th>\n");
      out.write("                        <th>UnitPrice</th>\n");
      out.write("                        <th>Total</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
while (rs.next()) {
      out.write(" \n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( rs.getInt(1));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getString(2));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getInt(3));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( rs.getDouble(4));
      out.write("</td>\n");
      out.write("                        <td style='text-align: center'>");
      out.print(rs.getInt(3) * rs.getDouble(4));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 total += rs.getInt(3) * rs.getDouble(4);
                        }
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td>Grand Total </td>\n");
      out.write("                        <td style='text-align: center'>");
      out.print(total);
      out.write("</td>\n");
      out.write("                    </tr> \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
