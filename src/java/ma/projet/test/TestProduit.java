/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Categorie;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.LigneCommandeProduitPK;
import ma.projet.entities.Produit;
import ma.projet.services.CategorieService;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;

/**
 *
 * @author Lachgar
 */
public class TestProduit {

    public static void main(String[] args) {

        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();

        //cs.create(new Categorie("pc", "pc"));
        //cs.create(new Categorie("imprimante", "imprimante"));
//        ps.create(new Produit("produit1", 200,3, cs.getById(1)));
//        ps.create(new Produit("produit2", 300,2,cs.getById(2)));
//        ps.create(new Produit("produit3", 400,5, cs.getById(1)));
//        ps.create(new Produit("produit4", 500,8, cs.getById(2)));
        
//        for(Produit p : ps.findBetweenDate(new Date("2021/01/01"), new Date("2023/01/01"))){
//            System.out.println(p.getReference());
//        }

           LigneCommandeProduitService lcps = new LigneCommandeProduitService();
    
    Categorie c = cs.getById(1);
        Produit p = ps.getById(1);
        Produit p2 = ps.getById(2);

        LigneCommandeProduitPK lpk = new LigneCommandeProduitPK(p.getId(), c.getId());
        LigneCommandeProduitPK lpk2 = new LigneCommandeProduitPK(p2.getId(), c.getId());
        
        LigneCommandeProduit lcp1 = new LigneCommandeProduit(lpk, 10);
        LigneCommandeProduit lcp2 = new LigneCommandeProduit(lpk2, 20);
        
        lcps.create(lcp1);
        lcps.create(lcp2);
    }

}
