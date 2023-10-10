package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Gestion Page</title>\n");
      out.write("    <style>\n");
      out.write("        /* Reset some default styles */\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Sidebar styles */\n");
      out.write("        #sidebar {\n");
      out.write("            width: 250px;\n");
      out.write("            background-color: #333;\n");
      out.write("            color: white;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            height: 100%;\n");
      out.write("            overflow-y: auto;\n");
      out.write("            padding-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #sidebar h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .menu-item {\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .menu-item a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            display: block;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .menu-item a:hover {\n");
      out.write("            background-color: #555;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Content styles */\n");
      out.write("        #content {\n");
      out.write("            margin-left: 250px; /* Adjust for the sidebar width */\n");
      out.write("            padding: 20px;\n");
      out.write("            height: 100vh;\n");
      out.write("            background-color: #f4f4f4; /* Add a background color for content */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Add your CSS styles for form elements and tables here */\n");
      out.write("\n");
      out.write("        .hidden {\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        iframe {\n");
      out.write("            border: none;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"sidebar\">\n");
      out.write("        <h2 style=\"background-color: #444; padding: 10px; text-align: center; margin-bottom: 20px; color: white;\">La Gestion</h2>\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"Categorie.jsp\" target=\"contentFrame\">Gestion des Catégories</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"Commande.jsp\" target=\"contentFrame\">Gestion des Commandes</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu-item\">\n");
      out.write("            <a href=\"Produit.jsp\" target=\"contentFrame\">Gestion des Produits</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"content\">\n");
      out.write("        <iframe id=\"contentFrame\" name=\"contentFrame\" src=\"Categorie.jsp\"></iframe>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Add click event listeners to menu items\n");
      out.write("        document.querySelectorAll('.menu-item a').forEach(function (item) {\n");
      out.write("            item.addEventListener('click', function (e) {\n");
      out.write("                e.preventDefault();\n");
      out.write("\n");
      out.write("                // Set the iframe source to the clicked menu item's href\n");
      out.write("                document.getElementById('contentFrame').src = item.getAttribute('href');\n");
      out.write("\n");
      out.write("                // Scroll to the top of the content section\n");
      out.write("                document.getElementById('content').scrollTop = 0;\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
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
