<%-- 
    Document   : Produit
    Created on : 6 oct. 2023, 19:15:36
    Author     : lenovo
--%>

<%@page import="ma.projet.entities.Categorie"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Produit Page</title>
    <style>
        /* Style de base pour améliorer l'apparence de la page */
        /* Style for the styled-select dropdown */
        .red-button {
    background-color: #ff0000; /* Red color */
    color: #fff;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}

.red-button:hover {
    background-color: #cc0000; /* Darker red color on hover */
}
        .styled-select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            appearance: none; /* Remove default styles in some browsers */
            -webkit-appearance: none; /* Remove default styles in WebKit browsers */
            -moz-appearance: none; /* Remove default styles in Mozilla browsers */
            background: url('arrow-down.png') no-repeat right; /* Add custom arrow icon */
            background-size: 24px; /* Adjust the arrow icon size */
        }

        /* Style for the select options */
        .styled-select option.styled-option {
            padding: 10px;
            background-color: #f4f4f4; /* Match the background color of the page */
            color: #333;
            font-size: 14px;
            cursor: pointer;
        }

        /* Hover effect for the select options */
        .styled-select option.styled-option:hover {
            background-color: #007bff;
            color: #fff;
        }

        /* Style for the selected option */
        .styled-select .selected-option {
            background-color: #007bff;
            color: #fff;
        }

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

        /* Style pour les formulaires */
        input[type="text"], input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Style pour le bouton Modifier */
        input[type="submit"][value="Modifier"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<script>
    function validateForm() {
        var prix = document.getElementsByName("prix")[0].value;
        var qStock = document.getElementsByName("qStock")[0].value;
        var ref = document.getElementsByName("ref")[0].value;
        var categorie = document.getElementsByName("categorie")[0].value;
        var id = document.getElementsByName("id")[0].value;
        var valider = document.getElementsByName("valider")[0].value;

        // Vérifier si les champs Code et Libelle sont vides
        if (ref.trim() === '' && prix.toString().trim() === '' && qStock.toString().trim() === '') {
            alert("Les champs ne peuvent pas être vides.");
            return false; // Empêcher la soumission du formulaire
        }

        // Vérifier la valeur du bouton "valider"
        if (valider === "Modifier") {
            // Si le bouton est "Modifier", rediriger avec l'ID
            window.location.href = "ProduitController?op=update&id=" + id + "&prix=" + prix + "&qStock=" + qStock + "&categorie=" + categorie + "&reference=" + ref;
            ;
            return false; // Empêcher la soumission du formulaire
        } else if (valider === "Ajouter") {
            // Si le bouton est "Ajouter", permettre la soumission du formulaire
            return true;
        }

        // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire
        return false;
    }

    function confirmDelete(id, ref) {
        var confirmation = confirm("Etes-vous sûr de vouloir supprimer le produit " + ref + " ?");
        if (confirmation) {
            // User confirmed, redirect to the delete URL
            window.location.href = "ProduitController?op=delete&id=" + id;
        }
    }

    function updateProduit(id, ref, prix, qStock, categorie) {
        document.getElementsByName("prix")[0].value = prix;
        document.getElementsByName("qStock")[0].value = qStock;
        document.getElementsByName("ref")[0].value = ref;
        document.getElementsByName("categorie")[0].value = categorie;

        document.getElementsByName("id")[0].value = id;
        document.getElementsByName("valider")[0].value = "Modifier";
    }
    
    // Function to handle select change event
    document.getElementById('categorieSelect').addEventListener('change', function () {
        var selectedOption = this.options[this.selectedIndex];
        if (selectedOption.value !== "") {
            // You can access the selected option's value and text like this:
            var selectedValue = selectedOption.value;
            var selectedText = selectedOption.textContent;
            
            // Do something with the selected values if needed
            console.log('Selected Value:', selectedValue);
            console.log('Selected Text:', selectedText);
        }
    });
</script>
<form action="ProduitController" onsubmit="return validateForm()" id="produitForm">
    <fieldset>
        <legend>Gestion des Produits</legend>
        <table border="0">
            <tr>
                <td>Réference : </td>
                <td><input type="text" name="ref" value="" /></td>
            </tr>
            <tr>
                <td>Prix: </td>
                <td><input type="number" name="prix" value="" /></td>
                <td  style="display: none;"><input type="text" name="id" value="" hidden/></td>
            </tr>
            <tr>
                <td>Quantité en stock : </td>
                <td><input type="number" name="qStock" value="" /></td>
            </tr>
            <tr>
                <td>Categorie:</td>
                <td>
                    <select name="categorie" class="styled-select" id="categorieSelect">
                        <option value="" class="styled-option">Choisir une catégorie</option>
                        <%
                            CategorieService cs = new CategorieService();
                            for (Categorie c : cs.findAll()) {
                        %>
                        <option value="<%= c.getId()%>" class="styled-option"><%= c.getLibelle()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Ajouter" name="valider" /></td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>
<fieldset>
    <legend>Liste des produits</legend>
    <table border="0">
        <thead>
        <tr>
            <th>Reference</th>
            <th>Prix</th>
            <th>Quantité en stock</th>
            <th>Categorie</th>
            <th>Supprimer</th>
            <th>Modifier</th>
        </tr>
        </thead>
        <tbody>
        <%
            ProduitService ps = new ProduitService();
            for (Produit p : ps.findAll()) {
        %>
        <tr>
            <td><%= p.getReference()%></td>
            <td><%= p.getPrix()%></td>
            <td><%= p.getqStock()%></td>
            <td><%= p.getCategorie().getLibelle()%></td>
            <td><button type="button" class="red-button" onclick="confirmDelete(<%=p.getId()%>, '<%=p.getReference()%>')">Supprimer</button></td>
            <td><button type="button" onclick="updateProduit(<%=p.getId()%>, '<%=p.getReference()%>', <%=p.getPrix()%>, <%= p.getqStock()%>, <%= p.getCategorie().getId()%>)">Modifier</button></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</fieldset>
</body>
</html>