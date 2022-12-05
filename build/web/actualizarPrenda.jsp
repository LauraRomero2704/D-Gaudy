<%-- 
    Document   : actualizarPrenda
    Created on : 9/10/2022, 03:31:21 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.CategoriaVO"%>
<%@page import="Modelo.CategoriaDAO"%>
<%@page import="Modelo.PrendaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Actualizar Prendas </title>
    </head>
    <body>



        <div class="container mt-3">
            <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">


                <%
                    if (request.getAttribute("prendaConsultada") != null) {
                        PrendaVO prenVO = (PrendaVO) request.getAttribute("prendaConsultada");

                %>



                <style>
                    .modal-header{
                        background: #18B1DE;
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
                        top:47px;
                    }

                </style>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">

                            <h5 class="modal-title" id="exampleModalLabel">Actualizar Prenda</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <form method="post" action="Prenda">

                                <div class="grupo_input">

                                    <label for="recipient-name" class="col-form-label">IDE PRENDA:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtIde_pren" value="<%=prenVO.getIde_pren()%>" readonly><br>
                                </div>

                                <div class="grupo_input">


                                    <label  for="recipient-name" class="col-form-label">IDE CATEGORIA:</label><br>
                                    <select name="txtIde_cat"  value="<%=prenVO.getIde_cat()%>"class="form-select" required>
                                        <option selected> Seleccionar... </option>
                                        <%  CategoriaDAO catDAO = new CategoriaDAO();
                                            for (CategoriaVO catVO : catDAO.listar()) {
                                        %>
                                        <option value="<%=catVO.getIde_cat()%>"><%=catVO.getNom_cat()%></option>
                                        <%  }
                                        %>
                                    </select> <br>


                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">NOMBRE:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtNom_pren" value="<%=prenVO.getNom_pren()%>"><br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">DESCRIPCION:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtDescrip_pren" value="<%=prenVO.getDescrip_pren()%>"><br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">IMAGEN:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtUrl_pren" value="<%=prenVO.getUrl_pren()%>"><br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">COLOR:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtColor_pren" value="<%=prenVO.getColor_pren()%>"><br>

                                </div>    

                                <div class="grupo_input">


                                    <label  for="recipient-name" class="col-form-label">TALLA:</label><br>
                                    <select class="form-select" name="txtTalla_pren" value="<%=prenVO.getTalla_pren()%>">
                                        <option> Seleccionar... </option>
                                        <option> 6 </option>
                                        <option> 8 </option>
                                        <option> 10 </option>
                                        <option> 12 </option>
                                        <option> 14 </option>
                                        <option> 16 </option>
                                    </select> <br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">STOCK:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtStock_pren" value="<%=prenVO.getStock_pren()%>"><br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">PRECIO:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtPrecio_pren" value="<%=prenVO.getPrecio_pren()%>"><br>

                                </div>

                                <div class="grupo_input">

                                    <label  for="recipient-name" class="col-form-label">ESTADO:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtEstado_pren" value="<%=prenVO.getEstado_pren()%>" readonly><br>

                                </div>

                                <div class="modal-footer">    
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" id="exampleModal" class="btn btn-primary">Actualizar</button>
                                    <input type="hidden" value="2" name="opcion" >
                                    </form><br>

                                    <%}%>

                                </div>
                        </div>
                    </div>
                </div>
            </div>



            <%
                if (request.getAttribute("prendaConsultada") != null) {
            %>

            <script>

                $(document).ready(function () {

                });

                window.$('#exampleModal2').modal('show');

            </script>   
            <%}%>
    </body>    
</html>


