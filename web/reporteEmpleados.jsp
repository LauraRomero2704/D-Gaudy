<%-- 
    Document   : reporteEmpleados
    Created on : 23/10/2022, 08:12:19 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Empleado</title>
    </head>
    <body>
        <%
        Connection con;
         
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgaudy","root","");
        File jasperfile = new File(application.getRealPath("reportes/reporteEmpleados.jasper"));
        Map parametro = new HashMap();
        byte[] bytes =JasperRunManager.runReportToPdf(jasperfile.getPath(),null,con );
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream output = response.getOutputStream();
        response.getOutputStream();
        output.write(bytes,0,bytes.length);
        output.flush();
        output.close();
        %>
    </body>
</html>
