<%-- 
    Document   : registrarReporte
    Created on : 9/11/2022, 04:43:06 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.EmpleadoDAO"%>
<%@page import="Modelo.EmpleadoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-formulario.css">
        
    </head>
    <body>

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title" id="modalLabel"> Registrar Reporte </h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">

                        <form method="post" action="Imagen?accion=GuardarReporte" enctype="multipart/form-data" class="formulario" id="formulario">
                            
                            <!-- Grupo: Empleado -->
                            <div class="formulario__grupo" id="grupo__empleado">  
                                <label for="txtPdf_rept" class="label"> Empleado <span> * </span> </label>
                                <select name="txtIde_emp" class="formulario__select date" required>
                                    <option selected> Seleccionar... </option>
                                    <%  EmpleadoDAO empDAO = new EmpleadoDAO();
                                        for (EmpleadoVO empVO : empDAO.listar()) {
                                    %>
                                        <option value="<%=empVO.getIde_emp()%>"><%=empVO.getNom_emp()%></option>
                                    <%  }
                                    %>
                                </select>
                            </div>

                            <!-- Grupo: Nombre -->
                            <div class="formulario__grupo plus" id="grupo__txtNom_rept">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtNom_rept" id="txtNom_rept" autocomplete="on" required>
                                    <label for="txtNom_rept" class="formulario__label"> Nombre <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error"> El nombre solo puede contener letras.</p>
                            </div>


                            <!-- Grupo: Categoria -->
                            <div class="formulario__grupo" id="grupo__txtCat_rept">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtCat_rept" id="txtCat_rept" autocomplete="on" required>
                                    <label for="txtCat_rept" class="formulario__label"> Categoría <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error"> La categoría solo puede contener letras.</p>
                            </div>

                            <div class="formulario__grupo" id="grupo__txtPdf_rept">
                                <div class="formulario__grupo-input"> 
                                    <label for="txtPdf_rept" class="label"> Reporte <span> * </span> </label>
                                    <input type="file" class="formulario__input date" name="txtPdf_rept" autocomplete="on" required>
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
                                <button type="submit" id="exampleModal" class="btn btnFooter-update"> Registrar </button>
                                <input type="hidden" value="GuardarReporte" name="opcion"></input>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <script src="JS/formulario.js"></script>
    <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>

</body>    
</html>


