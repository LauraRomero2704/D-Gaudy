<%-- 
    Document   : inicioSesion
    Created on : 2/08/2022, 08:23:28 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title> Iniciar Sesión </title>

        <!-- ICONOS -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style_login.css">

        <!-- ANIMACIONES -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
        
        <!-- CONTRASEÑA -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="JS/ocultarContraseña.js" type="text/javascript"></script>

</head>
<body>
    
    <div class="contenedor animate__animated animate__rotateIn">

        <div class="formularios">

            <div class="registrarse-iniciar">

                <form method="post" action="Usuario" class="formulario-iniciar formulario" id="formulario">

                    <h2 class="titulo"> Iniciar Sesion </h2>

                    <!-- Grupo: Correo electrónico -->
                    <div class="formulario__grupo" id="grupo__txtnom_usu">
                        <div class="formulario__grupo-input">
                            <input type="text" class="formulario__input" name="txtnom_usu" id="txtnom_usu" autocomplete="on" required>
                            <label for="txtnom_usu" class="formulario__label"> Correo electrónico </label> 
                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                        </div>
                        <p class="formulario__input-error">El correo electrónico  solo puede contener letras, numeros, puntos, guiones y guion bajo.</p>
                    </div>

                    <!-- Grupo: Contraseña -->
                    <div class="formulario__grupo" id="grupo__txtcont_usu">
                        <div class="formulario__grupo-input">
                            <input type="password" class="formulario__input" name="txtcont_usu" id="txtcont_usu" autocomplete="on" required>
                            <label for="txtcont_usu" class="formulario__label"> Contraseña </label> 
                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                            <button id="show_password" class="btn-contraseña" type="button" onclick="mostrarPassword()"> <i class="fa fa-eye-slash icon"></i> </button>
                        </div>
                        <p class="formulario__input-error">La contraseña debe tener entre 8 y 32 caracteres y debe contener mayúsculas, minúsculas, números y símbolos.</p>
                    </div>

                    <div class="formulario__grupo formulario__grupo-btn-enviar"></div>
                        <button class="btn"> Iniciar </button>
                        <input type="hidden" value="5" name="opcion">
                        
                        <!--Mensaje de exito o error-->
                        <%
                        if (request.getAttribute("mensajeError") != null) {
                        %>
                        <h5 class="mensaje centered"> ${mensajeError} </h5> 
                        <%  } else {
                        %>
                        <h5 class="mensaje centered"> ${mensajeExito} </h5> <br>
                        <%  }
                        %>

                </form>

            </div>
    
        </div>

        <div class="paneles">
            <div class="panel-izquierdo panel">
                <div class="content">
                    <h2 class="subtitulo"> ¿Eres nuevo por aquí?... <span> &#160; </span> </h2>
                    <p> ¿Estas preparada para diseñar tú nuevo estilo? </p>
                    <a href="registrarCliente.jsp"> <button class="bton" id="sign-up-button"> Regístrate </button></a> 
                </div>
                <img src="IMAGES/login.png" alt="Moda" class="image">
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script src="JS/formulario.js"></script>
    <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>

</body>
</html>
