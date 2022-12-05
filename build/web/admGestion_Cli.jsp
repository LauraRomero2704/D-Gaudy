<%-- 
    Document   : admGestion_Emp
    Created on : 22/10/2022, 07:40:10 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ClienteVO"%>
<%@page import="Modelo.ClienteDAO"%>
<%@include file="sesiones.jsp"%>
<%@include file="alerta.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title> Administrador </title>

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
                    <a href="admGestion.jsp" class="otro">
                        <i class="icon-suitcase"></i>
                        <span class="enlaces">Administrador</span>
                    </a>
                    <span class="tooltip">Administrador</span>
                </li>
            </ul>

            <ul class="lista tareas">
                <h3 class="titulo"> Tareas </h3>
                <li class="menu_marcado">
                    <a href="admGestion_Cli.jsp" class="marcado">
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
            <%  
                HttpSession miSesion2 = request.getSession();
                UsuarioVO usuvo = (UsuarioVO) miSesion2.getAttribute("datosUsuario");
                EmpleadoVO empvo = (EmpleadoVO) miSesion2.getAttribute("datosEmpleado");
                String rolEs = "Administradora";
            %> 

            <ul class="lista">
             <li>
                    <a href="CarritoController?accion=verPerfil&ide_emp=${datosEmpleado.getIde_emp()}" class="otro">
                    <i class='bx bxs-magic-wand'></i>
                    <span class="enlaces">Perfil</span>
               </a>             
               <span class="tooltip">Perfil</span>
             </li>
                <li class="perfil">
                    <div class="detalles_perfil">
                        <img src="IMAGES/modelo.png" alt="perfilImg">
                        <div class="nombre_rol">
                            <div class="nombre"><%=empvo.getNom_emp()%> <%=empvo.getApe_emp()%></div>
                            <div class="rol"><%=rolEs%></div>
                        </div>
                    </div>
                     <form method="post" action="sesiones">
                         <button type="submit" value="Cerrar Sesión" > <i class='bx bx-log-out' id="log_out"></i></button>
                     </form>
                </li>
            </ul>
        </aside>


        <!-- DATATABLE-->
        <h2 class="titulo_tabla">CLIENTES</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	

                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reporteCliente.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                    </div> 

                    <table id="table" class="stripe hover" style="width:100%;">

                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1">#</th>
                                <th data-priority="2">USUARIO</th>
                                <th data-priority="3">DOCUMENTO</th>
                                <th data-priority="4">NOMBRE</th>
                                <th data-priority="5">APELLIDO</th>
                                <th data-priority="6">CIUDAD</th>
                                <th data-priority="7">DIRECCIÓN</th>
                                <th data-priority="8">CORREO</th>
                                <th data-priority="9">TELÉFONO</th>
                                <th data-priority="10">ESTADO</th>
                                <th data-priority="11">INACTIVAR</th>
                            </tr>
                        </thead>

                        <!--LISTAR-->
                        <%
                            ClienteDAO cliDAO = new ClienteDAO();
                            ClienteVO cliVO = new ClienteVO();

                            ArrayList<ClienteVO> listaCliente = cliDAO.listar();
                            for (int i = 0; i < listaCliente.size(); i++) {
                                cliVO = listaCliente.get(i);

                        %>

                        <!--LLAMADO DE DATOS-->
                        <tr style="text-align: center;">
                        <td><%=cliVO.getIde_cli()%></td>
                        <td><%=cliVO.getIde_usu()%></td>
                        <td><%=cliVO.getDoc_cli()%></td>
                        <td><%=cliVO.getNom_cli()%></td>
                        <td><%=cliVO.getApe_cli()%></td>
                        <td><%=cliVO.getCiudad_cli()%></td>
                        <td><%=cliVO.getDir_cli()%></td>
                        <td><%=cliVO.getCorr_cli()%></td>
                        <td><%=cliVO.getTel_cli()%></td>
                        <td><%=cliVO.getEstado_cli()%></td>                                    


                        <!--FUNCION INACTIVAR-->    
                        <%
                        if (cliVO.getEstado_cli().equals("Inactivo")) {
                        %>
                            
                        <form action="Cliente" method="post">
                            <td class="text-center"><button class="boton" type="submit"><i class="bx bx-trash i"></i> <%= cliVO.getEstado_cli().equals("Inactivo") ? "" : ""%></button></td>
                            <input type="hidden" name="txtid" value="<%=cliVO.getIde_cli()%>">
                            <input type="hidden" name="txtestado" value="<%=cliVO.getEstado_cli()%>">
                            <input type="hidden"  name="opcion" value="4">

                            </tr>
                        </form>    
                        <%

                        } else {
                        %>

                        <td class="text-center"><button class="boton" onclick="confirmarCliente(<%=cliVO.getIde_cli()%>)"><i class="bx bx-check-circle a"></i> <%= cliVO.getEstado_cli().equals("Inactivo") ? "" : ""%></button></td>
                        <input type="hidden" name="txtid" value="<%=cliVO.getIde_cli()%>">
                        <input type="hidden" name="txtestado" value="<%=cliVO.getEstado_cli()%>">
                        <input type="hidden"  name="opcion" value="4">

                        </tr>

                        <% } %>

                        <% } %>

                    </table>     
                    <br><br>
                    <!--MODALES DE EXITO Y ERROR-->

                    <% if (request.getAttribute("mensajeDisponible") != null) {
                    %>
                    <meta http-equiv="refresh" content="8; url=admGestion_Cli.jsp">
                    <script>
                        Swal.fire(
                                'Buen trabajo!',
                                '¡Se ha puesto activo correctamente el cliente!',
                                'success'
                                )
                    </script>
                    <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
                    <meta http-equiv="refresh" content="8; url=admGestion_Cli.jsp">
                    <script>
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'No se puso el estado activo correctamente!',

                        })
                    </script>

                    <% }%>


                    <% if (request.getAttribute("mensajeAgotar") != null) {
                    %>
                    <meta http-equiv="refresh" content="8; url=admGestion_Cli.jsp">
                    <script>
                        Swal.fire(
                                'Buen trabajo!',
                                '¡Se ha Inactivado correctamente el cliente!',
                                'success'
                                )
                    </script>
                    <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
                    <meta http-equiv="refresh" content="8; url=admGestion_Cli.jsp">
                    <script>
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: 'No se puso el estado inactivo correctamente!',

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
        <script src="JS/table.js"></script>
        <script src="JS/aside.js"></script>


 </body>
 </html>

