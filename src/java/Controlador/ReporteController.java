/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PrendaDAO;
import Modelo.PrendaVO;
import Modelo.ReporteDAO;
import Modelo.ReporteVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Janus
 */
@WebServlet(name = "ReporteController", urlPatterns = {"/Reporte"})
public class ReporteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recibe Datos de las Vistas
        String iderept = request.getParameter("txtIde_rept");
        String ide_emp = request.getParameter("txtIde_emp");
        String nom_rept = request.getParameter("txtNom_rept");
        String cat_rept = request.getParameter("txtCat_rept");
        String pdf_rept = request.getParameter("txtPdf_rept");      
        String estado_rept = request.getParameter("txtEstado_rept");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
    
        int ide_rept = 0;
        if(iderept!= null){
        ide_rept = Integer.parseInt(iderept); 
        }
        
            
        // Se instancia la clase VO (El VO tiene los datos de forma segura)
        ReporteVO repvo = new ReporteVO();
        ReporteVO  repVO= new ReporteVO(ide_rept, ide_emp, nom_rept, cat_rept, pdf_rept,  estado_rept);
        
        // Se instancia la clase DAO (El DAO tiene las operaciones)
        ReporteDAO repdao = new ReporteDAO();
        ReporteDAO repDAO = new ReporteDAO(repVO);

        
        // Administrar Operaciones
        switch (opcion)
        {
            case 1: // Agregar Registro de Reporte
                
                if (repDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeRegistro", "La reporte se registro correctamente");
                }
                
                else 
                {
                    request.setAttribute("mensajeERegistro", "La reporte no se registro");
                }
                
                 request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);
                
            
            break;
            
            case 2: // Actualizar Registro de Reporte
                
                if (repDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeActualizar", "La reporte se actualizo correctamente");
                }
                
                else 
                {
                    request.setAttribute("mensajeEActualizar", "La reporte no se actualizo");
                }
                
                request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);
            
            break; 
            
            case 3: // Inactivar Registro de Reporte
               String inactivar = request.getParameter("txtEstado_rept");
                if (inactivar.equals("Archivado")) {
                    if (repDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La reporte esta disponible");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de reporte no se actualizo");
                    }
                    
                }else{
                    if (repDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La reporte esta agotada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de reporte no se actualizo");
                    }
                }
             request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);   
             break;

            
            case 4: // Consultar Registro de Reporte
                
                repVO = repDAO.consultarRegistro(ide_rept);
                
                if (repVO != null) {
                    
                    System.out.println("Consulto el reporte");
                    request.setAttribute("reporteConsultado", repVO);
                    request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);
                    System.out.println("Se redirecciono");
                    

                } else {
                    System.out.println("Ocurrio un error al consultar el reporte");
                    request.setAttribute("mensajeEAgotar", "El reporte NO existe!");
                    request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);
                          
                }
               
                break;                
           
        }
           
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ide_rept = Integer.parseInt(request.getParameter("txtIde_rept"));
        ReporteVO repVO = new ReporteVO(ide_rept);
        ReporteDAO repDAO = new ReporteDAO(repVO);
        String inactivar = request.getParameter("txtEstado_rept");
                if (!inactivar.equals("Archivado")) {
                    if (repDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La reporte esta disponible");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el reporte de pedido no se actualizo");
                    }
                    
                }else{
                    if (repDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La reporte esta agotada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el reporte de pedido no se actualizo");
                    }
                }
             request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);   
        }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}