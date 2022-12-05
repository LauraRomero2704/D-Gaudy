<%-- 
    Document   : gerPrendas
    Created on : 15/11/2022, 01:16:55 AM
    Author     : cindy rom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Administrador </title>

        <!-- ICONO -->
        <link rel="icon" type="image/png" sizes="16x16" href="IMAGES/icono.png">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-dashboard.css">
        <link rel="stylesheet" href="CSS/style_calendario.css">

        <!-- ICONOS -->
        <link rel="stylesheet" href="ICON/style.css">
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>	 

        <!-- ANIMACIONES -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

        <!-- JS -->
        <script src="JS/calendario.js" defer></script>
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
                <a href="admGestion.jsp" style="margin-left: 15px;">
                  <i class="icon-suitcase"></i>
                  <span class="enlaces">Administrador</span>
                </a>
                <span class="tooltip">Administrador</span>
              </li>
            </ul>

            <ul class="lista app">
              <h3 class="titulo"> Aplicaciones </h3>
              <li class="menu_marcado">
                <a href="calendario.jsp" class="marcado">
                  <i class="icon-calendar"></i>
                  <span class="enlaces">Calendario</span>
                </a>
                <span class="tooltip">Calendario</span>
              </li>
             <li>
               <a href="progreso.jsp">
                 <i class="icon-stats"></i>
                 <span class="enlaces">Progreso</span>
               </a>
               <span class="tooltip">Progreso</span>
             </li>
            </ul>

            <ul class="lista tareas">
              <h3 class="titulo"> Tareas </h3>
              <li>
                <a href="admGestion_Cli.jsp">
                  <i class="icon-basket" ></i>
                  <span class="enlaces">Clientes</span>
                </a>
                <span class="tooltip">Clientes</span>
              </li>
              <li>
                <a href="admGestion_Emp.jsp">
                  <i class='bx bx-id-card'></i>
                  <span class="enlaces">Empleados</span>
                </a>
                <span class="tooltip">Empleados</span>
              </li>
              <li>
                <a href="admGestion_R.jsp">
                  <i class="bx bxs-file-pdf" ></i>
                  <span class="enlaces otros">Reportes</span>
                </a>
                <span class="tooltip">Reportes</span>
              </li>
             <li>
               <a href="admGestion_Usu.jsp">
                 <i class="bx bxs-user" ></i>
                 <span class="enlaces otros">Usuarios</span>
               </a>
               <span class="tooltip">Usuarios</span>
             </li>
            </ul>

            <ul class="lista">
             <li>
                <a href="admGestion_Perfil.jsp" style="margin-left: 15px;">
                 <i class='bx bxs-magic-wand'></i>
                 <span class="enlaces">Perfil</span>
               </a>
               <span class="tooltip">Perfil</span>
             </li>
             <li class="perfil">
                <div class="detalles_perfil">
                   <img src="IMAGES/modelo.png" alt="perfilImg">
                   <div class="nombre_rol">
                     <div class="nombre">Laura Romero</div>
                     <div class="rol">Administradora</div>
                   </div>
                 </div>
                 <a href="inicioSesion.jsp"> <i class='bx bx-log-out' id="log_out" ></i> </a>
             </li>
            </ul>
          </aside>

            <!-- CALENDARIO -->
            <section class="adicionales animate__animated animate__pulse">
              <div class="contenedor cont">
                <div class="calendario">
                  <div class="cabecera-calendario">
                    <span class="selector_meses" id="selector_meses"> Noviembre </span>
                    <div class="selector_años" id="selector_años">
                      <span class="cambio_año" id="año_anterior">
                        <pre><</pre>
                      </span>
                      <span id="año"> 2022 </span>
                      <span class="cambio_año" id="proximo_año">
                        <pre>></pre>
                      </span>
                    </div>
                  </div>
          
                  <div class="cuerpo_calendario">
                    <div class="dias_semana">
                      <div>D</div>
                      <div>L</div>
                      <div>M</div>
                      <div>M</div>
                      <div>J</div>
                      <div>V</div>
                      <div>S</div>
                    </div>
                    <div class="dias_calendario">
                    </div>
                  </div>
                  <div class="formato_fecha_hora">
                    <div class="formato_texto_dia">HOY</div>
                    <div class="valor_fecha_hora">
                      <div class="formato_tiempo">10:10:00</div>
                      <div class="formato_fecha">19 - noviembre - 2022</div>
                    </div>
                  </div>
                  <div class="lista_meses"></div>
                </div>
              </div>
            </section>

            <!-- JS -->
            <script src="JS/aside.js"></script>

        </body>
    </html>
