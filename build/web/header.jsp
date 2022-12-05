<%-- 
    Document   : header
    Created on : 24/11/2022, 05:12:58 AM
    Author     : cindy rom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Estilos CSS -->
        <link rel="stylesheet" href="CSS/style-index.css">
        <link rel="stylesheet" href="CSS/font-awesome.css">
        <link rel="stylesheet" href="CSS/style-personalizar.css">

        <!-- JS -->
        <script src="JS/jquery-3.1.0.min.js"></script>
        <script src="JS/main.js"></script>

        <!-- Fuentes -->
        <script src="https://kit.fontawesome.com/a2e1308b84.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Damion&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Damion&family=Lemon&family=Signika:wght@500&family=Tiro+Telugu&display=swap" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>

        <!-- Iconos -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        
    </head>
    <body>
        
        <!-- Header -->
        <nav class="nav-header" id="navbar">
            <input id="nav-toggle" type="checkbox">
            <div class="brand">
                <a href="principal.jsp">
                    <h1 class="titulo1" style="font-size:35px; font-family: 'Lemon', cursive;"><span style="margin: 5px;font-family: 'Lemon', cursive;">D'</span>GAUDY</h1>
                </a>
            </div>

            <ul class="links">
                <li> <form class="form">
                        <input type="text" required>
                        <label class="lbl-nombre">
                            <span class="text-nomb" style="font-family: fuenteParrafo;"><i class="fa-solid fa-magnifying-glass" style="font-size:20px;"></i> Buscar</span>
                        </label>
                    </form></li>
                <div class="ima1">
                    <li><a href="./CarritoController?accion=Nuevo"><i  class="fa-sharp fa-solid fa-tags" style="position:relative;margin-left:-200px;font-size:30px; transition: all 1500ms ease;"></i><p style="margin:5px;font-size:21px;font-family: fuenteParrafo;transition: all 1500ms ease;">Categoria</p></a></li>
                </div>
                <li><a href="./CarritoController?accion=carrito"><i class="fas fa-shopping-cart" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i>(<label style="color: skyblue">${cont}</label>)</a></li>
                <li><a href="CarritoController?accion=MisPedidos"><i class='bx bxs-shopping-bags' style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i></a></li>
                <li><a href="CarritoController?accion=MisPerson"><i class="fa fa-paint-brush" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
                <li><a href="inicioSesion.jsp"><i class="fa-regular fa-circle-user" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
            </ul>

            <label for="nav-toggle" class="icon-burger">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </label>
        </nav>
        <!-- End Header -->
        
        <script src="JS/script-index.js"></script>
    <script src="JS/jquery-3.2.1.min.js"></script>
    <script src="JS/main.js"></script>
    
    </body>
</html>
