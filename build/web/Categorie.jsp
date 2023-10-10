<%-- 
    Document   : Categorie
    Created on : 4 oct. 2023, 11:52:10
    Author     : Lachgar
--%>

<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        /* Style de base pour améliorer l'apparence de la page */
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
        input[type="text"], input[type="submit"] {
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorie Page</title>
    </head>

    <body>
        <script>
            function validateForm() {
                var code = document.getElementsByName("code")[0].value;
                var libelle = document.getElementsByName("libelle")[0].value;
                var id = document.getElementsByName("id")[0].value;
                var valider = document.getElementsByName("valider")[0].value;

                // Vérifier si les champs Code et Libelle sont vides
                if (code.trim() === '' && libelle.trim() === '') {
                    alert("Les champs Code et Libelle ne peuvent pas être vides.");
                    return false; // Empêcher la soumission du formulaire
                }

                // Vérifier la valeur du bouton "valider"
                if (valider === "Modifier") {
                    // Si le bouton est "Modifier", rediriger avec l'ID
                    console.log(id);
                    window.location.href = "CategorieController?op=update&id=" + id + "&code=" + code + "&libelle=" + libelle;;
                    return false; // Empêcher la soumission du formulaire
                } else if (valider === "Ajouter") {
                    // Si le bouton est "Ajouter", permettre la soumission du formulaire
                    return true;
                }

                // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire
                return false;
            }

            function confirmDelete(id, libelle) {
                var confirmation = confirm("Etes-vous sûr de vouloir supprimer la catégorie " + libelle + " ?");
                if (confirmation) {
                    // User confirmed, redirect to the delete URL
                    window.location.href = "CategorieController?op=delete&id=" + id;
                }
            }
            function updateCategory(id, code, libelle) {
                // Pre-fill the code and libelle fields with the category data
                document.getElementsByName("code")[0].value = code;
                document.getElementsByName("libelle")[0].value = libelle;
                document.getElementsByName("id")[0].value = id;
                document.getElementsByName("valider")[0].value = "Modifier";
            }

        </script>
        <form action="CategorieController" onsubmit="return validateForm()" id="categorieForm">
            <fieldset>
                <legend>Gestion des catégories</legend>
                <table border="0">
                    <tr>
                        <td>Code: </td>
                        <td><input type="text" name="code" value="" /></td>
                        <td  style="display: none;"><input type="text" name="id" value="" hidden/></td>
                        
                    </tr>
                    <tr>
                        <td>Libelle : </td>
                        <td><input type="text" name="libelle" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Ajouter" name="valider" /></td>
                        <td></td>
                    </tr>
                </table>
            </fieldset>
        </form>

        <fieldset>
            <legend>Liste des catégories</legend>
            <table border="0">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Libelle</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategorieService cs = new CategorieService();
                        for (Categorie c : cs.findAll()) {
                    %>
                    <tr>
                        <td><%= c.getCode()%></td>
                        <td><%= c.getLibelle()%></td>
<td><button type="button" class="red-button" onclick="confirmDelete(<%=c.getId()%>, '<%=c.getLibelle()%>')">Supprimer</button></td>
                        </td>
                        <td><button type="button" onclick="updateCategory(<%=c.getId()%>, '<%=c.getCode()%>', '<%=c.getLibelle()%>')">Modifier</button>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </fieldset>
    </body>
</html>