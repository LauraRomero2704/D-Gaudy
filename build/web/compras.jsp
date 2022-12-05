<%@page import="Modelo.PrendaVO"%>
<%@page import="Modelo.PedidoVO"%>
<%@page import="Modelo.PedidoDAO"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ClienteVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="sesiones.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

        <link rel="stylesheet"href="CSS/cart.css">

        <!-- Estilos CSS -->
        <link rel="stylesheet" href="CSS/style-index.css">
        <link rel="stylesheet" href="CSS/font-awesome.css">

        <!-- JS -->
        <script src="JS/jquery-3.1.0.min.js"></script>
        <script src="JS/main.js"></script>

        <!-- Fuentes -->
        <script src="https://kit.fontawesome.com/a2e1308b84.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Damion&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Damion&family=Lemon&family=Signika:wght@500&family=Tiro+Telugu&display=swap" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>

        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
   
        <title>Mis Pedidos</title>
    </head>
    <body>       
        <style>
            @media print {
                @page { margin: 0;
                        size: auto; }
                .btn{
                    visibility: hidden;
                }
                .verD{
                    visibility: hidden;
                }
                .site-btn{
                    visibility: hidden;
                }
                .titulo1{
                    visibility: hidden;
                }
                .text-nomb{
                    visibility: hidden;
                }
                .ima1{
                    visibility: hidden;
                }
                .sd{
                    visibility: hidden;
                }
                .footer2{
                    visibility: hidden;
                }
                .footer{
                    visibility: hidden;
                }
            }
        </style>

        <br><br>
         <br><br>
          <br><br>
          
        <!-- Header -->
        <nav id="navbar">
            <input id="nav-toggle" type="checkbox">
            <div class="brand">
                <a href="principal.jsp">
                    <h1 class="titulo1" style="font-size:35px; font-family: 'Lemon', cursive;"><span style="margin: 5px;font-family: 'Lemon', cursive;">D'</span>GAUDY</h1>
                </a>
            </div>

            <ul class="links">
                <li> <form class="form">
                        <input type="text" required>
                        <label class="lbl-nombre">
                            <span class="text-nomb" style="font-family: fuenteParrafo;"><i class="fa-solid fa-magnifying-glass" style="font-size:20px;"></i> Buscar</span>
                        </label>
                    </form></li>
                <div class="ima1">
                    <li><a href="./CarritoController?accion=Nuevo"><i  class="fa-sharp fa-solid fa-tags" style="position:relative;margin-left:-200px;font-size:30px; transition: all 1500ms ease;"></i><p style="margin:5px;font-size:21px;font-family: fuenteParrafo;transition: all 1500ms ease;">Categoria</p></a></li>
                </div>
               
                <li class="sd"><a href="./CarritoController?accion=carrito"><i class="fas fa-shopping-cart" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i>(<label style="color: skyblue">${cont}</label>)</a></li>
                <li class="sd"><a href="CarritoController?accion=MisPedidos"><i class="bx bxs-shopping-bags" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i></a></li>
                <li class="sd"><a href="CarritoController?accion=MisPerson"><i class="fa fa-paint-brush" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
                <li class="sd"><a href="inicioSesion.jsp"><i class="fa-regular fa-circle-user" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
              
            </ul>

            <label for="nav-toggle" class="icon-burger">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </label>
        </nav>
        <!-- End Header -->

        <div class="container mt-4">
           <h2 style="font-size: 50px;font-family: fuenteTitulo;"><i class="fa fa-star" style="font-size: 50px; color: yellow;"></i> Mis Pedidos </h2>
           <hr>
            <div class="row">    
                <br>
                <table class="table table-striped">
                    <thead class="thead">
                        <tr class="text-center">
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Codigo</th>   
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Talla Prendas</th>                            
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Fecha </th>
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Medio De Pago</th> 
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Direccion</th> 
                            <th style="font-size: 25px;font-family: fuenteTitulo;">SubTotal</th>
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Descuento</th> 
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Total Pedido</th> 
                            <th style="font-size: 25px;font-family: fuenteTitulo;">Estado</th>                                                   
                            <th></th>   
                            <th></th> 
                        </tr>
                    </thead>
                    <tbody>
                        <%  PedidoVO p = new PedidoVO();
                            PedidoDAO peddao = new PedidoDAO();
                            UsuarioVO usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
                            ClienteVO clientevo = (ClienteVO) session.getAttribute("datosCliente");
                            System.out.println(clientevo.getIde_cli());
                            if (usuvo.getNom_usu() != null) {
                                List pedido = peddao.misPedidos(clientevo.getIde_cli());
                                for (int i = 0; i < pedido.size(); i++) {
                                    p = (PedidoVO) pedido.get(i);

                        %>


                        <tr class="text-center">
                            <td style="font-family: fuenteParrafo;font-size: 20px;">C00<%=p.getIde_ped()%> </td>    
                            <td style="font-family: fuenteParrafo;font-size: 20px;"><%=p.getTallaPrenda_ped()%></td>                                                                                                       
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getFecha_ped()%></td>
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getMedioPago_ped()%></td>  
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getDir_ped()%></td> 
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getSubTotal_ped()%></td>  
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getDescuento_ped()%></td>  
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getTotal_ped()%></td>  
                            <td style="font-family: fuenteParrafo;font-size: 20px"><%=p.getEstado_ped()%></td>   
                            <td ><a style="font-family: fuenteTitulo;font-size: 25px; background-color: #0DCECE; color:white; border-radius: 10px;" onclick="print()" class="site-btn">Descargar Factura</a></td>
                            <td>
                                <a style="font-family: fuenteTitulo;font-size: 25px; background-color: #EF708E; color:white; border-radius: 10px;" class="site-btn" href="CarritoController?accion=verDetalle&ide_ped=<%=p.getIde_ped()%>">Ver Detalle</a>
                            </td>                                                                                                       
                        </tr>

                        <%}
                              }%>  
                    </tbody>
                </table>             
            </div>          
        </div> 
        <br><br>
        <br><br>
        <br><br>
        <footer class="footer2">
            <div class="foo">
                <div class="row">
                    <div class="footer-co">
                        <img class="cal1" src="IMG/FONDOS/LOGO1.png" alt=""/>
                        <img class="cal2" src="IMG/FONDOS/LOGO2.png" alt=""/>
                        <img class="cal3"  src="IMG/FONDOS/LOGO3.png" alt=""/>
                    </div>
                </div>
            </div>
        </footer>

    <footer class="footer">
        <div class="foo">
            <div class="row">
                <div class="footer-col">
                    <h4>SOBRE NOSOTROS</h4>
                    <ul>
                        <li><a href="#">Nuestra Historia</a></li>
                        <li><a href="#">¿Quienes Somos?</a></li>
                        <li><a href="#">Linea Etica</a></li>
                        <li><a href="#">Politicas Empresariales</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>INFORMACION</h4>
                    <ul>
                        <li><a href="#">Contactenos</a></li>
                        <li><a href="#">Terminos Y Condiciones</a></li>
                        <li><a href="#">Politica De Uso De Datos Personales</a></li>
                        <li><a href="#">Politicas De Envios, Cambios Y Garantias</a></li>
                        <li><a href="#">Autorizacion De Tratamiento De Datos Personales</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>NUESTRA REDES</h4>
                    <div class="social-links">
                        <a href="#"><i class="fab fa-facebook-f"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <br>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <h1 class="des">DESARROLLADO POR :<h1 class="titulo2" style="font-family: 'Lemon', cursive;"><span style=" color:#2ecece; margin:5px;font-family: 'Lemon', cursive;">D'</span>GAUDY</h1></h1>
            </div>
        </div>
    </footer>

                    
        <script src="JS/script-index.js"></script>
        <script src="JS/jquery-3.2.1.min.js"></script>
        <script src="JS/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
