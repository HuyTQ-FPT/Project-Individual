package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import entity.OrderList;
import model.DAOOrders;
import java.util.Vector;

public final class ManagerListOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <title>Admin</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style_3.css\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <style>\r\n");
      out.write("            body {\r\n");
      out.write("                color: #566787;\r\n");
      out.write("                background: #f5f5f5;\r\n");
      out.write("                font-family: 'Roboto', sans-serif;\r\n");
      out.write("                position: relative;\r\n");
      out.write("            }\r\n");
      out.write("            .table-responsive {\r\n");
      out.write("                margin: 30px 0;\r\n");
      out.write("            }\r\n");
      out.write("            .table-wrapper {\r\n");
      out.write("                min-width: 1000px;\r\n");
      out.write("                background: #fff;\r\n");
      out.write("                padding: 20px;\r\n");
      out.write("                box-shadow: 0 1px 1px rgba(0,0,0,.05);\r\n");
      out.write("            }\r\n");
      out.write("            .table-title {\r\n");
      out.write("                padding-bottom: 10px;\r\n");
      out.write("                margin: 0 0 10px;\r\n");
      out.write("                min-width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            .table-title h2 {\r\n");
      out.write("                margin: 8px 0 0;\r\n");
      out.write("                font-size: 22px;\r\n");
      out.write("            }\r\n");
      out.write("            .search-box {\r\n");
      out.write("                position: relative;        \r\n");
      out.write("                float: right;\r\n");
      out.write("            }\r\n");
      out.write("            .search-box input {\r\n");
      out.write("                height: 34px;\r\n");
      out.write("                border-radius: 20px;\r\n");
      out.write("                padding-left: 35px;\r\n");
      out.write("                border-color: #ddd;\r\n");
      out.write("                box-shadow: none;\r\n");
      out.write("            }\r\n");
      out.write("            .search-box input:focus {\r\n");
      out.write("                border-color: #3FBAE4;\r\n");
      out.write("            }\r\n");
      out.write("            .search-box i {\r\n");
      out.write("                color: #a0a5b1;\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                font-size: 19px;\r\n");
      out.write("                top: 8px;\r\n");
      out.write("                left: 10px;\r\n");
      out.write("            }\r\n");
      out.write("            table.table tr th, table.table tr td {\r\n");
      out.write("                border-color: #e9e9e9;\r\n");
      out.write("            }\r\n");
      out.write("            table.table-striped tbody tr:nth-of-type(odd) {\r\n");
      out.write("                background-color: #fcfcfc;\r\n");
      out.write("            }\r\n");
      out.write("            table.table-striped.table-hover tbody tr:hover {\r\n");
      out.write("                background: #f5f5f5;\r\n");
      out.write("            }\r\n");
      out.write("            table.table th i {\r\n");
      out.write("                font-size: 13px;\r\n");
      out.write("                margin: 0 5px;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td:last-child {\r\n");
      out.write("                width: 130px;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td a {\r\n");
      out.write("                color: #a0a5b1;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                margin: 0 5px;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td a.view {\r\n");
      out.write("                color: #03A9F4;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td a.edit {\r\n");
      out.write("                color: #FFC107;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td a.delete {\r\n");
      out.write("                color: #E34724;\r\n");
      out.write("            }\r\n");
      out.write("            table.table td i {\r\n");
      out.write("                font-size: 19px;\r\n");
      out.write("            }    \r\n");
      out.write("            .pagination {\r\n");
      out.write("                float: right;\r\n");
      out.write("                margin: 0 0 5px;\r\n");
      out.write("            }\r\n");
      out.write("            .pagination li a {\r\n");
      out.write("                border: none;\r\n");
      out.write("                font-size: 95%;\r\n");
      out.write("                width: 30px;\r\n");
      out.write("                height: 30px;\r\n");
      out.write("                color: #999;\r\n");
      out.write("                margin: 0 2px;\r\n");
      out.write("                line-height: 30px;\r\n");
      out.write("                border-radius: 30px !important;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                padding: 0;\r\n");
      out.write("            }\r\n");
      out.write("            .pagination li a:hover {\r\n");
      out.write("                color: #666;\r\n");
      out.write("            }\t\r\n");
      out.write("            .pagination li.active a {\r\n");
      out.write("                background: #03A9F4;\r\n");
      out.write("            }\r\n");
      out.write("            .pagination li.active a:hover {        \r\n");
      out.write("                background: #0397d6;\r\n");
      out.write("            }\r\n");
      out.write("            .pagination li.disabled i {\r\n");
      out.write("                color: #ccc;\r\n");
      out.write("            }\r\n");
      out.write("            .pagination li i {\r\n");
      out.write("                font-size: 16px;\r\n");
      out.write("                padding-top: 6px\r\n");
      out.write("            }\r\n");
      out.write("            .hint-text {\r\n");
      out.write("                float: left;\r\n");
      out.write("                margin-top: 6px;\r\n");
      out.write("                font-size: 95%;\r\n");
      out.write("            }\r\n");
      out.write("            .selectStatus{\r\n");
      out.write("                position: fixed;\r\n");
      out.write("                top:117px;\r\n");
      out.write("                right: 20px;\r\n");
      out.write("                \r\n");
      out.write("            }\r\n");
      out.write("            .managerPro{\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                top:10px;\r\n");
      out.write("                left:10px;\r\n");
      out.write("                color: black;\r\n");
      out.write("                text-decoration: underline;\r\n");
      out.write("                list-style: circle inside;\r\n");
      out.write("            }\r\n");
      out.write("            .managerCus{\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                top:45px;\r\n");
      out.write("                left:10px;\r\n");
      out.write("                color: black;\r\n");
      out.write("                text-decoration: underline;\r\n");
      out.write("                list-style: circle inside;\r\n");
      out.write("            }\r\n");
      out.write("            .but{\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("            }\r\n");
      out.write("            .but:hover{\r\n");
      out.write("                transform: scale(0.98);\r\n");
      out.write("            }\r\n");
      out.write("            .log-out{\r\n");
      out.write("                border-radius: 5px;\r\n");
      out.write("                background-color: #F1BC31;\r\n");
      out.write("                margin-right: 20px;\r\n");
      out.write("            }\r\n");
      out.write("            .log-out:hover{\r\n");
      out.write("                transform: scale(0.98);\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            if(session.getAttribute("admin")==null){
                response.sendRedirect("ControllerLogin_Admin");
            }else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Vector<OrderList> vector = (Vector<OrderList>) request.getAttribute("list");
            DAOOrders dao = new DAOOrders();
            String status = "";
        
      out.write("\r\n");
      out.write("        <section class=\"ftco-section\">\r\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light\" id=\"ftco-navbar\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <span class=\"admin\"></i>Admin</span>\r\n");
      out.write("                    <form action=\"ControllerLogin_Admin?do=logout\" method=\"post\">\r\n");
      out.write("                           <button type=\"submit\" name=\"log-out\" class=\"log-out\">Log Out</button>\r\n");
      out.write("                     </form>\r\n");
      out.write("                    <form action=\"ControllerOrder?do=search\" method=\"post\" class=\"searchform order-lg-last\">\r\n");
      out.write("                        <div class=\"form-group d-flex\">\r\n");
      out.write("                            <input name=\"oid\" type=\"text\" class=\"form-control pl-3\" placeholder=\"SearchOrderID\">\r\n");
      out.write("                            <button type=\"submit\" placeholder=\"\" class=\"form-control search\"><span class=\"fa fa-search\"></span></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"ftco-nav\">\r\n");
      out.write("                        <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("                            <li class=\"nav-item \"><a href=\"ControllerProduct\" class=\"nav-link\">Manager<br>Products</a></li>\r\n");
      out.write("                            <li class=\"nav-item active\"><a href=\"ControllerOrder\" class=\"nav-link\">Manager<br>ListOrders</a></li>\r\n");
      out.write("                            <li class=\"nav-item \"><a href=\"ControllerCustomer\" class=\"nav-link\">Manager<br>Customers</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <form action=\"ControllerOrder?do=orderdate\" method=\"post\" class=\"searchform order-lg-last\">\r\n");
      out.write("                        <div class=\"form-group d-flex\">\r\n");
      out.write("                            From:<input name=\"from\" type=\"date\" class=\"form-control pl-3\" placeholder=\"from\" value=\"\">\r\n");
      out.write("                            To:<input name=\"to\" type=\"date\" class=\"form-control pl-3\" placeholder=\"to\" value=\"\">\r\n");
      out.write("                            <button type=\"submit\" placeholder=\"\" class=\"form-control search\"><span class=\"fa fa-search\"></span></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>                                        \r\n");
      out.write("        </section>\r\n");
      out.write("        <form class=\"selectStatus\"  action=\"ControllerOrder\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"do\" value=\"SelectStatus\">           \r\n");
      out.write("            <select name=\"status\" style=\"font-size: 17px; font-weight: bold; margin-left: 30px\">\r\n");
      out.write("                <option value=\"1\">New</option>\r\n");
      out.write("                <option value=\"2\">Process</option>\r\n");
      out.write("                <option value=\"3\">Done</option>\r\n");
      out.write("            </select>  \r\n");
      out.write("            <input class=\"but\" value=\"Select\" type=\"submit\" name=\"submit\">                                    \r\n");
      out.write("        </form> \r\n");
      out.write("        <div class=\"table-wrapper\">\r\n");
      out.write("            <table class=\"table table-striped table-hover table-bordered\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>OrderID</th>\r\n");
      out.write("                        <th>CustomerName</th>\r\n");
      out.write("                        <th>OrderDate</th>\r\n");
      out.write("                        <th>EmployeeName</th>\r\n");
      out.write("                        <th>ShippedDate</th>\r\n");
      out.write("                        <th>Status</th>\r\n");
      out.write("                        <th>OrderDetail</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");
for (OrderList or : vector) {
      out.write(" \r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>");
      out.print( or.getOrderID());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( or.getCompanyName());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(or.getOrderDate());
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print(or.getFirtName() + " " + or.getLastName());
      out.write("</td>                \r\n");
      out.write("                        <td>");
      out.print(or.getShippedDate());
      out.write("</td>                       \r\n");
      out.write("                        <td>");
      out.print(or.getStatus());
      out.write("</td>\r\n");
      out.write("                        ");

                            switch (or.getStatus()) {
                                case 1: {
                                    status = "New";
                                    break;
                                }
                                case 2: {
                                    status = "Process";
                                    break;
                                }
                                case 3: {
                                    status = "Done";
                                    break;
                                }
                            }
                        
      out.write("\r\n");
      out.write("                        <td ");
if (or.getStatus() == 1) {
      out.write("style=\"font-weight: boder;font-size: 17px\"");
}
      out.write(" \r\n");
      out.write("                                                          ");
if (or.getStatus() == 2) {
      out.write("style=\"font-weight: bolder;font-size: 17px\"");
}
      out.write("\r\n");
      out.write("                                                          ");
if (or.getStatus() == 3) {
      out.write("style=\"font-weight: bold;font-size: 20px\"");
}
      out.write(">\r\n");
      out.write("                            ");
      out.print(status);
      out.write("</td>\r\n");
      out.write("                        <td style=\"width:50px;\">\r\n");
      out.write("                            <a href=\"ControllerOrder?do=Orderdetail&oid=");
      out.print(or.getOrderID());
      out.write("&status=");
      out.print(status);
      out.write("\" class=\"view\" title=\"Detail\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE417;</i></a>\r\n");
      out.write("                            <!--<a href=\"#\" class=\"edit\" title=\"Update\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a>-->\r\n");
      out.write("                            <!--<a href=\"#\" class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a>-->\r\n");
      out.write("                        </td>                        \r\n");
      out.write("                    </tr> \r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div> \r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("    </body>\r\n");
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
