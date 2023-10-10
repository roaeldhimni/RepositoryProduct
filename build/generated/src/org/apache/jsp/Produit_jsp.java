package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.entities.Categorie;
import ma.projet.services.ProduitService;
import ma.projet.services.CategorieService;
import ma.projet.entities.Produit;

public final class Produit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Produit Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            function validateForm() {\n");
      out.write("                var prix = document.getElementsByName(\"prix\")[0].value;\n");
      out.write("                var qStock = document.getElementsByName(\"qStock\")[0].value;\n");
      out.write("                var ref = document.getElementsByName(\"ref\")[0].value;\n");
      out.write("                var categorie = document.getElementsByName(\"categorie\")[0].value;\n");
      out.write("                var id = document.getElementsByName(\"id\")[0].value;\n");
      out.write("                var valider = document.getElementsByName(\"valider\")[0].value;\n");
      out.write("\n");
      out.write("                // Vérifier si les champs Code et Libelle sont vides\n");
      out.write("                if (ref.trim() === '' && prix.toString().trim() === '' && qStock.toString().trim() === '') {\n");
      out.write("                    alert(\"Les champs ne peuvent pas être vides.\");\n");
      out.write("                    return false; // Empêcher la soumission du formulaire\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Vérifier la valeur du bouton \"valider\"\n");
      out.write("                if (valider === \"Modifier\") {\n");
      out.write("                    // Si le bouton est \"Modifier\", rediriger avec l'ID\n");
      out.write("                    window.location.href = \"ProduitController?op=update&id=\" + id + \"&prix=\" + prix + \"&qStock=\" + qStock + \"&categorie=\" + categorie + \"&reference=\" + ref;\n");
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
      out.write("            function confirmDelete(id, ref) {\n");
      out.write("                var confirmation = confirm(\"Etes-vous sûr de vouloir supprimer le produit \" + ref + \" ?\");\n");
      out.write("                if (confirmation) {\n");
      out.write("                    // User confirmed, redirect to the delete URL\n");
      out.write("                    window.location.href = \"ProduitController?op=delete&id=\" + id;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function updateProduit(id, ref, prix, qStock, categorie) {\n");
      out.write("                document.getElementsByName(\"prix\")[0].value = prix;\n");
      out.write("                document.getElementsByName(\"qStock\")[0].value = qStock;\n");
      out.write("                document.getElementsByName(\"ref\")[0].value = ref;\n");
      out.write("                document.getElementsByName(\"categorie\")[0].value = categorie;\n");
      out.write("\n");
      out.write("                document.getElementsByName(\"id\")[0].value = id;\n");
      out.write("                document.getElementsByName(\"valider\")[0].value = \"Modifier\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <form action=\"ProduitController\" onsubmit=\"return validateForm()\" id=\"categorieForm\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Gestion des Produits</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Réference : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"ref\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Prix: </td>\n");
      out.write("                        <td><input type=\"number\" name=\"prix\" value=\"\" /></td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" hidden/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Quantité en stock : </td>\n");
      out.write("                        <td><input type=\"number\" name=\"qStock\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Categorie:</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"categorie\">\n");
      out.write("                                ");

                                    CategorieService cs = new CategorieService();
                                    for (Categorie c : cs.findAll()) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( c.getId());
      out.write('"');
      out.write('>');
      out.print( c.getLibelle());
      out.write("</option>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <td><input type=\"submit\" value=\"Ajouter\" name=\"valider\" /></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Liste des produits</legend>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Reference</th>\n");
      out.write("                        <th>Prix</th>\n");
      out.write("                        <th>Quantité en stock</th>\n");
      out.write("                        <th>Categorie</th>\n");
      out.write("                        <th>Supprimer</th>\n");
      out.write("                        <th>Modifier</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        ProduitService ps = new ProduitService();
                        for (Produit p : ps.findAll()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( p.getReference());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( p.getPrix());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( p.getqStock());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( p.getCategorie().getLibelle());
      out.write("</td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"confirmDelete(");
      out.print(p.getId());
      out.write(", '");
      out.print(p.getReference());
      out.write("')\">Supprimer</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"updateProduit(");
      out.print(p.getId());
      out.write(", '");
      out.print(p.getReference());
      out.write("', ");
      out.print(p.getPrix());
      out.write(',');
      out.write(' ');
      out.print( p.getqStock());
      out.write(',');
      out.write(' ');
      out.print( p.getCategorie().getId());
      out.write(")\">Modifier</button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </fieldset>\n");
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
