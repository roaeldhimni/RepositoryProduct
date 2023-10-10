package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.services.CategorieService;
import ma.projet.entities.Categorie;

public final class Categorie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Categorie Page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            function validateForm() {\n");
      out.write("                var code = document.getElementsByName(\"code\")[0].value;\n");
      out.write("                var libelle = document.getElementsByName(\"libelle\")[0].value;\n");
      out.write("                var id = document.getElementsByName(\"id\")[0].value;\n");
      out.write("                var valider = document.getElementsByName(\"valider\")[0].value;\n");
      out.write("\n");
      out.write("                // Vérifier si les champs Code et Libelle sont vides\n");
      out.write("                if (code.trim() === '' && libelle.trim() === '') {\n");
      out.write("                    alert(\"Les champs Code et Libelle ne peuvent pas être vides.\");\n");
      out.write("                    return false; // Empêcher la soumission du formulaire\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Vérifier la valeur du bouton \"valider\"\n");
      out.write("                if (valider === \"Modifier\") {\n");
      out.write("                    // Si le bouton est \"Modifier\", rediriger avec l'ID\n");
      out.write("                    console.log(id);\n");
      out.write("                    window.location.href = \"CategorieController?op=update&id=\" + id + \"&code=\" + code + \"&libelle=\" + libelle;;\n");
      out.write("                    return false; // Empêcher la soumission du formulaire\n");
      out.write("                } else if (valider === \"Ajouter\") {\n");
      out.write("                    // Si le bouton est \"Ajouter\", permettre la soumission du formulaire\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function confirmDelete(id, libelle) {\n");
      out.write("                var confirmation = confirm(\"Etes-vous sûr de vouloir supprimer la catégorie \" + libelle + \" ?\");\n");
      out.write("                if (confirmation) {\n");
      out.write("                    // User confirmed, redirect to the delete URL\n");
      out.write("                    window.location.href = \"CategorieController?op=delete&id=\" + id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function updateCategory(id, code, libelle) {\n");
      out.write("                // Pre-fill the code and libelle fields with the category data\n");
      out.write("                document.getElementsByName(\"code\")[0].value = code;\n");
      out.write("                document.getElementsByName(\"libelle\")[0].value = libelle;\n");
      out.write("                document.getElementsByName(\"id\")[0].value = id;\n");
      out.write("                document.getElementsByName(\"valider\")[0].value = \"Modifier\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <form action=\"CategorieController\" onsubmit=\"return validateForm()\" id=\"categorieForm\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Gestion des catégories</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Code: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"code\" value=\"\" /></td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" hidden/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Libelle : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"libelle\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" value=\"Ajouter\" name=\"valider\" /></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Liste des catégories</legend>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Code</th>\n");
      out.write("                        <th>Libelle</th>\n");
      out.write("                        <th>Supprimer</th>\n");
      out.write("                        <th>Modifier</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        CategorieService cs = new CategorieService();
                        for (Categorie c : cs.findAll()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( c.getCode());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( c.getLibelle());
      out.write("</td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"confirmDelete(");
      out.print(c.getId());
      out.write(", '");
      out.print(c.getLibelle());
      out.write("')\">Supprimer</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"updateCategory(");
      out.print(c.getId());
      out.write(", '");
      out.print(c.getCode());
      out.write("', '");
      out.print(c.getLibelle());
      out.write("')\">Modifier</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </fieldset>\n");
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
