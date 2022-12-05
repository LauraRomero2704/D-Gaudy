<%-- 
    Document   : gerPedidos_Com
    Created on : 8/10/2022, 02:06:32 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.DetalleDAO"%>
<%@page import="Modelo.DetalleVO"%>
<%@include file="sesiones.jsp"%>
<%@include file="alerta.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title> Gerente Pedido </title>

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
                    <a href="gerPedidos.jsp" class="otro">
                        <i class="bx bxs-cart-add"></i>
                        <span class="enlaces"> Gerente de Pedidos </span>
                    </a>
                    <span class="tooltip"> Gerente de Pedidos </span>
                </li>
            </ul>

            <ul class="lista tareas">
                <h3 class="titulo"> Tareas </h3>
                <li class="menu_marcadoDet">
                    <a href="gerPedidos_Det.jsp" class="marcado">
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
             <li>
                    <a href="CarritoController?accion=verPerfilPedido&ide_emp=${datosEmpleado.getIde_emp()}" class="otro">
                    <i class='bx bxs-magic-wand'></i>
                    <span class="enlaces">Perfil</span>
               </a>             
               <span class="tooltip">Perfil</span>
             </li>
                <li class="perfil">
                    <div class="detalles_perfil">
                        <img src="IMAGES/gerPedidos.png" alt="Gerente de Pedidos">
                        <div class="nombre_rol">
                            <div class="nombre"><%=empvo.getNom_emp()%> <%=empvo.getApe_emp()%></div>
                            <div class="rol">Gerente de Pedidos</div>
                        </div>
                    </div>
                    <form method="post" action="sesiones">
                         <button type="submit" value="Cerrar Sesión" > <i class='bx bx-log-out' id="log_out"></i></button>
                     </form>
                </li>
            </ul>
        </aside>


        <!-- DATATABLE -->
        <h2 class="titulo_tabla">DETALLES</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	

                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reporteDetalle.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                    </div>

                    <table id="table" class="stripe hover" style="width:100%;">

                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1"> # </th>
                                <th data-priority="2"> PEDIDO </th>                                          
                                <th data-priority="3"> PRENDA </th>
                                <th data-priority="4"> CANTIDAD </th>
                                <th data-priority="5"> PRECIO </th>
                            </tr> 
                        </thead>

                        <!--LISTAR-->
                        <%  DetalleVO detVO = new DetalleVO();
                            DetalleDAO detDAO = new DetalleDAO();

                            ArrayList<DetalleVO> listaDetalles = detDAO.listarDetalles();
                            for (int i = 0; i < listaDetalles.size(); i++) {
                                detVO = listaDetalles.get(i);
                        %>

                        <!--LLAMADO DE DATOS-->
                        <tr style="text-align:center;">
                            <td> <%=detVO.getIde_det()%> </td>
                            <td> <%=detVO.getIde_ped()%> </td> 
                            <td> <%=detVO.getIde_pren()%> </td> 
                            <td> <%=detVO.getCantPren_det()%> </td> 
                            <td> <%=detVO.getPrecio_ped()%> </td> 
                            <% }%>
                        </tr>
                    </table>
                </div>
            </div>
        </section>

        <!--JS NECESARIOS-->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>  
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <jsp:include page="alerta.jsp" />

        <!-- jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>		

        <!--Datatables -->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>

        <!-- JS -->
        <script src="JS/table.js"></script>
        <script src="JS/table.js"></script>

    </body>
</html>


