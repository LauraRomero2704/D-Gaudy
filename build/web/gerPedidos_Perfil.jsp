<%-- 
    Document   : gerPedidos_Perfil
    Created on : 19/11/2022, 04:24:02 PM
    Author     : cindy rom
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Perfil</title>
    
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
                    <a href="gerPedidos.jsp" style="margin-left: 15px;">
                        <i class="bx bxs-cart-add"></i>
                        <span class="enlaces"> Gerente de Pedidos </span>
                    </a>
                    <span class="tooltip"> Gerente de Pedidos </span>
                </li>
            </ul>
        
            <ul class="lista tareas">
                <h3 class="titulo"> Tareas </h3>
                <li>
                    <a href="gerPedidos_Det.jsp">
                        <i class="bx bxs-receipt" ></i>
                        <span class="enlaces">Detalles de Pedidos</span>
                    </a>
                    <span class="tooltip">Detalles de Pedidos</span>
                </li>
                <li>
                    <a href="gerPedidos_P.jsp">
                        <i class='bx bxl-shopify'></i>
                        <span class="enlaces">Pedidos</span>
                    </a>
                    <span class="tooltip">Pedidos</span>
                </li>
            </ul>
            <%  
                HttpSession miSesion2 = request.getSession();
                UsuarioVO usuvo = (UsuarioVO) miSesion2.getAttribute("datosUsuario");
                EmpleadoVO empvo = (EmpleadoVO) miSesion2.getAttribute("datosEmpleado");
                String rols = "Gerente De Pedidos";
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
                        <img src="IMAGES/gerPedidos.png" alt="Gerente de Pedidos">
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
        EmpleadoVO empv = (EmpleadoVO)request.getAttribute("myPerfilPedido");
        %>      
        
        <!-- PERFIL -->
        <div class="perfil">
            <div class="publicidad animate__animated animate__slideInDown">
                <div class="imagen">
                    <img src="IMAGES/gerPedidos.png" class="foto">
                </div>
                <div class="texto">
                    <h2 class="nombre_perfil"> <%=empv.getNom_emp()%> <%=empv.getApe_emp()%> </h2>
                    <h3 class="rol_perfil"> <%=empv.getProf_emp()%> </h3>
                    <p> <%=empv.getPerfil_emp()%>
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
                            <li> <span class="dato"> Documento:</span> <%=empv.getDoc_emp()%> </li>
                            <li> <span class="dato"> Fecha de Nacimiento:</span> <%=empv.getFecha_nac()%> </li>
                            <li> <span class="dato"> Correo:</span> <%=empv.getCorr_emp()%> </li>
                          </ul>
                        </div>
                        <div>
                          <h3 class="titulo_categoria"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>
                          <ul class="datos">
                            <li> <span class="dato"> Ciudad:</span> <%=empv.getCiudad_emp()%></li>
                            <li> <span class="dato"> Dirección:</span> <%=empv.getDir_emp()%> </li>
                            <li> <span class="dato"> Teléfono:</span> <%=empv.getTel_emp()%> </li>
                          </ul>
                        </div>
                    </div>
                    <div class="item_informacion animate__animated animate__jackInTheBox" categoria="perfil">
                        <div class="formularios">

                          <!-- Perfil -->
                          <form method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='bx bx-bookmark-heart'></i> Perfil </h3>
                            <div class="grupo_form">
                              <textarea id="perfil" class="input_form" name="txtPerfil_emp" value="<%=empv.getPerfil_emp()%>" placeholder=" "></textarea>
                              <label for="perfil" class="label_form"> </label>
                              <span class="linea_form_"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="11" name="opcion">
                            <input type="hidden" value="<%=empv.getIde_emp()%>" name="txtIde_emp">
                          </form> 

                          <!-- Datos Personales -->
                          <form method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='icono bx bxs-user-detail'></i> Datos Personales </h3>

                            <div class="grupo_form">
                              <input type="number" id="documento" class="input_form" name="txtDoc_emp" value="<%=empv.getDoc_emp()%>" placeholder=" ">
                              <label for="documento" class="label_form">  </label>
                              <span class="linea_form"></span>
                            </div>

                            <div class="grupo_form">
                              <input type="date" id="fechaN" class="input_form" name="txtFecha_emp" value="<%=empv.getFecha_nac()%>" placeholder=" ">
                              <label for="fechaN" class="label_form">  </label>
                              <span class="linea_form"></span>
                            </div>

                            <div class="grupo_form">
                              <input type="email" id="correo" class="input_form" name="txtCorr_emp" value="<%=empv.getCorr_emp()%>" placeholder=" ">
                              <label for="correo" class="label_form"> </label>
                              <span class="linea_form"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="10" name="opcion">
                            <input type="hidden" value="<%=empv.getIde_emp()%>" name="txtIde_emp">
                          </form>

                          <!-- Contacto --> 
                          <form  method="post" action="Empleado" class="formulario">
                            <h3 class="titulo_formularios"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>
                            <div class="grupo_form">
                              <input type="text" id="ciudad" class="input_form" name="txtCiu_emp" value="<%=empv.getCiudad_emp()%>" placeholder=" ">
                              <label for="ciudad" class="label_form">  </label>
                              <span class="linea_form"></span>
                            </div>
                            <div class="grupo_form">
                              <input type="text" id="dir" class="input_form" name="txtDir_emp" value="<%=empv.getDir_emp()%>" placeholder=" ">
                              <label for="dir" class="label_form">  </label>
                              <span class="linea_form"></span>
                            </div>
                            <div class="grupo_form">
                              <input type="number" id="tel" class="input_form" name="txtTel_emp" value="<%=empv.getTel_emp()%>" placeholder=" ">
                              <label for="tel" class="label_form">  </label>
                              <span class="linea_form"></span>
                            </div>

                            <button type="submit" class="boton_form">Actualizar</button>
                            <input type="hidden" value="12" name="opcion">
                            <input type="hidden" value="<%=empv.getIde_emp()%>" name="txtIde_emp">
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
