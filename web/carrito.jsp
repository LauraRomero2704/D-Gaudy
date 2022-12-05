
<%@page import="Modelo.PrendaVO"%>
<%@page import="Conexion.Fecha"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Carrito de Compras</title>
    </head>
    <body>     
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
                <li><a href="./CarritoController?accion=carrito"><i class="fas fa-shopping-cart" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i>(<label style="color: skyblue">${cont}</label>)</a></li>
                <li><a href="CarritoController?accion=MisPedidos"><i class="bx bxs-shopping-bags" style="font-size:30px; transition: all 1500ms ease;" aria-hidden="true"></i></a></li>
                <li><a href="CarritoController?accion=MisPerson"><i class="fa fa-paint-brush" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
                <li><a href="inicioSesion.jsp"><i class="fa-regular fa-circle-user" style="font-size:30px; transition: all 1500ms ease;"></i></a></li>
            </ul>

            <label for="nav-toggle" class="icon-burger">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </label>
        </nav>
        <!-- End Header -->
        
        <div class="container mt-4">
            <div class="d-flex">
              <h2 style="font-size: 60px;font-family: fuenteTitulo; position: relative; margin-left: 20px; ">Carrito</h2>     
                <%
                    Fecha fechaSistema = new Fecha();
                %>                     
                <p style="font-size: 30px;font-family: fuenteTitulo;  " class="ml-auto"><%= fechaSistema.Fecha()%></p>                               
            </div>                    
     
    <!--Cart Section-->
    <section class="mt-5">
        <div class="container">
            <div class="cart">
            <div class="table-responsive">
                <table class="table">
                    <thead class="thead-lig">
                        <tr class="cab">                            
                                <th scope="col"class="text-dark" style="font-size: 18px;font-family: fuenteParrafo; ">PRENDA</th>
                                <th scope="col"class="text-dark" style="font-size: 18px;font-family: fuenteParrafo;">DESCRIPCION</th>
                                <th scope="col"class="text-dark" style="font-size: 18px;font-family: fuenteParrafo;">PRECIO</th>
                                <th scope="col"class="text-dark" style="font-size: 18px;font-family: fuenteParrafo;">CANTIDAD</th>                       
                                <th scope="col"class="text-dark" style="font-size: 18px;font-family: fuenteParrafo;">TOTAL</th>                       
                                <th></th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${Carrito}"> 
                        <tr>
                            <td>
                                <div class="main">
                                    <div class="d-flex">
                                        <img src="${c.getUrl_pren()}" width="180" height="150">
                                    </div>
                                    <div >
                                        <p style="font-family: fuenteParrafo; font-size: 20px;">${c.getNom_pren()}</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <h6 style="font-family: fuenteParrafo; font-size: 20px;">${c.getDescrip_pren()}</h6>
                            </td>
                             <td>
                                <h6 style="font-family: fuenteParrafo;font-size: 20px;">${c.getTotal_ped()}</h6>
                            </td>
                            <td>
                                <div class="counter">
                                    <input type="hidden" id="item1" value="${c.getIde_pren()}">
                                        <input type="number" min="1" max="10"  id="Cant" class=" form-control text-center" style="font-family: fuenteParrafo;font-size: 20px;" value="${c.getCantPren_det()}">
                                </div>
                            </td>
                            <td>
                                <h6 style="font-family: fuenteParrafo;font-size: 20px;">${c.getSubTotal_ped()}</h6>
                            </td>
                            <td class="text-center">                                         
                                        <input type="hidden" id="item2" value="${c.getIde_pren()}">
                                        <a id="deleteItem" href="#" class="btn"><i class="fas fa-trash-alt"></i></a>                                            
                                    </td> 
                        </tr>
                         </c:forEach>
                    </tbody>                   
                </table>
                
                <hr>
            </div>
            </div>
        </div>
    </section>
    <br><br>
    <div class="col-lg-4 offset-lg-8">
        <div class="checkout">
            <ul>
                <li style="font-family: fuenteTitulo; font-size: 25px; " class="subtotal">Subtotal
                    <span style="font-family: fuenteTitulo;">${SubTotal}</span>
                </li>
                <li style="font-family: fuenteTitulo;font-size: 22px; " class="cart-total">Descuento
                <span style="font-family: fuenteTitulo;"> ${Descuento}</span>
                </li>
                <li style="font-family: fuenteTitulo;font-size: 22px; " class="cart-total">Total A Pagar
                <span style="font-family: fuenteTitulo;">${totalPedido}</span>
                </li>
            </ul>
            <a href=href="#" data-toggle="modal" data-target="#myModalPago" style="font-family: fuenteTitulo;font-size: 30px; " class="proceed-btn">Realizar Pedido</a>
        </div>
    </div>
    
    <br><br>
<br><br>


<!-- Modal de Pago -->
         <c:forEach var="c" items="${Carrito}"> 
        <div class="modal fade" id="myModalPago" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">         
                <div class="modal-content">                   
                    <div class="modal-header text-center"> 
                        <label style="font-family: fuenteTitulo; font-size: 40px;"></><i class="fa fa-truck" style="font-size: 35px;"></i> Realizar Pedido</label>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                        </button>  
                    </div>
                    <div class="modal-body"> 
                        <div class="tab-content" id="pills-tabContent">
                            <!-- Metodo Pago -->
                            <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                <form method="post" action="CarritoController">
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;" >Talla Prenda</label>
                                        <select style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtTallaPrenda_ped" class="form-control" required>
                                            <option selected>Seleccionar Talla</option>
                                            <option style="font-family: fuenteParrafo;"> 6 </option>
                                            <option style="font-family: fuenteParrafo;"> 8 </option>
                                            <option style="font-family: fuenteParrafo;"> 10 </option>
                                            <option style="font-family: fuenteParrafo;"> 12 </option>
                                            <option style="font-family: fuenteParrafo;"> 14 </option>
                                            <option style="font-family: fuenteParrafo;"> 16 </option>
                                        </select>     
                                    </div>
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;">Medio Pago</label>
                                        <select style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtMedioPago_ped" class="form-control" required>
                                            <option selected>Seleccionar Medio Pago</option>
                                            <option style="font-family: fuenteParrafo;">DaviPlata</option>
                                            <option style="font-family: fuenteParrafo;">Nequi</option>
                                            <option style="font-family: fuenteParrafo;">Davivienda</option>
                                            <option style="font-family: fuenteParrafo;">Bancolombia</option>   
                                            </select>
                                    </div>
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;">Direccion envio</label>
                                        <input style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtDir_ped" placeholder="Digite la direccion del pedido" class="form-control h1">
                                    </div> 
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;">SubTotal</label>
                                        <input style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtSubTotal_ped" value="${SubTotal}" class="form-control h1" readonly>
                                    </div>      
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;">Descuento</label>
                                        <input style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtDescuento" value="${Descuento}" class="form-control h1" readonly>
                                    </div>       
                                    <div class="form-group">
                                        <label style="font-family: fuenteTitulo; font-size: 25px;">Total Pedido</label>
                                        <input style="font-family: fuenteParrafo; font-size: 20px;" type="text" name="txtmonto" value="${totalPedido}" class="form-control h1" readonly>
                                    </div>   
                                    <br>
                                    <button style="font-family: fuenteTitulo; font-size: 35px; border-radius: 10px;" type="submit" class="btn btn-info btn-block">Generar Pedido</button>
                                    <input type="hidden" name="accion" value="GenerarPedido">

                                </form>
                            </div>
                          </c:forEach>     
                            
                        </div> 
                    </div>
                </div>
            </div>
        </div>

    
<script src="JS/script-index.js"></script>
<script src="JS/jquery-3.2.1.min.js"></script>
<script src="JS/main.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="JS/funcion.js" type="text/javascript"></script>

    </body>
</html>
