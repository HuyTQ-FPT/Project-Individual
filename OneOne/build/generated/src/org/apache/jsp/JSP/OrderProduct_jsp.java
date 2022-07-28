package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DAOCustomers;
import java.text.SimpleDateFormat;
import java.sql.Date;
import entity.OrderList;
import java.util.Vector;
import java.sql.ResultSet;
import entity.OrderProduct;

public final class OrderProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
String titlepage = (String) request.getAttribute("titlepage");
      out.write("\n");
      out.write("        <title>");
      out.print(titlepage);
      out.write("</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

//            ResultSet rs=(ResultSet)request.getAttribute("list");
            DAOCustomers dao = new model.DAOCustomers();
            Vector<OrderProduct> vector = (Vector<OrderProduct>) request.getAttribute("list");           
            String status = (String) request.getAttribute("status");
            String oid = (String)request.getAttribute("oid");
            int o=Integer.parseInt(oid);
            ResultSet rs=dao.getData("select p.ProductID,p.ProductName,od.Quantity,p.UnitPrice from [Order Details] od join Products p on od.ProductID=p.ProductID where OrderID="+o);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            int total = 0;
            for (OrderProduct or : vector) {
                String strDate = formatter.format(or.getOrderDate());
                String strDate1 = formatter.format(or.getShippedDate());
        
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"ControllerOrder\"><button>Back to List Order</button></a>\n");
      out.write("        <h3>OrderID: ");
      out.print(or.getOrderID());
      out.write("</h3> \n");
      out.write("        <h3>CustomerName: ");
      out.print(or.getFirtName() + " " + or.getLastName());
      out.write("</h3>\n");
      out.write("        <h3>OrderDate: ");
      out.print(strDate);
      out.write("</h3>\n");
      out.write("        <h3>ShipDate: ");
      out.print(strDate1);
      out.write("</h3>    \n");
      out.write("        \n");
      out.write("        <form action=\"ControllerOrder\">\n");
      out.write("            <input type=\"hidden\" name=\"do\" value=\"Orderdetail\">\n");
      out.write("            <input type=\"hidden\" name=\"oid\" value=\"");
      out.print(o);
      out.write("\">\n");
      out.write("            <h3>Status: ");
      out.print(or.getStatus());
      out.write("\n");
      out.write("                <select name=\"status\" style=\"font-size: 17px; font-weight: bold; margin-left: 30px\">\n");
      out.write("                    <option value=\"1\" ");
if(or.getStatus()==1){
      out.write("selected");
}
      out.write(">New</option>\n");
      out.write("                    <option value=\"2\" ");
if(or.getStatus()==2){
      out.write("selected");
}
      out.write(">Process</option>\n");
      out.write("                    <option value=\"3\" ");
if(or.getStatus()==3){
      out.write("selected");
}
      out.write(">Done</option>\n");
      out.write("                </select>  \n");
      out.write("                <input value=\"Update\" type=\"submit\" name=\"submit\">\n");
      out.write("            </h3>                           \n");
      out.write("        </form>                  \n");
      out.write("        <h3>OrderStatus: ");
      out.print(status);
      out.write("</h3>\n");
      out.write("\n");
      out.write("        ");
break;}
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <caption>Order Detail</caption>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ProducID</th>\n");
      out.write("                    <th>ProductName</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>UnitPrice</th>                   \n");
      out.write("                    <th>Total=Quantity*UnitPrice</th>                   \n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    while(rs.next()) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getInt(1));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString(2));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getInt(3));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getDouble(4));
      out.write("</td>\n");
      out.write("                    <td style='text-align: center'>");
      out.print(rs.getInt(3) * rs.getDouble(4));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 total += rs.getInt(3) * rs.getDouble(4);
                    }
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>Grand Total </td>\n");
      out.write("                    <td style='text-align: center'>");
      out.print(total);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
