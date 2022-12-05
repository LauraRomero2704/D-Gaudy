<%-- 
    Document   : detallePrenda
    Created on : 14/11/2022, 02:03:52 PM
    Author     : Janus
--%>
<%@page import="Modelo.PrendaVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>Detalle Prenda</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#"><i>D´Gaudy</i></a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="./CarritoController?accion=Nuevo"><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./CarritoController?accion=carrito"><i class="fas fa-cart-plus">(<label style="color: skyblue">${cont}</label>)</i> Carrito</a>
                    </li> 
                    <%             PrendaVO p = new PrendaVO();
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="CarritoController?accion=CategoriaShort&ide_cat=<%=p.getIde_cat()%>">Shorts</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="CarritoController?accion=CategoriaFalda&ide_cat=<%=p.getIde_cat()%>">Faldas</a>
                    </li>

                </ul>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <!--<form class="form-inline my-2 my-lg-0">-->
                    <input style="width:400px" class="form-control mr-sm-2" id="txtBuscar">
                    <button class="btn btn-outline-info my-2 my-sm-0" id="btnBuscar"><i class="fas fa-search"></i> Buscar</button>
                    <!-- </form>       -->                 
                </ul>                                
                <ul class="navbar-nav btn-group my-2 my-lg-0" role="group">
                    <a style="color: white; cursor: pointer" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fas fa-user-tie"></i> <%=usuario%></a>
                    <div class="dropdown-menu text-center dropdown-menu-right">                      
                        <a class="dropdown-item" href="#"> <a><%=usuario%>  </a>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal">${correo}</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="CarritoController?accion=MisPedidos">Mis Pedidos</a>
                            <a class="dropdown-item" href="CarritoController?accion=MisPerson">Mis Personalizaciones</a>
                            <div class="dropdown-divider"></div>
                            <form method="post" action="sesiones">
                                <input class="dropdown-item" type="submit" value="Cerrar Sesión" id="Cerrar"> 
                            </form>
                    </div>
                </ul>     
            </div>
        </nav>
        <% 
        PrendaVO prenvo = (PrendaVO)request.getAttribute("DetallePrenda");
        %>  
        
     <tr style="text-align: center;">
            <td> <%=prenvo.getNom_pren()%> </td>
            <td> <%=prenvo.getDescrip_pren()%> </td>
            <td> <img src="<%=prenvo.getUrl_pren()%>" width="90" height="90"</td> <!--LLAMA IMAGEN--> 
            <td> <%=prenvo.getColor_pren()%> </td>
            <td> <%=prenvo.getTalla_pren()%> </td>
            <td> <%=prenvo.getPrecio_pren()%> </td>
     </tr>
     
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
