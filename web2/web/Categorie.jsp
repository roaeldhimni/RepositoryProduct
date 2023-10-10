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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CategorieController">
            <fieldset>
                <legend>Gestion des catégories</legend>
                <table border="0">
                   
                        <tr>
                            <td>Code: </td>
                            <td><input type="text" name="code" value="" /></td>
                        </tr>
                        <tr>
                            <td>Libelle : </td>
                            <td><input type="text" name="libelle" value="" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Valider" name="valider" /></td>
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
                      for(Categorie c : cs.findAll()){  
                    %>
                    <tr>
                        <td><%= c.getCode() %></td>
                        <td><%= c.getLibelle() %></td>
                        <td><a href="CategorieController?op=delete&id=<%=c.getId() %>">Supprimer</a></td>
                        <td><a href="">Modifier</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </fieldset>
    </body>
</html>
