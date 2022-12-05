<%-- 
    Document   : gerPrendas_P
    Created on : 9/10/2022, 03:21:54 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page import="Modelo.PersonalizaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.PersonalizaVO"%>
<%@include file="sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e1d55cc160.js" crossorigin="anonymous"></script>
        <title> Prenda </title>

        <!-- ICONO -->
        <link rel="icon" type="image/png" sizes="16x16" href="IMAGES/icono.png">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-dashboard.css">
        <link rel="stylesheet" type="text/css" href="CSS/style-datables.css">

        <!-- ICONOS -->
        <link rel="stylesheet" href="ICON/style.css">
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

        <!-- TAILWIND DATATABLES CSS -->
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">

        <!-- EXTENSION RESPONSIVE DATATABLES CSS -->
        <link href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css" rel="stylesheet">	 

        <!-- ANIMACIONES -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

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
                    <a href="gerPrendas.jsp" class="otro"> 
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
                <li class="menu_per">
                    <a href="gerPrendas_Per.jsp" class="marcado">
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
             <li>
                    <a href="CarritoController?accion=verPerfilPrenda&ide_emp=${datosEmpleado.getIde_emp()}" class="otro">
                    <i class='bx bxs-magic-wand'></i>
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


        <!-- DATATABLES -->
        <h2 class="titulo_tabla">PERSONALIZACIONES</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	

                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reportePersonaliza.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i>  Pdf </button></a>
                    </div>

                    <table id="table" class="stripe hover hola" style="width:100%;">

                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1"> # </th>
                                <th data-priority="2"> CLIENTE </th>
                                <th data-priority="3"> PRENDA </th>
                                <th data-priority="4"> CALCOMANÍA </th>
                                <th data-priority="5"> NOMBRE </th>
                                <th data-priority="6"> URL </th>
                                <th data-priority="7"> PRECIO </th>
                            </tr>
                        </thead>

                        <!--LISTAR-->
                        <%  PersonalizaDAO perDAO = new PersonalizaDAO();
                            PersonalizaVO perVO = new PersonalizaVO();

                            ArrayList<PersonalizaVO> listarPersonaliza = perDAO.listar();
                            for (int i = 0; i < listarPersonaliza.size(); i++) {
                                perVO = listarPersonaliza.get(i);


                        %>  

                        <!--LLAMADO DE DATOS-->
                        <tr>
                            <td class="col text-center"><%=perVO.getIde_pers()%></td>
                            <td class="col text-center"><%=perVO.getIde_cli()%></td>
                            <td class="col text-center"><%=perVO.getIde_pren()%></td>
                            <td class="col text-center"><%=perVO.getIde_calc()%></td>
                            <td class="col text-center"><%=perVO.getNom_pers()%></td>
                            <td class="col text-center"><%=perVO.getUrlDiseño_pers()%></td>
                            <td class="col text-center"><%=perVO.getPrecio_pers()%></td>

                            <% }%>  
                            </tbody>
                    </table>

                    <!--MODALES DE EXITO Y ERROR-->


                    <% if (request.getAttribute("mensajeDisponible") != null) {
                    %>
                    <meta http-equiv="refresh" content="8; url=gerPrendas_Per.jsp">
                    <script>
                        Swal.fire(
                                'Buen trabajo!',
                                '¡Se ha puesto publico correctamente la personalizacion!',
                                'success'
                                )
                    </script>
                    <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
                    <meta http-equiv="refresh" content="8; url=gerPrendas_Per.jsp">
                    <script>
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'No se puso el estado publico correctamente!',

                        })
                    </script>

                    <% }%>


                    <% if (request.getAttribute("mensajeAgotar") != null) {
                    %>
                    <meta http-equiv="refresh" content="8; url=gerPrendas_Per.jsp">
                    <script>
                        Swal.fire(
                                'Buen trabajo!',
                                '¡Se ha puesto privada correctamente la personalizacion!',
                                'success'
                                )
                    </script>
                    <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
                    <meta http-equiv="refresh" content="8; url=gerPrendas_Per.jsp">
                    <script>
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'No se puso el estado privada correctamente!',

                        })
                    </script>

                    <% }%>


        <!--JS NECESARIOS-->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>  
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <!-- jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>		

        <!--Datatables -->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>

        <!-- JS -->
        <script src="JS/table.js"></script>

 </body>
</html>
