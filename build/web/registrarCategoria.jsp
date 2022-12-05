<%-- 
    Document   : registrarCategoria
    Created on : 9/10/2022, 04:35:21 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.CategoriaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Categoria</title>
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
                    top: 45px;
                    }
                    
                </style>
                
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"<i class="fa fa-edit" aria-hidden="true"></i>Registrar Categoria</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>

                        <div class="modal-body">

                    <form method="post" action="Categoria">
                         <div class="grupo_input">
                                    
                                    <label for="recipient-name" class="col-form-label">NOMBRE:</label><br>
                                    <input class="form-control" type="text" id="formGroupExampleInput" autocomplete="on" placeholder="Digite el nombre de la categoria" name="txtNom_cat" required><br>
                                    
                                </div>
                                
                                    <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" id="exampleModal" class="btn btn-primary">Registrar</button>
                                    <input type="hidden" value="1" name="opcion"></input>
                            </form>
                            <br>
                         
                      
                        </div>  
                    </div>
                </div>
            </div>
        </div>

    </body>    
</html>

