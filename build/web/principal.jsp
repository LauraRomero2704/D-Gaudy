<%-- 
    Document   : principal
    Created on : 22/11/2022, 10:36:10 PM
    Author     : Janus
--%>

<%@page import="Modelo.PrendaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title> D'GAUDY </title>

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
   
    </head>
    <body>

        <!-- Cargando -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

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
                    <li><a href="./CarritoController?accion=Nuevo"><i  class="fa-sharp fa-solid fa-tags" style="position:relative;margin-left:-190px;font-size:30px; transition: all 1500ms ease;"></i><p style="margin:5px;font-size:21px;font-family: fuenteParrafo;transition: all 1500ms ease;">Categoria</p></a></li>
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

        <!-- Secciones -->
        <div class="secciones">
            <div class="split left">
                <h1 class="sec1">Personaliza Tus</h1>
                <h2 class="sec1">Jeans</h2>
                <p class="frase1">Encuentra tu estilo al alcance </p>
                <p class="frase2">de tu imaginacion</p>
                <a href="CarritoController?accion=CatPerson"><button class="boton cuatro" style="top:450px;"><span>Personalizar</span></button></a>

            </div>
            <div class="split right">
                <h1 class="sec1">Observa Nuestro</h1>
                <h2 class="sec1">Catalogo</h2>
                <p class="frase3">Prendas de calidad </p>
                <p class="frase4">hechas para ti</p>
               <a href="./CarritoController?accion=Nuevo"> <button class="buton cinco" style="top:450px;"><span>Ver Catalogo</span></button></a>
            </div>
        </div>
        <!-- End Secciones -->

        <br><br>
        <br><br>
        <br><br>
        <%             PrendaVO p = new PrendaVO();
        %>
        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 p-0">
                        <div style="margin-left:-140px;" class="categories__item categories__large__item set-bg"
                             data-setbg="IMG/FONDOS/sec2.PNG">

                            <div class="categories__text">
                                <h1>¡Atrevete A Tener Un Nuevo Estilo!</h1>
                                <p>Disfruta de una experencia unica personalizando y dandole tu toque personal a todos los jeans que tenemos para ti.</p>
                                <a style="font-size: 30px; top:20px;" href="./CarritoController?accion=Nuevo">Observar Ahora</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="IMG/FONDOS/sec3.PNG">
                                    <div class="categories__text">
                                        <h4>Para Ti</h4>
                                        <p>Descubre</p>
                                        <a href="CarritoController?accion=CategoriaShort&ide_cat=<%=p.getIde_cat()%>">Observar Ahora</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="IMG/FONDOS/sec4.PNG">

                                    <div class="categories__text">
                                        <h4>Recomendados</h4>
                                        <p>Encuentra</p>
                                        <a href="./CarritoController?accion=Nuevo">Observar Ahora</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="IMG/FONDOS/sec6.PNG">
                                    <div class="categories__text">
                                        <h4>Nuevo Look </h4>
                                        <p>Busca</p>
                                        <a href="CarritoController?accion=CategoriaFalda&ide_cat=<%=p.getIde_cat()%>">Observar Ahora</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 p-0">
                                <div class="categories__item set-bg" data-setbg="IMG/FONDOS/sec5.PNG">
                                    <div class="categories__text">
                                        <h4>Tendencia</h4>
                                        <p>Sigue</p>
                                        <a href="CarritoController?accion=CategoriaShort&ide_cat=<%=p.getIde_cat()%>">Observar Ahora</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <br><br>
        <br><br>
        <br><br>
        <!-- Carrusel -->


        <div id="slider"> 
            <div class="dp-wrap"> 
                <div id="dp-slider">

                    <div class="dp_item" data-class="1" data-position="1">
                        <div class="dp-content">

                            <h2>Trending</h2>
                            <p> Nuevos Jeans En Tendencia, Descubre Lo Mas Popular</p>
                            <a style="font-family: fuenteTitulo;" href="./CarritoController?accion=Nuevo" class="site-btn"><h5>Ver Prenda</h5></a>
                        </div>
                        <div class="dp-img">
                            <img style="border-radius: 20px; padding: 10px;" class="img-fluid" src="IMG/PRENDAS/JEAN-CARRUSEL.PNG" alt="investing">

                        </div>
                    </div>

                    <div class="dp_item" data-class="2" data-position="2">
                        <div class="dp-content">

                            <h2>For You</h2>
                            <p> Faldas Hechas Con El Mejor Estilo Para Ti</p>
                            <a style="font-family: fuenteTitulo;" href="CarritoController?accion=CategoriaFalda&ide_cat=<%=p.getIde_cat()%>" class="site-btn"><h5>Ver Prenda</h5></a>
                        </div>
                        <div class="dp-img">
                            <img style="border-radius: 20px; padding: 10px;" class="img-fluid" src="IMG/PRENDAS/sli1.PNG" alt="investing">
                        </div>
                    </div>

                    <div class="dp_item" data-class="3" data-position="3">
                        <div class="dp-content">

                            <h2>New</h2>
                            <p> Nuevos Shorts Para Que Encuentres Tu Mejor Estilo</p>
                            <a style="font-family: fuenteTitulo;" href="CarritoController?accion=CategoriaShort&ide_cat=<%=p.getIde_cat()%>" class="site-btn"><h5>Ver Prenda</h5></a>
                        </div>
                        <div class="dp-img">
                            <img style="border-radius: 20px; padding: 10px; " class="img-fluid" src="IMG/PRENDAS/sli2.PNG" alt="investing">
                        </div>

                    </div>



                    <span id="dp-next">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 51.401 51.401">
                        <defs>
                        <style>
                            .cls-1 {
                                fill: none;
                                stroke: #EF708E;
                                stroke-miterlimit: 10;
                                stroke-width: 7px;
                            }
                        </style>
                        </defs>
                        <path id="Rectangle_4_Copy" data-name="Rectangle 4 Copy" class="cls-1" d="M32.246,0V33.178L0,31.953" transform="translate(0.094 25.276) rotate(-45)"/>
                        </svg>
                    </span>

                    <span id="dp-prev">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 51.401 51.401">
                        <defs>
                        <style>
                            .cls-1 {
                                fill: none;
                                stroke: #EF708E;
                                stroke-miterlimit: 10;
                                stroke-width: 8px;
                            }
                        </style>
                        </defs>
                        <path id="Rectangle_4_Copy" data-name="Rectangle 4 Copy" class="cls-1" d="M32.246,0V33.178L0,31.953" transform="translate(0.094 25.276) rotate(-45)"/>
                        </svg>
                    </span>



                    <ul id="dp-dots">
                        <li data-class="1" class="active"></li>
                        <li data-class="2"></li>
                        <li data-class="3"></li>

                    </ul>
                </div>
            </div>

            <!-- End Carusel -->
            <br><br>
            <br><br>
            <br><br>
            <br><br>


            <div class="publi">
                <img src="IMG/FONDOS/PUBLICIDAD-2.PNG" alt="">
                <a href="./CarritoController?accion=Nuevo"class="publi-btn"><h2>Ver Prendas</h2></a>
            </div>

            <br><br>
            

            <div class="catCard">
                <div class="cont">

                    <div class="card">
                        <div class="imgBx">
                            <a href="#">
                                <img src="IMG/PRENDAS/FALDA-CATEGORIA.PNG"></a>
                            <div class="over">
                                <h1 style="font-size: 130px;">Faldas</h1>
                                <a href="CarritoController?accion=CategoriaFalda&ide_cat=<%=p.getIde_cat()%>" class="btn-neon1">
                                    <span id="span5"></span>
                                    <span id="span6"></span>
                                    <span id="span7"></span>
                                    <span id="span8"></span>
                                    Comprar
                                </a>
                            </div>
                            <div class="nombreC2" style="color: #FFC0CB;">
                                <div style=" font-family: fuenteTitulo;">F</div>   
                                <div style=" font-family: fuenteTitulo;">A</div>    
                                <div style=" font-family: fuenteTitulo;">L</div>   
                                <div style=" font-family: fuenteTitulo;">D</div>    
                                <div style=" font-family: fuenteTitulo;">A</div>    
                                <div style=" font-family: fuenteTitulo;">S</div>   
                            </div>	

                        </div>	
                    </div>	

                    <div class="card">	
                        <div class="imgBx">
                            <a href="#">
                                <img src="IMG/PRENDAS//JEAN-CATEGORIA.PNG"></a>
                            <div class="overlay">
                                <h1 class="categoria1" style="font-size: 130px;">Jean</h1>
                                <a href="./CarritoController?accion=Nuevo" class="btn-neon">
                                    <span id="span1"></span>
                                    <span id="span2"></span>
                                    <span id="span3"></span>
                                    <span id="span4"></span>
                                    Comprar
                                </a>
                            </div>
                            <div class="nombreC" style="color: #2ecece;">
                                <div style=" font-family: fuenteTitulo;">J E A N</div>   

                            </div>					
                        </div>
                    </div>


                    <div class="card">
                        <div class="imgBx">
                            <a href="#">
                                <img src="IMG/PRENDAS/SHORT-CATEGORIA.PNG"></a>
                            <div class="over">
                                <h1 style="font-size: 110px;">Shorts</h1>
                                <a href="CarritoController?accion=CategoriaShort&ide_cat=<%=p.getIde_cat()%>" class="btn-neon1">
                                    <span id="span5"></span>
                                    <span id="span6"></span>
                                    <span id="span7"></span>
                                    <span id="span8"></span>
                                    Comprar
                                </a>
                            </div>
                            <div class="nombreC3" style="color: #FFC0CB;">
                                <div style=" font-family: fuenteTitulo;">S</div>   
                                <div style=" font-family: fuenteTitulo;">H</div>    
                                <div style=" font-family: fuenteTitulo;">O</div>    
                                <div style=" font-family: fuenteTitulo;">R</div>    
                                <div style=" font-family: fuenteTitulo;">T</div>    
                                <div style=" font-family: fuenteTitulo;">S</div>         
                            </div>	


                        </div>	
                    </div>	

                </div>	
            </div>	
        </div>	
    </div>

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
</body>
</html>