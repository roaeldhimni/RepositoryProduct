/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.entities.Commande;
import ma.projet.entities.Produit;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.services.CommandeService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;

/**
 *
 * @author Lachgar
 */
@WebServlet(name = "CommandeController", urlPatterns = {"/CommandeController"})
public class CommandeController extends HttpServlet {

    private CommandeService cs;
    private ProduitService pps;
    private LigneCommandeProduitService ls;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        cs = new CommandeService();
        pps = new ProduitService();
        ls = new LigneCommandeProduitService();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("op") != null) {
            String op = request.getParameter("op");
            if (op.equals("delete")) {
                ls.deleteWhere(Integer.parseInt(request.getParameter("id")));
                cs.delete(cs.getById(Integer.parseInt(request.getParameter("id"))));
                response.sendRedirect("Commande.jsp");
            }
            if (op.equals("update")) {
                Commande c = cs.getById(Integer.parseInt(request.getParameter("id")));
                String dateStr = request.getParameter("date");

                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                    c.setDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String code = request.getParameter("code");

                c.setCode(code);

                cs.update(c);
                response.sendRedirect("Commande.jsp");
            }
            if (op.equals("ajouterProduit")) {
                int commande = Integer.parseInt(request.getParameter("commande"));
                int produit = Integer.parseInt(request.getParameter("produit"));
                int quantite = Integer.parseInt(request.getParameter("quantite"));
                LigneCommandeProduit l = new LigneCommandeProduit(quantite, cs.getById(commande), pps.getById(produit));
                ls.create(l);
                response.sendRedirect("Commande.jsp");
                Produit produi = pps.getById(produit);
                produi.setqStock(produi.getqStock() - quantite);
                pps.update(produi);

            }
            if (op.equals("supprimerProduit")) {
                int commande_id = Integer.parseInt(request.getParameter("commande"));
                int produit_id = Integer.parseInt(request.getParameter("produit"));
                int quantite = Integer.parseInt(request.getParameter("quantite"));
                LigneCommandeProduitPK id = new LigneCommandeProduitPK(produit_id, commande_id);
                ls.delete(ls.getById(id));
                Produit p = pps.getById(produit_id);
                p.setqStock(p.getqStock() + quantite);
                pps.update(p);
                response.sendRedirect("Commande.jsp");

//                Produit produi = pps.getById(produit);
//                pps.update(produi);
            }
            if (op.equals("afficherProduitsDeCommande")) {
                int commandeId = Integer.parseInt(request.getParameter("id"));

                // Récupérez la liste de produits en fonction de l'ID de la commande
                List<LigneCommandeProduit> produits = cs.getProduitsDeCommande(commandeId);

                // Générez le code HTML pour la liste de produits
                PrintWriter out = response.getWriter();
                for (LigneCommandeProduit produit : produits) {
                    out.println("<tr>");
                    out.println("<td>" + produit.getProduit().getReference() + "</td>");
                    out.println("<td>" + produit.getProduit().getPrix() + "</td>");
                    out.println("<td>" + produit.getProduit().getCategorie().getLibelle() + "</td>");
                    out.println("<td>" + produit.getQuantite() + "</td>");
                    out.println("<td><button type='button' onclick='supprimerProduitDeCommande(" + produit.getProduit().getId() + ", " + produit.getCommande().getId() + ", " + produit.getQuantite() + ")'>Supprimer</button></td>");
                    out.println("</tr>");
                }
            }

        } else {
            String dateStr = request.getParameter("date");
            Date date = new Date();
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String code = request.getParameter("code");
            
            cs.create(new Commande(date, code));
            response.sendRedirect("Commande.jsp");

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}