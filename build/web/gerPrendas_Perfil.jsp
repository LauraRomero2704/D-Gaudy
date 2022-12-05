<%-- 
    Document   : gerPrendas_Perfil
    Created on : 20/11/2022, 01:56:16 AM
    Author     : cindy rom
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfi</title>

        <!-- ICONO -->
        <link rel="icon" type="image/png" sizes="16x16" href="IMAGES/icono.png">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-dashboard.css">
        <link rel="stylesheet" type="text/css" href="CSS/style-datables.css">
        <link rel="stylesheet" type="text/css" href="CSS/style_perfil.css">

        <!-- ICONOS -->
        <link rel="stylesheet" href="ICON/style.css">
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

        <!-- ANIMACIONES -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

        <!-- JS -->
        <script src="JS/jquery-3.2.1.js"></script>
        <script src="JS/perfil.js"></script>

    </head>
    <body>
        
        <!-- ASIDE --> 
        <aside class="aside">
            <div class="logo">
                <div class="nombre_logo"> <span class="D"> D'</span>GAUDY </div>
                <i class='bx bx-menu-alt-right' id="btn" ></i>
            </div>
            <ul class="lista admin">
                <li>
                    <a href="gerPrendas.jsp"  style="margin-left: 15px;"> 
                        <i class="bx bx-closet"></i>
                        <span class="enlaces"> Gerente de Prendas </span>
                    </a>
                    <span class="tooltip"> Gerente de Prendas </span>
                </li>
            </ul>
    
            <ul class="lista tareas">
                <h3 class="titulo"> Tareas </h3>
                <li>
                    <a href="gerPrendas_C.jsp">
                        <i class="bx bxs-sticker"></i>
                        <span class="enlaces">Calcomanías</span>
                    </a>
                    <span class="tooltip">Calcomanías</span>
                </li>
                <li>
                    <a href="gerPrendas_Cat.jsp">
                        <i class='bx bx-purchase-tag'></i>
                        <span class="enlaces">Categorías</span>
                    </a>
                    <span class="tooltip">Categorías</span>
                </li>
                <li>
                    <a href="gerPrendas_P.jsp">
                        <i class="bx bxs-t-shirt"></i>
                        <span class="enlaces otros">Prendas</span>
                    </a>
                    <span class="tooltip">Prendas</span>
                </li>
                <li>
                    <a href="gerPrendas_Per.jsp" c>
                        <i class='bx bx-palette'></i>
                        <span class="enlaces otros">Personalizaciones</span>
                    </a>
                    <span class="tooltip">Personalizaciones</span>
                </li>
            </ul>
            <%  
                HttpSession miSesion2 = request.getSession();
                UsuarioVO usuvo = (UsuarioVO) miSesion2.getAttribute("datosUsuario");
                EmpleadoVO empvo = (EmpleadoVO) miSesion2.getAttribute("datosEmpleado");
                String rols = "Gerente De Prendas";
            %> 
    
            <ul class="lista">
            <li class="menu">
                    <a href="CarritoController?accion=verPerfil&ide_emp=${datosEmpleado.getIde_emp()}" class="marcado">
                    <i style="margin-left: 30px" class='bx bxs-magic-wand'></i>
                    <span class="enlaces">Perfil</span>
               </a>             
               <span class="tooltip">Perfil</span>
             </li>
                <li class="perfil">
                    <div class="detalles_perfil">
                        <img src="IMAGES/gerPrendas.png" alt="Gerente de Prendas">
                    <div class="nombre_rol">
                         <div class="nombre"><%=empvo.getNom_emp()%> <%=empvo.getApe_emp()%></div>
                         <div class="rol"><%=rols%></div>
                    </div>
                    </div>
                   <form method="post" action="sesiones">
                         <button type="submit" value="Cerrar Sesión" > <i class='bx bx-log-out' id="log_out"></i></button>
                    </form>
                </li>
            </ul>
        </aside>

        <% 
        EmpleadoVO emvo = (EmpleadoVO)request.getAttribute("myPerfilPrenda");
        %>  
        
        <!-- PERFIL -->
        <div class="perfil">
            <div class="publicidad animate__animated animate__slideInDown">
                <div class="imagen">
                    <img src="IMAGES/gerPedidos.png" class="foto">
                </div>
                <div class="texto">
                    <h2 class="nombre_perfil"> <%=emvo.getNom_emp()%> <%=emvo.getApe_emp()%></h2>
                    <h3 class="rol_perfil"> <%=emvo.getProf_emp()%> </h3>
                    <p> <%=emvo.getPerfil_emp()%>
                    </p>
                </div>
            </div>
            <div class="informacion">
                <div class="lista_categoria">
                    <a href="#" class="item_categoria" categoria="info-pers"> INFORMACIÓN PERSONAL </a>
                    <a href="#" class="item_categoria" categoria="perfil"> EDITAR PERFIL </a>
                </div>
                <section class="lista_informacion">
                    <div class="item_informacion info animate__animated animate__jackInTheBox" categoria="info-pers">
                        <div>
                          <h3 class="titulo_categoria"> <i class='icono bx bxs-user-detail'></i> Datos Personales </h3>
                          <ul class="datos">
                            <li> <span class="dato"> Documento:</span> <%=emvo.getDoc_emp()%> </li>
                            <li> <span class="dato"> Fecha de Nacimiento:</span> <%=emvo.getFecha_nac()%> </li>
                            <li> <span class="dato"> Correo:</span> <%=emvo.getCorr_emp()%> </li>
                          </ul>
                        </div>
                        <div>
                          <h3 class="titulo_categoria"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>
                          <ul class="datos">
                            <li> <span class="dato"> Ciudad:</span> <%=emvo.getCiudad_emp()%></li>
                            <li> <span class="dato"> Dirección:</span> <%=emvo.getDir_emp()%> </li>
                            <li> <span class="dato"> Teléfono:</span> <%=emvo.getTel_emp()%> </li>
                          </ul>
                        </div>
                    </div>
                    <div class="item_informacion animate__animated animate__jackInTheBox" categoria="perfil">
                        <div class="formularios">

                          <!-- Perfil -->
                          <form method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='bx bx-bookmark-heart'></i> Perfil </h3>
                            <div class="grupo_form">
                              <label for="perfil" class="formulario_label"> Perfil </label>
                              <textarea id="perfil" class="input_form" name="txtPerfil_emp" value="<%=emvo.getPerfil_emp()%>" placeholder=" "></textarea>
                              <span class="linea_form_"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="8" name="opcion">
                            <input type="hidden" value="<%=emvo.getIde_emp()%>" name="txtIde_emp">
                          </form> 

                          <!-- Datos Personales -->
                          <form method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='icono bx bxs-user-detail'></i> Datos Personales </h3>

                            <div class="grupo_form">
                              <label for="documento" class="formulario_label"> Documento </label>
                              <input type="number" id="documento" class="input_form" name="txtDoc_emp" value="<%=emvo.getDoc_emp()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>

                            <div class="grupo_form">
                              <label for="fechaN" class="formulario_label"> Fecha de Nacimiento </label>
                              <input type="date" id="fechaN" class="input_form" name="txtFecha_emp" value="<%=emvo.getFecha_nac()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>

                            <div class="grupo_form">
                              <label for="correo" class="formulario_label"> Correo electrónico </label>
                              <input type="email" id="correo" class="input_form" name="txtCorr_emp" value="<%=emvo.getCorr_emp()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="7" name="opcion">
                            <input type="hidden" value="<%=emvo.getIde_emp()%>" name="txtIde_emp">
                          </form>

                          <!-- Contacto --> 
                          <form  method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>
                            <div class="grupo_form">
                              <label for="ciudad" class="formulario_label"> Ciudad </label>
                              <input type="text" id="ciudad" class="input_form" name="txtCiu_emp" value="<%=emvo.getCiudad_emp()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>
                            <div class="grupo_form">
                              <label for="dir" class="formulario_label"> Dirección </label>
                              <input type="text" id="dir" class="input_form" name="txtDir_emp" value="<%=emvo.getDir_emp()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>
                            <div class="grupo_form">
                              <label for="tel" class="formulario_label"> Teléfono </label>
                              <input type="number" id="tel" class="input_form" name="txtTel_emp" value="<%=emvo.getTel_emp()%>" placeholder=" ">
                              <span class="linea_form"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="9" name="opcion">
                            <input type="hidden" value="<%=emvo.getIde_emp()%>" name="txtIde_emp">
                          </form> 
                        </div>                             
                    </div>
                </section>
            </div>
        </div>	
        
        <!-- JS -->
        <script src="JS/aside.js"></script>

    </body>
</html>
