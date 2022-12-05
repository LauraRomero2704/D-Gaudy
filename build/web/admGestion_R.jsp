<%-- 
    Document   : admGestion_R
    Created on : 9/11/2022, 02:44:49 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ReporteDAO"%>
<%@page import="Modelo.ReporteVO"%>
<%@include file="registrarReporte.jsp"%>
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
              <li class="menu">
                <a href="admGestion_R.jsp" class="marcado">
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
        <h2 class="titulo_tabla">REPORTES</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	
                    
                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reportePrincipal.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                        <!--BOTON NUEVO-->
                        <button type="hidden" class="nuevo" data-bs-toggle="modal" data-bs-target="#exampleModal" ><i class="bx bx-plus-medical"></i> Nuevo</button>   

                    </div> 

                    <table id="table" class="stripe hover" style="width:100%;">
                        
                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1"> # </th>
                                <th data-priority="2"> EMPLEADO </th>
                                <th data-priority="3"> NOMBRE </th>
                                <th data-priority="4"> CATEGORÍA </th>
                                <th data-priority="5"> PDF </th>
                                <th data-priority="6"> ESTADO </th>
                                <th data-priority="7">ACTUALIZAR</th>
                                <th data-priority="8">INACTIVAR</th>
                            </tr>
                        </thead>

                        <!--LISTAR-->
                        <%  ReporteVO repVO = new ReporteVO();
                            ReporteDAO repDAO = new ReporteDAO();
                            ArrayList<ReporteVO> listaReportes = repDAO.listarReportes();
                            for (int i = 0; i < listaReportes.size(); i++) {
                                repVO = listaReportes.get(i);
                        %>

                            <!--LLAMADO DE DATOS-->
                            <tr style="text-align: center;">
                                <td> <%=repVO.getIde_rept()%> </td>
                                <td> <%=repVO.getIde_emp()%> </td>
                                <td> <%=repVO.getNom_rept()%> </td>
                                <td> <%=repVO.getCat_rept()%> </td>

                                <td class="descargar"> <!--PARA PONER IMG DE PDF-->
                                    <%
                                        if (repVO.getPdf_rept() != null) {
                                    %>
                                        <a href="pdf?id_rept=<%=repVO.getIde_rept()%>" target="_blank"><i class='bx bxs-cart-download rept'> <div class="mensaje"> <span class="texto-reporte"> Descargar </span> </div></i></a>
                                        
                                    <%
                                    } else {
                                        out.print("Vacio");
                                    }
                                    %>
                                </td>
                                <td> <%=repVO.getEstado_rept()%> </td>
                            
                                <!--FUNCION ACTUALIZAR-->    
                                <form method="post" action="Reporte">
                                    <td class="text-center"> <button class="boton" type="submit"><i class="bx bx-edit e"></i></button></td> 
                                    <input type="hidden" name="opcion" value="4">
                                    <input type="hidden" name="txtIde_rept" value="<%=repVO.getIde_rept()%>">
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    </div>
                                </form> 

                                <!--FUNCION INACTIVAR-->   
                                <%
                                    if (repVO.getEstado_rept().equals("Archivado")) {
                                %>
                                    <form action="Reporte" method="post">
                                        <td class="text-center"><button class="boton" type="submit"><i class="bx bx-trash i"></i> <%= repVO.getEstado_rept().equals("Archivado") ? "" : ""%></button></td>
                                        <input type="hidden" name="txtIde_rept" value="<%=repVO.getIde_rept()%>">
                                        <input type="hidden" name="txtEstado_rept" value="<%=repVO.getEstado_rept()%>">
                                        <input type="hidden"  name="opcion" value="3">
                            </tr>
                                    </form>    
                                <%
                                } else {
                                %>

                                <td class="text-center"><button class="boton" onclick="confirmarReporte(<%=repVO.getIde_rept()%>)"><i class="bx bx-check-circle a"></i> <%= repVO.getEstado_rept().equals("Archivado") ? "" : ""%></button></td>
                                <input type="hidden" name="txtIde_rept" value="<%=repVO.getIde_rept()%>">
                                <input type="hidden" name="txtEstado_rept" value="<%=repVO.getEstado_rept()%>">
                                <input type="hidden"  name="opcion" value="3">
                            </tr>
                        <%
                            }
                        %>
        <% }%>  
    </table>

    <!--MODALES DE EXITO Y ERROR-->
    <% if (request.getAttribute("mensajeRegistro") != null) {
    %>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha registrado correctamente el reporte!',
                    'success'
                    )
        </script>
    <% } else if (request.getAttribute("mensajeERegistro") != null) {%>
    <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: '¡Error!',
            })
        </script>
    <% }%>

    <% if (request.getAttribute("mensajeActualizar") != null) {
    %>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha actualizado correctamente el reporte!',
                    'success'
                    )
        </script>
    <% } else if (request.getAttribute("mensajeEActualizar") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se actualizo correctamente!',

            })
        </script>
    <% }%>

    <% if (request.getAttribute("mensajeDisponible") != null) {
    %>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha puesto disponible inactivo el reporte!',
                    'success'
                    )
        </script>
    <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se puso el estado archivado correctamente!',

            })
        </script>
    <% }%>

    <% if (request.getAttribute("mensajeAgotar") != null) {
    %>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha agotado correctamente el reporte!',
                    'success'
                    )
        </script>
    <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_R.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se puso el estado archivado correctamente!',

            })
        </script>
    <% }%>

    <!--JS NECESARIOS-->
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>  
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <jsp:include page="actualizarReporte.jsp" />
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

