<%-- 
    Document   : Sesiones
    Created on : 15/06/2022, 09:08:19 AM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="Modelo.RolVO"%>
<%@page import="Modelo.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <%
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache, no-store,must-revalidate");
        response.setDateHeader("Expires", 0);
    %>
    <%
        HttpSession miSesion = (HttpSession)request.getSession();
        String usuario="";
            
        if(miSesion.getAttribute("datosUsuario") == null){
        request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
        }else{
            UsuarioVO usuVO = (UsuarioVO)miSesion.getAttribute("datosUsuario");
            RolVO rolVO = new RolVO();
            usuario = usuVO.getNom_usu();              
        }
    %>
    <body>
       
    </body>
</html>

