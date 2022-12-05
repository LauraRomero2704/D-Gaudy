<%-- 
    Document   : per
    Created on : 9/11/2022, 02:40:25 PM
    Author     : User
--%>
<%--<%@include file="sesiones.jsp"%>--%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://unpkg.com/konva@8.3.13/konva.min.js"></script>
        <link href="CSS/jean.css" rel="stylesheet" type="text/css"/>
        <script src="JS/canvas2image.js" type="text/javascript"></script>
        <script src="JS/html2canvas.min.js" type="text/javascript"></script>
        <script src="JS/jquery-2.2.4.min.js" type="text/javascript"></script>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/estilos1.css" rel="stylesheet" type="text/css"/>
        <title>D' gaudy</title>
        
        
        <!-- Estilos CSS -->
        <link rel="stylesheet" href="CSS/style-index.css">
        <link rel="stylesheet" href="CSS/font-awesome.css">
        <link rel="stylesheet" href="CSS/style-personalizar.css">
        <link rel="stylesheet" href="CSS/style-formulario.css">

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

        <!-- Iconos -->
        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-formulario.css">

    </head>
    
        <div class="personalizar">
            <div class="tarjeta">
                <h1 class="titulo_pers">Personaliza tus prendas</h1>                
            </div>

            <div class="grid-container">

                <div class="contenedorimg item1" id="drag-items">
                    <h2 class="titulo-calc"> Calcomanias </h2>
                    <p class="texto-calc"> ¡Elige el tamaño de la calcomanía que prefieras para tu personalización! </p>
                    <div class="tab">
                        <button class="tablinks" onclick="openCity(event, 'Pequeño')">Pequeño</button>
                        <button class="tablinks" onclick="openCity(event, 'Mediano')">Mediano</button>
                        <button class="tablinks" onclick="openCity(event, 'Grande')">Grande</button>
                    </div>

                    <div id="Pequeño" class="tabcontent">
                        <img src="calcomanias/Pequeñas/imagen-0.png" draggable="true"/>
                        <img src="calcomanias/Pequeñas/imagen-1.png" draggable="true" />
                        <img src="calcomanias/Pequeñas//imagen-2.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-3.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-4.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-9.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-10.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-11.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-12.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-13.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-14.png" draggable="true" />
                        <img src="calcomanias/Pequeñas/imagen-15.png" draggable="true" />
                    </div>

                    <div id="Mediano" class="tabcontent">
                        <img src="calcomanias/Mediano/imagen-0.png" draggable="true"/>
                        <img src="calcomanias/Mediano/imagen-1.png" draggable="true" />
                        <img src="calcomanias/Mediano//imagen-2.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-3.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-4.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-9.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-10.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-11.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-12.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-13.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-14.png" draggable="true" />
                        <img src="calcomanias/Mediano/imagen-15.png" draggable="true" />
                    </div>

                    <div id="Grande" class="tabcontent">
                        <img src="calcomanias/Grande/imagen-0.png" draggable="true"/>
                        <img src="calcomanias/Grande/imagen-1.png" draggable="true" />
                        <img src="calcomanias/Grande//imagen-2.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-3.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-4.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-9.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-10.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-11.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-12.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-13.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-14.png" draggable="true" />
                        <img src="calcomanias/Grande/imagen-15.png" draggable="true" />              
                    </div>
                    
                    <div class="captura2" id="contenedorCanvas"></div>
                    
                    <button class="ayuda" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalHelp"> Ayuda </button>
                    
                    <div class="btn-pers">
                        <div class="btn-limpiar">
                            <button class="limpiar" id="clean"> Limpiar </button>
                        </div>
                        <div class="btn-captura">
                            <button class="captura" id="btnCapturar"> Tomar captura </button>
                        </div>
                    </div>

                </div>
                <div class="prenda">
                    <h2 class="titulo-pren"> PRENDA </h2>
                    <div class="contenedor item2" id="container"></div>
                    <a href="#" class="nueva-pers" data-toggle="modal" data-target="#myModalPago" class="btn btn-info btn-block"> Agregar Personalizacion </a>
                </div>
                
                <div class="modal fade" id="myModalPago" tabindex="-1" aria-labelledby="myModalPagoLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title" id="modalLabel">Personalizaciones </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">

                            <form method="POST" action="Imagen?accion=GuardarPersonalizar" enctype="multipart/form-data" class="formulario" id="formulario">

                                <!-- Grupo: Nombre -->
                                <div class="formulario__grupo" id="grupo__txtNom_per">
                                    <div class="formulario__grupo-input" style="margin-top: -15px; margin-bottom: -20px;">
                                        <label for="txtNom_per" class="label" style="margin-right: 350px; font-size: 17px; margin-bottom: -15px;"> Nombre </label> 
                                        <input type="text" class="formulario__input" name="txtNom_per" id="txtNom_per" autocomplete="on" required>
                                    </div>
                                </div>

                                <div class="formulario__grupo" id="grupo__txtUrlDiseño_pers" style="margin-top: 15px;">
                                    <div class="formulario__grupo-input"> 
                                        <label for="txtUrlDiseño_pers" class="label" style="margin-right: 330px; font-size: 17px; margin-bottom: -15px;">Personalizacion </label>
                                        <input type="file" class="formulario__input date" name="txtUrlDiseño_pers" autocomplete="on" required>
                                    </div>
                                </div> 

                                <div class="modal-footer">
                                    <button type="button" class="btn btnFooter-close" data-bs-dismiss="modal"> 
                                        <span></span>
                                        <span></span>
                                        <span></span>
                                        <span></span>
                                        <p class="texto"> Cancelar </p>
                                    </button>
                                    <button type="submit" id="myModalPago" class="btn btnFooter-update"> Registrar </button>
                                    <input type="hidden" value="GuardarPersonalizar" name="accion"></input>
                                  
                            </form>
                            
                            <%
                                    if (request.getAttribute("mensajeError") != null) { %>
                            <h5>
                                ${mensajeError} 
                            </h5>

                            <%} else {%>
                            <h5>
                                ${mensajeExito}

                            </h5>
                            <% }%>

                                
                            </form>

                        </div>  
                    </div>
                </div>
            </div>
        </div>
            </div>
        </div>


<!-- Modal -->
<div class="modal fade" id="ModalHelp" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog helpModal">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title" id="modalLabel"> Pasos para personalizar</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body helpBody">
        <ol class="pasos">
            <li> A la derecha encontraras una tabla con calcomanias, elige el tamaño de calcomanias de tu preferencia </li>
            <li> Arrastra las calcomanias hacia la prenda </li>
            <li> Disfruta agregando calcomanias a tu prenda, y deja volar tu imaginación </li>
            <li> Cuando termines de personalizar tu prenda, da click en el boton de guardar captura </li>
            <li> Da click drecho encima de la imagen capturada y guardala en tu ordenador </li>
            <li> Luego da click en el boton de subir, y llena el formulario con el nombre y carga la imagen de tu personalizacion </li>
        </ol>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btnFooter-close" data-bs-dismiss="modal">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <p class="texto"> Cancelar </p>
        </button>
        <button type="button" id="ModalHelp" class="btn btnFooter-update"> Entendido </button>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/html2canvas@1.0.0-rc.1/dist/html2canvas.min.js"></script> 
<script src="JS/Shores.js" type="text/javascript"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script src="JS/formulario.js"></script>
    <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>





    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/html2canvas@1.0.0-rc.1/dist/html2canvas.min.js"></script> 
    <script src="JS/Jeans.js" type="text/javascript"></script>
</body>
</html>
