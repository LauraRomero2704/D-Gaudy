<%-- 
    Document   : falda
    Created on : 13/11/2022, 09:50:13 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://unpkg.com/konva@8.3.13/konva.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/falda.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="css/estilos1.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <h2>Personaliza tus prendas</h2>
        <div class="col-lg-3">                  
            <div class="card">
                <div class="card-header">
                    Agregar Personalizacion

                    <div class="card-footer">
                        <a href="#" data-toggle="modal" data-target="#myModalPago" class="btn btn-info btn-block">Subir</a>
                    </div>
                </div>
            </div>
        </div>                    
    </div>


    <!-- Modal de añadir -->

    <div class="modal fade" id="myModalPago" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered" role="document">         
            <div class="modal-content">                   
                <div class="modal-header text-center"> 
                    <label><i class="fa-dollar-sign"></i>Subir a mis personalizaciones</label>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>  
                </div>
                <div class="modal-body"> 
                    <div class="tab-content" id="pills-tabContent">
                        <!-- Metodo Pago -->
                        <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                            <form method="POST" action="Imagen?accion=GuardarPersonalizar" enctype="multipart/form-data">

                                <div class="form-group">
                                    <label>Nombre de tu personalizacion:</label>
                                    <input type="text" name="txtNom_per" placeholder="Digita el nombre de tu personalizacion" class="form-control h1">
                                </div> 
                                <div class="form-group">
                                    <label>Imagen:</label>
                                    <input type="file" name="txtUrlDiseño_pers" placeholder="Agrega la imagen de tu personalizacion" class="form-control h1">
                                </div> 

                                <input type="hidden" value="GuardarPersonalizar" name="accion">
                                <button type="submit" id="exampleModal" class="btn btn-primary">Subir</button>


                            </form>
                        </div>

                    </div> 
                </div>
            </div>
        </div>
    </div>
    <div class="grid-container">

        <div class="contenedorimg item1" id="drag-items">
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
                <img src="calcomanias/Grande/imagen-15.png" draggable="true" />              </div>

        </div>

        <div class="contenedor item2" id="container"></div>


        <button id="clean">Limpiar</button>
    </div>  


    <button id="btnCapturar">Tomar captura</button>
    <div id="contenedorCanvas" style="border: 1px solid red;">
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/html2canvas@1.0.0-rc.1/dist/html2canvas.min.js"></script> 
    <script src="JS/Faldas.js" type="text/javascript"></script>
</body>
</html>
