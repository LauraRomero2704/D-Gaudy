<%-- 
    Document   : actualizarCalcomania
    Created on : 9/10/2022, 04:51:20 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.CalcomaniaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
        <title>Actualizar Calcomania</title>
    </head>
    <body>

         <div class="container mt-3">
            <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                
        <%
            if (request.getAttribute("CalcomaniaConsultada") != null) {
                CalcomaniaVO calVO = (CalcomaniaVO) request.getAttribute("CalcomaniaConsultada");

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
                    top: 47px;
                    }
     
                </style>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            
                            <h5 class="modal-title" id="exampleModalLabel">Actualizar Calcomania</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="Calcomania">

                                 <div class="grupo_input">
                                     
                                    <label for="recipient-name" class="col-form-label">IDE:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtIde_calc" value="<%=calVO.getIde_calc()%>" readonly><br>

                                </div>
                                    
                                  <div class="grupo_input">
                                   
                                    <label  for="recipient-name" class="col-form-label">NOMBRE:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtNom_calc" value="<%=calVO.getNom_calc()%>"><br>

                                </div>    

                               <div class="grupo_input">
                                   
                                    <label  for="recipient-name" class="col-form-label">URL:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtUrl_calc" value="<%=calVO.getUrl_calc()%>"><br>

                                </div>

                                <div class="grupo_input">
                           
                                    <label  for="recipient-name" class="col-form-label">ESTADO:</label><br>
                                    <input class="form-control" type="text" id="recipient-name" name="txtEstado_calc" value="<%=calVO.getEstado_calc()%>" readonly><br>

                                </div>
                                    
                                <div class="modal-footer">    
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" id="exampleModal" class="btn btn-primary">Actualizar</button>
                                    <input type="hidden" value="2" name="opcion" >
                                    </form><br>
                          
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



                                    <%}%>

                                </div>
                            </div>
                        </div>
                     </div>
                  </div>
             
                                  
    
    <%
        if(request.getAttribute("CalcomaniaConsultada") !=null      
                ){
    %>
    
    <script>
                                       
     $(document).ready(function() {                                        
     });
     window.$('#exampleModal2').modal('show');
                                        
    </script>   
     <%}%>
     
    </body>    
</html>
