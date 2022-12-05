<%-- 
    Document   : registrarPrenda
    Created on : 9/10/2022, 03:26:21 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>
<%@page import="Modelo.CategoriaVO"%>
<%@page import="Modelo.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerente Prenda</title>
    </head>
    <body>

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

            <style>

                #formGroupExampleInput::placeholder {
                    color:#A9A9A9;
                }

                .modal-header{
                    background: #4ECDC4;
                    color:white;
                }


                form .grupo_input {
                    position:relative;
                }

                form .grupo_input input{
                    padding: 12px 0px 12px 42px;
                    margin-bottom: 5px;
                }

                form .grupo_input i{
                    position: absolute;
                    margin-left: 17px;
                    top: 36px;
                }

            </style>


            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"<i class="fa fa-edit" aria-hidden="true"></i>Registrar Prenda</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">

                        <form method="post" action="Imagen?accion=Guardar" enctype="multipart/form-data">
                            <div class="grupo_input">
                                <label for="recipient-name" class="col-form-label"> CATEGORIA:</label><br>
                                <select name="txtIde_cat" class="form-select" required>
                                    <option selected> Seleccionar... </option>
                                    <%  CategoriaDAO catDAO = new CategoriaDAO();
                                        for (CategoriaVO catVO : catDAO.listar()) {
                                    %>
                                    <option value="<%=catVO.getIde_cat()%>"><%=catVO.getNom_cat()%></option>
                                    <%  }
                                    %>
                                </select> <br>
                            </div>
                            <div class="formulario__grupo plus" id="grupo__txtNom_pren">
                                <div class="formulario__grupo_input">
                                    <label for="txtNom_pren" class="formulario__label">NOMBRE:</label><br>
                                    <input  class="formulario__input" type="text" id="txtNom_pren"  autocomplete="on" placeholder="Digite el nombre de la prenda" name="txtNom_pren" required><br>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">El documento tiene que ser de 8 a 10 dígitos y solo puede contener numeros.</p>
                            </div>

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">DESCRIPCION:</label><br>
                                <textarea  class="form-control" type="text" id="formGroupExampleInput" autocomplete="on" placeholder="Digite la dexcripcion de la prenda"  name="txtDescrip_pren" required></textarea><br>

                            </div>  

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">IMAGEN:</label><br>
                                <input class="form-control" type="file" id="formGroupExampleInput" autocomplete="on" placeholder="Digite la url de la prenda"  name="txtUrl_pren" required><br>

                            </div> 

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">COLOR:</label><br>
                                <input class="form-control" type="text" id="formGroupExampleInput" autocomplete="on" placeholder="Digite el color de la prenda"  name="txtColor_pren" required><br>

                            </div>     

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">TALLA:</label><br>
                                <select class="form-select" name="txtTalla_pren">
                                    <option> Seleccionar... </option>
                                    <option> 6 </option>
                                    <option> 8 </option>
                                    <option> 10 </option>
                                    <option> 12 </option>
                                    <option> 14 </option>
                                    <option> 16 </option>
                                </select> <br>

                            </div>  

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">STOCK:</label><br>
                                <input class="form-control" type="text" id="formGroupExampleInput" autocomplete="on" placeholder="Digite la cantidad de la prenda"  name="txtStock_pren" required><br>

                            </div>  

                            <div class="formulario__grupo_input">

                                <label for="recipient-name" class="col-form-label">PRECIO:</label><br>
                                <input class="form-control" type="text" id="formGroupExampleInput" autocomplete="on" placeholder="Digite el precio de la prenda"  name="txtPrecio_pren" required><br>

                            </div> 
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" id="exampleModal" class="btn btn-primary">Registrar</button>
                                <input type="hidden" value="Guardar" name="opcion"></input>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>    
</html>

