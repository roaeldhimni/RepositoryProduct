/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.util.Date;
import ma.projet.entities.Commande;
import ma.projet.services.CommandeService;
//import ma.projet.entities.Personne;
//import ma.projet.services.PersonneService;


/**
 *
 * @author Lachgar
 */
public class TestCommande {
     public static void main(String[] args) {

        CommandeService cs = new CommandeService();
//        PersonneService ps = new PersonneService();

        
        cs.create(new Commande(new Date(),"commande1"));
        cs.create(new Commande(new Date(),"commande2"));
}

        }
