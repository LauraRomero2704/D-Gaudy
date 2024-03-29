<%-- 
    Document   : gerPrendas_Cat
    Created on : 17/08/2022, 12:46:39 AM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CategoriaDAO"%>
<%@page import="Modelo.CategoriaVO"%>
<%@include file="registrarCategoria.jsp"%>
<%@include file="alerta.jsp"%>
<%@include file="sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title> Categoria </title>
        
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
                <li class="menu">
                    <a href="gerPrendas_Cat.jsp" class="marcado">
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
                    <a href="gerPrendas_Per.jsp">
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
        <h2 class="titulo_tabla">CATEGORIAS</h2>

        <!--TABLA-->
        <section class="datatable animate__animated animate__zoomIn">
            <div class="container w-full md:w-4/5 xl:w-3/5  mx-auto px-2">
                <div id='recipients' class=" p-8 mt-6 lg:mt-0">	
                    
                    <div class="adicional">
                        <!--REPORTE PDF-->
                        <a href="reporteCategoria.jsp" class="reporte"><button class="pdf"><i class="bx bxs-file-pdf"></i> Pdf </button></a>
                        <!--BOTON NUEVO-->
                        <button class="nuevo" type="hidden" data-bs-toggle="modal" data-bs-target="#exampleModal" ><i class="bx bx-plus-medical"></i> Nuevo </button>    
                    </div>
                    
                    <table id="table" class="stripe hover" style="width:100%;">
                        
                        <!--DATOS CABECERA-->
                        <thead class="cabecera">
                            <tr>
                                <th data-priority="1"> # </th>
                                <th data-priority="2"> NOMBRE </th> 
                                <th data-priority="3"> ESTADO </th>
                                <th data-priority="4"> ACTUALIZAR </th>
                                <th data-priority="5"> AGOTAR </th>
                            </tr>
                        </thead>

                        <!--LISTAR-->
                        <%
                            CategoriaVO catVO = new CategoriaVO();
                            CategoriaDAO catDAO = new CategoriaDAO();

                            ArrayList<CategoriaVO> listarCategorias = catDAO.listar();
                            for (int i = 0; i < listarCategorias.size(); i++) {
                                catVO = listarCategorias.get(i);
                        %>

                            <!--LLAMADO DE DATOS-->
                            <tr>
                                <td> <%=catVO.getIde_cat()%> </td>
                                <td> <%=catVO.getNom_cat()%> </td>
                                <td> <%=catVO.getEstado_cat()%> </td>

                                <!--FUNCION ACTUALIZAR--> 
                                <form action="Categoria" method="post">
                                    <td class="text-center"> <button class="boton" type="submit"><i class='bx bx-edit e'></i></button></td> 
                                    <input type="hidden" name="opcion" value="4">
                                    <input type="hidden" name="txtIde_cat" value="<%=catVO.getIde_cat()%>">
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
                                </form>

                                <!--FUNCION INACTIVAR-->
                                <%
                                    if (catVO.getEstado_cat().equals("Agotada")) {
                                %>
                                    <form action="Categoria" method="post">
                                        <td class="text-center"><button class="boton" type="submit"><i class='bx bx-trash i'></i> <%= catVO.getEstado_cat().equals("Agotada") ? "" : ""%></button></td>
                                        <input type="hidden" name="txtIde_cat" value="<%=catVO.getIde_cat()%>">
                                        <input type="hidden" name="txtEstado_cat" value="<%=catVO.getEstado_cat()%>">
                                        <input type="hidden"  name="opcion" value="3">
                                        </tr>
                                    </form>    
                                <%
                                } else {
                                %>
                                    <td class="text-center"><button class="boton" onclick="confirmarCategoria(<%=catVO.getIde_cat()%>)"><i class='bx bx-check-circle a'></i> <%= catVO.getEstado_cat().equals("Agotada") ? "" : ""%></button></td>
                                    <input type="hidden" name="txtIde_cat" value="<%=catVO.getIde_cat()%>">
                                    <input type="hidden" name="txtEstado_cat" value="<%=catVO.getEstado_cat()%>">
                                    <input type="hidden"  name="opcion" value="3">
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
        <% if (request.getAttribute("mensajeRegistro") != null) {
        %> 
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire(
                            'Buen trabajo!',
                            '¡Se ha actualizado correctamente la categoria!',
                            'success'
                            )
                </script>
        <% } else if (request.getAttribute("mensajeERegistro") != null) {%>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: '¡Ya existe esta categoria!',
                    })
                </script>
        <% }%>

        <%if (request.getAttribute("mensajeActualizar") != null) {
        %>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire(
                            'Buen trabajo!',
                            '¡Se ha actualizado correctamente la categoria!',
                            'success'
                            )
                </script>
        <% } else if (request.getAttribute("mensajeEActualizar") != null) {%>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: 'No se actualizo correctamente!'

                    })
                </script>
        <% }%>

        <% if (request.getAttribute("mensajeDisponible") != null) {
        %>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire(
                            'Buen trabajo!',
                            '¡Se ha puesto disponible correctamente la categoria!',
                            'success'
                            )
                </script>
        <% } else if (request.getAttribute("mensajeEDisponible") != null) {%>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
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
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire(
                            'Buen trabajo!',
                            '¡Se ha agotado correctamente la categoria!',
                            'success'
                            )
                </script>
        <% } else if (request.getAttribute("mensajeEAgotar") != null) {%>
            <meta http-equiv="refresh" content="8; url=gerPrendas_Cat.jsp">
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: 'No se puso el estado agotado correctamente!',

                    })
                </script>
        <% }%>


        <!--JS -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>  
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <jsp:include page="actualizarCategoria.jsp" />

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
