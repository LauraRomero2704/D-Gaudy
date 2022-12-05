<%@page import="Modelo.UsuarioVO"%>
<%@page import="Modelo.UsuarioDAO"%>
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
                        <h1 class="modal-title" id="modalLabel"> Registrar Empleado </h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
 
                        <form method="post" action="Empleado" class="formulario" id="formulario">
                                
                            <!-- Grupo: Usuario -->
                            <div class="formulario__grupo" id="grupo__usuario">  
                                <label for="txtIde_usu" class="label"> Usuario <span> * </span> </label>
                                <select name="txtIde_usu" class="formulario__select" required>
                                    <option selected> Seleccionar... </option>
                                    <%  UsuarioDAO usuDAO = new UsuarioDAO();
                                        for (UsuarioVO usuVO : usuDAO.listarEmp()) {
                                    %>
                                        <option value="<%=usuVO.getIde_usu()%>"><%=usuVO.getNom_usu()%></option>
                                    <%  }
                                    %>
                                </select>
                            </div>
                                
                            <!-- Grupo: Profesión -->
                            <div class="formulario__grupo plus" id="grupo__txtProf_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtProf_emp" id="txtProf_emp" autocomplete="on" required>
                                    <label for="txtProf_emp" class="formulario__label"> Profesión <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error"> La profesión solo puede contener letras.</p>
                            </div>
                                
                            <!-- Grupo: Documento -->
                            <div class="formulario__grupo plus" id="grupo__txtDoc_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtDoc_emp" id="txtDoc_emp" autocomplete="on" required>
                                    <label for="txtDoc_emp" class="formulario__label"> Documento <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">El documento tiene que ser de 8 a 10 dígitos y solo puede contener numeros.</p>
                            </div>
                                
                            <!-- Grupo: Nombre -->
                            <div class="formulario__grupo plus" id="grupo__txtNom_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtNom_emp" id="txtNom_emp" autocomplete="on" required>
                                    <label for="txtNom_emp" class="formulario__label"> Nombre <span> * </span> </label> 
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">El nombre solo puede contener letras.</p>
                            </div>
                                
                            <!-- Grupo: Apellido -->
                            <div class="formulario__grupo plus" id="grupo__txtApe_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtApe_emp" id="txtApe_emp" autocomplete="on" required>
                                    <label for="txtApe_emp" class="formulario__label"> Apellido <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">La apellido solo puede contener letras.</p>
                            </div>  
                                
                            <!-- Grupo: Perfil -->
                            <div class="formulario__grupo formulario__" id="grupo__txtPerfil_emp">
                                <div class="formulario__grupo-input"> 
                                    <textarea class="formulario__input text" type="text" name="txtPerfil_emp"  id="txtPerfil_emp" autocomplete="on" autocomplete="on" required></textarea>
                                    <label for="txtPerfil_emp" class="formulario__label">Perfil</label>
                                </div>
                            </div>
                                
                            <!-- Grupo: Fecha -->
                            <div class="formulario__grupo plus" id="grupo__txtFecha_emp">
                                <div class="formulario__grupo-input"> 
                                    <label for="txtFecha_emp" class="label"> Fecha de Nacimiento</label>
                                    <input type="date" class="formulario__input date" name="txtFecha_emp" autocomplete="on" required>
                                </div>
                            </div>
                                
                            <!-- Grupo: Ciudad -->
                            <div class="formulario__grupo plus" id="grupo__txtCiu_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtCiu_emp" id="txtCiu_emp" autocomplete="on" required>
                                    <label for="txtCiu_emp" class="formulario__label"> Ciudad <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">La ciudad solo puede contener letras.</p>
                            </div>

                            <!-- Grupo: Dirección -->
                            <div class="formulario__grupo plus" id="grupo__txtDir_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtDir_emp" id="txtDir_emp" autocomplete="on" required>
                                    <label for="txtDir_emp" class="formulario__label"> Dirección <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">La dirección puede contener letras y numeros y guiones.</p>
                            </div>
                            
                            <!-- Grupo: Correo Electrónico  -->
                            <div class="formulario__grupo plus" id="grupo__txtCorr_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtCorr_emp" id="txtCorr_emp" autocomplete="on" required>
                                    <label for="txtCorr_emp" class="formulario__label"> Correo Electrónico <span> * </span> </label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error"> El correo solo puede contener letras, numeros, puntos, guiones y guion bajo. </p>
                            </div>

                            <!-- Grupo: Teléfono -->
                            <div class="formulario__grupo plus" id="grupo__txtTel_emp">
                                <div class="formulario__grupo-input">
                                    <input type="text" class="formulario__input" name="txtTel_emp" id="txtTel_emp" autocomplete="on" required>
                                    <label for="txtTel_emp" class="formulario__label">Teléfono</label>
                                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                </div>
                                <p class="formulario__input-error">El teléfono solo puede contener numeros y el maximo son 14 dígitos.</p>
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
                                <input type="hidden" value="3" name="opcion"></input>
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