package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        *{\n");
      out.write("            padding: 0px;\n");
      out.write("            margin: 0px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("        body{\n");
      out.write("            background-image: url(img/login.jpg);\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: cover;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .content{\n");
      out.write("            position: relative;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        .content .card{\n");
      out.write("            position: absolute;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 45%;\n");
      out.write("            transform: scale(1.8);\n");
      out.write("            margin-top: 300px;\n");
      out.write("            color: white;\n");
      out.write("            height: fit-content;\n");
      out.write("            width: fit-content;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .logo p{\n");
      out.write("            width: fit-content;\n");
      out.write("            font-size: 30px;\n");
      out.write("            box-shadow: 0px 0px 1px 1px rgb(31, 30, 8);\n");
      out.write("            padding-bottom: 4px;\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("        }\n");
      out.write("        .logo p:hover{\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .content .username{\n");
      out.write("            display: flex;\n");
      out.write("            border-bottom: 1px solid green;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("        .content .password{\n");
      out.write("            display: flex;\n");
      out.write("            padding: 5px;\n");
      out.write("            border-bottom: 1px solid green;\n");
      out.write("        }\n");
      out.write("        .content .username input{\n");
      out.write("            margin-left: 10px;\n");
      out.write("            border: none;\n");
      out.write("            background: none;\n");
      out.write("            outline: none;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        input :-ms-input-placeholder{\n");
      out.write("            color: rgb(224, 20, 20);\n");
      out.write("        }\n");
      out.write("        .content .password input{\n");
      out.write("            margin-left: 10px;\n");
      out.write("            border: none;\n");
      out.write("            background: none;\n");
      out.write("            outline: none;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        .sign_in button{\n");
      out.write("            margin-top: 30px;\n");
      out.write("            width: 100%;\n");
      out.write("            border: 1px solid rgb(7, 139, 247);\n");
      out.write("            outline: none;\n");
      out.write("            background: none;\n");
      out.write("            color: white;\n");
      out.write("            height: 30px;\n");
      out.write("            font-size: 18px;\n");
      out.write("            background-color: #0B1218;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: 0.2s;\n");
      out.write("            opacity: 0.8;\n");
      out.write("        }\n");
      out.write("        .sign_in button:hover{\n");
      out.write("            opacity: 0.6;\n");
      out.write("            box-shadow: 0px 0px 1px 2px white;\n");
      out.write("            font-size: 17px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action=\"ControllerLogin?do=CheckLogin\" method=\"post\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("            <div class=\"Opacity\"></div>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <p>Login</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"username\">\n");
      out.write("                    <i class='bx bxs-user'></i>\n");
      out.write("                    <input name=\"username\" type=\"text\" placeholder=\"username\" value=\"\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"password\">\n");
      out.write("                    <i class='bx bxs-lock-alt'></i>\n");
      out.write("                    <input name=\"password\" type=\"password\" placeholder=\"password\" value=\"\">\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <h4 id=\"er\" style=\"color: white;font-size: 10px; position: fixed;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("                <div class=\"sign_in\">\n");
      out.write("                    <button type=\"submit\" name=\"sign_in\">Sign in</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        </form>       \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
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
