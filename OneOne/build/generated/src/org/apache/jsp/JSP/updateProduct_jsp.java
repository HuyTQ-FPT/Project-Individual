package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class updateProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Update Product</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        *{\n");
      out.write("            margin: 0px;\n");
      out.write("            padding: 0px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        body{\n");
      out.write("            background: linear-gradient(to right, #0B74AF, #0B1218);\n");
      out.write("        }\n");
      out.write("        .form table{\n");
      out.write("            padding: 30px;\n");
      out.write("            margin:80px auto;\n");
      out.write("            height: 600px;\n");
      out.write("            width: 500px;\n");
      out.write("            background-color: #FFFFFF;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            border: 2px solid background;\n");
      out.write("            box-shadow: 2px 2px 6px 4px #2c3e50;\n");
      out.write("        }\n");
      out.write("        .form table tr td input{\n");
      out.write("            display: flex;\n");
      out.write("            border: none;\n");
      out.write("            background: none;\n");
      out.write("            outline: none;\n");
      out.write("            color: black;\n");
      out.write("            padding-left: 10px; \n");
      out.write("        }\n");
      out.write("        .form table tr td{\n");
      out.write("            border-bottom: 2px solid #0B74AF;\n");
      out.write("        }\n");
      out.write("        .form table tr:last-child td input{\n");
      out.write("            margin-top: 20px;\n");
      out.write("            margin-left:  30px;\n");
      out.write("            border: 1px solid rgb(7, 139, 247);\n");
      out.write("            outline: none;\n");
      out.write("            background: none;\n");
      out.write("            color: black;\n");
      out.write("            height: 30px;\n");
      out.write("            font-size: 18px;\n");
      out.write("            background-color: #0B74AF;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: 0.2s;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("        .form table tr:last-child td input:hover{\n");
      out.write("            transform: scale(0.98);\n");
      out.write("        }\n");
      out.write("        .form table tr:last-child td{\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        ");

            ResultSet rs = (ResultSet) request.getAttribute("rsPro"),
                    rs1 = (ResultSet) request.getAttribute("rsSup"),
                    rs2 = (ResultSet) request.getAttribute("rsCate");
            if (rs.next()) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <form class=\"form\" action=\"ControllerProduct\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"do\" value=\"updateProduct\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ProductID</td>\n");
      out.write("                    <td><input readonly=\"\" type=\"text\" name=\"pid\" value=\"");
      out.print(rs.getInt(1));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ProductName</td>\n");
      out.write("                    <td><input type=\"text\" name=\"pName\" value=\"");
      out.print(rs.getString(2));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"suppId\">SupplierID</label></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"suppId\" id=\"suppId\">\n");
      out.write("                            ");
 while (rs1.next()) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(rs1.getInt(1));
      out.write('"');
      out.write(' ');
if(rs1.getInt(1)==rs.getInt(3)){
      out.write("\n");
      out.write("                                selected ");
}
      out.write(' ');
      out.write('>');
      out.print(rs1.getString(2));
      out.write("</option>                                                      \n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label for=\"cateId\">CategoryID</label></td>\n");
      out.write("                    <td><select name=\"cateId\" id=\"cateId\">\n");
      out.write("\n");
      out.write("                            ");
 while (rs2.next()) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(rs2.getInt(1));
      out.write('"');
      out.write(' ');
if(rs2.getInt(1)==rs.getInt(4)){
      out.write("\n");
      out.write("                                selected ");
}
      out.write(' ');
      out.write('>');
      out.print(rs2.getString(2));
      out.write("</option>                                                      \n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>QuantityPerUnit</td>\n");
      out.write("                    <td><input type=\"text\" name=\"qPerUnit\" value=\"");
      out.print(rs.getString(5));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>UnitPrice</td>\n");
      out.write("                    <td><input type=\"number\" name=\"uPrice\" value=\"");
      out.print(rs.getString(6));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>UnitsInStock</td>\n");
      out.write("                    <td><input type=\"number\" name=\"uInStock\" value=\"");
      out.print(rs.getString(7));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>UnitsOnOrder</td>\n");
      out.write("                    <td><input type=\"number\" name=\"uOnOrder\" value=\"");
      out.print(rs.getString(8));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ReorderLevel</td>\n");
      out.write("                    <td><input type=\"number\" name=\"reOLevel\" value=\"");
      out.print(rs.getString(9));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Discontinued</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
if(rs.getInt(10) == 0){
      out.write("\n");
      out.write("                        <input type=\"radio\" name=\"discontinute\" value=\"0\" checked>Continue\n");
      out.write("                        <input type=\"radio\" name=\"discontinute\" value=\"1\">DisContinue\n");
      out.write("                        ");
}else{
      out.write("\n");
      out.write("                        <input type=\"radio\" name=\"discontinute\" value=\"0\" >Continue\n");
      out.write("                        <input type=\"radio\" name=\"discontinute\" value=\"1\" checked>DisContinue\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Image</td>\n");
      out.write("                    <td><input type=\"text\" name=\"img\" value=\"");
      out.print(rs.getString(11));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <h3></h3>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"submit\" value=\"Update\" name=\"submit\"></td>\n");
      out.write("                    <td><input type=\"reset\" value=\"Clear\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form> \n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
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
