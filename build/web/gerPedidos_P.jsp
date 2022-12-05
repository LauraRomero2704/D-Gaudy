<%-- 
    Document   : gerPrendas_T
    Created on : 17/08/2022, 12:14:20 AM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page import="Modelo.PedidoDAO"%>
<%@page import="Modelo.PedidoVO"%>
<%@page import="java.util.ArrayList"%>
<%@include file="sesiones.jsp"%>
<%@include file="alerta.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e1d55cc160.js" crossorigin="anonymous"></script>
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
                <li>
                    <a href="gerPedidos_Det.jsp">
                        <i class="bx bxs-receipt" ></i>
                        <span class="enlaces">Detalles de Pedidos</span>
                    </a>
                    <span class="tooltip">Detalles de Pedidos</span>
                </li>
                <li class="menu">
                    <a href="gerPedidos_P.jsp" class="marcado">
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
        <h2 class="titulo_tabla">PEDIDOS</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	

                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reportePedidos.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                    </div>

                    <table id="table" class="stripe hover" style="width:100%;">

                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1"> # </th>
                                <th data-priority="2"> CLIENTE</th>                                          
                                <th data-priority="3"> TALLA</th>
                                <th data-priority="4"> FECHA</th>
                                <th data-priority="5"> MEDIO PAGO</th>
                                <th data-priority="6">DIRECCIÓN</th>
                                <th data-priority="7"> SUBTOTAL </th>
                                <th data-priority="8"> DESCUENTO </th>
                                <th data-priority="9"> TOTAL </th>
                                <th data-priority="10"> ESTADO </th>
                                <th data-priority="11"> ENTREGAR </th>
                            </tr> 
                        </thead>

                        <!--LISTAR-->
                        <%  PedidoVO pedVO = new PedidoVO();
                            PedidoDAO pedDAO = new PedidoDAO();

                            ArrayList<PedidoVO> listaPedidos = pedDAO.listarPedidos();
                            for (int i = 0; i < listaPedidos.size(); i++) {
                                pedVO = listaPedidos.get(i);
                        %>

                        <!--LLAMADO DE DATOS-->
                        <tr style="text-align:center;">
                            <td> <%=pedVO.getIde_ped()%> </td>
                            <td> <%=pedVO.getIde_cli()%> </td> 
                            <td> <%=pedVO.getTallaPrenda_ped()%> </td> 
                            <td> <%=pedVO.getFecha_ped()%> </td> 
                            <td> <%=pedVO.getMedioPago_ped()%> </td> 
                            <td> <%=pedVO.getDir_ped()%> </td> 
                            <td> <%=pedVO.getSubTotal_ped()%> </td>
                            <td> <%=pedVO.getDescuento_ped()%> </td>
                            <td> <%=pedVO.getTotal_ped()%> </td> 
                            <td> <%=pedVO.getEstado_ped()%> </td> 

                            <!--FUNCION INACTIVAR-->   
                            <%
                                if (pedVO.getEstado_ped().equals("Pendiente")) {
                            %>
                        <form action="Pedido" method="post">
                            <td class="text-center"><button class="boton" type="submit"><i class="bx bx-trash i"></i> <%= pedVO.getEstado_ped().equals("Pendiente") ? "" : ""%></button></td>
                            <input type="hidden" name="txtIde_ped" value="<%=pedVO.getIde_ped()%>">
                            <input type="hidden" name="txtEstado_ped" value="<%=pedVO.getEstado_ped()%>">
                            <input type="hidden"  name="opcion" value="1">
                            </tr>
                        </form>    
                        <%
                        } else {
                        %>

                        <td class="text-center"><button class="boton" onclick="confirmarPedido(<%=pedVO.getIde_ped()%>)"><i class="bx bx-check-circle a"></i> <%= pedVO.getEstado_ped().equals("Pendiente") ? "" : ""%></button></td>
                        <input type="hidden" name="txtIde_ped" value="<%=pedVO.getIde_ped()%>">
                        <input type="hidden" name="txtEstado_ped" value="<%=pedVO.getEstado_ped()%>">
                        <input type="hidden"  name="opcion" value="1">
                        </tr>
                        <%
                            }
                        %>
                        <% }%>  
                    </table>
                </div>
            </div>
        </section>

        <!--MODALES DE EXITO Y ERROR-->
        <% if (request.getAttribute("mensajeDisponible") != null) {
        %>
        <meta http-equiv="refresh" content="8; url=gerPedidos_P.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha puesto entregado correctamente el pedido!',
                    'success'
                    )
        </script>
        <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
        <meta http-equiv="refresh" content="8; url=gerPedidos_P.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se puso el estado disponible correctamente!',

            })
        </script>
        <% }%>

        <% if (request.getAttribute("mensajeAgotar") != null) {
        %>
        <meta http-equiv="refresh" content="8; url=gerPedidos_P.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha puesto pendiente correctamente el pedido!',
                    'success'
                    )
        </script>
        <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
        <meta http-equiv="refresh" content="8; url=gerPedidos_P.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se puso el estado agotado correctamente!',

            })
        </script>
        <% }%>

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
        <script src="JS/aside.js"></script>
        <script src="JS/table.js"></script>

    </body>
</html>

