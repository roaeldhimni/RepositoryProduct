/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.entities.LigneCommandeProduit;

import ma.projet.entities.Produit;
import ma.projet.services.CommandeService;
import ma.projet.util.HibernateUtil;
import sun.applet.Main;

/**
 *
 * @author Lachgar
 */
public class Test {
    public static void main (String [] args){
        HibernateUtil.getSessionFactory();
        CommandeService cs = new CommandeService();
        
        for (LigneCommandeProduit p:cs.getProduitsDeCommande(1)){
            System.out.println(p);
        }
    }
}
