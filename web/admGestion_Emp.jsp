<%-- 
    Document   : admGestion_Emp
    Created on : 22/10/2022, 07:40:10 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.EmpleadoVO"%>
<%@page import="Modelo.EmpleadoDAO"%>
<%@include file="registrarEmpleado.jsp"%>
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
                <li class="menu">
                    <a href="admGestion_Emp.jsp" class="marcado">
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
        <h2 class="titulo_tabla">EMPLEADOS</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	

                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reporteEmpleados.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                        <!--BOTON NUEVO-->
                        <button type="hidden" class="nuevo" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"><i class="bx bx-plus-medical"></i> Nuevo</button>   
                    </div> 

                    <table id="table" class="stripe hover" style="width:100%;">

                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1">#</th>
                                <th data-priority="2">USUARIO</th>
                                <th data-priority="3">PROFESIÓN</th>
                                <th data-priority="4">DOCUMENTO</th>
                                <th data-priority="5">NOMBRE</th>
                                <th data-priority="6">APELLIDO</th>
                                <th data-priority="7">FECHA DE NACIMIENTO</th>
                                <th data-priority="8">CIUDAD</th>
                                <th data-priority="9">DIRECCIÓN</th>
                                <th data-priority="10">CORREO</th>
                                <th data-priority="11">TELÉFONO</th>
                                <th data-priority="12">ESTADO</th>
                                <th data-priority="13">INACTIVAR</th>
                            </tr>
                        </thead>

                        <!--LISTAR-->
                        <%
                            EmpleadoDAO admDAO = new EmpleadoDAO();
                            EmpleadoVO empVO = new EmpleadoVO();

                            ArrayList<EmpleadoVO> listaEmpleado = admDAO.listar();
                            for (int i = 0; i < listaEmpleado.size(); i++) {
                                empVO = listaEmpleado.get(i);
                        %>

                        <!--LLAMADO DE DATOS-->
                        <tr>
                            <td><%=empVO.getIde_emp()%></td>
                            <td><%=empVO.getIde_usu()%></td>
                            <td><%=empVO.getProf_emp()%></td>
                            <td><%=empVO.getDoc_emp()%></td>           
                            <td><%=empVO.getNom_emp()%></td>
                            <td><%=empVO.getApe_emp()%></td>
                            <td><%=empVO.getFecha_nac()%></td>
                            <td><%=empVO.getCiudad_emp()%></td>
                            <td><%=empVO.getDir_emp()%></td>
                            <td><%=empVO.getCorr_emp()%></td>
                            <td><%=empVO.getTel_emp()%></td>
                            <td><%=empVO.getEstado_emp()%></td>   

                            <!--FUNCION INACTIVAR-->  
                            <%
                                if (empVO.getEstado_emp().equals("Inactivo")) {
                            %>

                        <form action="Empleado" method="post">
                            <td class="text-center"><button class="boton" type="submit"><i class="bx bx-trash i"></i> <%= empVO.getEstado_emp().equals("Inactivo") ? "" : ""%></button></td>
                            <input type="hidden" name="txtIde_emp" value="<%=empVO.getIde_emp()%>">
                            <input type="hidden" name="txtEstado_emp" value="<%=empVO.getEstado_emp()%>">
                            <input type="hidden" name="opcion" value="4">
                        </form>    
                        <%
                        } else {
                        %>
                        <td class="text-center"><button class="boton" onclick="confirmarEmpleado(<%=empVO.getIde_emp()%>)"><i class="bx bx-check-circle a"></i> <%= empVO.getEstado_emp().equals("Inactivo") ? "" : ""%></button></td>
                        <input type="hidden" name="txtIde_emp" value="<%=empVO.getIde_emp()%>">
                        <input type="hidden" name="txtEstado_emp" value="<%=empVO.getEstado_emp()%>">
                        <input type="hidden" name="opcion" value="4">          
                        </tr>
                        <%
                            }
                        %>
                        <%  } %>
                    </table>
                </div>
            </div>
        </section>

        <!--MODALES DE EXITO Y ERROR-->
        <% if (request.getAttribute("mensajeRegistro") != null) {
        %>
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha registrado correctamente el empleado!',
                    'success'
                    )
        </script>
        <% } else if (request.getAttribute("mensajeERegistro") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: '¡Ya existe esta Empleado!',
            })
        </script>
        <% }%>

        <% if (request.getAttribute("mensajeDisponible") != null) {
        %>
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha puesto disponible correctamente el empleado!',
                    'success'
                    )
        </script>
        <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
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
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
        <script>
            Swal.fire(
                    'Buen trabajo!',
                    '¡Se ha agotado correctamente el empleado!',
                    'success'
                    )
        </script>
        <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
        <meta http-equiv="refresh" content="8; url=admGestion_Emp.jsp">
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
        <script src="JS/table.js"></script>
        <script src="JS/aside.js"></script>


    </body>
</html>

