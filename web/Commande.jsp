<%-- 
    Document   : Commande
    Created on : 6 oct. 2023, 19:15:36
    Author     : lenovo
--%>

<%@page import="ma.projet.entities.LigneCommandeProduit"%>
<%@page import="java.util.List"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.services.CommandeService"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commande Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>        
        <style>
        /* Style de base pour améliorer l'apparence de la page */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h1 {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px;
        }

        fieldset {
            margin: 10px;
            padding: 10px;
            background-color: #fff;
        }

        legend {
            font-weight: bold;
            font-size: 1.2em;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Style pour les boutons */
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Style pour les pop-ups */
        .popup {
            display: none;
            position: fixed;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            z-index: 1;
        }

        .popup-content {
            background-color: #fff;
            margin: 10% auto;
            padding: 20px;
            width: 60%;
            box-shadow: 0px 0px 10px 0px #000;
        }

        .close-button {
            background-color: #f44336;
            color: #fff;
            border: none;
            padding: 5px 10px;
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }

        /* Style pour les formulaires */
        input[type="text"], input[type="date"], select, input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
        }
        .red-button {
    background-color: #ff0000; /* Red color */
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}

.red-button:hover {
    background-color: #cc0000; /* Darker red color on hover */
}
    </style>
    </head>
    <body>
        <script>
            function afficherPopup(id) {
                document.getElementsByName("id")[0].value = id;
                
                var popup = document.getElementById("listeProduitsPopup");
                popup.style.display = "block";
            }

            function fermerPopup() {
                var popup = document.getElementById("listeProduitsPopup");
                popup.style.display = "none";
            }

            function afficherProduitPopup(id) {
                document.getElementsByName("id")[0].value = id;
                $(document).ready(function () {
                    // Remplacez 7 par la valeur de votre choix
                    $.ajax({
                        type: "POST",
                        url: "CommandeController?op=afficherProduitsDeCommande&id=" + id,
                        data: {id: id},
                        success: function (response) {
                            $("#l").html(response)
                            // Le code ici sera exécuté lorsque la requête au serveur aura réuss
                        }
                    });
                });
                var popup = document.getElementById("listeProduitsPopupDeCommande");
                popup.style.display = "block";
            }

            function fermerProduitPopup() {
                var popup = document.getElementById("listeProduitsPopupDeCommande");
                popup.style.display = "none";
            }
            function validateForm() {
                var code = document.getElementsByName("code")[0].value;
                var date = document.getElementsByName("date")[0].value;
//                var client = document.getElementsByName("client")[0].value;
                var id = document.getElementsByName("id")[0].value;
                var valider = document.getElementsByName("valider")[0].value;

                // Vérifier si les champs Code et Libelle sont vides
                if (code.trim() === '') {
                    alert("Les champs ne peuvent pas être vides.");
                    return false; // Empêcher la soumission du formulaire
                }

                // Vérifier la valeur du bouton "valider"
                if (valider === "Modifier") {
                    // Si le bouton est "Modifier", rediriger avec l'ID
                    window.location.href = "CommandeController?op=update&id=" + id + "&code=" + code + "&date=" + date ;
                    ;
                    return false; // Empêcher la soumission du formulaire
                } else if (valider === "Ajouter") {
                    // Si le bouton est "Ajouter", permettre la soumission du formulaire
                    return true;
                }

                // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire
                return false;
            }

            function confirmDelete(id, code) {
                var confirmation = confirm("Etes-vous sûr de vouloir supprimer la commande " + code + " ?");
                if (confirmation) {
                    // User confirmed, redirect to the delete URL
                    window.location.href = "CommandeController?op=delete&id=" + id;
                }
            }
           function updateCommande(id, code, date) {
    document.getElementsByName("code")[0].value = code;
    document.getElementsByName("date")[0].value = date;
    document.getElementsByName("id")[0].value = id;
    document.getElementsByName("valider")[0].value = "Modifier"; // Ajoutez cette ligne
}


            function addProductToCommande(produit_id) {
                console.log("Fonction addProductToCommande appelée avec produit_id =", produit_id);
                var id = document.getElementsByName("id")[0].value;
                var quantite = document.getElementsByName("quantite")[0].value;
                window.location.href = "CommandeController?op=ajouterProduit&commande=" + id + "&produit=" + produit_id + "&quantite=" + quantite;
                alert("Produit ajouté avec succés");
            }
            function supprimerProduitDeCommande(produit, commande, quantite) {
                window.location.href = "CommandeController?op=supprimerProduit&commande=" + commande + "&produit=" + produit + "&quantite=" + quantite;
                alert("Produit supprimé de la commande avec succés");

            }

        </script>
        <form action="CommandeController" onsubmit="return validateForm()">
            <fieldset>
                <legend>Gestion des Commandes</legend>
                <table border="0">
                    <tr>
                        <td>Code : </td>
                        <td><input type="text" name="code" value="" /></td>
                    </tr>
                    <tr>
                        <td>Date : </td>
                        <td><input type="date" name="date" value="" /></td>
                    </tr>
                    
                    <tr>
                        
                        <td><input type="text" name="id" value="" hidden/></td>
                    </tr>

                    <tr>

                        <td><input type="submit" value="Ajouter" name="valider" /></td>
                        <td></td>
                    </tr>

                </table>

            </fieldset>
        </form>

        <fieldset>
            <legend>Liste des commandes</legend>
            <table border="0">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Date</th>
<!--                        <th>Client</th>-->
                        <th>Voir les Produits</th>
                        <th>Ajouter un Produit</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CommandeService cs = new CommandeService();
                        for (Commande c : cs.findAll()) {
                    %>
                    <tr>
                        <td><%= c.getCode()%></td>
                        <td><%= c.getDate()%></td>

                        <td><button type="button" onclick="afficherProduitPopup(<%=c.getId()%>)">Voir les produits</button></td>
                        <td><button type="button" onclick="afficherPopup(<%=c.getId()%>)">Ajouter un produit</button></td>
                        <td><button type="button" onclick="confirmDelete(<%=c.getId()%>, '<%=c.getCode()%>')" type="button" class="red-button">Supprimer</button>
                        </td>
                        <td><button type="button" onclick="updateCommande(<%=c.getId()%>, '<%=c.getCode()%>', '<%=c.getDate()%>')">Modifier</button>
                        
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>


        </fieldset>

        <div id="listeProduitsPopup" style="display: none;">
            <fieldset>
                <legend>Liste des produits</legend>
                <table border="0">
                    <thead>
                        <tr>
                            <th>Reference</th>
                            <th>Prix</th>
                            <th>Quantité en stock</th>
                            <th>Categorie</th>
                            <th>Quantité du produit dans la commande</th>
                            <th>Ajouter a la commande</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%

                            ProduitService pps = new ProduitService();
                            for (Produit p : pps.findAll()) {
                        %>
                        <tr>
                            <td><%= p.getReference()%></td>
                            <td><%= p.getPrix()%></td>
                            <td><%= p.getqStock()%></td>
                            <td><%= p.getCategorie().getLibelle()%></td>
                            <td><input type="number" name="quantite" value="1" /></td>
                            <td><button type="button" onclick="addProductToCommande(<%=p.getId()%>)">Ajouter</button>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
                <button onclick="fermerPopup()">Fermer</button>
            </fieldset>
        </div>
        <div id="listeProduitsPopupDeCommande" style="display: none;">
            <fieldset>
                <legend>Liste des produits</legend>
                <table border="0">
                    <thead>
                        <tr>
                            <th>Reference</th>
                            <th>Prix</th>
                            <th>Categorie</th>
                            <th>Quantité du produit dans la commande</th>
                            <th>supprimer le produit</th>
                        </tr>
                    </thead>
                    <tbody id="l">

                    </tbody>

                </table>
                <button onclick="fermerProduitPopup()">Fermer</button>
            </fieldset>
        </div>




    </body>
</html>