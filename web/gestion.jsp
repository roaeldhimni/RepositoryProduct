<%-- 
    Document   : gestion
    Created on : 10 oct. 2023, 01:25:50
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestion Page</title>
    <style>
        /* Reset some default styles */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Sidebar styles */
        #sidebar {
            width: 250px;
            background-color: #333;
            color: white;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            overflow-y: auto;
            padding-top: 20px;
        }

        #sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .menu-item {
            margin-bottom: 10px;
        }

        .menu-item a {
            text-decoration: none;
            color: white;
            display: block;
            padding: 10px 20px;
        }

        .menu-item a:hover {
            background-color: #555;
        }

        /* Content styles */
        #content {
            margin-left: 250px; /* Adjust for the sidebar width */
            padding: 20px;
            height: 100vh;
            background-color: #f4f4f4; /* Add a background color for content */
        }

        /* Add your CSS styles for form elements and tables here */

        .hidden {
            display: none;
        }

        iframe {
            border: none;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <div id="sidebar">
        <h2 style="background-color: #444; padding: 10px; text-align: center; margin-bottom: 20px; color: white;">La Gestion</h2>
        <div class="menu-item">
            <a href="Categorie.jsp" target="contentFrame">Gestion des Catégories</a>
        </div>
        <div class="menu-item">
            <a href="Commande.jsp" target="contentFrame">Gestion des Commandes</a>
        </div>
        <div class="menu-item">
            <a href="Produit.jsp" target="contentFrame">Gestion des Produits</a>
        </div>
    </div>

    <div id="content">
        <iframe id="contentFrame" name="contentFrame" src="Categorie.jsp"></iframe>
    </div>

    <script>
        // Add click event listeners to menu items
        document.querySelectorAll('.menu-item a').forEach(function (item) {
            item.addEventListener('click', function (e) {
                e.preventDefault();

                // Set the iframe source to the clicked menu item's href
                document.getElementById('contentFrame').src = item.getAttribute('href');

                // Scroll to the top of the content section
                document.getElementById('content').scrollTop = 0;
            });
        });
    </script>
</body>
</html>