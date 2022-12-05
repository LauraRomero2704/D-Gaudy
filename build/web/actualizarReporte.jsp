<%-- 
    Document   : actualizarReporte
    Created on : 9/11/2022, 06:20:46 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.ReporteVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Actualizar Reportes </title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- CSS -->
        <link rel="stylesheet" href="CSS/style-formulario.css">

    </head>
    <body>

       <div class="container mt-3">
            <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

                <%
                    if (request.getAttribute("reporteConsultado") != null) {
                        ReporteVO repVO = (ReporteVO) request.getAttribute("reporteConsultado");

                %>

                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title" id="modalLabel"> Actualizar Reporte </h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">

                            <form method="post" action="Reporte" class="formulario" id="formulario">

                                <!-- Grupo: Reporte -->
                                <div class="formulario__grupo" id="grupo__txtIde_rept">
                                    <div class="formulario__grupo-input"> 
                                        <label for="txtIde_rept" class="label"> # Reporte </label>
                                        <input type="text" class="formulario__input date" name="txtIde_rept" autocomplete="on" value="<%=repVO.getIde_rept()%>" readonly>
                                    </div>
                                </div> 

                                <!-- Grupo: Empleados -->
                                <div class="formulario__grupo plus" id="grupo__txtIde_emp">
                                    <div class="formulario__grupo-input"> 
                                        <label for="txtIde_emp" class="label"> # Empleados </label>
                                        <input type="text" class="formulario__input date" name="txtIde_emp" autocomplete="on" value="<%=repVO.getIde_emp()%>" readonly>
                                    </div>
                                </div> 
                                
                                <!-- Grupo: Nombre -->
                                <div class="formulario__grupo plus" id="grupo__txtNom_rept">
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="txtNom_rept" id="txtNom_rept" autocomplete="on" value="<%=repVO.getNom_rept()%>" required>
                                        <label for="txtNom_rept" class="formulario__label"> Nombre </label>
                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                    </div>
                                    <p class="formulario__input-error"> El nombre solo puede contener letras.</p>
                                </div>

                                <!-- Grupo: Categoria -->
                            <div class="formulario__grupo" id="grupo__txtCat_rept">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtCat_rept" id="txtCat_rept" autocomplete="on" value="<%=repVO.getCat_rept()%>" required>
                                    <label for="txtCat_rept" class="formulario__label"> Categoría </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error"> La categoría solo puede contener letras.</p>
                            </div>
                                 
                            <div class="formulario__grupo" id="grupo__txtEstado_rept">
                                <div class="formulario__grupo-input"> 
                                    <label for="txtEstado_rept" class="label"> Estado </label>
                                    <input type="text" class="formulario__input date" name="txtEstado_rept" autocomplete="on" value="<%=repVO.getEstado_rept()%>" readonly>
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
                                    <input type="hidden" value="2" name="opcion"></input>
                                
                            </form><br>

                                    <%}%>

                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <%
                if (request.getAttribute("reporteConsultado") != null) {
            %>

            <script>

                $(document).ready(function () {

                });

                window.$('#exampleModal2').modal('show');

            </script>   
            <%}%>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <script src="JS/formulario.js"></script>
        <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
    
    </body>    
</html>



