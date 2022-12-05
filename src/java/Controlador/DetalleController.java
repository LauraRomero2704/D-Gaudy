/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleDAO;
import Modelo.DetalleVO;
import Modelo.PrendaVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Janus
 */
@WebServlet(name = "DetalleController", urlPatterns = {"/Detalle"})
public class DetalleController extends HttpServlet {

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
        String id_det = request.getParameter("txtIde_det");
        String id_ped = request.getParameter("txtIde_ped");
        String id_pren = request.getParameter("txtIde_pren");
        String cantPren = request.getParameter("txtCantPren_det");
        String precio = request.getParameter("txtPrecio_ped");
      
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int ide_det = 0;
        if(id_det!= null){
        ide_det = Integer.parseInt(id_det); 
        }
        
        int ide_ped = 0;
        if(id_ped!= null){
        ide_ped = Integer.parseInt(id_ped); 
        }
        
        int ide_pren = 0;
        if(id_pren!= null){
        ide_pren = Integer.parseInt(id_pren); 
        }
        
        int cantPren_det = 0;
        if(cantPren!= null){
        cantPren_det = Integer.parseInt(cantPren); 
        }
        
        double precio_ped = 0.0;
        if(precio!= null){
        precio_ped = Double.parseDouble(precio); 
        } 
        
        // Se instancia la clase VO (El VO tiene los datos de forma segura)
        DetalleVO comVO = new DetalleVO();
        PrendaVO prendavo = null;
        comVO = new DetalleVO(ide_det, ide_ped, ide_pren, cantPren_det, precio_ped, prendavo);

        // Se instancia la clase DAO (El DAO tiene las operaciones)
        DetalleDAO comDAO = new DetalleDAO();
        comDAO = new DetalleDAO(comVO);
        
         // Administrar Operaciones
        switch (opcion) {
           
             case 1:
               String inactivar = request.getParameter("txtEstado_det");
                if (inactivar.equals("Pendiente")) {
                    if (comDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "El comprobante de factura se entrego");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de comprobante de factura no se actualizo");
                    }
                    
                }else{
                    if (comDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "El comprobante de factura esta pendiente por entrega");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de comprobante de factura no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPedidos_Com.jsp").forward(request, response);   
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
        int ide_det = Integer.parseInt(request.getParameter("txtIde_det"));
        DetalleVO comVO = new  DetalleVO(ide_det);
        DetalleDAO comDAO = new  DetalleDAO(comVO);
        String inactivar = request.getParameter("txtEstado_det");
                if (!inactivar.equals("Pendiente")) {
                    if (comDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "El comprobante de factura se entrego");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de comprobante de factura no se actualizo");
                    }
                    
                }else{
                    if (comDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "El comprobante de factura esta pendiente por entrega");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de comprobante de factura no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPedidos_Com.jsp").forward(request, response);  
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
