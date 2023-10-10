package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.services.PersonneService;
import ma.projet.entities.Personne;

public final class Personne_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Personne Page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            function validateForm() {\n");
      out.write("                var username = document.getElementsByName(\"username\")[0].value;\n");
      out.write("                var mdp = document.getElementsByName(\"password\")[0].value;\n");
      out.write("                var type = document.getElementsByName(\"type\")[0].value;\n");
      out.write("                var id = document.getElementsByName(\"id\")[0].value;\n");
      out.write("                var valider = document.getElementsByName(\"valider\")[0].value;\n");
      out.write("\n");
      out.write("                // Vérifier si les champs Code et Libelle sont vides\n");
      out.write("                if (username.trim() === '' && mdp.trim() === '') {\n");
      out.write("                    alert(\"Les champs username et mot de passe ne peuvent pas être vides.\");\n");
      out.write("                    return false; // Empêcher la soumission du formulaire\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Vérifier la valeur du bouton \"valider\"\n");
      out.write("                if (valider === \"Modifier\") {\n");
      out.write("                    // Si le bouton est \"Modifier\", rediriger avec l'ID\n");
      out.write("                    console.log(id);\n");
      out.write("                    window.location.href = \"PersonneController?op=update&id=\" + id + \"&username=\" + username + \"&mdp=\" + mdp + \"&type=\" + type;\n");
      out.write("                    ;\n");
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
      out.write("            function confirmDelete(id, username) {\n");
      out.write("                var confirmation = confirm(\"Etes-vous sûr de vouloir supprimer l'utilisateur \" + username + \" ?\");\n");
      out.write("                if (confirmation) {\n");
      out.write("                    // User confirmed, redirect to the delete URL\n");
      out.write("                    window.location.href = \"PersonneController?op=delete&id=\" + id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function updatePersonne(id, username, mdp, type) {\n");
      out.write("                // Pre-fill the code and libelle fields with the category data\n");
      out.write("                document.getElementsByName(\"username\")[0].value = username;\n");
      out.write("                document.getElementsByName(\"password\")[0].value = mdp;\n");
      out.write("                document.getElementsByName(\"type\")[0].value = type;\n");
      out.write("                document.getElementsByName(\"id\")[0].value = id;\n");
      out.write("                document.getElementsByName(\"valider\")[0].value = \"Modifier\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <form action=\"PersonneController\" onsubmit=\"return validateForm()\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Gestion des Utilisateurs(Client & Admin)</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>UserName: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"username\" value=\"\" /></td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" hidden/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Mot de passe: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"password\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Type: </td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"type\">\n");
      out.write("                                <option value=\"false\">Client</option>\n");
      out.write("                                <option value=\"true\">Admin</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
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
      out.write("                        <th>Username</th>\n");
      out.write("                        <th>Mot de passe</th>\n");
      out.write("                        <th>Admin</th>\n");
      out.write("                        <th>Supprimer</th>\n");
      out.write("                        <th>Modifier</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        PersonneService cs = new PersonneService();
                        for (Personne c : cs.findAll()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( c.getUserName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( c.getMdp());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( c.isIsAdmin());
      out.write("</td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"confirmDelete(");
      out.print(c.getId());
      out.write(", '");
      out.print(c.getUserName());
      out.write("')\">Supprimer</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"updatePersonne(");
      out.print(c.getId());
      out.write(", '");
      out.print(c.getUserName());
      out.write("', '");
      out.print(c.getMdp());
      out.write("', '");
      out.print( c.isIsAdmin());
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
