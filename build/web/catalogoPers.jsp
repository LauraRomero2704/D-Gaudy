<%-- 
    Document   : catalogoPers
    Created on : 24/11/2022, 08:09:37 PM
    Author     : Janus
--%>

<%@page import="Modelo.PrendaVO"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.UsuarioVO"%>
<%@page import="Modelo.PersonalizaVO"%>
<%@page import="Modelo.PedidoDAO"%>
<%@page import="Modelo.ClienteVO"%>
<%@page import="Modelo.ImagenDAO"%>
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
   
        <title>Mis Persoanlizaciones</title>
    </head>
    <body>
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
               
                <li class="sd"><a href="./CarritoController?accion=carritoPers"><i class="fas fa-shopping-cart" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i>(<label style="color: skyblue">${cont}</label>)</a></li>
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

        <br><br>
        <br><br>
        <br><br>
        
         <div class="container mt-4">
            <div class="row">
                <%

            PrendaVO p = new PrendaVO();
            PedidoDAO peddao = new PedidoDAO();
            UsuarioVO usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
            ClienteVO clientevo = (ClienteVO) session.getAttribute("datosCliente");
            System.out.println(clientevo.getIde_cli());
            if (usuvo.getNom_usu() != null) {
                List catPer = peddao.CatPers(clientevo.getIde_cli());
                for (int i = 0; i < catPer.size(); i++) {
                    p = (PrendaVO) catPer.get(i);

        %>
        
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="card">
                                <div class="card-header">
                                  <center><label class="col-sm-13" style="font-family: fuenteTitulo;font-size: 25px;"><%=p.getNom_pren()%></label></center>                                    
                                </div>
                                <div class="card-body center d-flex">
                                    <img src="<%=p.getUrl_pren()%>" width="450" height="290">
                                </div>
                                <div class="card-body2 text-center">
                                    <label style="font-family: fuenteParrafo;font-size: 20px;"><i class="fas fa-dollar-sign"><%=p.getPrecio_pren()%></i></label>                                    
                                </div>
                                <div class="card-footer">
                                    <div class="col-sm-12" >
                                      <center>  <label style="font-family: fuenteParrafo;font-size: 20px;"><%=p.getDescrip_pren()%></label> </center>                                  
                                    </div>
                                    <br>
                                    <div class=" col-sm-12 text-center">              
                                        <a href="jean1.jsp" style="font-family: fuenteTitulo;font-size: 25px;" class="btn btn-info"><i class="fa fa-rocket"></i> Personalizar</a>
                                       
                                    </div>                          
                                </div>
                            </div>
                        </div>
                    </div>
               <%} }%> 
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

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>
</html>
