<%-- 
    Document   : registrarUsuario
    Created on : 22/10/2022, 07:17:09 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.RolVO"%>
<%@page import="Modelo.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="Estilos/estiloCrud.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>   
        <script src="https://kit.fontawesome.com/e1d55cc160.js" crossorigin="anonymous"></script>
        <script src="JS/contAleatorias.js" type="text/javascript"></script>
        <title>Administrador</title>
    </head>
    <body>

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

            <style>

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
                    top: 47px;
                }

                .generar{
                    width: 100%;
                    height: 40px;
                    outline: none;
                    border: none;
                    border-radius: 40px;
                    background: #0DCECE;
                    color: #F4F4F4;
                    text-transform: uppercase;
                    font-weight: 600;
                    margin-top: 20px;
                    font-size: 18px;
                    transition: all 0.5s;
                }
                .generar:hover
                {
                    background: #54e4e4;
                    color: #000;
                    box-shadow: 0px 0px 6px #54e4e4;
                }

            </style>


            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"<i class="fa fa-edit" aria-hidden="true"></i>Registrar Usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">

                        <form method="post" action="Usuario">

                            <div class="grupo_input">

                                <label for="recipient-name" class="col-form-label">Rol:</label><br>
                                <select name="txtide_rol" class="form-select" required>
                                    <option selected>Seleccionar</option>
                                    <%RolDAO rolDAO = new RolDAO();
                                        for (RolVO rolVO : rolDAO.listarRol()) {
                                    %>

                                    <option value="<%=rolVO.getIde_rol()%>"><%=rolVO.getNom_rol()%></option>
                                    <%}%>

                                </select><br>

                            </div>

                            <div class="grupo_input">

                                <label for="recipient-name" class="col-form-label">Correo:</label><br>
                                <input class="form-control" type="text" id="recipient-name" autocomplete="on" placeholder="Digite el nombre del usuario" name="txtnom_usu"  required><br>

                            </div>

                            <div class="mb-3">
                                <label for="inputLength" class="form-label">Length</label>
                                <input type="number" id="inputLength" class="form-control text-center" min="1" max="50" value="12" />
                            </div>
                            <div class="form-check my-3">
                                <input type="checkbox" id="checkbox1" class="form-check-input" />
                                <label class="form-check-label" for="checkbox1">Incluide numbers</label>
                            </div>
                            <div class="form-check my-3">
                                <input type="checkbox" id="checkbox2" class="form-check-input" />
                                <label class="form-check-label" for="checkbox2">Incluide symbols</label>
                            </div>
                            <div class="d-grid gap-2 my-3">
                                <button class="generar" id="btnGenerate">Generar Contraseña</button>
                            </div>
                            <hr/>
                            <div class="d-grid gap-2 py-3">
                                <span id="generatedPassword" class="badge bg-success"></span>
                            </div>

                            <div class="grupo_input">

                                <label for="recipient-name" class="col-form-label">Contraseña:</label><br>
                                <input class="form-control" type="text" id="recipient-name" autocomplete="on" placeholder="Digite el nombre del usuario" name="txtcont_usu"  required><br>

                            </div>        

                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" id="exampleModal" class="btn btn-primary">Registrar</button>
                                <input type="hidden" value="4" name="opcion"></input>
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
                    </div>  
                </div>

            </div>
        </div>
    </div>


</center>
</body>    

</html>

