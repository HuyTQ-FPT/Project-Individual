package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>Sign Up Form by Colorlib</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Font Icon -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"fonts/material-icon/css/material-design-iconic-font.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Main css -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style_2.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    \r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("        <section class=\"signup\">\r\n");
      out.write("             <!--<img src=\"img/signup-bg.jpg\" alt=\"\">--> \r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"signup-content\">\r\n");
      out.write("                    <form action=\"ControllerRegister?do=CheckRegister\" method=\"post\" id=\"signup-form\" class=\"signup-form\">\r\n");
      out.write("                        <h2 class=\"form-title\">Create account</h2>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-input\" name=\"name\" id=\"name\" placeholder=\"NameID\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-input\" name=\"username\" placeholder=\"Username\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-input\" name=\"password\" id=\"password\" placeholder=\"Password\"/>\r\n");
      out.write("                            <span toggle=\"#password\" class=\"zmdi zmdi-eye field-icon toggle-password\"></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group lastt\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-input\" name=\"re_password\" id=\"re_password\" placeholder=\"Repeat your password\"/>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <h4 id=\"er\" class=\"er\" style=\"color: red;font-size: 13px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.errorpass}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\r\n");
      out.write("                                <h4 id=\"er\" class=\"er\" style=\"color: red;font-size: 13px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\r\n");
      out.write("                            </div>        \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <input type=\"submit\" name=\"submit\" id=\"submit\" class=\"form-submit\" value=\"Sign up\"/>\r\n");
      out.write("                        </div>                       \r\n");
      out.write("                    </form>\r\n");
      out.write("                    <p class=\"loginhere\">\r\n");
      out.write("                        Have already an account ? <a href=\"ControllerLogin\" class=\"loginhere-link\">Login here</a>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- JS -->\r\n");
      out.write("</body><!-- This templates was made by Colorlib (https://colorlib.com) -->\r\n");
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
